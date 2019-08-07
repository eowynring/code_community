package code.goffy.community.service;

import code.goffy.community.dto.QuestionDTO;
import code.goffy.community.mapper.QuestionMapper;
import code.goffy.community.mapper.UserMapper;
import code.goffy.community.model.Question;
import code.goffy.community.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:Goffy
 */
@Service
public class QuestionService {

    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private UserMapper userMapper;
    public List<QuestionDTO> questionList() {
        List<Question> questionList = questionMapper.questionList();
        List<QuestionDTO> questionDTOList = new ArrayList<>();
        for (Question question : questionList) {
            User user=userMapper.findById(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question,questionDTO);//快速把question属性拷贝到questionDTO对象上
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        return questionDTOList;
    }
}
