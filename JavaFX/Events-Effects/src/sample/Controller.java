package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.GridPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

public class Controller {
    @FXML
    private Label label;
    @FXML
    private Button button4;
    @FXML
    private GridPane gridPane;
    @FXML
    private WebView webView;

    public void initialize(){
        button4.setEffect(new DropShadow());
    }

    public void handleMouseEnter(){
        label.setScaleX(2.0);
        label.setScaleY(2.0);
        label.setRotate(90);
    }

    public void handleMouseExit(){
        label.setScaleX(1.0);
        label.setScaleY(1.0);
        label.setRotate(0);
    }

    public void handleClick() {
        //this selects a folder
        //DirectoryChooser chooser = new DirectoryChooser();
        //File file = chooser.showDialog(gridPane.getScene().getWindow());

        //this selects a file
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Save Application File");
        chooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text", "*.txt"),
                new FileChooser.ExtensionFilter("PDF", "*.pdf"),
                new FileChooser.ExtensionFilter("Zip", "*.zip"),
                new FileChooser.ExtensionFilter("Images files", "*.jpg", "*.png", "*.gif"),
                new FileChooser.ExtensionFilter("All files", "*.*")
        );
        //File file = chooser.showOpenDialog(gridPane.getScene().getWindow());
        //File file = chooser.showSaveDialog(gridPane.getScene().getWindow());
        List<File> file = chooser.showOpenMultipleDialog(gridPane.getScene().getWindow());

        if(file != null){
            for(int i = 0; i<file.size(); i++){
                System.out.println(file.get(i));
            }
            //System.out.println(file.getPath());
        }else {
            System.out.println("Chooser was cancelled");
        }
    }

    public void handleLinkClick(){
       /* try{

            //OPENS DEFAULT BROWSER

            Desktop.getDesktop().browse(new URI("http://www.javafx.com"));
        }catch(IOException e){
            e.printStackTrace();
        }catch(URISyntaxException e){
            e.printStackTrace();
        }*/

        WebEngine engine = webView.getEngine();
        engine.load("http://www.youtube.com");
    }
}
