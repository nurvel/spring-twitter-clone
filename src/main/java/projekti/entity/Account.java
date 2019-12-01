package projekti.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.springframework.data.jpa.domain.AbstractPersistable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(
		exclude = { "tweets", "password", "authorities", "likedTweets", "comments", "parent", "followers", "following" })
public class Account extends AbstractPersistable<Long> {

	private String username;
	private String password;

	@ElementCollection(fetch = FetchType.EAGER)
	private List<String> authorities;

	@OneToMany(mappedBy = "poster")
	private List<Tweet> tweets = new ArrayList<>();

	@OneToMany(mappedBy = "poster")
	private List<Comment> comments = new ArrayList<>();

	@ManyToMany(mappedBy = "likes")
	private List<Tweet> likedTweets = new ArrayList<>();

	@ElementCollection(targetClass = String.class)
	private Set<String> followers = new HashSet<>(); // HOX: jostain syystä lisätään 2 kertaa

	@ElementCollection(targetClass = String.class)
	private Set<String> following = new HashSet<>(); // HOX: jostain syystä lisätään 2 kertaa

	
//	@ManyToOne
//	private Account parent = this;
//	@OneToMany(mappedBy = "parent")
//	private List<Account> following = new ArrayList<>();
//	@OneToMany(mappedBy = "parent")
//	private List<Account> followers = new ArrayList<>();

	// private List<Account> blockedUsers = new ArrayList<>(); TODO: 2-way

	public Account(String username, String password, List<String> authorities) {
		this.username = username;
		this.password = password;
		this.authorities = authorities;
	}

}