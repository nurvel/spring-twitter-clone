package projekti.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import projekti.entity.Account;
import projekti.entity.Follower;
import projekti.entity.Image;
import projekti.repository.AccountRepository;
import projekti.repository.FollowerRepository;
import projekti.repository.ImageRepository;

@Service
public class AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private ImageRepository imageRepository;

//	@Autowired
//	private FollowerService followerService;

	@Autowired
	private FollowerRepository followerRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	public Account findAccount(String username) {
		return accountRepository.findByUsername(username);
	}

	public List<Account> findAll() {
		return accountRepository.findAll();
	}

	public Account createAccout(String username, String password, String name) {
		List<String> authorities = new ArrayList<String>();
		Account a = new Account(username, passwordEncoder.encode(password), authorities);
		a.setName(name);
		return accountRepository.save(a);
	}

//	public void startFollow(String followUsername) {
//		Account account = getAuthenticatedAcccount();
//		Account getsFollowed = findAccount(followUsername);
//
//		if (account == getsFollowed)
//			return;
//
//		Follower f1 = new Follower(getsFollowed);
//		Follower f2 = new Follower(account);
//		followerRepository.save(f1);
//		followerRepository.save(f2);
//
//		account.getFollows().add(f1);
//		getsFollowed.getFollowers().add(f2);
//		accountRepository.save(account);
//		accountRepository.save(getsFollowed);
//
//	}

	// FOR INIT DB
	public void startFollow(Account target, Account follower) {
		Follower f1 = new Follower();
		f1.setFollowed(target);
		f1.setFollower(follower);
		f1.setLocalDateTime(LocalDateTime.now());
		followerRepository.save(f1);
	}

	// TODO: Throw exception?
	public Account getAuthenticatedAcccount() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		return accountRepository.findByUsername(username);
	}

	public void setProfileImage(Account account, Long id) {
		Image image = imageRepository.getOne(id);
		account.setProfileImage(image);
		accountRepository.save(account);
	}

}
