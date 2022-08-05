package com.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.Bean.ListSubCategoryBean;
import com.Bean.UserBean;
import com.Dao.SubCategoryDao;

@RestController
public class listController {
	@Autowired
	SubCategoryDao subCategoryDao;
	
	
	@GetMapping("/listsubcategory/{categoryId}")
	public List<ListSubCategoryBean> listsubcategory(@PathVariable("categoryId") int categoryid,HttpSession session) {
		
		UserBean user = (UserBean)session.getAttribute("users");
		int userId =user.getUserid();
		return subCategoryDao.listsubcategorys(categoryid,userId);
	}
}
