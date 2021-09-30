package com.revature.service;

import com.revature.models.Finance;
import com.revature.repo.DAOFinance;

public class FinanceServiceImp implements FinanceService {

	DAOFinance daoFinance;
	@Override
	public Finance loginFinance(String username, String password) {
		// TODO Auto-generated method stub
	
		return this.daoFinance.selectFinance(username, password);
	}

}
