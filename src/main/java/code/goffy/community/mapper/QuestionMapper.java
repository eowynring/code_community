package code.goffy.community.mapper;

import code.goffy.community.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author:Goffy
 */
@Mapper
public interface QuestionMapper {
    //问题插入
    @Insert("insert into question (title,description,gmt_create,gmt_modified,creator,tag) values(#{title},#{description},#{gmtCreate},#{gmtModified},#{creator},#{tag})")
    void create(Question question);

    //分页
    @Select("select * from question limit #{offSet},#{size}")
    List<Question> questionList(@Param("offSet") Integer offSet, @Param("size") Integer size);

    //查询总数
    @Select("select count(1) from question")
    Integer count();

}
