package com.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.Bean.Loginbean;
import com.Bean.UserBean;

@Repository
public class UserDao {
	@Autowired
	JdbcTemplate stmt;
	
	public void adduser(UserBean user) {
		stmt.update("insert into users(firstname,lastname,email,gender,password,usertype) values(?,?,?,?,?,?)",
				user.getFirstName(), user.getLastName(), user.getEmail(), user.getGender(), user.getPassword(),
				user.getUsertype());
	}
	//login
	public UserBean authenticate(Loginbean login) {

		UserBean sign = null;
		try {
			sign = stmt.queryForObject("select * from users where email = ? and password = ?",
					new BeanPropertyRowMapper<UserBean>(UserBean.class),
					new Object[] { login.getEmail(), login.getPassword() });
			System.out.println(sign);
		} catch (Exception e) {
			System.out.println("invalid email and password");
		}
		return sign;

	}
}
