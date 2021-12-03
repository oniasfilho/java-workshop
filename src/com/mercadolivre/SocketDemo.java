package com.mercadolivre;

import java.io.IOException;
import java.net.ServerSocket;

public class SocketDemo {
    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket serverSocket = new ServerSocket(12345);
        Thread.sleep(3000L);
    }
}
