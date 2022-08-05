package com.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.Bean.AddSubCategoryBean;
import com.Bean.ListSubCategoryBean;

@Repository
public class SubCategoryDao {
	@Autowired
	JdbcTemplate stmt;

	public void insertsubcat(AddSubCategoryBean addsubcategorybean) {
		stmt.update("insert into subcategory(subcategoryname,categoryid)values(?,?)",
				addsubcategorybean.getSubCategoryName(), addsubcategorybean.getCategoryId());
	}

	
	/*
	 * public List<ListSubCategoryBean> listsubcategorys(int categoryid,int userId)
	 * { return stmt.query(
	 * "select c.categoryname , s.subcategoryname from category c join subcategory s on c.categoryid = s.categoryid where userid = ?"
	 * , new BeanPropertyRowMapper<ListSubCategoryBean>(ListSubCategoryBean.class),
	 * new Object[] { userId }); }
	 */
	 
	public List<ListSubCategoryBean> listsubcategorys(int categoryid, int userId) {
		return stmt.query("select * from subcategory where categoryid=? ",
				new BeanPropertyRowMapper<ListSubCategoryBean>(ListSubCategoryBean.class), new Object[] { categoryid });
	}
			 

	
	}

