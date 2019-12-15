package projekti.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.data.jpa.domain.AbstractPersistable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = { "tweets", "password", "authorities", "likedTweets", "comments", "followers", "follows" })
public class Account extends AbstractPersistable<Long> {

	private String name;
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

	@OneToMany(mappedBy = "follower", fetch = FetchType.LAZY)
	private List<Follower> follows = new ArrayList<>(); // new HashSet<>();

	@OneToMany(mappedBy = "followed", fetch = FetchType.LAZY)
	private List<Follower> followers = new ArrayList<>();

	@OneToMany(mappedBy = "account")
	private List<Image> images = new ArrayList<>();

	@OneToOne
	private Image profileImage; // TODO: reference of profile IGM

	@ManyToMany(mappedBy = "likes")
	private List<Image> likedImages = new ArrayList<>();

	
	// private List<Account> blockedUsers = new ArrayList<>(); TODO: 2-way

	public Account(String username, String password, List<String> authorities) {
		this.username = username;
		this.password = password;
		this.authorities = authorities;
	}

}