package projekti.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projekti.entity.Account;
import projekti.entity.Tweet;
import projekti.repository.TweetRepository;

@Service
public class TweetService {

	@Autowired
	TweetRepository tweetRepository;

	public List<Tweet> findAll() {
		return tweetRepository.findAll();
	}

	public Tweet addTweet(String tweetText, Account account) {

		Tweet tweet = new Tweet();
		tweet.setText(tweetText);
		// tweet.setPostTime();
		tweet.setPoster(account);

		return tweetRepository.save(tweet);
	}

	public void likeTweet(Long tweetId, Account account) {

		Tweet tweet = tweetRepository.getOne(tweetId);

		if (tweet.getLikes().contains(account)) {
			tweet.getLikes().remove(account);
		} else {
			tweet.getLikes().add(account);
		}

		tweetRepository.save(tweet);
	}

}
