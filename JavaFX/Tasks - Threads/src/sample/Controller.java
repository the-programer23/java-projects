package sample;


import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.Worker;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;

import java.util.Arrays;

public class Controller {

    @FXML
    private ListView listView;
    @FXML
    private ProgressBar progressBar;
    @FXML
    private Label progressLabel;
    private Service<ObservableList<String>> service;

    public void initialize(){

        /*task = new Task<>() {
            @Override
            protected ObservableList<String> call() throws Exception {

                String[] names = {"Fabian Pinzon",
                        "Tim Buchalka",
                        "Bill Rogers",
                        "Jack Jill",
                        "Joan Andrews",
                        "Mary Johnson"};

                ObservableList<String> employees = FXCollections.observableArrayList();

                for (int i=0; i<names.length; i++){
                    employees.add(names[i]);
                    updateMessage("Added " + names[i] + " to the list");
                    updateProgress(i + 1, 6);
                    Thread.sleep(200);
                }

                return employees;
            }
        };*/
        service = new EmployeeService();
        progressBar.progressProperty().bind(service.progressProperty());
        progressLabel.textProperty().bind(service.messageProperty());
        listView.itemsProperty().bind(service.valueProperty());

      /*  service.setOnRunning(workerStateEvent -> {
            System.out.println("service is running");
            progressBar.setVisible(true);
            progressLabel.setVisible(true);
        });
        service.setOnSucceeded(workerStateEvent -> {
            System.out.println("Service succeeded");
            progressBar.setVisible(false);
            progressLabel.setVisible(false);
        });

        progressBar.setVisible(false);
        progressLabel.setVisible(false);*/
        progressBar.visibleProperty().bind(service.runningProperty());
        progressLabel.visibleProperty().bind(service.runningProperty());
    }

    @FXML
    public void buttonPressed(){
        if(service.getState() == Service.State.SUCCEEDED){
            service.reset();
            service.start();
        }else if(service.getState() == Service.State.READY){
            service.start();
        }
    }
}
