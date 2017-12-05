package sample;

public class Synth {

    static Oscillator osc = new Oscillator();
    static Player player = new Player();
    MidiController control = new MidiController();

    double freq;
    int mod;
    int shape1;
    int shape2;

    public Synth() {
        player = new Player();
        osc = new Oscillator();
        player.setSampleProvider(osc);

    }

    public static void setFrequency(double freq) {

        osc.setFrequency(freq);
    }

    public static void playNote(double freq) {
        setFrequency(freq);

    }

    public static void stopNote() {

        setFrequency(0);

    }

    public static void playOsc(){
        player.startPlayer();
    }

    public static void stopOsc(){
        player.stopPlayer();
    }

    public void setShape(int shape1) {
        switch (shape1) {

            case 1:
                osc.setOscWaveshape(Oscillator.WAVESHAPE.SIN);
                break;

            case 2:
                osc.setOscWaveshape(Oscillator.WAVESHAPE.SQU);
                break;

            case 3:
                osc.setOscWaveshape(Oscillator.WAVESHAPE.SAW);
                break;
        }
    }
}

