package code.goffy.community.controller;

import code.goffy.community.dto.QuestionDTO;
import code.goffy.community.mapper.QuestionMapper;
import code.goffy.community.mapper.UserMapper;
import code.goffy.community.model.Question;
import code.goffy.community.model.User;
import code.goffy.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author:Goffy
 */
@Controller
public class IndexController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private QuestionService questionService;

    @GetMapping("/")
    public String hello(HttpServletRequest request, Model model){
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
        //得到问题列表
        List<QuestionDTO> questionDTOS = questionService.questionList();
        model.addAttribute("questionDTOS",questionDTOS);
        return "index";
    }
}
