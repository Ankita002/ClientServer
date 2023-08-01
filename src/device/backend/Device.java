package device.backend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Device {
    ServerSocket server;
    Socket socket;




    public Device(int port){
        try {
            server = new ServerSocket(port);
            System.out.println("Server is ready to accept connection");
            System.out.println("waiting...");
            socket=server.accept();
            System.out.println("Server is connected");

            startReading();
            startWriting();


        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public Device(String host, int port){
        try {
            System.out.println("Server is sending connection...");
            socket = new Socket(host,port);
            System.out.println("Connected!");

            startReading();
            startWriting();


        }
        catch(IOException e){
            e.printStackTrace();
        }
    }



    private void startWriting() {
      Thread  writer=new Thread(new Writer(socket));
        writer.start();



    }

    private void startReading()  {
       Thread reader=new Thread(new Reader(socket));
        reader.start();



    }

}
