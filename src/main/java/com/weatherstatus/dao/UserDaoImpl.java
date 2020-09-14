package com.weatherstatus.dao;


import javax.sql.DataSource;

import org.apache.logging.log4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.weatherstatus.config.DemoSecurityConfig;
import com.weatherstatus.model.User;

public class UserDaoImpl implements UserDao {
	@Autowired
	DataSource datasource;

	private static final Logger logger = LogManager.getLogger(UserDaoImpl.class.getName());	

	public void register(User user) {
		logger.info("inside register DAO");
		JdbcTemplate jdbcTemplate = new JdbcTemplate(datasource);
		String sql_user = "insert into users values(?,?,?,?,?)";
		String sql_authorities = "insert into authorities values(?,?)";
		try {
			logger.info("insert user data AND user role(user) in data base");
			jdbcTemplate.update(sql_user,
					new Object[] { user.getUsername(), new BCryptPasswordEncoder().encode(user.getPassword()),
							user.getEmail(), user.getmobileNumber(), "1" });
			jdbcTemplate.update(sql_authorities, new Object[] { user.getEmail(), "ROLE_ADMIN" });
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
	}
}
