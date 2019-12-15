package projekti.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	

	@OneToOne //
	private ImageFile imageFile;
	
//	private LocalDateTime postTime;

	
	@ManyToOne
	private Account account;
	
	// toimiiko sama?
	@OneToMany (mappedBy = "image")
	private List<Comment> comments = new ArrayList<>();

	
	
	

}
