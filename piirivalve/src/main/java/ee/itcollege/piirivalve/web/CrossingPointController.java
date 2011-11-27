package ee.itcollege.piirivalve.web;

import ee.piirivalve.entities.CrossingPoint;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RooWebScaffold(path = "crossingpoints", formBackingObject = CrossingPoint.class)
@RequestMapping("/crossingpoints")
@Controller
public class CrossingPointController {
	
    @RequestMapping(value = "/{id}", params = "form", method = RequestMethod.GET)
    public String updateForm(@PathVariable("id") Long id, Model uiModel) {
    	uiModel.addAttribute("troop_guards", CrossingPoint.findCrossingPoint(id).getTroops().getGuard());
        uiModel.addAttribute("crossingPoint", CrossingPoint.findCrossingPoint(id));
        return "crossingpoints/update";
    }
}
