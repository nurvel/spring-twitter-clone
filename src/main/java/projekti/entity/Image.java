package projekti.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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

	@OneToOne ( cascade = CascadeType.REMOVE)
	private ImageFile imageFile;

//	private LocalDateTime postTime;

	@ManyToOne
	private Account account;

	private String caption;

	@OneToMany(mappedBy = "image")
	private List<Comment> comments = new ArrayList<>();

	@ManyToMany
	@JoinTable(name = "image_like", joinColumns = @JoinColumn(name = "image_id"), inverseJoinColumns = @JoinColumn(
			name = "account_id"))
	private List<Account> likes = new ArrayList<>();

}
