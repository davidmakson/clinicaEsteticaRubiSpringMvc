package com.mkyong.form.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import com.mkyong.form.model.Servico;

@Service("servicoDao")
public class ServicoDaoImp implements ServicoDao {

	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	public void setNamedParameterJdbcTemplate (NamedParameterJdbcTemplate namedParameterJdbcTemplate){
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}
	
	@Override
	public List<Servico> findAll() {
		
		String sql = "SELECT * FROM SERVICO where isprod is null";
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
		String sql = "SELECT * FROM SERVICO WHERE isprod is NOT null";
		List<Servico> resultado = namedParameterJdbcTemplate.query(sql, new ServicoMapper());
		return resultado;
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
