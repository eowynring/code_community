package code.goffy.community.controller;

import code.goffy.community.mapper.UserMapper;
import code.goffy.community.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @Author:Goffy
 */
@Controller
public class IndexController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/")
    public String hello(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length !=0)
            for (Cookie cookie : cookies) {
                if("token".equals(cookie.getName())){
                    String tokenValue = cookie.getValue();
                    User user=userMapper.findByToken(tokenValue);
                    if (user != null) {
                        request.getSession().setAttribute("user",user);
                    }
                    break;
                }
            }

         return "index";
    }
}
