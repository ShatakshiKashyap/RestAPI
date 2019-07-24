package com.app.RestAPP;

import java.util.HashMap;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	HashMap<String,String> hm=new HashMap<>();
	@GetMapping("/welcome")//this /welcome is actually the part of url
	@ResponseBody
	public String sayWelcome() {
		return "Welcome to myApp";
	}
	@GetMapping("/login")
	//@ResponseBody
public String login() {
	return "login";//this name must match with jsp page name
	//location of jsp page is dedicated 
}	
	@PostMapping("/loginvalidate")
	//@ResponseBody
	public String loginValidate(@RequestParam("uname") String name,@RequestParam("psw")String Paswd)
	{
		if(name.equals(hm.get(Paswd)) && Paswd.equals(hm.get(name)))
		return "Success";
		else
			return "Failure";
	}
	@GetMapping("/register")
	public String register()
	{
		return "Register";
	}
	@PostMapping("/Saving")
	public String registerSave(@RequestParam("uname") String name,@RequestParam("psw")String Paswd)
	{
		hm.put(name,Paswd);
		return "login";
	}
}
