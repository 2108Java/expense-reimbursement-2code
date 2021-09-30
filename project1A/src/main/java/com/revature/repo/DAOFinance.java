package com.revature.repo;

import com.revature.models.Finance;

public interface DAOFinance {

	Finance selectFinance(String username, String password);

}
