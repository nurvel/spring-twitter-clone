package projekti.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.springframework.data.jpa.domain.AbstractPersistable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tweet extends AbstractPersistable<Long> {

	private String text;
	private LocalDateTime postTime;

	@ManyToOne
	private Account poster;

	@ManyToMany
	@JoinTable(
			  name = "tweet_like", 
			  joinColumns = @JoinColumn(name = "tweet_id"), 
			  inverseJoinColumns = @JoinColumn(name = "account_id"))
	private List<Account> likes = new ArrayList<>();

	// private List<String> comments; // TOOD: modify to comment-object?

}