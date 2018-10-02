package com.mwf.test.config;

import com.mwf.model.Request;
import com.mwf.model.Response;
import com.mwf.parser.HttpParser;
import com.mwf.parser.Parser;
import com.mwf.server.Server;
import com.mwf.config.Config;
import com.mwf.config.anno.Configuration;
import com.mwf.server.Httpserver;
import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class TkConfig implements Config {
    public TkConfig() {
        log.debug("TkConfig");
    }

    @Override
    public Server getServer() {
        return new Httpserver(this, 7878);
    }

    @Override
    public Parser newParser(Request request, Response response) {
        return new HttpParser(request, response);
    }
}
