package com.dharma.patterns.gof.structure.proxy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

// 5. 统一接口，保证兼容性
interface SocketInterface {
    String readLine();
    void writeLine(String str);
    void dispose();
}

class SocketProxy implements SocketInterface {
    // 1. 代理远程对象
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    SocketProxy(String host, int port, boolean wait) {
        try {
            if (wait) {
                // 2. 封装复杂业务规则
                ServerSocket server = new ServerSocket(port);
                socket = server.accept();
            } else {
                socket = new Socket(host, port);
            }
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String readLine() {
        String str = null;
        try {
            str = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    public void writeLine(String str) {
        // 4. 代理目的
        out.println(str);
    }

    public void dispose() {
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public class ProxySocket {
    public static void main(String[] args) {
        // 3. 用户调用
        SocketInterface socket = new SocketProxy("127.0.0.1", 8888, args[0].equals("first") ? true : false);
        String str;
        boolean skip = true;
        while (true) {
            if (args[0].equals("second") && skip) {
                skip = !skip;
            } else {
                str = socket.readLine();
                System.out.println("Receive - " + str);
                if (str.equals(null)) {
                    break;
                }
            }
            System.out.print("Send ---- ");
            str = new Scanner(System.in).nextLine();
            socket.writeLine(str);
            if (str.equals("quit")) {
                break;
            }
        }
        socket.dispose();
    }
}
