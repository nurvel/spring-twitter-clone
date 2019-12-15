package projekti.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

import org.springframework.data.jpa.domain.AbstractPersistable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class ImageFile extends AbstractPersistable<Long> {

	@Lob
	private byte[] content;

	@OneToOne(mappedBy ="imageFile",  cascade = CascadeType.REMOVE)
	Image image;

}
