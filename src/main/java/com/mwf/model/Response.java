package com.mwf.model;

import lombok.Data;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
@Data
public class Response {
    private final Socket scoket;
    public Response(Socket scoket) {
        this.scoket = scoket;
    }
    public OutputStream getOutputStream() throws IOException {
        return this.scoket.getOutputStream();
    }
}
