package sample;

public class Oscillator  {

    // Instance data
    private WAVESHAPE waveshape;
    private long periodSamples;
    private long sampleNumber;
    private boolean flag;
    private int vol;
    public int midiNum;


    public enum WAVESHAPE {
        SIN, SQU, SAW
    }

    public Oscillator() {
        setOscWaveshape(WAVESHAPE.SIN);
        setFrequency(0);
        setVol(0);
        released();
    }

    public void setOscWaveshape(WAVESHAPE waveshape) {
        this.waveshape = waveshape;
    }

    public void clicked(){
        this.flag = true;
    }

    public void released(){
        this.flag = false;
    }
    public boolean isClicked(){
        return this.flag;
    }

    /**
     * Set the frequency of the oscillator in Hz.
     *
     * @param frequency Frequency in Hz for this oscillator
     */

    public void setFrequency(double frequency) {

        periodSamples = (long)(Player.SAMPLE_RATE / frequency);
    }

    public void setVol(int vol){

        this.vol = vol;
    }

    public int getVol() {
        return vol;
    }


    /**
     * Return the next sample of the oscillator's waveform
     *
     * @return Next oscillator sample
     */

    protected double getSample() {
        double value;
        double x = sampleNumber / (double) periodSamples;
        switch (waveshape) {
            default:
            case SIN:
                value = Math.sin(2.0 * Math.PI * x);
                break;
            case SQU:
                if (sampleNumber < (periodSamples / 2)) {
                    value = 0.9;

                }  else  {
                    value = -0.9;
                }
                break;
            case SAW:
                value = 2.0 * (x - Math.floor(x + 0.5));
                break;
        }
        sampleNumber = (sampleNumber + 1) % periodSamples;
        return value;
    }
}