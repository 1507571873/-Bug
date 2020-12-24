package com.shield.controller;

import com.shield.service.PunchcardService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("PunchcardController")
public class PunchcardController {

    @Resource
    private PunchcardService punchcardService;


}
