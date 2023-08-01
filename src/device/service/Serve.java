package device.service;

import device.backend.Device;

public class Serve {

    int port;
    public Serve(int port){
        this.port=port;
    }

    public void startServer(){
        new Device(port);
    }


}
