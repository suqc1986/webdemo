package com.suqc.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.propertyeditors.LocaleEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@Controller
public class PageController {
    @RequestMapping("/")
    public String showIndex() {
        return "index";
    }

    @RequestMapping("/{page}")
    public String showPage(@PathVariable String page) {
        return page;
    }

    @RequestMapping(value = "/setLocal")
    public void setLocal(String lang, HttpServletRequest request,
                         HttpServletResponse response) throws Exception
    {
        LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
        if(localeResolver == null) {
            throw new IllegalStateException("No LocaleResolver found: not in a DispatcherServlet request?");
        }
        LocaleEditor localeEditor = new LocaleEditor();
        localeEditor.setAsText(lang);
        localeResolver.setLocale(request, response, (Locale)localeEditor.getValue());
        JSONObject result = new JSONObject();
        result.put("success", true);
        response.getWriter().print(result);
    }
}
