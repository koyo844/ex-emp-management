package jp.co.sample.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import jp.co.sample.domain.Administrator;
import jp.co.sample.domain.Employee;

@Repository
public class EmployeeRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;

	
	// rowmapperの作成
	private static final RowMapper<Employee> EMPLOYEE_ROW_MAPPER = (rs, i) -> {
		Employee employee = new Employee();
		employee.setId(rs.getInt("id"));
		employee.setName(rs.getString("name"));
		employee.setImage(rs.getString("image"));
		employee.setGender(rs.getString("gender"));
		employee.setHireDate(rs.getDate("hire_date"));
		employee.setZipCode(rs.getString("mail_address"));
		employee.setZipCode(rs.getString("zip_code"));
		employee.setAddress(rs.getString("address"));
		employee.setTelephone(rs.getString("telephone"));
		employee.setSalary(rs.getInt("salary"));
		employee.setCharacteristics(rs.getString("characteristics"));
		employee.setDependentsCount(rs.getInt("dependents_count"));

		return employee;
	};
	//従業員一覧情報を入社日順で取得
	public List<Employee> findAll(){
		String sql = "SELECT id, name, image, gender, hire_date, mail_address, zip_code, address, telephone, salary, characteristics, dependents_count FROM employees ORDER BY hire_date DESC";
		
		List<Employee> employeeList = template.query(sql, EMPLOYEE_ROW_MAPPER);
		
		//従業員が存在しない場合はサイズ 0 件の従業員一覧を返す
		if (employeeList.size() == 0) {
			return employeeList; 
			}else {
		return employeeList;
		}
	}
	
	//主キーから情報を取得
	public Employee load(Integer id) {
		String sql = "SELECT id, name, image, gender, hire_date, mail_address, zip_code, address, telephone, salary, characteristics, dependents_count FROM employees WHERE id = :id";
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		Employee employee = template.queryForObject(sql, param, EMPLOYEE_ROW_MAPPER);
		
		return employee;
	}
	
	/*
	 * 従業員情報を変更する(id カラムを除いた 従業員情報の全てのカラムを更新できる ような SQL を発行する)。
	 * 全行更新されな いように Where 句の指定を考える。
	 */
	public void update(Employee employee) {
		String sql = "UPDATE members\n"
				+ " SET name = :name, image = :image, gender = :gender, hire_date = :hire_date, mail_address = :mailAddress, zip_code = :zip_code, address = :address, telephone = :telephone, salary = :salary, characteristics = :characteristics, dependents_count = :dependents_count WHERE id = :id";
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", employee.getId())
							.addValue("name", employee.getName())
							.addValue("image", employee.getImage())
							.addValue("gender", employee.getGender())
							.addValue("hire_date", employee.getHireDate())
							.addValue("mail_address", employee.getMailAddress())
							.addValue("zip_Code", employee.getZipCode())
							.addValue("address", employee.getAddress())
							.addValue("telephone", employee.getTelephone())
							.addValue("salary", employee.getSalary())
							.addValue("characteristics", employee.getCharacteristics())
							.addValue("dependents_count", employee.getDependentsCount());
		template.update(sql, param);
						
	}
}
