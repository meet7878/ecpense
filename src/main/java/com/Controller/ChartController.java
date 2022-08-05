package com.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.Bean.CategoryReportBean;
import com.Dao.CategoryDao;

@Controller
public class ChartController {

	@Autowired
	CategoryDao catDao;
	@GetMapping("/mychart")
	public String mychart(Model model) {
		List<CategoryReportBean> categories = catDao.getCategoryByInvestment();
		model.addAttribute("categories", categories);//name , totalprice 
		return "Mychart";
	}
}
