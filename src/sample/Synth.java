package sample;

import sample.MidiController;
import sample.Oscillator;
import sample.Player;

public class Synth {

    static Oscillator[] osc = new Oscillator[16];
    static Player player = new Player();
    MidiController control = new MidiController();

    public Synth() {
        for(int i=0;i<16;i++) {
            osc[i] = new Oscillator();
        }
    }

    public static void playNote(double freq, int num,int vol) {
        for(int i=0;i<16;i++){
            if (!osc[i].isClicked()) {
                osc[i].midiNum=num;
                osc[i].clicked();
                osc[i].setFrequency(freq);
                osc[i].setVol(vol);
                break;
            }
        }

    }

    public static void stopNote(int num) {
        for(int i=0;i<16;i++) {
            if(osc[i].midiNum==num) {
                osc[i].released();
                osc[i].setFrequency(0);
                break;
            }
        }
    }

    public static void playOsc(){
        player.startPlayer();
    }

    public void setShape(int shape1) {

        switch (shape1) {
            case 1:
                for(int i=0; i<16;i++) {
                    osc[i].setOscWaveshape(Oscillator.WAVESHAPE.SIN); }
                break;
            case 2:
                for(int i=0; i<16;i++) {
                    osc[i].setOscWaveshape(Oscillator.WAVESHAPE.SQU); }
                break;
            case 3:
                for(int i=0; i<16;i++) {
                    osc[i].setOscWaveshape(Oscillator.WAVESHAPE.SAW); }
                break;
        }
    }
}

