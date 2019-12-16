package projekti.service;

import java.io.IOException;

import javax.tools.FileObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import projekti.entity.Account;
import projekti.entity.Comment;
import projekti.entity.Image;
import projekti.entity.ImageFile;
import projekti.repository.AccountRepository;
import projekti.repository.CommentRepository;
import projekti.repository.ImageFileRepository;
import projekti.repository.ImageRepository;

@Service
public class ImageService {

	@Autowired
	private ImageFileRepository imageFileRepository;

	@Autowired
	private ImageRepository imageRepository;

	@Autowired
	CommentRepository commentRepository;

	@Autowired
	AccountRepository accountRepository;

	public void saveImage(MultipartFile file, Account account, String caption) throws IOException {

		// MAX images 10
		if (account.getImages().size() >= 10)
			return;

		Image image = new Image();
		
		System.out.println(file.getContentType());

		if (file.getContentType().equals("image/gif") || file.getContentType().equals("image/jpeg") || file
				.getContentType()
				.equals("image/jpg")) {

			ImageFile fo = new ImageFile();
			fo.setContent(file.getBytes());
			imageFileRepository.save(fo);

			image.setAccount(account);
			image.setImageFile(fo);
			image.setCaption(caption);
			imageRepository.save(image);

		}

	}

	public Image getImage(Long id) {
		return imageRepository.getOne(id);
	}

	public void commentImage(Long id, Account account, String commentText) {
		Image image = imageRepository.getOne(id);

		Comment comment = new Comment();
		comment.setText(commentText);
		comment.setPoster(account);
		comment.setImage(image);

		commentRepository.save(comment);

	}

	public void likeImage(Long id, Account account) {
		Image image = imageRepository.getOne(id);

		if (image.getLikes().contains(account)) {
			image.getLikes().remove(account);
		} else {
			image.getLikes().add(account);
		}

		imageRepository.save(image);

	}

	public void deleteImage(Long id, Account account) {
		Image image = imageRepository.getOne(id);

		if (image.getAccount() == account) {

			if (account.getProfileImage() != null && account.getProfileImage().getId() == image.getId()) {
				account.setProfileImage(null);
				accountRepository.save(account);
			}
			imageFileRepository.deleteById(image.getImageFile().getId());
			// imageRepository.deleteById(id);
		}

	}
}
