package com.dknoe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dknoe.model.Product;
import com.dknoe.repository.ProductsRepository;

@Controller
public class HomeController {
	@Autowired
	ProductsRepository productRepository;
	    
    @RequestMapping("/")
    public String home(Model model) {
    	Iterable<Product> products = productRepository.findAll();
    	model.addAttribute("products", products);
        return "home";
    }
    
    @GetMapping("/newproduct")
    public String newProduct(Model model) {
    	Product product = new Product();
    	model.addAttribute("product", product);
    	return "newproduct";
    }
    
    @GetMapping("/edit/{id}")
    public String editProduct(Model model, @PathVariable(value="id") Integer idProducto) {    	
    	Product product = productRepository.findById(idProducto).get();    	
    	
    	model.addAttribute("product", product);
    	return "newproduct";
    }
    
    @PostMapping("/save")
    public String guardar(Product product) {
    	System.out.print(product.getCode());
    	productRepository.save(product);
        
        return "redirect:" + "/";
    }
    
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable(value="id") Integer idProducto) {
    	productRepository.deleteById(idProducto);
        
        return "redirect:" + "/";
    }    

}
