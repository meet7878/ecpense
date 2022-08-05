package com.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.Bean.AddCategoryBean;
import com.Bean.AddSubCategoryBean;
import com.Bean.ListSubCategoryBean;
import com.Bean.UserBean;
import com.Dao.CategoryDao;
import com.Dao.SubCategoryDao;
@Controller
public class AddSubCategoryController {
	@Autowired
	CategoryDao categoryDao;

	@Autowired 
	SubCategoryDao subcategoryDao;
	
	@GetMapping("/addsubCategory")
	public String subaddcat(AddSubCategoryBean  addsubcategorybean,Model model,HttpSession session) {
		UserBean user = (UserBean)session.getAttribute("users");
		int userId =user.getUserid();
		model.addAttribute("sub", addsubcategorybean);
	
		List<AddCategoryBean> cat = categoryDao.listcategory(userId);
		model.addAttribute("subcategory",cat);
		return"SubCategory";
	}
	
	@PostMapping("/savesubCategory")
	public String addsavecat(@ModelAttribute("subcategory") @Valid AddSubCategoryBean addsubcategorybean,BindingResult result ,Model model,HttpSession session) {
		if(result.hasErrors()) {
			model.addAttribute("subcategory",addsubcategorybean);
			return "SubCategory";
			
		}else {
			/*
			 * UserBean user =(UserBean)session.getAttribute("users"); int userId =
			 * user.getUserid(); addsubcategorybean.setUserId(userId);
			 */
		 subcategoryDao.insertsubcat(addsubcategorybean);
		 model.addAttribute(addsubcategorybean);
		 model.addAttribute("msg","add Subcategory Successfully");
		 return"Home";
		}	
		
	}
	

	
	
}
