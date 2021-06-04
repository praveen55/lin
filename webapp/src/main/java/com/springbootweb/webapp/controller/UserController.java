package com.springbootweb.webapp.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springbootweb.webapp.model.User;
import com.springbootweb.webapp.service.UserServiceImpl;


@Controller
public class UserController {
	@Autowired
	private UserServiceImpl userServiceImpl;
	//Login
	@GetMapping("/login")
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("user", new User());
		return mav;
	}
	@PostMapping("/login")
	public String login(@ModelAttribute("user") User user) {
		User oauthUser = userServiceImpl.login(user.getUsername(), user.getPassword(), user.getRole());
		if(Objects.nonNull(oauthUser) && user.getRole().equals("admin")) {
			return "redirect:/";
		}
		else if (Objects.nonNull(oauthUser) && user.getRole().equals("emp")) {
			return "/loginSuccessful";
		}
		else {
			return "redirect:/login";
		}
	}
	//Registration
	 @GetMapping("/shop")
	    public String viewHomePage(Model model) {
	        List<User> listuser = userServiceImpl.All();
	        model.addAttribute("listuser", listuser);
	        System.out.print("Get / ");	
	        return "index";
	    }
	    @GetMapping("/new")
	    public String add(Model model) {
	        model.addAttribute("user", new User());
	        return "new";
	    }
	    @RequestMapping(value = "/save", method = RequestMethod.POST)
	    public String saveEmployee(@ModelAttribute("user") User user) {
	    	userServiceImpl.save(user);
	        return "redirect:/";
	    }
	    @RequestMapping("/edit/{id}")
	    public ModelAndView showEditEmployeePage(@PathVariable(name = "id") int id) {
	        ModelAndView mav = new ModelAndView("new");
	        User user = userServiceImpl.get(id);
	        mav.addObject("user", user);
	        return mav;  
	    }
	    @RequestMapping("/delete/{id}")
	    public String deleteUserPage(@PathVariable(name = "id") int id) {
	    	userServiceImpl.delete(id);
	        return "redirect:/";
	    }	
}