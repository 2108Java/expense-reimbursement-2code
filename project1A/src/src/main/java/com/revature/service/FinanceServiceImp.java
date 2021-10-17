package com.revature.service;

import com.revature.models.Finance;
import com.revature.repo.DAOFinance;

public class FinanceServiceImp implements FinanceService {

	private DAOFinance daoFinance;
	
	
	public FinanceServiceImp(DAOFinance daoFinance) {
		super();
		this.daoFinance = daoFinance;
	}


	@Override
	public Finance loginFinance(String username, String password) {
		// TODO Auto-generated method stub
	
		return this.daoFinance.selectFinance(username, password);
	}

}
