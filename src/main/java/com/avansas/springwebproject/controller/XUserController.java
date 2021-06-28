package com.avansas.springwebproject.controller;

import com.avansas.springwebproject.dto.UserDto;
import com.avansas.springwebproject.entities.CurrentUser;
import com.avansas.springwebproject.entities.XUser;
import com.avansas.springwebproject.service.IXUserService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Controller
@Validated
@RequestMapping("/user")
@Log
public class XUserController {
    CurrentUser currentUser;
    @Autowired
    public XUserController(IXUserService userService) {
        this.userService = userService;
        currentUser=new CurrentUser();
    }

    private IXUserService userService;
    @GetMapping("/add")
    public String addActor( Model model){

        model.addAttribute("userAdd", new XUser());
        model.addAttribute("currentUser",currentUser.getxUser());
        return "UserAdd";
    }
    @PostMapping("/add")
    public String add(@Valid @ModelAttribute XUser user,BindingResult bindingResult){
        userService.save(user);

        return "redirect:/user/users";
    }
    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("login", new UserDto());
        return "Login";
    }
    @PostMapping("/login")
    public String loginP(@ModelAttribute UserDto userDto){
        XUser xUserx = userService.loginAuth(userDto);
        System.out.println(xUserx.getRole()+"-----------------------------------");
        currentUser.setxUser(xUserx);
        return "redirect:/user/users";
    }
    @GetMapping("/users")
    public String UserLists(Model model) {
        model.addAttribute("userList", userService.findAll());
        model.addAttribute("currentUser",currentUser.getxUser());
        return "UserList";
    }
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id){
        XUser byId = userService.getById(id);
        userService.delete(byId);
        return "redirect:/user/users";
    }
    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable Long id,Model model){
        XUser byId = userService.getById(id);
        model.addAttribute("userEdit",byId);
        return "UserEdit";
    }
    @PostMapping("/edit/{id}")
    public String updateUser(@PathVariable("id") long id, @ModelAttribute XUser user,
                             BindingResult result, Model model) {
        userService.save(user);
        return "redirect:/user/users";
    }
}
