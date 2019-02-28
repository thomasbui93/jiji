package kiki.analytics.jiji;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import kiki.analytics.jiji.message.MessengerConfiguration;

@SpringBootApplication
public class JijiApplication {

    @Autowired
    MessengerConfiguration messengerConfiguration;

	public static void main(String[] args) {
		SpringApplication.run(JijiApplication.class, args);
	}
}

