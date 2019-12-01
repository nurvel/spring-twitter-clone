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
	
	public List<Tweet> getMyWall(Account account) {
		
		// TODO: get 1) My tweets 2) Tweets from who i follow
		
		
		
		return tweetRepository.findAll();

	}

	
	
	
}
