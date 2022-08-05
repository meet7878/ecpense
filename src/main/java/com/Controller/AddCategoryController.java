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
import org.springframework.web.bind.annotation.PostMapping;

import com.Bean.AddCategoryBean;

import com.Bean.UserBean;
import com.Dao.CategoryDao;

@Controller
public class AddCategoryController {

	@Autowired 
	CategoryDao categoryDao;
	
	@GetMapping("/addcategory")
	public String addcat(AddCategoryBean  addcategorybean,Model model) {
		model.addAttribute("category", addcategorybean);
		return"Category";
	}
	
	@PostMapping("/categorys")
	public String addsavecat(@ModelAttribute("category") @Valid AddCategoryBean addcategorybean,BindingResult result ,Model model,HttpSession session) {
		if(result.hasErrors()) {
			model.addAttribute("category",addcategorybean);
			return "Category";
			
		}else {
			UserBean user =(UserBean)session.getAttribute("users");
		 int userId	= user.getUserid();
		 addcategorybean.setUserId(userId);
		 categoryDao.insercat(addcategorybean);
		 model.addAttribute("msg","add category Successfully");
		 return"Category";
		}	
		
	}
	
	@GetMapping("/listcategory")
	public String listcategory(HttpSession session,Model model) {
		UserBean user = (UserBean)session.getAttribute("users");
		int userId = user.getUserid();
		List<AddCategoryBean> cat = categoryDao.listcategory(userId);
		model.addAttribute("category",cat);
		return "Additems";
	}
	
}
