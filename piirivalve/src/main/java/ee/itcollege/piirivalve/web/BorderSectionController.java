package ee.itcollege.piirivalve.web;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import ee.piirivalve.entities.BorderSection;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RooWebScaffold(path = "bordersections", formBackingObject = BorderSection.class)
@RequestMapping("/bordersections")
@Controller
public class BorderSectionController {
	
    @RequestMapping(method = RequestMethod.PUT)
    public String update(@Valid BorderSection borderSection, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("borderSection", borderSection);
            return "bordersections/update";
        }
        uiModel.asMap().clear();
        borderSection.merge();
        return "redirect:/bordersections";
    }
}
