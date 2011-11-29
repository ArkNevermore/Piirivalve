package ee.itcollege.piirivalve.web;

import java.util.ArrayList;
import java.util.Date;

import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ee.piirivalve.entities.Troops;

@RequestMapping("/report/**")
@Controller
public class ReportController {

    @RequestMapping
    public String index(Model uiModel) {       
    	List <Troops> troops = Troops.findAllTroopses();
       	uiModel.addAttribute("troops", troops);
        return "report/index";
    }

    @RequestMapping (params = "date", method = RequestMethod.GET)
    public String findBorderSchedule(@RequestParam("date") @DateTimeFormat(iso = ISO.DATE) Date date,
    						 @RequestParam("troops") Long id,
    						 Model uiModel) {
    	
    	List <Troops> troops = Troops.findAllTroopses();
       	uiModel.addAttribute("troops", troops);

    	
    	Troops c = Troops.findTroops(id);
       	List <Report> data = new ArrayList<Report>();
       	List <Report> data2 = new ArrayList<Report>();


       	data.add(Report.findAllSections(c, date));
       	data2.add(Report.findAllPoints(c, date));

       	uiModel.addAttribute("data", data);
       	uiModel.addAttribute("data2", data2); 

        return "report/index";
    }
}
