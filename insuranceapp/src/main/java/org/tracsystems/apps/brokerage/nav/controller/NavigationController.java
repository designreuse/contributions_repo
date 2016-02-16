package org.tracsystems.apps.brokerage.nav.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/protected/home")
public class NavigationController {
	
	@RequestMapping(method = RequestMethod.GET)
    public ModelAndView welcome() {
        return new ModelAndView("welcomePage");
    }
    
    @RequestMapping(value="/setups",method = RequestMethod.GET)
    public ModelAndView setups() {
        return new ModelAndView("setupScreen");
    }
    
    @RequestMapping(value="/orgsetups",method = RequestMethod.GET)
    public ModelAndView orgSetups() {
        return new ModelAndView("orgsetupScreen");
    }

}
