package projekti.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import projekti.entity.Account;
import projekti.entity.Follower;
import projekti.repository.FollowerRepository;

@Service
public class FollowerService {

	@Autowired
	private FollowerRepository followerRepository;

	public List<Follower> findAll() {
		return followerRepository.findAll();
	}

	public Follower createFollower(Account followerAccount, Account getsFollowed) {
		Follower follower = new Follower();
		// follower.setFollower(followerAccount);
		// follower.setFollowing(getsFollowed);
		// follower.setFollowTimestamp();
		return followerRepository.save(follower);
	}

	public void unfollow(Account a1, Account a2) {
		// TODO: JPA query?
	}

}
