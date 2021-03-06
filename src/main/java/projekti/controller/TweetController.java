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
		return "tweets";
	}

	@GetMapping("/tweets/{id}")
	public String oneTweets(Model model, @PathVariable Long id) {
		Tweet tweet = tweetService.findOne(id);
		model.addAttribute("tweet", tweet);
		System.out.println("JAUSAAAAAA");
		return "tweet";
	}

	@PostMapping("/tweets/new")
	public String newTweet(HttpServletRequest request, @RequestParam String tweetText) {
		Account account = accountService.getAuthenticatedAcccount();
		tweetService.addTweet(tweetText, account);

		String referer = request.getHeader("Referer");
		return "redirect:" + referer;
	}

	@PostMapping("/tweets/like")
	public String likeTweet(HttpServletRequest request, @RequestParam Long id) {
		Account account = accountService.getAuthenticatedAcccount();
		tweetService.likeTweet(id, account);

		String referer = request.getHeader("Referer");
		return "redirect:" + referer;
	}

	@PostMapping("/tweets/comment")
	public String commentTweet(HttpServletRequest request, @RequestParam Long id, @RequestParam String commentText) {
		Account account = accountService.getAuthenticatedAcccount();
		tweetService.commentTweet(id, account, commentText);

		String referer = request.getHeader("Referer");
		return "redirect:" + referer;
	}

}
