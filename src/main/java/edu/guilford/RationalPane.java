package edu.guilford;

import java.io.File;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class RationalPane extends GridPane {

    // Rational attribute
    private Rational rational;

    // Three text fields
    private TextField userRationalField = new TextField();
    private TextField randomRationalField = new TextField();
    private TextField resultField = new TextField();

    // Three labels
    private Label userRationalLabel;
    private Label randomRationalLabel;
    private Label resultLabel;
    // Add a title to the pane
    private Label title = new Label("Rational Number Calculator");

    // Three RadioButtons
    private RadioButton negate;
    private RadioButton invert;
    private RadioButton add;

    // One button (when clicked on, it will pop up an image)
    private Button showImage;

    // Step 1. Declare an imageView Attribute
    private ImageView imageView = new ImageView();

    // Constructor
    public RationalPane(Rational rational) {
        Rational randomRational = new Rational();
        this.rational = rational;
        // Instantiation

        // Fields
        userRationalField = new TextField();
        randomRationalField = new TextField(randomRational.toString());
        randomRationalField.setEditable(false);
        resultField = new TextField();
        resultField.setEditable(false);

        // Labels
        userRationalLabel = new Label("Enter your rational number numerator: ");
        randomRationalLabel = new Label("Random rational number: ");
        resultLabel = new Label("Result: ");

        // RadioButtons (might change this medium), not that nice
        negate = new RadioButton("Negate");
        invert = new RadioButton("Invert");
        add = new RadioButton("Add to Random Rational Number");

        // Buttons
        showImage = new Button("Ew,Math!");

        // Image
        // Step 2. Instantiate the ImageView attribute with the image in the resources
        // folder. We have to tell javafx
        // where our resource is and then convert it into an URL which needs to be
        // turned into a string.
        File avatar = new File(this.getClass().getResource("world.jpg").getPath());
        imageView = new ImageView(avatar.toURI().toString());

        // Add the labels, fields, and buttons to the pane

        // Labels
        this.add(title, 0, 0);
        this.add(userRationalLabel, 0, 1);
        this.add(randomRationalLabel, 0, 2);
        this.add(resultLabel, 0, 3);

        // Fields
        this.add(userRationalField, 1, 1);
        this.add(randomRationalField, 1, 2);
        this.add(resultField, 1, 3);

        // Add RadioButtons to the far right of the fields
        this.add(negate, 3, 1);
        this.add(invert, 3, 2);
        this.add(add, 3, 3);

        // Button in the bottom of the panel
        this.add(showImage, 0, 4);

        // Give a pane a border color of black
        this.setStyle("-fx-border-color: black;");
        // Give a pane a background color
        this.setStyle("-fx-background-color: lightblue;");
        // Bold title
        title.setStyle("-fx-font-weight: bold");
        // Italicize RadioButtons
        negate.setStyle("-fx-font-style: italic");
        invert.setStyle("-fx-font-style: italic");
        add.setStyle("-fx-font-style: italic");

        // Image
        // Step 3. Add the ImageView to the bottom half of the pane.
        // I didn't add it here but actually
        // added it in the button listener below. Scroll all the way down to the bottom of the code to view the listener. 

        // Add a listener that gets the value inputted into the Numerator and
        // Denominator textfields after user clicks enter
        userRationalField.setOnAction(e -> {
            // Set label to the value of the userRationalField
            userRationalLabel.setText("Rational Number: " + userRationalField.getText());
            // Get the value of the userRationalField, seperate it into a numerator and
            // denominator by the /, and set the rational object
            // 's numerator and denominator to that value
            String text = userRationalField.getText();
            String[] parts = text.split("/");
            String numeratorString = parts[0];
            String denominatorString = parts[1];
            int numerator = Integer.parseInt(numeratorString);
            int denominator = Integer.parseInt(denominatorString);
            // Make sure denominator is not negative for syntax purposes
            if (denominator < 0 && numerator > 0) {
                numerator = numerator * -1;
                denominator = denominator * -1;
                String set = numerator + "/" + denominator;
                userRationalLabel.setText("Rational Number: " + set);
            }
        });

        // Add a listener to the RadioButtons that change the resultField
        // when clicked on
        negate.setOnAction(e -> {
            // Get the value of the userRationalField, seperate it into a numerator and
            // denominator by the /, and set the rational object
            // 's numerator and denominator to that value
            String text = userRationalField.getText();
            String[] parts = text.split("/");
            String numeratorString = parts[0];
            String denominatorString = parts[1];
            int numerator = Integer.parseInt(numeratorString);
            int denominator = Integer.parseInt(denominatorString);
            // Make sure denominator is not negative
            if (denominator < 0 && numerator > 0) {
                numerator = numerator * -1;
                denominator = denominator * -1;
            }
            // Convert numerator and denominator to integers and set the rational object's
            // numerator and denominator to those values
            rational.setNumerator(numerator);
            rational.setDenominator(denominator);
            rational.negate();
            resultField.setText(rational.toString());
        });
        invert.setOnAction(e -> {
            // Get the value of the userRationalField, seperate it into a numerator and
            // denominator by the /, and set the rational object
            // 's numerator and denominator to that value
            String text = userRationalField.getText();
            String[] parts = text.split("/");
            String numeratorString = parts[0];
            String denominatorString = parts[1];
            int numerator = Integer.parseInt(numeratorString);
            int denominator = Integer.parseInt(denominatorString);
            // Make sure denominator is not negative
            if (denominator < 0 && numerator > 0) {
                numerator = numerator * -1;
                denominator = denominator * -1;
            }
            // Convert numerator and denominator to integers and set the rational object's
            // numerator and denominator to those values
            rational.setNumerator(numerator);
            rational.setDenominator(denominator);
            rational.invert();
            resultField.setText(rational.toString());
        });

        add.setOnAction(e -> {
            // Get the value of the userRationalField, seperate it into a numerator and
            // denominator by the /, and set the rational object
            // 's numerator and denominator to that value
            String text = userRationalField.getText();
            String[] parts = text.split("/");
            String numeratorString = parts[0];
            String denominatorString = parts[1];
            int numerator = Integer.parseInt(numeratorString);
            int denominator = Integer.parseInt(denominatorString);
            // Make sure denominator is not negative
            if (denominator < 0 && numerator > 0) {
                numerator = numerator * -1;
                denominator = denominator * -1;
            }
            // Convert numerator and denominator to integers and set the rational object's
            // numerator and denominator to those values
            rational.setNumerator(numerator);
            rational.setDenominator(denominator);
            resultField.setText(rational.add(randomRational).toString());
        });

        // Add a listener that displays or removes image every time button is clicked on 
        // Step 3. Add the ImageView to the bottom half of the pane.
        // Steps 4 & 5: Write an event listener and connect it to the component
        // that will trigger the event. (open pr close the image everytime the button is clicked)
        
        showImage.setOnAction(e -> {
            // Position image at the center of bottom half of the pane
            if (showImage.getText().equals("Ew,Math!")) {
                this.add(imageView, 1, 7);
                // alter image size
                imageView.setFitWidth(380);
                imageView.setFitHeight(380);
                showImage.setText("Hide Image");
            } else {
                this.getChildren().remove(imageView);
                showImage.setText("Ew,Math!");
            }
        });

    }

}
