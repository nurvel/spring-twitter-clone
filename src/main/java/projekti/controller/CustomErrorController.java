package projekti.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomErrorController implements ErrorController { 
	
	 // TODO: fix

	@RequestMapping("/error")
	public String handleError() {
		// do something like logging
		return "error";
	}

	@Override
	public String getErrorPath() {
		return "/error";
	}

}
