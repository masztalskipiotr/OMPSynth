package sample;

import javax.sound.midi.*;

        /*MidiInputReceiver takes the midi controller midi signals and sends them to the MidiParser*/

public class MidiInputReceiver implements javax.sound.midi.Receiver {
    public String name;

    MidiParser parser = new MidiParser();
    public MidiInputReceiver(String in) {
        name = in;
    }

    public void send(MidiMessage msg, long timeStamp) {
        System.out.println("midi received ");
        parser.parse(msg, timeStamp);
    }
    public void close(){}

}


