package com.weatherstatus.services;

import org.apache.logging.log4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weatherstatus.dao.UserDao;
import com.weatherstatus.model.User;

@Service
public class UserService {
	@Autowired
	UserDao userdao;
	private static final Logger logger = LogManager.getLogger(UserService.class.getName());	

	public void register(User user) {
		logger.info("inside register service");
		userdao.register(user);
		
	}

}
