package com.mkyong.form.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.mkyong.form.model.User;

@Repository
public class UserDaoImpl implements UserDao {

	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) throws DataAccessException {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	@Override
	public User findById(Integer id) {

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);

		String sql = "SELECT * FROM users WHERE id=:id";

		User result = null;
		try {
			result = namedParameterJdbcTemplate.queryForObject(sql, params, new UserMapper());
		} catch (EmptyResultDataAccessException e) {
			// do nothing, return null
		}

		/*
		 * User result = namedParameterJdbcTemplate.queryForObject( sql, params,
		 * new BeanPropertyRowMapper<User>());
		 */

		return result;

	}

	@Override
	public List<User> findAll() {

		String sql = "SELECT * FROM users";
		List<User> result = namedParameterJdbcTemplate.query(sql, new UserMapper());

		return result;

	}

	@Override
	public void save(User user) {

		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		String sql = "INSERT INTO USERS (nome, email, address, passwd,"
					+"isFunc, sexo, cidade, dtNasct, obs) "
					+"VALUES ( :nome, :email, :address, :passwd, "
					+":isFunc,:sexo, :cidade, :dtNasct, :obs)";

		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(user), keyHolder);
		user.setId(keyHolder.getKey().intValue());
		
	}

	@Override
	public void update(User user) {

		String sql = "UPDATE USERS SET nome=:nome, email=:email, address=:address, " 
					+"passwd=:passwd, isFunc=:isFunc, sexo=:sexo, "
					+"cidade=:cidade, dtNasct=:dtNasct, obs=:obs WHERE id=:id";

		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(user));

	}

	@Override
	public void delete(Integer id) {

		String sql = "DELETE FROM USERS WHERE id= :id";
		namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource("id", id));

	}

	private SqlParameterSource getSqlParameterByModel(User user) {

		// Unable to handle List<String> or Array
		// BeanPropertySqlParameterSource

		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("id", user.getId());
		paramSource.addValue("nome", user.getName());
		paramSource.addValue("email", user.getEmail());
		paramSource.addValue("address", user.getAddress());
		paramSource.addValue("passwd", user.getPassword());
		paramSource.addValue("isFunc", user.isFunc());
		paramSource.addValue("sexo", user.getSex());
		paramSource.addValue("cidade", user.getCidade());
		paramSource.addValue("dtNasct", user.getDtNasct());
		paramSource.addValue("obs", user.getObs());

		return paramSource;
	}

	private static final class UserMapper implements RowMapper<User> {

		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			user.setId(rs.getInt("id"));
			user.setName(rs.getString("nome"));
			user.setEmail(rs.getString("email"));
			user.setAddress(rs.getString("address"));
			user.setPassword(rs.getString("passwd"));
			user.setIsFunc(rs.getBoolean("isFunc"));
			user.setSex(rs.getString("sexo"));
			user.setPassword(rs.getString("cidade"));
			user.setDtNasct(rs.getDate("dtNasct"));
			user.setObs(rs.getString("obs"));
			return user;
		}
	}

	private static List<String> convertDelimitedStringToList(String delimitedString) {

		List<String> result = new ArrayList<String>();

		if (!StringUtils.isEmpty(delimitedString)) {
			result = Arrays.asList(StringUtils.delimitedListToStringArray(delimitedString, ","));
		}
		return result;

	}

/*	private String convertListToDelimitedString(List<String> list) {

		String result = "";
		if (list != null) {
			result = StringUtils.arrayToCommaDelimitedString(list.toArray());
		}
		return result;

	}*/

}