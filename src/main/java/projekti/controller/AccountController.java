package projekti.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import projekti.entity.Account;
import projekti.entity.Tweet;
import projekti.service.AccountService;
import projekti.service.ImageService;

@Controller
public class AccountController {

	@Autowired
	private AccountService accountService;

	@Autowired
	private ImageService imageService;

	@GetMapping("/accounts")
	public String list(Model model) {
		List<Account> as = accountService.findAll();
		model.addAttribute("accounts", accountService.findAll());
		return "accounts";
	}

	@GetMapping("/accounts/{username}")
	public String list(Model model, @PathVariable String username) {
		Account ac = accountService.findAccount(username);

		if (ac == null)
			return "redirect:/accounts";

		Account account = accountService.findAccount(username);

		model.addAttribute("account", account);

		List<Tweet> tweets = account.getTweets();
		tweets.sort((Tweet a, Tweet b) -> b.getPostTime().compareTo(a.getPostTime()));

		model.addAttribute("tweets", tweets);
		return "account";
	}

	@PostMapping("/accounts/search")
	public String searchUsers(Model model, @RequestParam String searchString) {
		List<Account> accounts = accountService.searchAccounts(searchString);

		model.addAttribute("accounts", accounts);
		return "search";
	}

	@PostMapping("/accounts")
	public String add(@RequestParam String username, @RequestParam String password, @RequestParam String name) {

		try {
			accountService.createAccout(username, password, name);
		} catch (Exception e) {
			// TODO: if accout exists or other error
		}
		return "redirect:/login";
	}

	@PostMapping("/accounts/follow")
	public String add(HttpServletRequest request, @RequestParam String followUsername) {
		accountService.startFollow(followUsername); // FIX method

		String referer = request.getHeader("Referer");
		return "redirect:" + referer;
	}

	@GetMapping("/accounts/{username}/images/{id}")
	public String accountImages(Model model, @PathVariable String username, @PathVariable Long id) {
		Account a = accountService.findAccount(username);

		if (a == null)
			return "redirect:/accounts";

		model.addAttribute("image", imageService.getImage(id));
		model.addAttribute("account", accountService.findAccount(username));
		return "images";
	}

}
