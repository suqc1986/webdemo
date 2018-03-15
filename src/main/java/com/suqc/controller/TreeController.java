package com.suqc.controller;

import com.suqc.dao.SchoolTreeDao;
import com.suqc.pojo.SchoolTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class TreeController {

    @Autowired
    SchoolTreeDao schoolTreeDao;

    @RequestMapping("/getTree")
    @ResponseBody
    public List<SchoolTree> getSchoolTree(HttpServletRequest request) throws Exception {
        String id = request.getParameter("id");
        Map<String, Object> params = new HashMap<>();
        if (id != null) {
            params.put("pId", Integer.parseInt(id));
        }
        List<SchoolTree> schoolTrees = schoolTreeDao.query(params);
        for (SchoolTree tree : schoolTrees) {
            if (tree.getpId() == 10) {
                tree.setIsParent(0);
            } else {
                tree.setIsParent(1);
            }
        }
        return schoolTrees;
    }
}
