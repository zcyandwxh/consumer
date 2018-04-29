package com.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 *   
 * <p>Socket服务</p>
 *
 * @author: 彗星（huixing@maihaoche.com）
 * @date: 2018/2/6 
 * @since V1.0
 *  
 */
public class SocketServerUtil {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(9999);
            while (true) {
                Socket socket = serverSocket.accept();
                new Thread(new TimeServerHandler(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                serverSocket.close();
                serverSocket = null;
            }
        }
    }

    public static class TimeServerHandler implements Runnable{
        Socket socket = null;

        public TimeServerHandler(Socket socket){
            this.socket = socket;
        }

        @Override
        public void run() {
            BufferedReader in = null;
            PrintWriter out = null;
            try {
                in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
                out = new PrintWriter(this.socket.getOutputStream());

                String currentTime = null;
                String body = null;
                while (true) {
                    body = in.readLine();
                    System.out.println("body:" + body);
                    if (body == null) {
                        break;
                    }
                    currentTime = "TIME".equalsIgnoreCase(body) ? new Date(System.currentTimeMillis()).toString() : "BAD";
                    out.println(currentTime);
                    out.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (in == null) {
                    try {
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (out == null) {
                    out.close();
                }
                if (socket == null) {
                    try {
                        socket.close();
                        socket = null;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
