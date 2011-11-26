package ee.itcollege.piirivalve.web;

import ee.piirivalve.entities.ChildTroops;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "childtroopses", formBackingObject = ChildTroops.class)
@RequestMapping("/childtroopses")
@Controller
public class ChildTroopsController {
}
