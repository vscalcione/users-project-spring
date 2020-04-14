package it.intersistemi.corso.users.dao.jdbc.plain.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import it.intersistemi.corso.users.dao.jdbc.DataAccessException;
import it.intersistemi.corso.users.dao.jdbc.plain.mapper.AuthorityMapper;
import it.intersistemi.corso.users.dao.jdbc.AuthorityRepository;
import it.intersistemi.corso.users.model.AuthorityDto;

public class AuthorityRepositoryImpl implements AuthorityRepository {
	private DataSource dataSource;

	public AuthorityRepositoryImpl(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}

	@Override
	public Iterable<AuthorityDto> findAll() {
		try (
			Connection conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM AUTHORITIES");
			ResultSet rs = ps.executeQuery();
				) {
			return new AuthorityMapper().mapRowsAsList(rs);
		} catch (SQLException e) {
			throw new DataAccessException(e);
		}
	}

	@Override
	public AuthorityDto findById(String id) {
		try (
			Connection conn = dataSource.getConnection();
			PreparedStatement ps =
					conn.prepareStatement("SELECT * FROM AUTHORITIES WHERE AUTHORITY = ?");
				) {
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return new AuthorityMapper().mapRow(rs, rs.getRow());
			} else {
				return null;
			}
		} catch (SQLException e) {
			throw new DataAccessException(e);
		}
	}

	@Override
	public String insert(AuthorityDto entity) {
		try (
			Connection conn = dataSource.getConnection();
			PreparedStatement ps =
					conn.prepareStatement(
						"INSERT INTO AUTHORITIES (AUTHORITY, DESCRIPTION) VALUES (?, ?)");
				) {
			ps.setString(1, entity.getAuthority());
			ps.setString(2, entity.getDescription());
			ps.executeUpdate();
			return entity.getAuthority();
		} catch (SQLException e) {
			throw new DataAccessException(e);
		}
	}

	@Override
	public int update(String id, AuthorityDto entity) {
		try (
			Connection conn = dataSource.getConnection();
			PreparedStatement ps =
					conn.prepareStatement(
						"UPDATE AUTHORITIES SET AUTHORITY = ?, DESCRIPTION = ? WHERE AUTHORITY = ?");
				) {
			ps.setString(1, entity.getAuthority());
			ps.setString(2, entity.getDescription());

			ps.setString(3, id);
			return ps.executeUpdate();
		} catch (SQLException e) {
			throw new DataAccessException(e);
		}
	}

	@Override
	public int deleteById(String id) {
		try (
			Connection conn = dataSource.getConnection();
			PreparedStatement ps =
					conn.prepareStatement(
						"DELETE AUTHORITIES WHERE AUTHORITY = ?");
				) {
			ps.setString(1, id);
			return ps.executeUpdate();
		} catch (SQLException e) {
			throw new DataAccessException(e);
		}
	}

}
