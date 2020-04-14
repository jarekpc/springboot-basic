package com.example.springbootbasic;

import com.example.springbootbasic.entity.User;
import com.example.springbootbasic.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootBasicApplication {

    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringbootBasicApplication.class, args);
    }


    //	@Override
//	public void run(String... args) throws Exception {
////		return () -> {
////			userRepository.save(new User(1,"Jarek", "jarekpc@o2.pl", true));
////			userRepository.save(new User(1,"Jarek", "jarekpc@o2.pl", true));
////		};
//		return (args) -> {
//			// save a couple of customers
//		};
//	}
    @Bean
    public CommandLineRunner demo(UserRepository repository) {
        return (args) -> {
            // save a couple of customers
            repository.save(new User(1,"Jarek", "jarekpc@o2.pl", true));
            repository.save(new User(2,"Monika", "akinom_84@o2.pl", false));
        };
    }
}
