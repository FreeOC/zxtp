package com.baizhi.controller;

import com.baizhi.entity.User;
import com.baizhi.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServiceImpl userServiceImpl;

    @RequestMapping("/login")
    public Object login(String username, String password, HttpSession session) {
        System.out.println("-----login----" + username);
        System.out.println("-----login----" + password);
        boolean login = userServiceImpl.login(username, password);
        System.out.println("-----login----" + login);
        if (login) {
            User user = userServiceImpl.getUser(username);
            session.setAttribute("user", user);
            return "redirect:/user/list";
        } else {
            return "redirect:/login.jsp";
        }
    }

    @RequestMapping("/regist")
    public String regist(User user, String code, HttpSession session) {
        System.out.println("-----regist----" + user);
        System.out.println("-----regist----" + code);
        //验证码
        String realCode = (String) session.getAttribute("realCode");
        System.out.println("-----regist----" + realCode);
        if (!code.equals(realCode)) {
            return "redirect:/regist.jsp";
        }
        Integer regist = userServiceImpl.regist(user);
        if (regist == 1) {
            return "redirect:/login.jsp";
        } else {
            return "redirect:/regist.jsp";
        }
    }

    @RequestMapping("/delete")
    public String delete(Integer id) {
        int i = userServiceImpl.deleteByPrimaryKey(id);
        if (i == 1) {
            return "redirect:/user/list";
        } else {
            return "index";
        }
    }

    @RequestMapping("/select")
    public String select(Integer id, ModelMap mm) {
        User user = userServiceImpl.selectByPrimaryKey(id);
        mm.addAttribute("user", user);
        return "updateUser";
    }

    @RequestMapping("/update")
    public String update(User user) {
        int i = userServiceImpl.updateByPrimaryKeySelective(user);
        if (i == 1) {
            return "redirect:/user/list";
        } else {
            return "index";
        }
    }
}
