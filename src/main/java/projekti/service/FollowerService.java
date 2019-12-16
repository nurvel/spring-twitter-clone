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

	public void createFollower(Account followerAccount, Account getsFollowed) {

		boolean add = true;

		List<Follower> followers = getsFollowed.getFollows();

		for (Follower f : followers) {
			System.out.println("I follow: "  + f.getFollower().getName());
			if (f.getFollower() == followerAccount) {
				add = false;
				followerRepository.deleteById(f.getId());
			}
		}

		if (add) {
			Follower follower = new Follower();
			followerRepository.save(follower);
		}

//		Follower follower = new Follower();
//		followerRepository.save(follower);

	}

	public void unfollow(Account a1, Account a2) {
		// TODO: JPA query?
	}

}
