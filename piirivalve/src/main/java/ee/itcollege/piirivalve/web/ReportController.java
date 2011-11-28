package ee.itcollege.piirivalve.web;

import java.util.ArrayList;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ee.piirivalve.entities.Troops;

@RequestMapping("/report/**")
@Controller
public class ReportController {

    @RequestMapping
    public String index(Model uiModel) {
        
       	List <Report> data = new ArrayList<Report>();
       	List <Report> data2 = new ArrayList<Report>();

       	for (Troops c : Troops.findAllTroopses()) {
       		data.add(Report.findAllSections(c));
       		data2.add(Report.findAllPoints(c));
       	}

       	uiModel.addAttribute("data", data);
       	uiModel.addAttribute("data2", data2);
        return "report/index";
    }
}
