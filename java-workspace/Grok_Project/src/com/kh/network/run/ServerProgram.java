package com.kh.network.run;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class ServerProgram {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ServerSocket server = null;

        int portNumber = 1234;

        try {
            server = new ServerSocket(portNumber);
            System.out.println("서버가 시작되었습니다. 클라이언트를 기다리는 중...");

            // 서버는 영원히 살아있음
            while (true) {
                Socket socket = null;
                PrintWriter pw = null;
                BufferedReader br = null;

                try {
                    System.out.println("클라이언트의 요청을 기다리는 중...");
                    socket = server.accept();
                    System.out.println("클라이언트와 연결 성공!");

                    br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    pw = new PrintWriter(socket.getOutputStream());

                    // 클라이언트와 대화 루프
                    while (true) {
                        String message = null;
                        try {
                            message = br.readLine();   // ← 여기서 Connection reset 발생 가능
                        } catch (SocketException e) {
                            // 클라이언트 강제 종료 시 발생하는 예외
                            System.out.println("클라이언트와 연결이 끊겼습니다. (Connection reset)");
                            break;
                        } catch (IOException e) {
                            System.out.println("클라이언트와 연결이 끊겼습니다.");
                            break;
                        }

                        // 정상적인 종료 신호
                        if (message == null || "null".equals(message)) {
                            System.out.println("클라이언트와 연결이 끊겼습니다.");
                            break;
                        }

                        System.out.println("클라이언트로부터 받은 메세지 : " + message);

                        System.out.print("클라이언트로부터 전송할 메세지 > ");
                        String sendMessage = sc.nextLine();
                        pw.println(sendMessage);
                        pw.flush();
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    // 현재 클라이언트 자원만 정리
                    if (pw != null) pw.close();
                    try { if (br != null) br.close(); } catch (IOException e) {}
                    try { if (socket != null) socket.close(); } catch (IOException e) {}
                }
            } // 바깥 while(true)

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (server != null) {
                try { server.close(); } catch (IOException e) {}
            }
        }
        sc.close();
    }
}