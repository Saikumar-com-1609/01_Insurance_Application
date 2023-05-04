package com.ait.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ait.entity.Product;
import com.ait.repository.ProductRepository;



@Controller
public class ProductController {
	
	@Autowired
	private ProductRepository repo;
	
	@GetMapping("/")
	public String indexPage(Model model) {
		
		 
		model.addAttribute("products",new Product());
		
		return "index";
	}
   
	@PostMapping("/save")
	public String saveEmployee(Product p,Model model) {
		model.addAttribute("products",new Product());
        model.addAttribute("save", p);
		p=repo.save(p);
		if(p.getId()!=null) {
			model.addAttribute("msg", "Product Saved");
		}
		return "index";
	}
}
