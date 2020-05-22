package com.lixx.elasticsearchtemplate.controller;

import com.lixx.elasticsearchtemplate.service.StaffService;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lxx
 * @date 2020/5/14 21:29
 * @description
 */
@RestController
public class StaffController {

    private final StaffService service;

    public StaffController(StaffService service) {
        this.service = service;
    }

    public void queryByPage() {

    }
}
