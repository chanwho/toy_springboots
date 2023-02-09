package com.toy.toy_springboots.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.toy.toy_springboots.service.UserDataService;
import com.toy.toy_springboots.utils.AddUUID;

@Controller
@RequestMapping(value = "/userData")
public class UserDataController {

    @Autowired
    UserDataService userDataService;

    @Autowired
    AddUUID addUUID;

    @RequestMapping(value = { "/", "", "/list" }, method = RequestMethod.GET)
    public ModelAndView list(@RequestParam Map<String, Object> params, ModelAndView modelAndView) {
        Object resultMap = userDataService.getlist(params);

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            String username = ((UserDetails) principal).getUsername();
            String password = ((UserDetails) principal).getPassword();
            Boolean isAccountNonExpired = ((UserDetails) principal).isAccountNonExpired();
            Boolean isAccountNonLocked = ((UserDetails) principal).isAccountNonLocked();
            Boolean isCredentialsNonExpired = ((UserDetails) principal).isCredentialsNonExpired();

            System.out.println(username);
            System.out.println(password);
            System.out.println(isAccountNonExpired);
            System.out.println(isAccountNonLocked);
            System.out.println(isCredentialsNonExpired);
        } else {
            String username = principal.toString();
        }

        modelAndView.addObject("resultMap", resultMap);
        modelAndView.setViewName("/list");
        return modelAndView;
    }

    @RequestMapping(value = { "/listPagination/{currentPage}" }, method = RequestMethod.GET)
    public ModelAndView listPagination(@RequestParam Map<String, Object> params, @PathVariable String currentPage,
            ModelAndView modelAndView) {
        params.put("currentPage", Integer.parseInt(currentPage)); // 현재 페이지 번호
        params.put("pageScale", 10); // 페이지당 게시물 수
        Object resultMap = userDataService.getListWithPagination(params);
        modelAndView.addObject("resultMap", resultMap);
        modelAndView.setViewName("/list_pagination");
        return modelAndView;
    }

    @RequestMapping(value = { "/uploadMultiImg" }, method = RequestMethod.POST)
    public ModelAndView uploadMultiImg(MultipartHttpServletRequest multipartHttpServletRequest,
            @RequestParam Map<String, Object> params, ModelAndView modelAndView)
            throws IllegalStateException, IOException {

        Map<String, Object> utilsParams = addUUID.UploadProcess(multipartHttpServletRequest, params);

        Object resultMap = userDataService.insertWithFileAndGetList(utilsParams);

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

    @RequestMapping(value = "/formMulti")
    public ModelAndView uploadFile(@RequestParam Map<String, Object> params, ModelAndView modelAndView) {
        modelAndView.setViewName("/editMultiFileUpload");
        return modelAndView;
    }

}
