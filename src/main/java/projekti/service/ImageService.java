package projekti.service;

import java.io.IOException;

import javax.tools.FileObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import projekti.entity.Account;
import projekti.entity.Image;
import projekti.entity.ImageFile;
import projekti.repository.ImageFileRepository;
import projekti.repository.ImageRepository;

@Service
public class ImageService {

	@Autowired
	private ImageFileRepository imageFileRepository;

	@Autowired
	private ImageRepository imageRepository;

	
	public Image saveImage(MultipartFile file, Account account) throws IOException {
		Image image = new Image();

		if (file.getContentType().equals("image/gif")) {


			
			ImageFile fo = new ImageFile();
			fo.setContent(file.getBytes());
//			fo.setImage(image);
			imageFileRepository.save(fo);

			image.setAccount(account);
			image.setImageFile(fo);
			imageRepository.save(image);

			
			
		}

		return image;
	}

}
