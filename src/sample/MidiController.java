package sample;

import javax.sound.midi.*;
import java.util.List;

        /*MidiController class is the class that simulates and connects the external midi keyboard */

public class MidiController  {

    public MidiController(){
        MidiDevice device;
        MidiDevice.Info[] infos = MidiSystem.getMidiDeviceInfo();
        for (int i = 0; i < infos.length; i++) {
            try {
                device = MidiSystem.getMidiDevice(infos[i]);
                System.out.println(infos[i]);
                List<Transmitter> transmitters = device.getTransmitters();

                for(int j = 0; j<transmitters.size();j++) {
                    transmitters.get(j).setReceiver(
                            new MidiInputReceiver(device.getDeviceInfo().toString())
                    );
                }

                Transmitter trans = device.getTransmitter();
                trans.setReceiver(new MidiInputReceiver(device.getDeviceInfo().toString()));
                device.open();
                System.out.println(device.getDeviceInfo()+" Was Opened");


            } catch (MidiUnavailableException e) {}
        }
    }

}
