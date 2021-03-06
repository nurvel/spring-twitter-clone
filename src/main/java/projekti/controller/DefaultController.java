package projekti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import projekti.entity.Account;
import projekti.service.AccountService;

@Controller
public class DefaultController {

	@Autowired
	private AccountService accountService;

	@GetMapping("/")
	public String helloWorld(Model model) {

		Account account = accountService.getAuthenticatedAcccount();

		model.addAttribute("message", "World!");

		return account != null ? "redirect:/mywall" : "index";
	}
}
