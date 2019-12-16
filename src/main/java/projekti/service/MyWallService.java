package projekti.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projekti.entity.Account;
import projekti.entity.Follower;
import projekti.entity.Tweet;
import projekti.repository.TweetRepository;

@Service
public class MyWallService {

	@Autowired
	TweetService tweetService;

	@Autowired
	AccountService accountService;

	public List<Tweet> getMyWall() {
		Account account = accountService.getAuthenticatedAcccount();

		List<Tweet> myWallTweets = account.getTweets();

		for (Follower f : account.getFollows()) {
			f.getFollowed().getTweets().forEach(x -> myWallTweets.add(x));
		}

		myWallTweets.sort((Tweet a, Tweet b) -> b.getPostTime().compareTo(a.getPostTime()));

		return myWallTweets.size() > 25 ? myWallTweets.subList(0, 24) : myWallTweets;

	}

}
