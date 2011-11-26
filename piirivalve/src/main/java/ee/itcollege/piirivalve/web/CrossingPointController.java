package ee.itcollege.piirivalve.web;

import ee.piirivalve.entities.CrossingPoint;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "crossingpoints", formBackingObject = CrossingPoint.class)
@RequestMapping("/crossingpoints")
@Controller
public class CrossingPointController {
}
