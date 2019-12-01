package projekti.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import projekti.entity.Account;
import projekti.entity.Tweet;
import projekti.service.AccountService;
import projekti.service.TweetService;

@Controller
public class TweetController {

	@Autowired
	private TweetService tweetService;

	@Autowired
	private AccountService accountService;

	@GetMapping("/tweets")
	public String allTweets(Model model) {
		List<Tweet> tweets = tweetService.findAll();
		model.addAttribute("tweets", tweets);
		// System.out.println(tweets.get(0).toString());
		return "tweets";
	}

	@PostMapping("/tweets/like")
	public String likeTweet(HttpServletRequest request, @RequestParam Long tweetId) {
		Account account = accountService.getAuthenticatedAcccount();
		tweetService.likeTweet(tweetId, account);

		String referer = request.getHeader("Referer");
		return "redirect:" + referer;
	}


	
}
