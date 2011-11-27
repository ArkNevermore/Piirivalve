package ee.itcollege.piirivalve.web;

import ee.piirivalve.entities.BorderSection;


import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@RooWebScaffold(path = "bordersections", formBackingObject = BorderSection.class)
@RequestMapping("/bordersections")
@Controller
public class BorderSectionController {
	
    @RequestMapping(value = "/{id}", params = "form", method = RequestMethod.GET)
    public String updateForm(@PathVariable("id") Long id, Model uiModel) {
    	uiModel.addAttribute("troop_guards", BorderSection.findBorderSection(id).getTroops().getGuard());
    	uiModel.addAttribute("borderSection", BorderSection.findBorderSection(id));
        return "bordersections/update";
    }
    
}
