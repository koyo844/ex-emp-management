package jp.co.sample.domain;

//管理者情報を表すドメイン
public class Administrator {
	
	private Integer id;
	private String name;
	private String mailAddress;
	private String password;
	
	//引数のないコンストラクタ
	public Administrator() {}
	
	//全てのフィールドを引数にとるコンストラクタ
	public Administrator(Integer id, String name, String mailAddress, String password) {
		super();
		this.id = id;
		this.name = name;
		this.mailAddress = mailAddress;
		this.password = password;
	}
	@Override
	public String toString() {
		return "administrator [id=" + id + ", name=" + name + ", mailAddress=" + mailAddress + ", passwrd=" + password
				+ "]";
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
	public String getMailAddress() {
		return mailAddress;
	}
	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String passwrd) {
		this.password = passwrd;
	}

	
}
