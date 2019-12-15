package projekti.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.data.jpa.domain.AbstractPersistable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Image extends AbstractPersistable<Long> {
	

	@OneToOne
	private ImageFile imageFile;
	
//	private LocalDateTime postTime;

	
	@ManyToOne
	private Account account;
	
	// toimiiko sama?
//	@OneToMany (mappedBy = "tweet")
//	private List<Comment> comments = new ArrayList<>();

	
	
	

}
