(function () {
	"use strict";

	var tileVariants = ["hex--light", "hex--dark", "hex--light", "hex--light", "hex--dark", "hex--light"];

	var iconMap = {
		"Risk Insights": "fa-chart-line",
		Admin: "fa-users-cog",
		"RT Reports": "fa-file-alt",
		ASL: "fa-building",
		"Credit Risk": "fa-credit-card",
		"Liquidity & Risk": "fa-exclamation-triangle",
		"File Upload": "fa-cloud-upload-alt",
		"MC Reports": "fa-clipboard-list",
		Audit: "fa-eye",
		"User Profile": "fa-user-circle",
		"Access and Roles": "fa-user-shield",
		"Bloomberg Data": "fa-database",
		"Report Control Center": "fa-tasks",
		"Data Inventory": "fa-boxes",
		"EAB Exceptions": "fa-exclamation-circle",
		"Customer Groups": "fa-users",
		"Bill Details": "fa-file-invoice-dollar",
		"Counterparty Maintenance": "fa-address-book",
		"Nostro Account Balance": "fa-university",
		"FX Risk Data": "fa-exchange-alt",
		"Trade Market Risk": "fa-chart-area",
		"MM Data": "fa-coins",
		"Repo Data": "fa-handshake",
		"Investment Risk": "fa-chart-pie",
		"Treasury Credit Limit": "fa-balance-scale",
		"Trade Derivatives": "fa-random",
		"Derivatives Simplified": "fa-project-diagram",
		"CCR Data": "fa-link",
		"Cross Currency Funding": "fa-globe-americas",
		"Liquidity Risk Data": "fa-tint",
		"Investment Securities": "fa-certificate",
		"Liquidity Dashboard": "fa-tachometer-alt",
		"IRRBB Data": "fa-chart-bar",
		"Auth Counterparties": "fa-building",
		"Exposure Data": "fa-chart-bar",
		"Interbank Placements": "fa-landmark",
		"Swap Settlement": "fa-sync-alt",
		"Final Risk View": "fa-binoculars",
		"SBL/Guarantee Maintenance": "fa-file-contract",
		"Bank Limit Check": "fa-check-double",
		"ASL Limit Request": "fa-file-signature",
		"Treasury Placement": "fa-piggy-bank",
		"Settlement Upload": "fa-file-upload",
		"Portfolio Analysis": "fa-briefcase",
		"Analytical Pivot": "fa-table",
		SLS: "fa-water",
		"SLS Sensitivity": "fa-thermometer-half",
		"IRS Sensitivity": "fa-sliders-h",
		IRS: "fa-percent",
		"User Audit": "fa-user-check",
		"Service Audit": "fa-server",
		"Market Conduct Service Audit": "fa-server"
	};

	var HEX_RATIO = 2 / 1.73205;
	var nav = document.getElementById("mainNav");
	var panel = document.querySelector(".menu-landing__panel");
	var currentCols = 0;
	var activeGridId = "grid-root";
	var baseHexSize = null;

	if (!nav) {
		return;
	}

	function getIcon(label) {
		if (iconMap[label]) return iconMap[label];
		var lower = label.toLowerCase();
		if (lower.indexOf("fx") >= 0 || lower.indexOf("currency") >= 0) return "fa-exchange-alt";
		if (lower.indexOf("derivative") >= 0) return "fa-random";
		if (lower.indexOf("liquidity") >= 0) return "fa-tint";
		if (lower.indexOf("investment") >= 0) return "fa-chart-pie";
		if (lower.indexOf("audit") >= 0) return "fa-clipboard-check";
		if (lower.indexOf("upload") >= 0) return "fa-cloud-upload-alt";
		if (lower.indexOf("report") >= 0) return "fa-file-alt";
		if (lower.indexOf("limit") >= 0) return "fa-balance-scale";
		if (lower.indexOf("data") >= 0) return "fa-database";
		if (lower.indexOf("user") >= 0) return "fa-user";
		if (lower.indexOf("dashboard") >= 0 || lower.indexOf("insights") >= 0) return "fa-chart-line";
		return "fa-th-large";
	}

	function getCellLabel(cell) {
		var labelEl = cell.querySelector(".menu-cell__label");
		return cell.getAttribute("data-label") || (labelEl ? labelEl.textContent.trim() : "") || "Module";
	}

	function getCellDesc(cell) {
		return cell.getAttribute("data-desc") || "";
	}

	function getGridCells(gridId) {
		var grid = document.getElementById(gridId);
		if (!grid) return [];
		return Array.prototype.slice.call(grid.querySelectorAll(".menu-cell"));
	}

	function tessMetrics(hexW) {
		var hexH = hexW * HEX_RATIO;
		return {
			hexW: hexW,
			hexH: hexH,
			pitchX: hexW,
			pitchY: hexH * 0.75
		};
	}

	function honeycombPosition(index, cols, m) {
		var row = Math.floor(index / cols);
		var col = index % cols;
		return {
			x: col * m.pitchX + (row % 2) * (m.pitchX / 2),
			y: row * m.pitchY
		};
	}

	function clusterSize(cols, itemCount, m) {
		var rows = Math.ceil(itemCount / cols);
		var maxW = 0;

		for (var r = 0; r < rows; r++) {
			var countInRow = Math.min(cols, itemCount - r * cols);
			if (countInRow <= 0) break;
			var offset = r % 2 === 1 ? m.pitchX / 2 : 0;
			var rowW = offset + (countInRow - 1) * m.pitchX + m.hexW;
			if (rowW > maxW) maxW = rowW;
		}

		var totalH = rows > 0 ? (rows - 1) * m.pitchY + m.hexH : 0;
		return { width: maxW, height: totalH, rows: rows };
	}

	function getColumnRange(availW, itemCount) {
		var minHex = 88;
		var maxCols = Math.max(3, Math.min(itemCount, Math.floor((availW - minHex) / minHex + 1)));
		var minCols = 3;
		if (availW >= 1600) minCols = 9;
		else if (availW >= 1280) minCols = 8;
		else if (availW >= 1024) minCols = 7;
		else if (availW >= 768) minCols = 5;
		return { minCols: Math.min(minCols, itemCount), maxCols: maxCols };
	}

	function layoutForColumns(cols, availW, availH, itemCount, maxHexSize) {
		var lo = 88;
		var hi = maxHexSize ? Math.min(200, maxHexSize) : 200;
		var best = null;

		while (lo <= hi) {
			var mid = Math.floor((lo + hi) / 2);
			var m = tessMetrics(mid);
			var size = clusterSize(cols, itemCount, m);
			if (size.width <= availW && size.height <= availH) {
				best = {
					cols: cols,
					hexSize: mid,
					width: size.width,
					height: size.height,
					metrics: m
				};
				lo = mid + 1;
			} else {
				hi = mid - 1;
			}
		}
		return best;
	}

	function findBestLayout(availW, availH, itemCount, maxHexSize) {
		var range = getColumnRange(availW, itemCount);
		var best = null;

		for (var cols = range.minCols; cols <= range.maxCols; cols++) {
			var layout = layoutForColumns(cols, availW, availH, itemCount, maxHexSize);
			if (!layout) continue;
			if (!best || layout.hexSize > best.hexSize) best = layout;
		}

		if (!best) {
			var fallbackCols = range.maxCols;
			var hexSize = maxHexSize ? Math.min(88, maxHexSize) : 88;
			var m = tessMetrics(hexSize);
			var size = clusterSize(fallbackCols, itemCount, m);
			best = {
				cols: fallbackCols,
				hexSize: hexSize,
				width: size.width,
				height: size.height,
				metrics: m
			};
		}

		return best;
	}

	function appendHex(cell, index) {
		var label = getCellLabel(cell);
		var desc = getCellDesc(cell);
		var isBack = cell.classList.contains("menu-cell--back");
		var icon = isBack ? "fa-arrow-left" : getIcon(label);
		var variant = tileVariants[index % tileVariants.length];
		var link = document.createElement("a");
		link.href = "#";
		link.className = "hex " + variant;
		link.setAttribute("role", "button");
		link.setAttribute("tabindex", "0");
		link.setAttribute("title", label);
		link.setAttribute("aria-label", label);

		var descHtml = desc ? '<p class="hex-desc">' + desc + "</p>" : "";
		link.innerHTML =
			'<svg class="hex-edge" viewBox="0 0 100 100" preserveAspectRatio="none" aria-hidden="true" focusable="false">' +
			'<polygon class="hex-edge__track" vector-effect="non-scaling-stroke" points="50,0 100,25 100,75 50,100 0,75 0,25"></polygon>' +
			'<polygon class="hex-edge__trace hex-edge__trace--primary" vector-effect="non-scaling-stroke" pathLength="100" points="50,0 100,25 100,75 50,100 0,75 0,25"></polygon>' +
			'<polygon class="hex-edge__trace hex-edge__trace--secondary" vector-effect="non-scaling-stroke" pathLength="100" points="50,0 100,25 100,75 50,100 0,75 0,25"></polygon>' +
			"</svg>" +
			'<div class="hex-shape">' +
			'<span class="hex-icon-wrap"><i class="fas ' + icon + ' hex-icon" aria-hidden="true"></i></span>' +
			'<p class="hex-label">' + label + "</p>" +
			descHtml +
			"</div>";

		["data-url", "data-label", "data-desc", "data-drill", "data-back"].forEach(function (attr) {
			var val = cell.getAttribute(attr);
			if (val) link.setAttribute(attr, val);
		});

		nav.appendChild(link);
	}

	function positionHoneycomb(cols, m) {
		var hexes = nav.querySelectorAll(".hex");
		hexes.forEach(function (hex, index) {
			var pos = honeycombPosition(index, cols, m);
			hex.style.left = pos.x + "px";
			hex.style.top = pos.y + "px";
		});
	}

	function applyLayout(layout) {
		currentCols = layout.cols;
		document.documentElement.style.setProperty("--hex-size", layout.hexSize + "px");
		document.documentElement.style.setProperty("--hex-pitch-x", layout.metrics.pitchX + "px");
		document.documentElement.style.setProperty("--hex-pitch-y", layout.metrics.pitchY + "px");
		nav.style.width = Math.ceil(layout.width) + "px";
		nav.style.height = Math.ceil(layout.height) + "px";
		positionHoneycomb(layout.cols, layout.metrics);
	}

	function highlightCenterHex() {
		var hexes = nav.querySelectorAll(".hex");
		if (hexes.length < 3) return;
		var center = Math.floor(hexes.length / 2);
		var hex = hexes[center];
		hex.classList.remove("hex--light", "hex--dark");
		hex.classList.add("hex--accent");
	}

	function buildMenu(gridId) {
		activeGridId = gridId || "grid-root";
		nav.innerHTML = "";
		nav.className = "hex-menu hex-menu--connected";
		getGridCells(activeGridId).forEach(function (cell, i) {
			appendHex(cell, i);
		});
		highlightCenterHex();
		staggerHexTiles();
	}

	function staggerHexTiles() {
		nav.querySelectorAll(".hex").forEach(function (hex, index) {
			hex.style.setProperty("--hex-stagger", Math.min(index, 11) * 42 + "ms");
		});
	}

	function syncTopbarHeight() {
		var topbar = document.querySelector(".menu-landing__topbar");
		if (!topbar) return;
		var height = Math.ceil(topbar.getBoundingClientRect().height);
		if (height > 0) {
			document.documentElement.style.setProperty("--topbar-h", height + "px");
		}
	}

	function fitLayout() {
		if (!panel) return;

		syncTopbarHeight();

		requestAnimationFrame(function () {
			var itemCount = nav.querySelectorAll(".hex").length;
			if (!itemCount) return;

			document.documentElement.style.setProperty("--menu-scale", "1");

			var panelRect = panel.getBoundingClientRect();
			var panelStyle = window.getComputedStyle(panel);
			var padTop = parseFloat(panelStyle.paddingTop) || 0;
			var padBottom = parseFloat(panelStyle.paddingBottom) || 0;
			var padLeft = parseFloat(panelStyle.paddingLeft) || 0;
			var padRight = parseFloat(panelStyle.paddingRight) || 0;
			var availW = Math.floor(panelRect.width - padLeft - padRight);
			var availH = Math.floor(panelRect.height - padTop - padBottom);

			var rootCount = getGridCells("grid-root").length;
			var rootLayout = findBestLayout(availW, availH, rootCount);
			baseHexSize = rootLayout.hexSize;

			var layout;
			if (activeGridId === "grid-root") {
				layout = rootLayout;
			} else {
				layout = findBestLayout(availW, availH, itemCount, baseHexSize);
			}
			applyLayout(layout);

			requestAnimationFrame(function () {
				var rootScaleX = availW / rootLayout.width;
				var rootScaleY = availH / rootLayout.height;
				var rootScale = Math.min(rootScaleX, rootScaleY);

				var menuScaleX = availW / layout.width;
				var menuScaleY = availH / layout.height;
				var menuScale = Math.min(menuScaleX, menuScaleY);

				var scale = Math.min(rootScale, menuScale);
				if (!isFinite(scale) || scale <= 0) scale = 1;
				document.documentElement.style.setProperty("--menu-scale", scale.toFixed(4));
			});
		});
	}

	function navigate(link) {
		var url = link.getAttribute("data-url");
		if (url) window.location.href = url;
	}

	var MENU_EXIT_MS = 280;
	var MENU_ENTER_MS = 980;
	var menuTransitioning = false;

	function prefersReducedMotion() {
		return window.matchMedia("(prefers-reduced-motion: reduce)").matches;
	}

	function clearMenuTransitionClasses() {
		nav.classList.remove(
			"hex-menu--transitioning",
			"hex-menu--exit-forward",
			"hex-menu--exit-back",
			"hex-menu--enter-forward",
			"hex-menu--enter-back",
			"hex-menu--enter-active"
		);
	}

	function runEnterAnimation(direction) {
		nav.classList.add(direction === "back" ? "hex-menu--enter-back" : "hex-menu--enter-forward");
		requestAnimationFrame(function () {
			requestAnimationFrame(function () {
				nav.classList.add("hex-menu--enter-active");
			});
		});
		window.setTimeout(function () {
			clearMenuTransitionClasses();
			menuTransitioning = false;
		}, MENU_ENTER_MS);
	}

	function transitionToMenu(gridId, direction) {
		if (menuTransitioning) {
			return;
		}
		if (prefersReducedMotion()) {
			buildMenu(gridId);
			fitLayout();
			return;
		}

		menuTransitioning = true;
		staggerHexTiles();
		nav.classList.add("hex-menu--transitioning");
		nav.classList.add(direction === "back" ? "hex-menu--exit-back" : "hex-menu--exit-forward");

		window.setTimeout(function () {
			clearMenuTransitionClasses();
			buildMenu(gridId);
			fitLayout();
			runEnterAnimation(direction);
		}, MENU_EXIT_MS);
	}

	function handleHexAction(hex) {
		var backGrid = hex.getAttribute("data-back");
		if (backGrid) {
			transitionToMenu(backGrid, "back");
			return;
		}

		var drill = hex.getAttribute("data-drill");
		if (drill) {
			transitionToMenu("grid-" + drill, "forward");
			return;
		}

		navigate(hex);
	}

	nav.addEventListener("click", function (e) {
		var hex = e.target.closest("a.hex");
		if (!hex || !nav.contains(hex)) return;
		e.preventDefault();
		handleHexAction(hex);
	});

	nav.addEventListener("keydown", function (e) {
		if (e.key !== "Enter" && e.key !== " ") return;
		var hex = e.target.closest("a.hex");
		if (!hex || !nav.contains(hex)) return;
		e.preventDefault();
		handleHexAction(hex);
	});

	window.addEventListener("resize", function () {
		syncTopbarHeight();
		fitLayout();
	});

	var INTRO_STORAGE_KEY = "bobUaeMenuIntroShown";
	var INTRO_TOTAL_MS = 5200;
	var INTRO_EXIT_MS = 550;

	function hasSeenIntro() {
		try {
			return sessionStorage.getItem(INTRO_STORAGE_KEY) === "1";
		} catch (err) {
			return true;
		}
	}

	function markIntroSeen() {
		try {
			sessionStorage.setItem(INTRO_STORAGE_KEY, "1");
			document.documentElement.classList.add("menu-intro-seen");
		} catch (err) {
			/* ignore */
		}
	}

	function finishIntro(introEl, onDone) {
		if (!introEl) {
			onDone();
			return;
		}
		introEl.classList.add("menu-landing__intro--exit");
		window.setTimeout(function () {
			introEl.remove();
			document.body.classList.remove("menu-landing--intro");
			markIntroSeen();
			onDone();
		}, INTRO_EXIT_MS);
	}

	function runIntro(onDone) {
		var introEl = document.getElementById("menuIntro");
		if (!introEl || hasSeenIntro()) {
			if (introEl) {
				introEl.remove();
			}
			document.body.classList.remove("menu-landing--intro");
			onDone();
			return;
		}

		document.body.classList.add("menu-landing--intro");
		introEl.classList.add("menu-landing__intro--play");

		var duration = INTRO_TOTAL_MS;
		if (window.matchMedia("(prefers-reduced-motion: reduce)").matches) {
			duration = 900;
		}

		window.setTimeout(function () {
			finishIntro(introEl, onDone);
		}, duration);
	}

	function init() {
		buildMenu("grid-root");
		runIntro(fitLayout);
	}

	if (document.readyState === "loading") {
		document.addEventListener("DOMContentLoaded", init);
	} else {
		init();
	}
})();
