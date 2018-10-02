package com.mwf.server;

import java.io.IOException;

public abstract class Server {
    abstract public void start() throws IOException, InterruptedException;
}
