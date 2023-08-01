package device.backend;

import java.io.*;
import java.net.Socket;

public class Writer implements Runnable {
    private PrintWriter out;
    private BufferedReader input;

    private Socket socket;

    public Writer(Socket socket) {
        try {
            this.socket = socket;
            this.out = new PrintWriter(this.socket.getOutputStream());
            this.input = new BufferedReader(new InputStreamReader(System.in));
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            while (!socket.isClosed()) {
                String content = input.readLine();
                out.println(content);
                out.flush();
                if(content.equalsIgnoreCase("exit")) {
                    socket.close();


                }


            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

