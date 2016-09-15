package com.mkyong.form.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.stereotype.Service;

import com.mkyong.form.model.Servico;

import ch.qos.logback.core.Appender;

@Service("servicoDao")
public class ServicoDaoImp implements ServicoDao {

	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	public void setNamedParameterJdbcTemplate (NamedParameterJdbcTemplate namedParameterJdbcTemplate){
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}
	
	@Override
	public List<Servico> findAll() {
		
		String sql = "SELECT * FROM SERVICO";
		List<Servico> result = namedParameterJdbcTemplate.query(sql, new ServicoMapper());
		return result;
	}

	@Override
	public void update(Servico servico) {
		// TODO Auto-generated method stub

	}

	@Override
	public Servico findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void save(Servico servico) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Servico> findAllProdutos() {
		String sql = "SELECT * FROM SERVICO WHERE isProd = 1";
		List<Servico> resultado = namedParameterJdbcTemplate.query(sql, new ServicoMapper());
		return resultado;
	}
	@Override
	public List<Servico> findAllServicos() {
		String sql = "SELECT * FROM SERVICO WHERE isProd = 0";
		List<Servico> resultado = namedParameterJdbcTemplate.query(sql, new ServicoMapper());
		return resultado;
	}

	@Override
	public List<Servico> findAll(int identificador) {
		
		Map<String,Object> param =  new HashMap<>();
		param.put("identificador", identificador);

		StringBuilder sql = new StringBuilder()
		.append(" SELECT servico.nome, servico.id FROM")
		.append(" servico where isProd = :identificador");
		
		return namedParameterJdbcTemplate.query(sql.toString(), param, getParametizedRowMapper());
	}

	private ParameterizedRowMapper<Servico> getParametizedRowMapper() {
		
		return new ParameterizedRowMapper<Servico>(){

			@Override
			public Servico mapRow(final ResultSet rs,final int rowNum) throws SQLException {
				
				Servico serv = new Servico();
				
				serv.setId(rs.getInt("id"));
				serv.setNome(rs.getString("nome"));
				
				return serv;
			}
		};
	}
	
}
class ServicoMapper implements RowMapper<Servico>{

	@Override
	public Servico mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Servico servico = new Servico();
		
			servico.setId(rs.getInt("id"));
			servico.setNome(rs.getString("nome"));
			servico.setDescricao(rs.getString("descricao"));
			servico.setProd(rs.getBoolean("isProd"));
			servico.setQuantidade(rs.getInt("quantidade"));
			servico.setValor(rs.getInt("valor"));
			servico.setObs(rs.getString("obs"));
			
		return servico;
	}

}
