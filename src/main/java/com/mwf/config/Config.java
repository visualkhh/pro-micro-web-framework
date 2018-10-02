package com.mwf.config;

import com.mwf.model.Request;
import com.mwf.model.Response;
import com.mwf.parser.Parser;
import com.mwf.server.Server;

public interface Config {
    public Server getServer();
    public Parser newParser(Request request, Response response);
}
