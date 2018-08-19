package com.bobo.springboot.lean.controller;

import org.springframework.boot.autoconfigure.web.AbstractErrorController;
import org.springframework.boot.autoconfigure.web.DefaultErrorAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author wuxiaobo
 */
@Controller
public class ErrorController extends AbstractErrorController {

    public ErrorController() {
        super(new DefaultErrorAttributes());
    }

    @RequestMapping("/error")
    public ModelAndView handleError() {
        return new ModelAndView("error");
    }
    @Override
    public String getErrorPath() {
        return null;
    }
}
