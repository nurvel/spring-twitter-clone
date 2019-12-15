package projekti.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import projekti.entity.Account;
import projekti.entity.Image;
import projekti.service.AccountService;
import projekti.service.ImageService;

@Controller
public class ImageController {

	@Autowired
	private AccountService accountService;

	@Autowired
	private ImageService imageService;

	@PostMapping("image")
	public String uploadImage(@RequestParam("file") MultipartFile file, @RequestParam String caption) {

		Account account = accountService.getAuthenticatedAcccount();

		try {
			imageService.saveImage(file, account, caption);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("ERRORII PUKAAA");
			e.printStackTrace();
		}

		return "redirect:/mywall";
		// return account == null ? "redirect:/" : "mywall";
	}

	@GetMapping(path = "/image/{id}", produces = "image/png")
	@ResponseBody
	public byte[] get(@PathVariable Long id) {
		Image img = imageService.getImage(id);
		return img.getImageFile().getContent();
	}

	@PostMapping("image/comment")
	public String commentImage(HttpServletRequest request, @RequestParam Long id, @RequestParam String commentText) {
		Account account = accountService.getAuthenticatedAcccount();

		imageService.commentImage(id, account, commentText);

		String referer = request.getHeader("Referer");
		return "redirect:" + referer;
	}

	@PostMapping("image/like")
	public String likeImage(HttpServletRequest request, @RequestParam Long id) {
		Account account = accountService.getAuthenticatedAcccount();
		imageService.likeImage(id, account);
		String referer = request.getHeader("Referer");
		return "redirect:" + referer;
	}

	@PostMapping("image/setprofile")
	public String setProfileImage(HttpServletRequest request, @RequestParam Long id) {
		Account account = accountService.getAuthenticatedAcccount();
		accountService.setProfileImage(account, id);

		String referer = request.getHeader("Referer");
		return "redirect:" + referer;
	}

	@DeleteMapping("image")
	public String deleteImage(@RequestParam Long id) {
		Account account = accountService.getAuthenticatedAcccount();
		accountService.setProfileImage(account, id);
		imageService.deleteImage(id, account);
		return "redirect:mywall";
	}

	// delete
	// set to profile img

}
