package edu.javacourse.city.net;
/*
 *   Created by Kovalyov Anton 21.04.2022
 */

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class SimpleSocket {
    @Test
    public void simpleSocket() throws IOException {
        Socket socket = new Socket("localhost", 8080);

        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();

        String command =
                """
                        GET /ttt HTTP/1.1\r
                        Host:java-course.ru\r
                        \r
                        """;
        outputStream.write(command.getBytes());
        outputStream.flush();

        int c;
        while ((c = inputStream.read()) != -1) {
            System.out.print((char) c);
        }

        socket.close();
    }
}
