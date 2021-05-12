package jp.co.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;

import jp.co.sample.domain.Employee;
import jp.co.sample.form.UpdateEmployeeForm;
import jp.co.sample.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	//UpdateEmployeeFormをインスタンス化しそのまま return する処理を記述する。
	@ModelAttribute
	public UpdateEmployeeForm setUpUpdateEmployeeForm() {
		return new UpdateEmployeeForm();
	}
	
	//従業員一覧を出力
	@RequestMapping("/showList")
	public String showList(Model model) {
		model.addAttribute("employeeList", employeeService.showList());
		return "employee/list.html";
	}
	
	//従業員情報の詳細を出力
	@RequestMapping("/showDetail")
	public String showDetail(String id,Model model) {
		model.addAttribute("employee", employeeService.showDetail(Integer.parseInt(id)));
		return "employee/detail.html";
	}
	
	//idを元に扶養人数を上書きする
	@RequestMapping("/update")
	public String update(
			@Validated UpdateEmployeeForm form
			,BindingResult result
			,Model model
			) {
		
		//入力値チェックで引っ掛かると登録ページに戻る(showDetailごと持ってこないと情報なくなってしまう)
				if(result.hasErrors()) {
					return showDetail(form.getId(), model);//教科書p.143参照
				}
		
		//送られてきたリクエストパラメータのidを使用して Employee ドメインを主キー検索
		Employee employee = employeeService.showDetail(Integer.parseInt(form.getId())); //主キー検索で合致したキーの情報を全て取得
		
		employee.setDependentsCount(Integer.parseInt(form.getDependentsCount()));//扶養人数を上書き
		employee.setName(form.getName());//名前を上書き
		employee.setGender(form.getGender());
		employee.setHireDate(form.getHireDate());
		employee.setMailAddress(form.getMailAddress());
		employee.setZipCode(form.getZipCode());
		employee.setTelephone(form.getTelephone());
		employee.setSalary(Integer.parseInt(form.getSalary()));
		employee.setCharacteristics(form.getCharacteristics());
		employee.setId(Integer.parseInt(form.getId()));//idを上書き（しなくてもいい）
		//employeeService の update()メソッドを呼ぶ→上書きした情報を更新,emoployeeに格納する
		employeeService.update(employee);
		return "redirect:/employee/showList";
	}
	
	
}
	


