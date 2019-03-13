package WithOutServer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class FinalCode extends Application {
Scanner file1;
Scanner file2;
    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {

        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);

        Label firstNumberLabel = new Label("Total Milage Distance: ");
        Label secondNumberLabel = new Label("Miles Per Gallon: ");
        Label result = new Label("Result: ");

        TextField textField1 = new TextField();
        TextField textField2 = new TextField();

        ArrayList<String> results = new ArrayList<String>();

        final ToggleGroup toggleGroup = new ToggleGroup();

        RadioButton rb1 = new RadioButton("Diesel");
        RadioButton rb2 = new RadioButton("98 Octane");
        Button submitButton = new Button("Submit");

        rb1.setToggleGroup(toggleGroup);
        rb2.setToggleGroup(toggleGroup);
        rb1.setSelected(true);

        GridPane.setConstraints(firstNumberLabel, 0, 0);
        GridPane.setConstraints(textField1, 0, 1);
        GridPane.setConstraints(secondNumberLabel, 0, 2);
        GridPane.setConstraints(textField2, 0, 3);

        GridPane.setConstraints(rb1, 0, 4);
        GridPane.setConstraints(rb2, 0, 6);
        GridPane.setConstraints(submitButton, 0, 8);

        GridPane.setConstraints(result, 0, 15);
        
        file1 = new Scanner(new File("C:\\Users\\Amirreza\\Documents\\NetBeansProjects\\Final JavaCode/DieselPrice.txt"));
        file2 = new Scanner(new File("C:\\Users\\Amirreza\\Documents\\NetBeansProjects\\Final JavaCode/OctanePrice.txt"));
        
        String dieselPrice = file1.next();
        String octanePrice = file2.next();


        submitButton.setOnAction((ActionEvent event) -> {

            PrintWriter output
                    = null;
            try {
                RadioButton selectedRadioButton
                        = (RadioButton) toggleGroup.getSelectedToggle();
                switch (selectedRadioButton.getText()) {
                    case "Diesel":
                        Calculation calculation = new Calculation(selectedRadioButton.getText(),
                                Double.parseDouble(textField2.getText()),
                                Double.parseDouble(textField1.getText()),
                                Double.parseDouble(dieselPrice));
                        result.setText("Distance: " + calculation.getDistance()+
                                "\nMPG: " + calculation.getMPG()+
                                "\nPriceOfFuel: " + calculation.getPriceOfFuel()+
                                "\nFinal Price: £" + calculation.quickMaths());
                        
                        output = new PrintWriter("C:\\Users\\Amirreza\\Documents\\NetBeansProjects\\Final JavaCode/DieselFinal.txt");
                        output.print(("Distance: " + calculation.getDistance()+
                                "\nMPG: " + calculation.getMPG()+
                                "\nPriceOfFuel: " + calculation.getPriceOfFuel()+
                                "\nFinal Price: £" + calculation.quickMaths()));
                        break;
                    case "98 Octane":
                        Calculation octane = new Calculation(selectedRadioButton.getText(),
                                Double.parseDouble(textField2.getText()),
                                Double.parseDouble(textField1.getText()),
                                Double.parseDouble(octanePrice));
                        
                        result.setText("Distance: " + octane.getDistance()+
                                "\nMPG: " + octane.getMPG()+
                                "\nPriceOfFuel: " + octane.getPriceOfFuel()+
                                "\nFinal Price: £" + octane.quickMaths());
                        
                        output = new PrintWriter("C:\\Users\\Amirreza\\Documents\\NetBeansProjects\\Final JavaCode/OctaneFinal.txt");
                        output.print(("Distance: " + octane.getDistance()+
                                "\nMPG: " + octane.getMPG()+
                                "\nPriceOfFuel: " + octane.getPriceOfFuel()+
                                "\nFinal Price: £" + octane.quickMaths()));
                        break;
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(FinalCode.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                output.close();
            }

        });

        GridPane.setConstraints(submitButton, 0, 14);

        root.getChildren().addAll(firstNumberLabel, textField1,
                secondNumberLabel, textField2, rb1, rb2, submitButton,
                result);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("The Fuel Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public double stringToDouble(String number) {
        return Double.parseDouble(number);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
