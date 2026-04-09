package com.pedro.picpaychallenge;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.pedro.picpaychallenge.domain.User;
import com.pedro.picpaychallenge.domain.enums.UserType;
import com.pedro.picpaychallenge.repository.UserRepository;

@SpringBootApplication
public class PicpaychallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PicpaychallengeApplication.class, args);
	}
	
    @Bean
    CommandLineRunner init(UserRepository userRepository) {
        return args -> {

            User u1 = new User(
                null,
                "Pedro",
                "12345678900",
                "pedro@email.com",
                "123",
                new BigDecimal("1000"),
                UserType.COMMON
            );

            User u2 = new User(
                null,
                "Loja",
                "98765432100",
                "loja@email.com",
                "123",
                new BigDecimal("0"),
                UserType.MERCHANT
            );

            userRepository.save(u1);
            userRepository.save(u2);
        };
    }

}
