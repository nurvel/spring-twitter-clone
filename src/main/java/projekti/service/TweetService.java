package projekti.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projekti.entity.Account;
import projekti.entity.Comment;
import projekti.entity.Tweet;
import projekti.repository.CommentRepository;
import projekti.repository.TweetRepository;

@Service
public class TweetService {

	@Autowired
	TweetRepository tweetRepository;

	@Autowired
	CommentRepository commentRepository;

	public List<Tweet> findAll() {
		return tweetRepository.findAll();
	}

	public Tweet findOne(Long id) {
		return tweetRepository.getOne(id);
	}

//	public List<Tweet> findAccountsTweets(Account account) {
//		return tweetRepository.findAccountsTweets(account);
//	}

	public Tweet addTweet(String tweetText, Account account) {

		Tweet tweet = new Tweet();
		tweet.setText(tweetText);
		tweet.setPostTime(LocalDateTime.now());
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

	public void commentTweet(Long tweetId, Account account, String commentText) {

		Tweet tweet = tweetRepository.getOne(tweetId);

		Comment comment = new Comment();
		comment.setText(commentText);
		comment.setPoster(account);
		comment.setTweet(tweet);
		comment.setPostTime(LocalDateTime.now());

		commentRepository.save(comment);
	}

}
