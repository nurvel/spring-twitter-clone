package projekti.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import org.springframework.data.jpa.domain.AbstractPersistable;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = { "follower", "followed" })
public class Follower extends AbstractPersistable<Long> {

	@ManyToOne(fetch = FetchType.LAZY)
	private Account follower;

	@ManyToOne(fetch = FetchType.LAZY)
	private Account followed;

	// boolean blokked?
	
//	private LocalDateTime interactionTimestamp;

//	public Follower(Account account) {
//		this.account = account;
////		this.interactionTimestamp = 
//	}

}
