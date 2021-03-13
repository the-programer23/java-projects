package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

public class EmployeeService extends Service<ObservableList<String>> {
    @Override
    protected Task<ObservableList<String>> createTask() {
        return new Task<>() {
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
        };
    }
}
