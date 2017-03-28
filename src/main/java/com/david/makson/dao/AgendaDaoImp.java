package com.david.makson.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

import com.david.makson.model.Agenda;

@Service("agendaDao")
public class AgendaDaoImp implements AgendaDao{

	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate){
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}
	
	@Override
	public List<Agenda> findAll() {
		
		String sql = "SELECT * FROM AGENDA";
		
		return namedParameterJdbcTemplate.query(sql, new AgendaMaper());
	}

	@Override
	public void save(Agenda agenda) {
		
		KeyHolder id = new GeneratedKeyHolder();
		
		String sql = "INSERT INTO AGENDA(dt_agenda,hora_agenda,id_funcionario,id_servico,id_cliente,obs)"
					+"VALUES (:dt_agenda,:hora_agenda,:id_funcionario,:id_servico,:id_cliente,:obs)";
		
		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(agenda), id);
		agenda.setId(id.getKey().intValue());
	}

	private SqlParameterSource getSqlParameterByModel(Agenda agenda) {
		
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		
		//paramSource.addValue("id", agenda.getId());
		paramSource.addValue("id_cliente",agenda.getContato());
		paramSource.addValue("id_funcionario", agenda.getFuncionario());
		paramSource.addValue("id_servico", agenda.getServico());
		paramSource.addValue("dt_agenda", agenda.getDtAgenda());
		paramSource.addValue("hora_agenda", agenda.getHoraAgenda());
		paramSource.addValue("obs", agenda.getObs());
		
		return paramSource;
	}

	@Override
	public void update(Agenda agenda) {
		
		String sql = "UPDATE AGENDA SET dt_agenda = :dt_agenda,"
					+"id_funcionario =:id_funcionario,id_servico =:id_servico,"
					+"id_cliente = :id_cliente,hora_agenda=:hora_agenda,obs =:obs";
		
		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(agenda));
	}

	@Override
	public Agenda findById(Integer id) {
		
		Map<String, Object>  paramSource = new HashMap<String, Object>();
		 paramSource.put("id", id);
		
		String sql = "SELECT * FROM AGENDA WHERE id= :id";

		Agenda result = null;
		
		try {
			result = namedParameterJdbcTemplate.queryForObject(sql, paramSource, new AgendaMaper());	
		} catch (EmptyResultDataAccessException e) {
			// TODO: handle exception
		}
		
		
		return result;
	}

	@Override
	public void delete(Integer id) {
		
		String sql = "DELETE FROM AGENDA WHERE id= :id";
		
		/*Map<String, Object> paramSource = new HashMap<String, Object>();
		paramSource.put("id", id);
		
		namedParameterJdbcTemplate.update(sql, paramSource);*/
		
		//or
		
		namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource("id",id));
		
	}

	private static class AgendaMaper implements RowMapper<Agenda>{

		public Agenda mapRow(ResultSet rs, int rowNum) throws SQLException {

			Agenda agenda = new Agenda();
			agenda.setId(rs.getInt("id"));
			agenda.setContato(rs.getInt("id_cliente"));
			agenda.setDtAgenda(rs.getString("dt_agenda"));
			agenda.setHoraAgenda(rs.getString("hora_agenda"));
			agenda.setServico(rs.getInt("id_servico"));
			agenda.setFuncionario(rs.getInt("id_funcionario"));
			agenda.setObs(rs.getString("obs"));
			
			return agenda;
		}
		
	}

	@Override
	public List<Agenda> validaAgenda(String data, String hora, int funcionario) {
		
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("data", data);
		paramMap.put("hora", hora);
		paramMap.put("funcionario", funcionario);
		
		StringBuilder sql = new StringBuilder()
		.append("SELECT * FROM AGENDA ")
		.append("WHERE dt_agenda = :data ")
		.append("AND hora_agenda = :hora ")
		.append("AND id_funcionario = :funcionario");
		
		return namedParameterJdbcTemplate.query(sql.toString(), paramMap, new AgendaMaper());
	}
}
