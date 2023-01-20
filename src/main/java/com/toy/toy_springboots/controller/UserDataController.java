package com.toy.toy_springboots.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.toy.toy_springboots.service.UserDataService;

@Controller
@RequestMapping(value = "/userData")
public class UserDataController {

    @Autowired
    UserDataService userDataService;

    @RequestMapping(value = { "/", "", "/list" }, method = RequestMethod.GET)
    public ModelAndView list(@RequestParam Map<String, Object> params, ModelAndView modelAndView) {
        Object resultMap = userDataService.getlist(params);

        modelAndView.addObject("resultMap", resultMap);
        modelAndView.setViewName("/list");
        return modelAndView;
    }
}
