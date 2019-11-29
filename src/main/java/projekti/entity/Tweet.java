package projekti.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	
	@ManyToOne (fetch = FetchType.LAZY)
	private Account poster;

	@ElementCollection(fetch = FetchType.EAGER)
	private List<Account> likes;

	//private List<String> comments; // TOOD: modify to comment-object?

	
}