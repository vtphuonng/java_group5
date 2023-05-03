package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.demo.HomeStayList.HomeStayLIst;
@Controller
public class generate_controller {
	@GetMapping("/")
	public String HomeStay() {
		return "HomeStay";
	}

	@PostMapping("HomeStayList")
	public String HomeStayList(@ModelAttribute HomeStayLIst user) {
		System.out.print("check1");
		return "list";
	}
}
