package jp.co.sample.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import jp.co.sample.domain.Administrator;
import jp.co.sample.form.InsertAdministratorForm;
import jp.co.sample.form.LoginForm;
import jp.co.sample.service.AdministratorService;

@Controller
@RequestMapping("/")
public class AdministratorController {

	@Autowired
	private HttpSession session;
	
	@Autowired
	private AdministratorService administratorService;
	
	//InsertAdministratorForm をインスタンス化しそのままreturnする処理
	@ModelAttribute
	InsertAdministratorForm setUpInsertAdministratorForm() {
		return new InsertAdministratorForm();
	}
	
	//「administrator/insert.html」にフォワードする処理を記述する。
	@RequestMapping("/toInsert")
	String toInsert() {
		return "administrator/insert.html";
	}
	
	//管理者情報を登録する。
	@RequestMapping("/insert")
	public String insert(InsertAdministratorForm form) {
		Administrator administrator = new Administrator(); //インスタンス化
		BeanUtils.copyProperties(form, administrator);//コピー
		administratorService.insert(administrator);
		return "redirect;/";
	}
	
	//LoginForm をインスタンス化しそのままreturnする処理
	@ModelAttribute
	LoginForm setUpLoginForm() {
		return new LoginForm(); 
	}
	
	//「administrator/login.html」にフォワードする処理
	@RequestMapping("/")
	public String toLogin() {
		return "administrator/login.html";
	}
	
	@RequestMapping("/login")
	public String login(LoginForm form
			, Model model) {
		if (administratorService.login(form.getMailAddress(), form.getPassword()) == null) {
			//エラーメッセージの格納
			model.addAttribute("model", "メールアドレスまたはパスワードが不正です。");
			return "administrator/login.html";
			
		}else {
			/*
			 * セッションスコープに administratorName という名前をつけて管理者名を格納する
			 *とはいえここのnameのところに情報を入れる方法がわからない、、、
			 */
			Administrator administrator = new Administrator();
			model.addAttribute("administratorName", administrator.getName());
			return "forward:/employee/showList";
		}
		
	}
	//@RequestMapping("/logout")
	
	
	
}
