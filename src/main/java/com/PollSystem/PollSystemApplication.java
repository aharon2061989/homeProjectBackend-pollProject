package com.PollSystem;

import com.PollSystem.service.UserAnswerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PollSystemApplication {
	public static void main(String[] args) {
		SpringApplication.run(PollSystemApplication.class, args);
	}

}
