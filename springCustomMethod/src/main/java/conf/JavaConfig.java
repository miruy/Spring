package conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.Client3;

@Configuration
public class JavaConfig {
	
	@Bean
	public Client3 clientInit() {
		Client3 client3 = new Client3();
		client3.setHost("서버2");
		return client3;
	}
	
	public Client3 clientDestroy() {
		Client3 client3 = new Client3();
		client3.setHost("서버2");
		return client3;
	}
}
