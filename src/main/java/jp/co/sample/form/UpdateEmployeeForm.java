package jp.co.sample.form;

import java.sql.Date;

import javax.validation.constraints.NotBlank;

public class UpdateEmployeeForm {

	@NotBlank(message="idを入力してください")
	private String id;
	@NotBlank(message="扶養人数を入力してください")
	private String dependentsCount;
	private String name;
	private String gender;
	private Date hireDate;
	private String mailAddress;
	private String zipCode;
	private String address;
	private String telephone;
	private String salary;
	private String characteristics;
	
	public String getMailAddress() {
		return mailAddress;
	}
	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDependentsCount() {
		return dependentsCount;
	}
	public void setDependentsCount(String dependentsCount) {
		this.dependentsCount = dependentsCount;
	}
	@Override
	public String toString() {
		return "UpdateEmployeeForm [id=" + id + ", dependentsCount=" + dependentsCount + ", name=" + name + ", gender="
				+ gender + ", hireDate=" + hireDate + ", mailAddress=" + mailAddress + ", zipCode=" + zipCode
				+ ", address=" + address + ", telephone=" + telephone + ", salary=" + salary + ", characteristics="
				+ characteristics + "]";
	}
}
