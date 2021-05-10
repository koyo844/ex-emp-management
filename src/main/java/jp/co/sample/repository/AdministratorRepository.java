package jp.co.sample.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import jp.co.sample.domain.Administrator;

@Repository
public class AdministratorRepository {
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	//rowmapperの作成
	private static final RowMapper<Administrator> ADMINISTRATOR_ROW_MAPPER = (rs, i) ->{
		Administrator administrator = new Administrator();
		administrator.setId(rs.getInt("id"));
		administrator.setName(rs.getString("name"));
		administrator.setMailAddress(rs.getString("mail_address"));
		administrator.setPassword(rs.getString("password"));
	
		return administrator; 
	};
	
	//管理者を登録する（管理者情報を挿入する）
	public void insert(Administrator administrator) {
		String sql = "INSERT INTO administrators(id, name, mail_address, password) VALUES (:id, :name, :mailAddress, :password)";
		//Valuesの内容に代入する内容
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", administrator.getId())
								.addValue("name", administrator.getName())
								.addValue("mail_address", administrator.getMailAddress())
								.addValue("password", administrator.getPassword());
	}
	//パスワードとアドレスから管理者情報を取得する
	public Administrator findByMailAddressAndPassword(String mailAddress, String password) {
		String sql = "SELECT id, name, mail_address, password FROM administrators WHERE mail_address = :mailaddress AND password = :mail_address";
		SqlParameterSource param = new MapSqlParameterSource().addValue("mail_address", mailAddress)
							.addValue("password", password);
		List<Administrator> administratorList = template.query(sql, param, ADMINISTRATOR_ROW_MAPPER);
		
		if (administratorList.size() == 0) {
		return null; 
		}
		return administratorList.get(0);
	}
}

