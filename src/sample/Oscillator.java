package sample;

public class Oscillator  {

    private long periodSamples;
    private long sampleNumber;
    private boolean flag;
    private int vol;
    public int midiNum;
    private double sinValue;
    private double squareValue;
    private double sawValue;

    public void setSineValue(double sinValue) {
        this.sinValue = sinValue;
        System.out.println("sin set to: " + this.sinValue);
    }

    public void setSquareValue(double squareValue) {
        this.squareValue = squareValue;
        System.out.println("square set to: " + this.squareValue);
    }

    public void setSawValue(double sawValue) {
        this.sawValue = sawValue;
        System.out.println("saw set to: " + this.sawValue);
    }


    public Oscillator() {

        setFrequency(0);
        setVol(0);
        released();
    }

    protected void clicked(){
        this.flag = true;
    }

    protected void released(){
        this.flag = false;
    }
    protected boolean isClicked(){
        return this.flag;
    }


    public void setFrequency(double frequency) {

        periodSamples = (long)(Player.SAMPLE_RATE / frequency);
    }

    public void setVol(int vol){

        this.vol = vol;
    }

    public int getVol() {
        return vol;
    }

    private double mixShapes()
    {
        double value;
        double x = sampleNumber / (double) periodSamples;
        double sine = this.sinValue * Math.sin(2.0 * Math.PI * x);
        double square;
        if (sampleNumber < (periodSamples / 2)) {
            square = this.squareValue * 0.99;
        }else { square = this.squareValue * -0.99; }
        double saw =  this.sawValue * 2.0 * (x - Math.floor(x + 0.5));
        value = (sine + square + saw)/3;

        return value;
    }


    public double getSample() {
        sampleNumber = (sampleNumber + 1) % periodSamples;
        return mixShapes();
    }
}