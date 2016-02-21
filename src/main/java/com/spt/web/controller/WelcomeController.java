package com.spt.web.controller;

import com.spt.core.manager.IPersonMgr;
import com.spt.core.model.Person;
import com.spt.core.service.HelloWorldService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * BDRent
 * User: maheraj
 * Date: 8/16/2015
 */
@Controller
public class WelcomeController {
    private final Logger LOGGER = LoggerFactory.getLogger(WelcomeController.class);
    private final HelloWorldService helloWorldService;

    @Autowired
    IPersonMgr personMgr;

    @Autowired
    public WelcomeController(HelloWorldService pHelloWorldService) {
        this.helloWorldService = pHelloWorldService;
    }



    @RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.HEAD})
    public String index(Map<String, Object> model) {
        LOGGER.debug("index() is executed!");

        model.put("title", helloWorldService.getTitle(""));
        model.put("msg", helloWorldService.getDesc());
        return "index";
    }

    @RequestMapping(value = "/person/create", method = {RequestMethod.GET})
    public String createPerson(Map<String, Object> model, @RequestParam String name, @RequestParam String email) {
        LOGGER.debug("createPerson() is executed!");
        Person person = new Person();
        person.setName(name);
        person.setEmailAddress(email);
        person.setPassword("123456");
        personMgr.save(person);

        model.put("title", helloWorldService.getTitle(""));
        model.put("msg", helloWorldService.getDesc());
        return "index";
    }

}
