package com.mwf.parser;

import com.mwf.config.component.ComponentManager;
import com.mwf.model.Request;
import com.mwf.model.Response;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@Slf4j
public class HttpParser extends Parser {

    public HttpParser(Request request, Response response) {
        super(request, response);
    }

    @Override
    public void run() {
        try {
            String requestStr = "";
            while (true) {
                byte[] z = new byte[1024];
                getRequest().getInputStream().read(z);
                requestStr = new String(z);
                log.debug(requestStr);
                break;
            }
            String[] requestLins = requestStr.split("\r\n");
            String[] line1 = requestLins[0].split(" ");


            ComponentManager.getInstance().executeController(line1[1], line1[0], getRequest(), getResponse());
            getResponse().getScoket().close();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
