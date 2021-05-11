package jp.co.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

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
	public String update(UpdateEmployeeForm form) {
		
		//送られてきたリクエストパラメータのidを使用して Employee ドメインを主キー検索
		Employee employee = employeeService.showDetail(Integer.parseInt(form.getId())); 
		
		employee.setDependentsCount(Integer.parseInt(form.getDependentsCount()));
		employee.setId(Integer.parseInt(form.getId()));
		//employeeService の update()メソッドを呼ぶ
		employeeService.update(employee);
		return "redirect:/employee/showList";
	}
	
	
}
	


