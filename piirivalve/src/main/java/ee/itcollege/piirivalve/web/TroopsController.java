package ee.itcollege.piirivalve.web;

import ee.piirivalve.entities.Troops;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "troopses", formBackingObject = Troops.class)
@RequestMapping("/troopses")
@Controller
public class TroopsController {
}
