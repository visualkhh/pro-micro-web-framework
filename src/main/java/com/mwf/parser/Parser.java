package com.mwf.parser;

import com.mwf.model.Request;
import com.mwf.model.Response;
import lombok.Data;

@Data
public abstract class Parser implements Runnable{
    private Request request;
    private Response response;

    public Parser(Request request, Response response) {
        this.request = request;
        this.response = response;
    }
}
