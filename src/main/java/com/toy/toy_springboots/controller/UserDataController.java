package com.toy.toy_springboots.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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

    @RequestMapping(value = { "/edit/{unique_id}" }, method = RequestMethod.GET)
    public ModelAndView edit(@RequestParam Map<String, Object> params, @PathVariable String unique_id,
            ModelAndView modelAndView) {
        params.put("USER_UID", unique_id);
        Object resultMap = userDataService.getOne(params);
        modelAndView.addObject("resultMap", resultMap);
        modelAndView.setViewName("/edit");
        return modelAndView;
    }

    @RequestMapping(value = { "/insert" }, method = RequestMethod.POST)
    public ModelAndView insert(@RequestParam Map<String, Object> params, ModelAndView modelAndView) {
        Object resultMap = userDataService.insertOneAndGetList(params);
        modelAndView.addObject("resultMap", resultMap);
        modelAndView.setViewName("/list");
        return modelAndView;
    }

    @RequestMapping(value = { "/update" }, method = RequestMethod.POST)
    public ModelAndView update(@RequestParam Map<String, Object> params, ModelAndView modelAndView) {
        Object resultMap = userDataService.updateAndGetList(params);
        modelAndView.addObject("resultMap", resultMap);
        modelAndView.setViewName("/list");
        return modelAndView;
    }

    @RequestMapping(value = { "/delete/{uniqueId}" }, method = RequestMethod.POST)
    public ModelAndView delete(@RequestParam Map<String, Object> params, @PathVariable String uniqueId,
            ModelAndView modelAndView) {
        params.put("USER_UID", uniqueId);
        Object resultMap = userDataService.deleteAndGetList(params);
        modelAndView.addObject("resultMap", resultMap);
        modelAndView.setViewName("/list");
        return modelAndView;
    }

}
