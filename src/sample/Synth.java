package sample;


public class Synth  {

    static Oscillator[] osc;
    static Player player = new Player();
    MidiController control = new MidiController();

    public Synth() {
        osc = new Oscillator[16];
        for (int i = 0; i < 16; i++) {
            osc[i] = new Oscillator();
        }
    }

    public void setOscSineValue(double value){
        for (int i = 0; i < 16; i++) {
            osc[i].setSineValue(value);
        }
    }

    public void setOscSquareValue(double value){
        for (int i = 0; i < 16; i++) {
            osc[i].setSquareValue(value);
        }
    }

    public void setOscSawValue(double value){
        for (int i = 0; i < 16; i++) {
            osc[i].setSawValue(value);
        }
    }

    public static void playNote(double freq, int num, int vol) {
        for (int i = 0; i < 16; i++) {
            if (!osc[i].isClicked()) {
                osc[i].midiNum = num;
                osc[i].clicked();
                osc[i].setFrequency(freq);
                osc[i].setVol(vol);
                break;
            }
        }

    }

    public static void stopNote(int num) {
        for (int i = 0; i < 16; i++) {
            if (osc[i].midiNum == num) {
                osc[i].released();
                osc[i].setFrequency(0);
                break;
            }
        }
    }

    public static void playOsc() {
        player.startPlayer();
    }

}

