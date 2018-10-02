package com.mwf.model;

import lombok.Data;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

@Data
public class Request {

    private final Socket socket;

    public Request(Socket socket) {
        this.socket = socket;
    }

    public InputStream getInputStream() throws IOException {
        return this.socket.getInputStream();
    }
}
