package sample;

public class Mixer {

    protected static double suma() {
        double sum = 0;

        for(int i=0; i< 16  ;i++) {
            sum+= Synth.osc[i].getSample() * Synth.osc[i].getVol()/127;
        }
        return sum/MidiParser.count;
    }

    public static int getSamples(byte[] buffer) {
        int index = 0;
        for (int i = 0; i < Player.SAMPLES_PER_BUFFER; i++) {
            double ds = suma() * Short.MAX_VALUE;
            short ss = (short) Math.round(ds);
            buffer[index++] = (byte)(ss >> 8);
            buffer[index++] = (byte)(ss & 0xFF);
        }
        return Player.BUFFER_SIZE;
    }
}
