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
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.mkyong.form.model.User;

@Service("userDao")
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
			System.out.println("UserDaoImpl - findById - ");
			e.printStackTrace();
		}

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
		
		String sql = "INSERT INTO USERS (nome, email, telefone, celular, address, passwd,"
					+"isFunc, sexo, cidade, dtNasct, obs) "
					+"VALUES ( :nome, :email, :telefone, :celular, :address, :passwd, "
					+":isFunc,:sexo, :cidade, :dtNasct, :obs)";

		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(user), keyHolder);
		user.setId(keyHolder.getKey().intValue());
		
	}

	@Override
	public void update(User user) {

		String sql = "UPDATE USERS SET nome=:nome, email=:email, telefone=:telefone, celular=:celular, address=:address, " 
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
		paramSource.addValue("nome", user.getNome());
		paramSource.addValue("email", user.getEmail());
		paramSource.addValue("telefone", user.getTelefone());
		paramSource.addValue("celular", user.getCelular());
		paramSource.addValue("address", user.getAddress());
		paramSource.addValue("passwd", user.getPassword());
		paramSource.addValue("isFunc", user.getIsFunc());
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
				user.setNome(rs.getString("nome"));
				user.setEmail(rs.getString("email"));
				user.setTelefone(rs.getString("telefone"));
				user.setCelular(rs.getString("celular"));
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


	@Override
	public List<User> findAll(int identificador) {
		
		Map<String, Object> param = new HashMap<>();
			param.put("identificador", identificador);
		
		StringBuilder sql = new StringBuilder()
		.append(" SELECT users.nome, users.id FROM")
		.append(" users where isFunc = :identificador");
		
		return namedParameterJdbcTemplate.query(sql.toString(), param, getUserMapper());
	}
	
	private ParameterizedRowMapper<User> getUserMapper() {

		return new ParameterizedRowMapper<User>() {

			@Override
			public User mapRow(final ResultSet rs, final int rowNum) throws SQLException {

				User user = new User();

				user.setNome(rs.getString("nome"));
				user.setId(rs.getInt("id"));
				return user;
			}
		};
	}
/*	private String convertListToDelimitedString(List<String> list) {

		String result = "";
		if (list != null) {
			result = StringUtils.arrayToCommaDelimitedString(list.toArray());
		}
		return result;

	}*/


}