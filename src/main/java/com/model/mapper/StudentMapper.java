package com.model.mapper;

import com.model.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Created by Administrator on 2017/2/17.
 */
@Controller
public interface StudentMapper {
    @Select("select * from student")
    public List<Student> query();

    @Delete("delete from student where id=#{id}")
    public int del(int id);
    public Student queryById(int id);
}
