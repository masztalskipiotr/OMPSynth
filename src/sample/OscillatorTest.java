package sample;

import static org.junit.Assert.*;

public class OscillatorTest {

    @org.junit.Test
    public void mixShapes_sineValue0() {
        double sampleNumber = 0;
        double periodSamples = Math.floor(Math.random()*101);
        double x = sampleNumber/periodSamples;
        double sine =  Math.sin(2.0 * Math.PI * x);
        assertEquals(0,sine,0);
    }

    @org.junit.Test
    public void mixShapes_sineValue1() {
        double sampleNumber = 1;
        double periodSamples = 4;
        double x = sampleNumber/periodSamples;
        double sine =  Math.sin(2.0 * Math.PI * x);
        assertEquals(1,sine,0);
    }

    @org.junit.Test
    public void mixShapes_overdrive(){
        boolean od;
        double sine = 1;
        double square = 0.99;
        double saw = 1;
        double value = (sine + square + saw)/3;

        if (value > 1 | value <-1){
            od = true;
        }else {
            od = false;
        }
        assertFalse(od);
    }
}