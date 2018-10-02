package com.mwf.server;

import com.mwf.config.Config;
import com.mwf.model.Request;
import com.mwf.model.Response;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
@Slf4j
public class Httpserver extends Server {
    private final int port;
    private final Config config;

    public Httpserver(Config config) {
        this(config, 80);
        log.debug("TcpServer");
    }

    public Httpserver(Config config, int port) {
        this.config = config;
        this.port = port;
        log.debug("TcpServer");
    }

    @Override
    public void start() throws IOException, InterruptedException {
        InetSocketAddress ipep = new InetSocketAddress(this.port);
        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(ipep);

        while (true) {
            Socket socket = serverSocket.accept();
            Request request = new Request(socket);
            Response response = new Response(socket);
            new Thread(config.newParser(request, response)).start();

            Thread.sleep(1000);
        }
    }
}
