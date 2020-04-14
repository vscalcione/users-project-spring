package it.intersistemi.corso.users.dao;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import it.intersistemi.corso.users.dao.jdbc.UserRepository;
import it.intersistemi.corso.users.model.UserDto;

public class UserRepositorySpringJdbcTest {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("users-dao-context.xml");

		UserRepository userRepository = ctx.getBean(UserRepository.class);

		UserDto[] users = new UserDto[100];
		for(int i=0 ; i<users.length ; i++) {
			UserDto user = new UserDto();
			user.setUserName("user_"+i);
			user.setPassword("password_"+i);
			user.setEnabled(true);
			Integer userId = userRepository.insert(user);
			user.setUserId(userId);

			users[i] = user;
		}

		Arrays.stream(users)
		.forEach(u -> System.out.println(u.getUserId() + " - " + u.getUserName() ));
	}

}
