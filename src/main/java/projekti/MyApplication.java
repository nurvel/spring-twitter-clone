package projekti;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import projekti.entity.Account;
import projekti.entity.Tweet;
import projekti.service.AccountService;
import projekti.service.TweetService;

@SpringBootApplication
@EnableAutoConfiguration(exclude = { ErrorMvcAutoConfiguration.class }) // TODO: fix
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

		Account trumpAccount = accountService.createAccout("trump", "password");
		Account obamaAccount = accountService.createAccout("obama", "password");
		Account niiloAccount = accountService.createAccout("niilo", "password");

		Tweet trumpt1 = tweetService.addTweet("Make Amurica great again", trumpAccount);
		Tweet trumpt2 = tweetService.addTweet("Mä meen golffaamaan NY!", trumpAccount);
		Tweet trumpt3 = tweetService.addTweet("It will be huge!", trumpAccount);
		Tweet obamat1 = tweetService.addTweet("Obama tällä, tweet tweet", obamaAccount);
		Tweet obamat2 = tweetService.addTweet("Mitähän tekis eläkkellä", obamaAccount);
		Tweet obamat3 = tweetService.addTweet("Voisin kirjoittaa vaikka kirjan", obamaAccount);
		Tweet niilot1 = tweetService.addTweet("Niilon oma tili :)", niiloAccount);
		Tweet niilot2 = tweetService.addTweet("Aika huikeeta olla täällä", niiloAccount);
		Tweet niilot3 = tweetService.addTweet("Söin juuri voileivän, namskis!", niiloAccount);

		tweetService.commentTweet(obamat2.getId(), trumpAccount, "Tuu golffaa!");
		tweetService.commentTweet(obamat2.getId(), trumpAccount, "Voin heittä mun lentskarilla");
		tweetService.commentTweet(trumpt1.getId(), obamaAccount, "Äläs nyt trumppi");
		tweetService.commentTweet(trumpt1.getId(), niiloAccount, "LOLZ");
		tweetService.commentTweet(niilot3.getId(), niiloAccount, "Oli herkullinen");
		tweetService.commentTweet(niilot3.getId(), obamaAccount, "Kiitos tiedosta");
		tweetService.commentTweet(obamat1.getId(), trumpAccount, "Tervetuloa tee King of Twitter");

	}

}
