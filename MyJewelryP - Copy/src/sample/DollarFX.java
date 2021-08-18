package sample;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URISyntaxException;

public class DollarFX extends Application implements EventHandler<ActionEvent> {
    Stage sD;
    TextField textField1, textField2, textField3, textField4;
    Button btn1, btn2, btn3, btn4, btn5;
    ChoiceBox choiceBox;
    Label labelResult;
    IJDollar jewelry;
    int caliber ;
    double ONS, grams, wages;

    @Override
    public void start(Stage stage) throws Exception {
        Pane pane1 = new Pane();
        pane1.setStyle("-fx-background-color: #e6dded ");
        pane1.setPrefSize(1200, 1000);
        pane1.setTranslateX(0);
        pane1.setTranslateY(0);

        Text text = new Text("Convert Grams");
        text.setX(260);
        text.setY(70);
        text.setStyle(
                "-fx-font: 30px Georgia;"
                        + "-fx-fill: linear-gradient(from 0% 0% to 100% 200%, repeat, Black 0%, #746580 50%);"
                        + "-fx-stroke-width: 1.5;"
                        + "-fx-font-weight: bold;"
        );
        Text text1 = new Text("To Dollars");
        text1.setX(285);
        text1.setY(110);
        text1.setStyle(
                "-fx-font: 30px Georgia;"
                        + "-fx-fill: linear-gradient(from 0% 0% to 100% 200%, repeat, #746580 0%, Black 50%);"
                        + "-fx-stroke-width: 1.5;"
                        + "-fx-font-weight: bold;"
        );

        Image image1 = new Image(getClass().getResourceAsStream("/image/darklogo.png"));
        ImageView imageView1 = new ImageView(image1);
        imageView1.setTranslateX(700);
        imageView1.setTranslateY(45);

        Image image2 = new Image(getClass().getResourceAsStream("/image/darklogo.png"));
        ImageView imageView2 = new ImageView(image2);
        imageView2.setTranslateX(45);
        imageView2.setTranslateY(45);

        Image image3 = new Image(getClass().getResourceAsStream("/image/darklogo.png"));
        ImageView imageView3 = new ImageView(image3);
        imageView3.setTranslateX(700);
        imageView3.setTranslateY(500);

        Image image4 = new Image(getClass().getResourceAsStream("/image/darklogo.png"));
        ImageView imageView4 = new ImageView(image4);
        imageView4.setTranslateX(45);
        imageView4.setTranslateY(500);

        Tooltip tooltip1 = new Tooltip("The ons price must be for the same day and in oz!");
        tooltip1.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/image/mylogomini.png"))));
        tooltip1.setStyle(
                "-fx-text-fill: white;"
                        + "-fx-background-color: Black;"
                        + "-fx-opacity: 0.8;"
                        + "-fx-font-size: 10px;"
        );

        Tooltip tooltip1ONS = new Tooltip("This button takes you to the official ONS live website");
        tooltip1ONS.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/image/mylogomini.png"))));
        tooltip1ONS.setStyle(
                "-fx-text-fill: white;"
                        + "-fx-background-color: Black;"
                        + "-fx-opacity: 0.8;"
                        + "-fx-font-size: 10px;"
        );

        Tooltip tooltipBack = new Tooltip("This button takes you back to the Gold System first page");
        tooltipBack.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/image/mylogomini.png"))));
        tooltipBack.setStyle(
                "-fx-text-fill: white;"
                        + "-fx-background-color: Black;"
                        + "-fx-opacity: 0.8;"
                        + "-fx-font-size: 10px;"
        );

        Tooltip tooltipGrams = new Tooltip("must enter the total amount of grams!");
        tooltipGrams.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/image/mylogomini.png"))));
        tooltipGrams.setStyle(
                "-fx-text-fill: white;"
                        + "-fx-background-color: Black;"
                        + "-fx-opacity: 0.8;"
                        + "-fx-font-size: 10px;"
        );

        Tooltip tooltipRestart = new Tooltip("This button gives you the opportunity to convert new amount of grams! ");
        tooltipRestart.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/image/mylogomini.png"))));
        tooltipRestart.setStyle(
                "-fx-text-fill: white;"
                        + "-fx-background-color: Black;"
                        + "-fx-opacity: 0.8;"
                        + "-fx-font-size: 10px;"
        );

        Tooltip tooltipCaliber = new Tooltip("Please chose the correct gold caliber! ");
        tooltipCaliber.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/image/mylogomini.png"))));
        tooltipCaliber.setStyle(
                "-fx-text-fill: white;"
                        + "-fx-background-color: Black;"
                        + "-fx-opacity: 0.8;"
                        + "-fx-font-size: 10px;"
        );


        Label label1 = new Label("ONS Price");
        label1.setTranslateX(90);
        label1.setTranslateY(150);
        label1.setFont(Font.font("Georgia", 15));
        label1.setTextFill(Color.BLACK);

        textField1 = new TextField();
        textField1.setPromptText("ONS Price");
        textField1.setTooltip(tooltip1);
        textField1.setTranslateX(90);
        textField1.setTranslateY(180);
        textField1.setFocusTraversable(false);
        textField1.setPrefSize(200, 20);
        textField1.setFont(Font.font("Georgia", 18));
        textField1.setBackground(new Background(new BackgroundFill(Color.rgb(115, 100, 132), new CornerRadii(5), Insets.EMPTY)));


        btn1 = new Button("LEARN ONS PRICE");
        btn1.setTooltip(tooltip1ONS);
        btn1.setTranslateX(500);
        btn1.setTranslateY(180);
        btn1.setPrefSize(200, 20);
        btn1.setTextFill(Color.BLACK);
        btn1.setFont(Font.font("Georgia", 18));
        btn1.setBackground(new Background(new BackgroundFill(Color.rgb(115, 100, 132), new CornerRadii(5), Insets.EMPTY)));
        btn1.setOnAction((ActionEvent m) -> {
            CalculationForGold g = new CalculationForGold();
            try {
                g.openWebPage();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        Label label2 = new Label("Amount of Grams ");
        label2.setTranslateX(90);
        label2.setTranslateY(220);
        label2.setFont(Font.font("Georgia", 15));
        label2.setTextFill(Color.BLACK);

        textField2 = new TextField();
        textField2.setPromptText("Amount of Grams");
        textField2.setTooltip(tooltipGrams);
        textField2.setTranslateX(90);
        textField2.setTranslateY(250);
        textField2.setFocusTraversable(false);
        textField2.setPrefSize(200, 20);
        textField2.setFont(Font.font("Georgia", 18));
        textField2.setBackground(new Background(new BackgroundFill(Color.rgb(115, 100, 132), new CornerRadii(5), Insets.EMPTY)));


        choiceBox = new ChoiceBox();
        choiceBox.setPrefSize(200, 30);
        choiceBox.setTooltip(tooltipCaliber);
        choiceBox.setTranslateX(500);
        choiceBox.setTranslateY(250);
        choiceBox.getItems().addAll("24", "22", "21", "18", "14", "12", "8");
        choiceBox.setBackground(new Background(new BackgroundFill(Color.rgb(115, 100, 132), new CornerRadii(5), Insets.EMPTY)));


        Label label3 = new Label("Manufacturing Wages");
        label3.setTranslateX(90);
        label3.setTranslateY(290);
        label3.setFont(Font.font("Georgia", 15));
        label3.setTextFill(Color.BLACK);

        textField3 = new TextField();
        textField3.setPromptText("Wages");
        textField3.setTranslateX(90);
        textField3.setTranslateY(320);
        textField3.setFocusTraversable(false);
        textField3.setPrefSize(200, 20);
        textField3.setFont(Font.font("Georgia", 18));
        textField3.setBackground(new Background(new BackgroundFill(Color.rgb(115, 100, 132), new CornerRadii(5), Insets.EMPTY)));

        btn2 = new Button("LEARN WAGES");
        btn2.setTranslateX(500);
        btn2.setTranslateY(320);
        btn2.setPrefSize(200, 20);
        btn2.setTextFill(Color.BLACK);
        btn2.setFont(Font.font("Georgia", 18));
        btn2.setBackground(new Background(new BackgroundFill(Color.rgb(115, 100, 132), new CornerRadii(5), Insets.EMPTY)));
        btn2.setOnAction((ActionEvent e ) ->{
            WagesClass w = new WagesClass();
            try {
                w.start(new Stage());
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        btn3 = new Button("RESULT");
        btn3.setTranslateX(280);
        btn3.setTranslateY(390);
        btn3.setPrefSize(200, 20);
        btn3.setTextFill(Color.BLACK);
        btn3.setFont(Font.font("Georgia", 18));
        btn3.setBackground(new Background(new BackgroundFill(Color.rgb(115, 100, 132), new CornerRadii(5), Insets.EMPTY)));
        btn3.setOnAction(this);

        labelResult = new Label();
        labelResult.setTranslateX(280);
        labelResult.setTranslateY(440);
        labelResult.setFont(Font.font("Georgia", 20));
        labelResult.setTextFill(Color.BLACK);
        labelResult.setBackground(new Background(new BackgroundFill(Color.rgb(115, 100, 132), new CornerRadii(5), Insets.EMPTY)));

        btn4 = new Button("EXIT");
        btn4.setTooltip(tooltipBack);
        btn4.setTranslateX(90);
        btn4.setTranslateY(470);
        btn4.setPrefSize(200, 20);
        btn4.setTextFill(Color.BLACK);
        btn4.setFont(Font.font("Georgia", 18));
        btn4.setBackground(new Background(new BackgroundFill(Color.rgb(115, 100, 132), new CornerRadii(5), Insets.EMPTY)));
        btn4.setOnAction((ActionEvent e) -> {
                    Gold g = new Gold();
                    try {
                        g.start(new Stage());
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
            sD.close();
                });

        btn5 = new Button("RESTART");
        btn5.setTooltip(tooltipRestart);
        btn5.setTranslateX(500);
        btn5.setTranslateY(470);
        btn5.setPrefSize(200, 20);
        btn5.setTextFill(Color.BLACK);
        btn5.setFont(Font.font("Georgia", 18));
        btn5.setBackground(new Background(new BackgroundFill(Color.rgb(115, 100, 132), new CornerRadii(5), Insets.EMPTY)));
        btn5.setOnAction((ActionEvent m) -> {
            sD.close();
                    try {
                        start(sD);
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }

        });


        pane1.getChildren().addAll(text, text1, imageView1, imageView2, imageView3, imageView4);


        Group root = new Group();
        root.getChildren().addAll(pane1, label1, label2, label3, textField1, textField2, btn1, choiceBox, btn2, btn3, labelResult, textField3, btn4, btn5);

        Scene scene = new Scene(root, 800, 600);

        stage = new Stage();
        stage.setTitle("Jewelry Workshop");
        stage.setScene(scene);
        stage.show();
        sD = stage;
    }


    @Override
    public void handle(ActionEvent actionEvent) {
        jewelry = new CalculationForGold();
        ONS = Double.parseDouble(textField1.getText());
        grams = Double.parseDouble(textField2.getText());
        wages = Double.parseDouble(textField3.getText());
        caliber = Integer.parseInt(choiceBox.getValue().toString());
        double result = jewelry.dollar(caliber, ONS, grams, wages);
        btn3.setOnAction((ActionEvent e) -> {
            labelResult.setText(String.valueOf(result));
        });

    }
}

