package com.mwf.test.controller;

import com.mwf.config.anno.Controller;
import com.mwf.config.anno.RequestMapping;
import com.mwf.model.Request;
import com.mwf.model.Response;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Controller
@Slf4j
public class UserController {
    public UserController() {
      log.debug("UserController");
    }

    @RequestMapping(value = "/", method = "GET")
    public void say(Request request, Response response) throws IOException {
        log.debug("say");
        response.getOutputStream().write("show me the money".getBytes());
        response.getOutputStream().flush();
    }
    @RequestMapping(value = "/wow", method = "GET")
    public void wow(Request request, Response response) throws IOException {
        log.debug("wow");
        response.getOutputStream().write("wowowowow show me the money".getBytes());
        response.getOutputStream().flush();
    }
}
