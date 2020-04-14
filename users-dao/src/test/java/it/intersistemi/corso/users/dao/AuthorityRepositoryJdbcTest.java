package it.intersistemi.corso.users.dao;

import org.apache.commons.dbcp2.BasicDataSource;

import it.intersistemi.corso.users.dao.jdbc.AuthorityRepository;
import it.intersistemi.corso.users.dao.jdbc.plain.impl.AuthorityRepositoryImpl;
import it.intersistemi.corso.users.model.AuthorityDto;

public class AuthorityRepositoryJdbcTest {
	private static BasicDataSource ds = new BasicDataSource();

    static {
        ds.setUrl("jdbc:h2:tcp://localhost:9092/~/workspace-intersistemi-2018/users-dao/users");
        ds.setUsername("");
        ds.setPassword("");
        ds.setMinIdle(5);
        ds.setMaxIdle(10);
        ds.setMaxOpenPreparedStatements(100);
    }

	public static void main(String[] args) {
		AuthorityRepository authorityRepository = new AuthorityRepositoryImpl(ds);

		AuthorityDto entity = new AuthorityDto();
		entity.setAuthority("VIEW_FILE");
		entity.setDescription("Visualizza file");

		authorityRepository.insert(entity);

		Iterable<AuthorityDto> it = authorityRepository.findAll();
		it.forEach(a -> System.out.println(
						a.getAuthority()
						+ " - "
						+ a.getDescription()));
	}

}
