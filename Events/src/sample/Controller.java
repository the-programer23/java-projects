package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private TextField nameField;
    @FXML
    private Button helloBtn;
    @FXML
    private Button byeBtn;
    @FXML
    private CheckBox ourCheckBox;
    @FXML
    private Label ourLabel;

    //the initialize method is like ngOnInit in Angular
    public void initialize(){
        helloBtn.setDisable(true);
        byeBtn.setDisable(true);
    }

    public void sayHello(ActionEvent e){
        if(e.getSource().equals(helloBtn)){
            System.out.println("Hello " + nameField.getText());
        }else if(e.getSource().equals(byeBtn)){
            System.out.println("Bye " + nameField.getText());
        }

        Runnable task = new Runnable() {
            @Override
            public void run() {
                try{
                    String s = Platform.isFxApplicationThread() ? "UI thread" : "Background thread";
                    System.out.println("I'm going to sleep in the " + s);
                    Thread.sleep(5000);
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            String s = Platform.isFxApplicationThread() ? "UI thread" : "Background thread";
                            System.out.println("I'm updating the label on the: " + s);
                            ourLabel.setText("We did something yeah!!!!");
                        }
                    });
                }catch(InterruptedException event){
                    //we do not care about this
                }
            }
        };

        new Thread(task).start();

        if(ourCheckBox.isSelected()){
            nameField.clear();
            helloBtn.setDisable(true);
            byeBtn.setDisable(true);
        }
    }

    public void handleKeyReleased(){
        String text = nameField.getText();
        boolean disableButtons = text.isEmpty() || text.trim().isEmpty();
        helloBtn.setDisable(disableButtons);
        byeBtn.setDisable(disableButtons);
    }

    public void handleChange(){
        System.out.println("The checkbox is " + (ourCheckBox.isSelected() ? "checked" : "not checked"));
    }
}
