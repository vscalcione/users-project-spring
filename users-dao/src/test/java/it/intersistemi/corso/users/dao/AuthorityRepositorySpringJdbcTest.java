package it.intersistemi.corso.users.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import it.intersistemi.corso.users.dao.jdbc.AuthorityRepository;
import it.intersistemi.corso.users.model.AuthorityDto;

public class AuthorityRepositorySpringJdbcTest {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("users-dao-context.xml");

		AuthorityRepository authorityRepository = ctx.getBean(AuthorityRepository.class);

		AuthorityDto entity = new AuthorityDto();
		entity.setAuthority("VIEW_FILE2");
		entity.setDescription("Visualizza file");

		authorityRepository.insert(entity);

		Iterable<AuthorityDto> it = authorityRepository.findAll();
		it.forEach(a -> System.out.println(
						a.getAuthority()
						+ " - "
						+ a.getDescription()));
	}

}
