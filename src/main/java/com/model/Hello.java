package com.model;

import com.model.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Administrator on 2017/2/17.
 */
@Controller
public class Hello {
    @Autowired
    private StudentMapper smr;

    @RequestMapping("/ok") @ResponseBody
    public String ok(){
        return "ok";
    }

    @RequestMapping(value = "/del/{id}.html", method= RequestMethod.GET)
    public String show(@PathVariable int id){
        smr.del(id);
        return "redirect:/show.html";
    }
    @RequestMapping("/show.html")
    public ModelAndView show(){
        ModelAndView mv=new ModelAndView("show");
            mv.addObject("student", smr.query());
        return mv;
    }
}
