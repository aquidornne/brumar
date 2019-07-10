package com.blumar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/")
public class PagesController {
	
    @RequestMapping
    @ResponseBody
    public String index() {
    	return "Servidor ativo ...";
    }
}
