package de.telekom.sea3.webserver;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import de.telekom.sea3.webserver.model.Person;

@Configuration
public class WebServerConfig {

		@Bean
		public Person person() {
			return new Person();
		}
}
