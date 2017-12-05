package sample;

import javax.sound.sampled.*;

public class Player extends Thread {

    // Instance data
    private AudioFormat format;
    private DataLine.Info info;
    private SourceDataLine auline;
    private boolean done;
    private byte [] sampleData = new byte[BUFFER_SIZE];
    private SampleProvider provider;

    // AudioFormat parameters
    public  static final int     SAMPLE_RATE = 44100;
    private static final int     SAMPLE_SIZE = 16;
    private static final int     CHANNELS = 1;
    private static final boolean SIGNED = true;
    private static final boolean BIG_ENDIAN = true;

    static Mixer.Info[] getMixerInfo() {
        return new Mixer.Info[0];
    }

    // Chunk of audio processed at one time
    public static final int BUFFER_SIZE = 2048;
    public static final int SAMPLES_PER_BUFFER = BUFFER_SIZE / 2;

    public Player() {

        // Create the audio format we wish to use
        format = new AudioFormat(SAMPLE_RATE, SAMPLE_SIZE, CHANNELS, SIGNED, BIG_ENDIAN);

        // Create dataline info object describing line format
        info = new DataLine.Info(SourceDataLine.class, format);
    }

    public void run() {

        done = false;
        int nBytesRead = 0;

        try {
            // Get line to write data to
            auline = (SourceDataLine) AudioSystem.getLine(info);
            auline.open(format, BUFFER_SIZE);
            auline.start();

            while ((nBytesRead != -1) && (! done)) {
                nBytesRead = provider.getSamples(sampleData);
                if (nBytesRead > 0) {
                    auline.write(sampleData, 0, nBytesRead);
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            auline.drain();
            auline.close();
        }
    }

    public void startPlayer() {
        if (provider != null) {
            start();
        }
    }

    public void stopPlayer() {
        done = true;
    }

    public void setSampleProvider(SampleProvider provider) {
        this.provider = provider;
    }

}