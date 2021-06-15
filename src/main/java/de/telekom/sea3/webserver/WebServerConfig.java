package de.telekom.sea3.webserver;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebServerConfig {

		@Bean
		public Katze katze() {
			return new Katze();
		}
}
