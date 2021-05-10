package jp.co.sample.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import jp.co.sample.domain.Administrator;
import jp.co.sample.form.InsertAdministratorForm;
import jp.co.sample.service.AdministratorService;

@Controller
@RequestMapping("/")
public class AdministratorController {

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
}
