package jp.co.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import jp.co.sample.form.InsertAdministratorForm;
import jp.co.sample.service.AdministratorService;

@Controller
@RequestMapping("/")
public class AdministratorController {

	//InsertAdministratorForm をインスタンス化しそのままreturnする処理
	@Autowired
	private AdministratorService administratorService;
	
	@ModelAttribute
	InsertAdministratorForm setUpInsertAdministratorForm(Model model) {
		InsertAdministratorForm form = new InsertAdministratorForm();
		model.addAttribute(form);
		return form;
	}
	//「administrator/insert.html」にフォワードする処理を 記述する。
	@RequestMapping("/toInsert")
	String toInsert() {
		return "administrator/insert.html";
	}
}
