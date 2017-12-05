package sample;

import com.sun.swing.internal.plaf.synth.resources.synth;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.input.DragEvent;
import javafx.scene.input.KeyEvent;

public class Controller {

    private Synth synth = new Synth();

    @FXML
    private RadioButton sine;
    @FXML
    private RadioButton square;
    @FXML
    private RadioButton saw;



    @FXML
    public void selectSine (ActionEvent event){
        System.out.println("Sine is " + (sine.isSelected()?"on":"off"));
        synth.setShape(1);
        saw.setSelected(false);
        square.setSelected(false);
    }

    @FXML
    public void selectSquare (ActionEvent event){
        System.out.println("Square is " + (square.isSelected()?"on":"off"));
        synth.setShape(2);
        sine.setSelected(false);
        saw.setSelected(false);
    }

    @FXML
    public void selectSaw (ActionEvent event){
        System.out.println("Saw is " + (saw.isSelected()?"on":"off"));
        synth.setShape(3);
        sine.setSelected(false);
        square.setSelected(false);
    }
}
