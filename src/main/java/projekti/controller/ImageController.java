package projekti.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import projekti.entity.Account;
import projekti.entity.ImageFile;
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
			System.out.println("ERRORII PUKAAA");
			e.printStackTrace();
		}

		return "redirect:/mywall";
		//return account == null ? "redirect:/" : "mywall";
	}

	@GetMapping(path ="/image/{id}", produces= "image/png")
	@ResponseBody
	public byte[] get (@PathVariable Long id) {
		ImageFile fo = imageService.getImageFile(id);
		return fo.getContent();
	}
	
	
	// delete
	// set to profile img

	// comment
	// like

}
