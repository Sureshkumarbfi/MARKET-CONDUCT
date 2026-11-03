package com.bornfire.xbrl.controllers;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@ControllerAdvice
public class GlobalModelInjector {

    @ModelAttribute("menuList")
    public List<String> populateMenuList(HttpSession session) {
        String menuStr = (String) session.getAttribute("MENULIST");
     //   System.out.println(menuStr + "hjkfdsah;aioefhsldf;lajlfk");
        if (menuStr != null && !menuStr.trim().isEmpty()) {
        	
//        	System.out.println(Arrays.asList(menuStr.split(",")));
            return Arrays.asList(menuStr.split(","));
        }
        return Collections.emptyList();
    }
}
