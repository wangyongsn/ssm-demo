package com.xwtec.controller;

import com.xwtec.service.ISalveUserService;
import com.xwtec.service.IUserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Controller
 */
@Controller
public class HellSSMController {
    private Logger logger = Logger.getLogger(HellSSMController.class);
    @Autowired
    private IUserService service;

    @Autowired
    private ISalveUserService salveUserService;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    public String hello() {
        logger.info("进入hello()");
        try {
            List<Map<String, Object>> mapList = service.qryUser();
            return mapList.toString();
        } catch (Exception e) {
            logger.error("hello >>出现错误", e);
        }
        return "hello,ssm-demo come!";
    }

    @RequestMapping(value = "/salve", method = RequestMethod.GET)
    @ResponseBody
    public String salve() {
        logger.info("进入salve()");
        try {
            List<Map<String, Object>> mapList = salveUserService.qryUser();
            return mapList.toString();
        } catch (Exception e) {
            logger.error("hello >>出现错误", e);
        }
        return "hello,ssm-demo come!";
    }
}