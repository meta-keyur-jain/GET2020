package com.metacube.assignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class PassService {

	@Autowired
	private PassDaoImpl passDao;

	public int generatePass(Pass pass) {
		return passDao.addPass(pass);
	}
}
