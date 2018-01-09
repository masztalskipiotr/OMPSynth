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
}
