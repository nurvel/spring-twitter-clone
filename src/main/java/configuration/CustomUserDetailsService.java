package configuration;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import entity.Account;
import repository.AccountRepository;
import service.AccountService;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private AccountService accountService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Account account = accountService.findAccount(username);

		if (account == null) {
			throw new UsernameNotFoundException("No such user: " + username);
		}

		List<SimpleGrantedAuthority> auths = account.getAuthorities()
				.stream()
				.map(auth -> new SimpleGrantedAuthority(auth))
				.collect(Collectors.toList());

		return new org.springframework.security.core.userdetails.User(account.getUsername(), account.getPassword(),
				true, true, true, true, auths);
	}
}