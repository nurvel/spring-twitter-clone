package projekti.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import projekti.entity.Account;
import projekti.repository.AccountRepository;
import projekti.repository.TweetRepository;

@Service
public class AccountService {

	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;

	public Account findAccount(String username) {
		return accountRepository.findByUsername(username);
	}

	public List<Account> findAll() {
		return accountRepository.findAll();
	}

	public Account createAccout(String username, String password) {
		List<String> authorities = new ArrayList<String>();
		Account a = new Account(username, passwordEncoder.encode(password), authorities);
		return accountRepository.save(a);
	}

}
