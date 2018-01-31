package com.suqc.controller;

import com.suqc.pojo.Subject;
import com.suqc.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/subject")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    @RequestMapping("/getAllSubject")
    @ResponseBody
    public List<Subject> getSubjectList(HttpServletRequest request, HttpServletResponse response){
        List<Subject> subjectList = subjectService.getAllSubject();
        return subjectList;
    }
}
