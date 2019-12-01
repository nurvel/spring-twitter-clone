package projekti.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import projekti.entity.Tweet;

@Repository
public interface TweetRepository extends JpaRepository<Tweet, Long> {

//	@Query("SELECT t FROM Tweet t WHERE t.poster_id IN :pids")
//	List<Tweet> findTweetsByUserIds(@Param("pids") Collection<Long> pids);

}
