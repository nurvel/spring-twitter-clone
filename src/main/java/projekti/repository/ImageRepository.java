package projekti.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projekti.entity.Image;
import projekti.entity.ImageFile;

public interface ImageRepository extends JpaRepository<Image, Long> {

}
