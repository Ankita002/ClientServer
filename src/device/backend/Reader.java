package device.backend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Reader implements Runnable{
    private BufferedReader br;


    private Socket socket;

    public Reader(Socket socket){
        try {
            this.socket=socket;
            this.br=new BufferedReader(new InputStreamReader(this.socket.getInputStream()));

        } catch (IOException e) {
            e.printStackTrace();
        }



    }

    @Override
    public void run() {
        try {
            while (!socket.isClosed()) {
                String msg=br.readLine();
                System.out.println("Client: "+msg);
                if(msg.equalsIgnoreCase("exit")){
                    System.out.println("Client terminated the chat!");

                    socket.close();
                }





            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


}
