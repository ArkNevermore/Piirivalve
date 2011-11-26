package ee.itcollege.piirivalve.web;

import ee.piirivalve.entities.Manager;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "managers", formBackingObject = Manager.class)
@RequestMapping("/managers")
@Controller
public class ManagerController {
}
