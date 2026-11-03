package com.bornfire.xbrl.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bornfire.xbrl.dto.CounterpartyMaintenanceDto;
import com.bornfire.xbrl.entities.Counterparty_Rep;
import com.bornfire.xbrl.entities.RT_CountryRiskDropdownRepo;
import com.bornfire.xbrl.services.CounterpartyMaintenanceService;

@Controller
public class CounterpartyMaintenanceController {

	@Autowired
	CounterpartyMaintenanceService counterpartyMaintenanceService;

	@Autowired
	Counterparty_Rep counterpartyRep;

	@Autowired
	RT_CountryRiskDropdownRepo countryRepo;

	@RequestMapping(value = "/Counterparty_Maintenance", method = { RequestMethod.GET, RequestMethod.POST })
	public String counterpartyMaintenance(@RequestParam(required = false) String formmode,
			@RequestParam(required = false) String counterpartyCode, @RequestParam(required = false) String reportDate,
			Model md, HttpServletRequest req) {

		String roleId = (String) req.getSession().getAttribute("ROLEID");
		md.addAttribute("roleId", roleId);

		String mode = (formmode == null || formmode.trim().isEmpty()) ? "list" : formmode;

		if ("outstanding".equalsIgnoreCase(mode)) {
			md.addAttribute("menu", "Counterparty Maintenance");
			md.addAttribute("menuname", "Outstanding Counterparties");
			md.addAttribute("formmode", "outstanding");
			md.addAttribute("reportDate", reportDate);
			if (reportDate != null && !reportDate.trim().isEmpty()) {
				md.addAttribute("outstandingList", counterpartyMaintenanceService.getOutstanding(reportDate.trim()));
			}
			return "Counterparty_Maintenance";
		}

		if ("modify".equalsIgnoreCase(mode) || "view".equalsIgnoreCase(mode)) {
			CounterpartyMaintenanceDto record = counterpartyMaintenanceService.getByCode(counterpartyCode);
			if (record == null) {
				record = counterpartyMaintenanceService.getOutstandingByCode(counterpartyCode, reportDate);
			}
			if (record == null) {
				record = new CounterpartyMaintenanceDto();
				record.setCounterpartyCode(counterpartyCode);
				record.setReportDate(reportDate);
			} else if (reportDate != null && !reportDate.trim().isEmpty() && record.getReportDate() == null) {
				record.setReportDate(reportDate);
			}
			md.addAttribute("menu", "Counterparty Maintenance");
			md.addAttribute("menuname", "modify".equalsIgnoreCase(mode) ? "Counterparty Maintenance - Modify"
					: "Counterparty Maintenance - View");
			md.addAttribute("formmode", mode.toLowerCase());
			md.addAttribute("reportDate", reportDate);
			md.addAttribute("record", record);
			md.addAttribute("Counterpartynamelist", counterpartyRep.Getcounterpartyname());
			md.addAttribute("countryList", countryRepo.findAllByOrderByCountryOfRiskAsc());
			return "Counterparty_Maintenance";
		}

		md.addAttribute("menu", "Counterparty Maintenance");
		md.addAttribute("menuname", "Counterparty Maintenance");
		md.addAttribute("formmode", "list");
		md.addAttribute("listall", counterpartyMaintenanceService.getAllMaintained());
		return "Counterparty_Maintenance";
	}

	@PostMapping("/Counterparty_Maintenance_save")
	@ResponseBody
	public String saveCounterparty(@ModelAttribute CounterpartyMaintenanceDto record, HttpServletRequest req) {
		String userid = (String) req.getSession().getAttribute("USERID");
		if (userid == null) {
			return "Session Expired. Please login again.";
		}
		return counterpartyMaintenanceService.save(record, userid);
	}
}
