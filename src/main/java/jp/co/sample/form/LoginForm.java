package jp.co.sample.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class LoginForm {
	@NotBlank(message="メールアドレスを入力してください")
	private String mailAddress;
	@Size(min=1, max=127, message="パスワードは4文字以上でお願いします")
	private String password;
	
	
	public String getMailAddress() {
		return mailAddress;
	}


	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "LoginForm [mailAddress=" + mailAddress + ", password=" + password + "]";
	}
	
	

}
