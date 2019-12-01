package projekti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import projekti.entity.Account;
import projekti.service.AccountService;

@Controller
public class AccountController {

	@Autowired
	private AccountService accountService;

	@GetMapping("/accounts")
	public String list(Model model) {
		List<Account> as = accountService.findAll();
		model.addAttribute("accounts", accountService.findAll());
		return "accounts";
	}

	@GetMapping("/accounts/{username}")
	public String list(Model model, @PathVariable String username) {
		Account a = accountService.findAccount(username);

		if (a == null)
			return "redirect:/accounts";

		model.addAttribute("account", accountService.findAccount(username));
		return "account";
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
