package projekti.entity;

import java.util.ArrayList;
import java.util.List;

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
@ToString(exclude = { "tweets", "password", "authorities", "likedTweets" })
public class Account extends AbstractPersistable<Long> {

	private String username;
	private String password;

	@ElementCollection(fetch = FetchType.EAGER)
	private List<String> authorities;

	@OneToMany(mappedBy = "poster")
	private List<Tweet> tweets = new ArrayList<>();


	@ManyToMany(mappedBy = "likes")
	private List<Tweet> likedTweets = new ArrayList<>();

	public Account(String username, String password, List<String> authorities) {
		this.username = username;
		this.password = password;
		this.authorities = authorities;
	}

}