package projekti.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projekti.entity.Account;
import projekti.entity.Tweet;

public interface TweetRepository extends JpaRepository<Tweet, Long> {

}
