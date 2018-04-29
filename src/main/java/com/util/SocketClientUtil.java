package com.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *   
 * <p>Socket客户端</p>
 *
 * @author: 彗星（huixing@maihaoche.com）
 * @date: 2018/2/6 
 * @since V1.0
 *  
 */
public class SocketClientUtil {
    public static void main(String[] args) throws IOException {
        Socket socket = null;
        BufferedReader in = null;
        PrintWriter out =  null;

        try {
            socket = new Socket("127.0.0.1", 9999);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
            out.println("TIME");
            System.out.println("---------");
            String resp = in.readLine();
            System.out.println("+++++++++++++" + resp);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                socket.close();
                socket = null;
            }
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }
}
