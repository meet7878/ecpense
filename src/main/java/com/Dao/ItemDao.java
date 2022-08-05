package com.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.Bean.AddAccountBean;
import com.Bean.AddItemBean;
import com.Bean.ListCategoryBean;

@Repository
public class ItemDao {
	@Autowired
	JdbcTemplate stmt;

	public void insertitems(AddItemBean addbean, int balance, int accountType) {
		stmt.update(
				"insert into items(itemname,location,price,item,date,time,userid,categoryid) values(?,?,?,?,?,?,?,?)",
				addbean.getItemName(), addbean.getLocation(), addbean.getPrice(), addbean.getItem(), addbean.getDate(),
				addbean.getTime(), addbean.getUserId(), addbean.getCategoryId());

		// final balance set
		stmt.update("update accounts set accountbalance=? where accountid = ? and userid =?", balance, accountType,
				addbean.getUserId());

	}

	public AddAccountBean getbalance(int userId, int accountType) {

		return stmt.queryForObject("select * from accounts where userid =? and accountid=?",
				new BeanPropertyRowMapper<AddAccountBean>(AddAccountBean.class), new Object[] { userId, accountType });
	}

	// list expense
	public List<ListCategoryBean> listitem(int userId) {
		
		return stmt.query("select * from items i join category c on i.categoryid = c.categoryid  where i.userid =?",
				new BeanPropertyRowMapper<ListCategoryBean>(ListCategoryBean.class), userId);

	}

	public void addaccount(AddAccountBean accountbean) {
		stmt.update(
				"insert into accounts(accountnumber,accounttype,accountbalance,userid,accountmode,upiid) values(?,?,?,?,?,?)",
				accountbean.getAccountNumber(), accountbean.getAccountType(), accountbean.getAccountBalance(),
				accountbean.getUserId(), accountbean.getAccountMode(), accountbean.getUpiId());

	}

	public List<AddAccountBean> listaccount(int userId) {
		return stmt.query("select * from accounts where userid =?",
				new BeanPropertyRowMapper<AddAccountBean>(AddAccountBean.class), new Object[] { userId });

	}

}
