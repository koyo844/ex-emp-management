package jp.co.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.sample.domain.Administrator;
import jp.co.sample.repository.AdministratorRepository;

@Service
@Transactional
public class AdministratorService {

	@Autowired
	private AdministratorRepository administratorRepository;
	
	// insert() メソッドを呼ぶ処理
	public void insert(Administrator administrator) {
		administratorRepository.insert(administrator);
	}
	
	//ログイン処理を行う
	public Administrator login(String mailAddress, String password) {
		//戻ってきた管理者情報をそのまま呼び出し元に返す。
		return administratorRepository.findByMailAddressAndPassword(mailAddress, password);
		 
	}
}
