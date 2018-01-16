package sample;

import javax.sound.midi.*;

        /*MidiParser takes the Midi signals and sends them to the synth to be processed as input*/

public final class MidiParser{
    protected static int count =0;
    protected static int runCheck = 0;

    public MidiParser(){

    }

    public void parse(MidiMessage message, long timestamp){
        if (message instanceof ShortMessage){
            parseShortMessage((ShortMessage)message, timestamp);
        }
    }

    private void parseShortMessage(ShortMessage message, long timestamp){
        int track = message.getChannel();

        switch (message.getCommand()){


            case ShortMessage.NOTE_ON :
                if (message.getData2() == 0){
                    noteOffEvent(timestamp, track, message.getData1(), message.getData2());
                } else {
                    noteOnEvent(timestamp, track, message.getData1(), message.getData2());
                }
                break;

            case ShortMessage.NOTE_OFF :
                noteOffEvent(timestamp, track, message.getData1(), message.getData2());
                break;
        }
    }

    public static void noteOnEvent(long timestamp, int track, int data1, int data2){
        System.out.println("Note on " + data1 +" - attack is " + data2);

        double freq = Math.rint(8.1757989156 * Math.pow(2.0, data1 / 12.0) * 10000.0) / 10000.0;
        System.out.println(freq);
        Synth.playNote(freq,data1,data2);

        count++;
        System.out.println(count);

        if(runCheck==0){
            Synth.playOsc();
            runCheck++;
        }
    }

    public static void noteOffEvent(long timestamp, int track, int data1, int data2){
        System.out.println("Note off "+data1+" - decay is "+data2);
        count--;
        Synth.stopNote(data1);

    }



}
