package com.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.Bean.AddCategoryBean;
import com.Bean.CategoryReportBean;

@Repository
public class CategoryDao {
	@Autowired
	JdbcTemplate stmt;

	public void insercat(AddCategoryBean addcategorybean) {
		stmt.update("insert into category(categoryname,userId)values(?,?)", addcategorybean.getCategoryName(),
				addcategorybean.getUserId());
	}

	public List<AddCategoryBean> listcategory(int userId) {
		return stmt.query("select * from category  where userid=? ",
				new BeanPropertyRowMapper<AddCategoryBean>(AddCategoryBean.class), new Object[] { userId });
	}

	public List<CategoryReportBean> getCategoryByInvestment() {
		return stmt.query(
				"select sum(price) as totalprice,categoryname from items e join category c on e.categoryid = c.categoryid group by categoryname",
				new BeanPropertyRowMapper<CategoryReportBean>(CategoryReportBean.class));
	}

}
