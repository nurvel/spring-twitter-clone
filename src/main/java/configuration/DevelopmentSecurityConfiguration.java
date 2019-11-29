package configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class DevelopmentSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    public void configure( HttpSecurity http) throws Exception {
    	
        // Pyyntöjä ei tarkasteta
        //sec.ignoring().antMatchers("/**"); // WebSecurity sec
                
		// poistetaan csrf-tarkistus käytöstä h2-konsolin vuoksi
		http.csrf().disable();
		http.headers().frameOptions().sameOrigin();
		
		
    }
}
