package ee.itcollege.piirivalve.web;

import ee.piirivalve.entities.BorderSection;


import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;


@RooWebScaffold(path = "bordersections", formBackingObject = BorderSection.class)
@RequestMapping("/bordersections")
@Controller
public class BorderSectionController {
	
}
