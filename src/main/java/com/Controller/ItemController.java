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

import com.Bean.AddAccountBean;
import com.Bean.AddCategoryBean;
import com.Bean.AddItemBean;
import com.Bean.AddSubCategoryBean;
import com.Bean.ListCategoryBean;
import com.Bean.ListSubCategoryBean;
import com.Bean.UserBean;
import com.Dao.CategoryDao;
import com.Dao.ItemDao;
import com.Dao.SubCategoryDao;


@Controller
public class ItemController {
	
	@Autowired
	ItemDao userDao;
	@Autowired 
	CategoryDao categoryDao;
	
	@Autowired 
	SubCategoryDao subcategoryDao;
  
	@GetMapping("/additem")
	public String additem(AddItemBean addbean,Model model,HttpSession session) {
		UserBean user = (UserBean)session.getAttribute("users");
		int userId =user.getUserid();
		model.addAttribute("item",addbean);
		
		List<AddAccountBean> accounts = userDao.listaccount(userId);
		model.addAttribute("account",accounts);
		
		List<AddCategoryBean> cat = categoryDao.listcategory(userId);
		model.addAttribute("category",cat);
		
		 
		/*
		 * List<ListSubCategoryBean> cate =
		 * subcategoryDao.listsubcategorys(categoruserId);
		 * model.addAttribute("subcategory",cate);
		 */
		 
		
		return "Additems";
	}
	
	@PostMapping("/additems")
	public String savuser(@ModelAttribute("item") @Valid AddItemBean addbean , BindingResult result, Model model,HttpSession session) {
		System.out.println(result);
		
		if (result.hasErrors()) {
			model.addAttribute("item", addbean);
			return "Additems";
		}

		else {
			System.out.println("itemname" + addbean.getItemName());
			System.out.println("result" + result);
			UserBean user = (UserBean)session.getAttribute("users");
			int userId =user.getUserid();
			
		     int accountType = Integer.parseInt(addbean.getItem());
		     System.out.println("accountType");
		     AddAccountBean account = userDao.getbalance(userId,accountType);
		     System.out.println(account+"   sdfghj");
		     int balance = account.getAccountBalance()-addbean.getPrice();
		     addbean.setUserId(userId);
			userDao.insertitems(addbean,balance,accountType);
			
			
			model.addAttribute(addbean);
			model.addAttribute("msg", " Item add Suceefully");
			return "Additems";

		}
		
		
	}
	
	@GetMapping("/listitems")
	public String listitems(HttpSession session,Model model) {
		UserBean user = (UserBean)session.getAttribute("users");
		int userId = user.getUserid();
         List<ListCategoryBean> item = userDao.listitem(userId);
         model.addAttribute("items",item);
         
         return "listitem";
	}
	
	@GetMapping("/addaccount")
	public String addaccount(AddAccountBean accountbean,Model model) {
		model.addAttribute("account",accountbean);	
		return "AddAccount";
		
	}
	
	@PostMapping("/addaccount")
	public String addsaveaccount(@ModelAttribute("account") @Valid AddAccountBean accountbean , BindingResult result, Model model,HttpSession session) {
		
		if(result.hasErrors()) {
			model.addAttribute("account",accountbean);
			return "AddAccount";
		}else {
			UserBean user = (UserBean)session.getAttribute("users");
			int userId =user.getUserid();
			accountbean.setUserId(userId);
			userDao.addaccount(accountbean);
			
			model.addAttribute("account",accountbean);
			model.addAttribute("msg", " Account Detail  Add Suceefully");
			return "AddAccount";

		}
		
		
	}
	
	@GetMapping("/viewaccount")
	public String listaccount(HttpSession session,Model model) {
		UserBean user = (UserBean)session.getAttribute("users");
		int userId = user.getUserid();
         List<AddAccountBean> accounts = userDao.listaccount(userId);
         model.addAttribute("show",accounts);
         
         return "ViewAccount";
	}

	
	
	
}
