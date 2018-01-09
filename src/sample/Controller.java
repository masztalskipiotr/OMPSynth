package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Slider;


public class Controller {

    private Synth synth = new Synth();

    @FXML
    private Slider sin;
    @FXML
    private Slider square;
    @FXML
    private Slider saw;

    public void initialize() {

        sin.valueProperty().addListener((observable, oldValue, newValue) -> {

            synth.setOscSineValue(newValue.doubleValue());


        });
        square.valueProperty().addListener((observable, oldValue, newValue) -> {

            synth.setOscSquareValue(newValue.doubleValue());


        });
        saw.valueProperty().addListener((observable, oldValue, newValue) -> {

            synth.setOscSawValue(newValue.doubleValue());


        });
    }


//
//    @FXML
//    public void selectSine (ActionEvent event){
//            System.out.println("Sine is " + (sine.isSelected() ? "on" : "off"));
//            synth.setShape(1);
//    }
//
//    @FXML
//    public void selectSquare (ActionEvent event){
//        System.out.println("Square is " + (square.isSelected()?"on":"off"));
//        synth.setShape(2);
//    }
//
//    @FXML
//    public void selectSaw (ActionEvent event){
//        System.out.println("Saw is " + (saw.isSelected()?"on":"off"));
//        synth.setShape(3);
//    }


//    @FXML
//    public void sineControl(){
//        synth.setSinValue(sin.getValue());
//    }
}
