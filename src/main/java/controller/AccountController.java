package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import service.AccountService;

@Controller
public class AccountController {

	@Autowired
	private AccountService accountService;

	@GetMapping("/accounts")
	public String list(Model model) {
		model.addAttribute("accounts", accountService.findAll());
		return "accounts";
	}

	@PostMapping("/accounts")
	public String add(@RequestParam String username, @RequestParam String password) {

		try {
			accountService.createAccout(username, password);
		} catch (Exception e) {
			// TODO: if accout exists or other error
		}
		return "redirect:/accounts";
	}

	
	
}
