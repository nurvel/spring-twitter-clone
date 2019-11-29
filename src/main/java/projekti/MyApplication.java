package projekti;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import projekti.entity.Account;
import projekti.service.AccountService;
import projekti.service.TweetService;

@SpringBootApplication
public class MyApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyApplication.class);
	}

	@Autowired
	AccountService accountService;
	
	@Autowired
	TweetService tweetService;

	@EventListener(ApplicationReadyEvent.class)
	public void doSomethingAfterStartup() {

		System.out.println("Init some data");
		
		Account a1 = accountService.createAccout("trump", "password");
		Account a2 = accountService.createAccout("obama", "password");
		Account a3 = accountService.createAccout("niilo", "password");
		
		tweetService.addTweet("Mää oon Trumppi", a1);
		tweetService.addTweet("Tää on mut tweetti", a1);
		tweetService.addTweet("Vois mennä golfaamaan", a1);
		tweetService.addTweet("Obama tällä, tweet tweet", a2);
		tweetService.addTweet("Mitähän tekis eläkkellä", a2);
		tweetService.addTweet("Voisin kirjoittaa vaikka kirjan", a2);
		tweetService.addTweet("Niilon oma tili :)", a3);
		tweetService.addTweet("Aika huikeeta olla täällä", a3);
		tweetService.addTweet("Söin juuri voileivän, namskis!", a3);

	}

}
