package projekti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projekti.entity.Account;
import projekti.entity.Tweet;
import projekti.repository.TweetRepository;

@Service
public class MyWallService {

	@Autowired
	TweetRepository tweetRepository;

	@Autowired
	AccountService AccountService;

	public List<Tweet> getMyWall() {
		Account account = AccountService.getAuthenticatedAcccount();
		
		
		// TODO: 1) My tweets 2) Tweets from who i follow 3) no tweets from blocked
		// TODO: Sort by time and return 25 newest

		// TODO: ei toimi tällä hetkellä
		//List<Tweet> myWallTweets = tweetRepository.findTweetsByUserId(account.getId());
		//return myWallTweets;

		
		
		
		 return tweetRepository.findAll();

	}

}
