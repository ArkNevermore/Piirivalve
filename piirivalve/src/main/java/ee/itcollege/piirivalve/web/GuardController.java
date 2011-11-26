package ee.itcollege.piirivalve.web;

import ee.piirivalve.entities.Guard;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "guards", formBackingObject = Guard.class)
@RequestMapping("/guards")
@Controller
public class GuardController {
}
