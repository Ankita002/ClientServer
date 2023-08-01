package device.service;

import device.backend.Device;

public class Connect {

    int port;
    String host;
    public Connect(String host,int port){
        this.port=port;
        this.host=host;
    }

    public void startConnection(){
        new Device(host,port);
    }
}
