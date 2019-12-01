package projekti.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.springframework.data.jpa.domain.AbstractPersistable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = { "tweet" })
public class Comment extends AbstractPersistable<Long> {

	private String text;
	private LocalDateTime postTime;

	@ManyToOne
	private Account poster;

	@ManyToOne
	private Tweet tweet;

}
