package projekti.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import projekti.entity.Account;
import projekti.service.AccountService;
import projekti.service.ImageService;

@Controller
public class ImageController {

	@Autowired
	private AccountService accountService;

	@Autowired
	private ImageService imageService;

//	// Tää menee muihin controllereihin henk. koht
//	@GetMapping("/images")
//	public String getImages(Model model) {
//		//List<Image> images = imageService.findAll();
//		return null; // TODO: html file
//	}

	@PostMapping("image")
	public String uploadImage(@RequestParam("file") MultipartFile file) {

		Account account = accountService.getAuthenticatedAcccount();

		try {
			imageService.saveImage(file, account);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return account == null ? "redirect:/" : "mywall";
	}

	// upload
	// delete
	// set to profile img

	// comment
	// like

}
