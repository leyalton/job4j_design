package ru.job4j.io;

import java.io.*;
import java.net.*;

public class EchoServer {

    public void server() {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (true) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                    String line;
                    String message = null;
                    while (!(line = in.readLine()).isEmpty()) {
                        if (line.contains("msg=") && line.contains("exit")) {
                            return;
                        } else if (line.contains("msg=")) {
                            message = line.substring(line.indexOf("=") + 1, line.lastIndexOf(" "));
                        }
                        System.out.println(line);
                    }
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    out.write(message.getBytes());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new EchoServer().server();
    }
}