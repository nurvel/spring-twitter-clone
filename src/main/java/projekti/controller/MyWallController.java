package projekti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import projekti.entity.Account;
import projekti.entity.Tweet;
import projekti.service.AccountService;
import projekti.service.MyWallService;

@Controller
public class MyWallController {

	@Autowired
	private AccountService accountService;

	@Autowired
	private MyWallService myWallService;

	@GetMapping("/mywall")
	public String list(Model model) {

		Account account = accountService.getAuthenticatedAcccount();

		// System.out.println(account.toString());

		List<Tweet> myWallTweets = myWallService.getMyWall();
//		System.out.println("KOKO:  " + myWallTweets.size());
//		System.out.println("TWEETS:  " + myWallTweets.toString());
//		System.out.println("ACCOUNT" + account.toString());
//		System.out.println("ACCOUNT" + account.getFollowers().toString());

		model.addAttribute("tweets", myWallTweets);
		model.addAttribute("account", account);

		return account == null ? "redirect:/" : "mywall";
	}

}
