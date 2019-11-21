/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivl.car.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ivl.car.domain.User;
import com.ivl.car.service.CustomUserDetailsService;

/**
 *
 * @author didin
 */
@Controller
public class LoginController {

    @Autowired
    private CustomUserDetailsService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public ModelAndView signup() {
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("signup");
        return modelAndView;
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ModelAndView createNewUser(@Valid  User user, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        System.out.println(user.getEmail()+ " "+ user.getFullname()+" "+user.getRoles());
        User userExists = userService.findUserByEmail(user.getEmail());
        if (userExists != null) {
            bindingResult
                    .rejectValue("email", "error.user",
                            "There is already a user registered with the username provided");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("signup");
        } else {
            userService.saveUser(user);
            modelAndView.addObject("successMessage", "User has been registered successfully");
            modelAndView.addObject("user", new User());
            modelAndView.setViewName("login");

        }
        return modelAndView;
    }

   /* @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ModelAndView dashboard() {
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        modelAndView.addObject("currentUser", user);
        modelAndView.addObject("fullName", "Welcome " + user.getFullname());
        modelAndView.addObject("adminMessage", "Content Available Only for Users with Admin Role");
        modelAndView.setViewName("dashboard");
        return modelAndView;
    }*/
    
    
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String dashboard() {
    	
    	System.out.println("hello...........................");
		/*
		 * ModelAndView modelAndView = new ModelAndView(); Authentication auth =
		 * SecurityContextHolder.getContext().getAuthentication(); User user =
		 * userService.findUserByEmail(auth.getName());
		 * modelAndView.addObject("currentUser", user);
		 * modelAndView.addObject("fullName", "Welcome " + user.getFullname());
		 * modelAndView.addObject("adminMessage",
		 * "Content Available Only for Users with Admin Role");
		 * modelAndView.setViewName("dashboard");
		 */
        return "search";
    }
    
   

}
