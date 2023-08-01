package device.client;

import java.util.Scanner;
import device.service.Connect;
import device.service.Serve;

public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);




            System.out.println("Menu:");
            System.out.println("1. Connect at a port");
            System.out.println("2. Wait for connection");
            System.out.println("3. Exit");
            char ch = sc.next().charAt(0);
            switch (ch) {
                case '3':
                    break ;
                case '2':
                    System.out.println("Mention the port you want to serve at: ");
                    int portServe = sc.nextInt();
                    new Serve(portServe).startServer();
                    break ;

                case '1':
                    System.out.println("Mention the host you want to connect to: ");
                    String hostConn = sc.next();
                    System.out.println("Mention the port you want to connect to: ");
                    int portConn = sc.nextInt();
                    new Connect(hostConn, portConn).startConnection();
                    break ;
            }



    }
}

