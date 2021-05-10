package jp.co.sample.domain;

import java.util.Date;

//従業員情報を表すドメイン
public class Employee {
	private Integer id;
	private String name;
	private String image;
	private String gender;
	private Date hireDate;//入社日
	private String zipCode;
	private String address;
	private String telephone;
	private String salary;
	private String characteristics;//特性
	private Integer dependents_count;//扶養人数
	
	public Employee() {}
	
	public Employee(Integer id, String name, String image, String gender, Date hireDate, String zipCode,
			String address, String telephone, String salary, String characteristics, Integer dependents_count) {
		super();
		this.id = id;
		this.name = name;
		this.image = image;
		this.gender = gender;
		this.hireDate = hireDate;
		this.zipCode = zipCode;
		this.address = address;
		this.telephone = telephone;
		this.salary = salary;
		this.characteristics = characteristics;
		this.dependents_count = dependents_count;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getCharacteristics() {
		return characteristics;
	}

	public void setCharacteristics(String characteristics) {
		this.characteristics = characteristics;
	}

	public Integer getDependents_count() {
		return dependents_count;
	}

	public void setDependents_count(Integer dependents_count) {
		this.dependents_count = dependents_count;
	}

	@Override
	public String toString() {
		return "employees [id=" + id + ", name=" + name + ", image=" + image + ", gender=" + gender + ", hireDate="
				+ hireDate + ", zipCode=" + zipCode + ", address=" + address + ", telephone=" + telephone + ", salary="
				+ salary + ", characteristics=" + characteristics + ", dependents_count=" + dependents_count + "]";
	}
	
	
	
}

