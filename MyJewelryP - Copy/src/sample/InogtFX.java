package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class InogtFX extends Application {

    Button btn,button;
    TextField textFieldW,textFieldG,textFieldS,textFieldC;
    Label labelResult1,labelResult2,labelResult3,labelResult4;
    double result1,result2,result3,result4;
    Stage s;
    public void ingotAnalyzes(){

        double weight = Double.valueOf(textFieldW.getText());
        double gold = Double.valueOf(textFieldG.getText());
        double silver = Double.valueOf(textFieldS.getText());
        double copper = Double.valueOf(textFieldC.getText());
        result1=weight * gold;
        result2=weight * silver;
        result3=weight * copper;
        result4 = result1 - result2 - result3;
    }

    @Override
    public void start(Stage stage) throws Exception {

        Pane pane = new Pane();
        pane.setStyle("-fx-background-color:#e6dded ");
        pane.setPrefSize(1200, 1000);
        pane.setTranslateX(0);
        pane.setTranslateY(0);

        Pane pane1 = new Pane();
        pane1.setStyle("-fx-background-color: #746580 ");
        pane1.setPrefSize(330, 1000);
        pane1.setTranslateX(0);
        pane1.setTranslateY(0);

        Text text = new Text("Jewelry");
        text.setX(45);
        text.setY(70);
        text.setStyle(
                "-fx-font: 35px Georgia;"
                        + "-fx-fill: linear-gradient(from 0% 0% to 100% 200%, repeat, Pink 0%, lavender 50%);"
                        + "-fx-stroke-width: 1.5;"
        );

        Text text1 = new Text("Workshop");
        text1.setX(60);
        text1.setY(100);
        text1.setStyle(
                "-fx-font: 35px Georgia;"
                        + "-fx-fill: linear-gradient(from 0% 0% to 100% 200%, repeat, Pink 0%, lavender 50%);"
                        + "-fx-stroke-width: 1.5;"
        );

        Image image = new Image(getClass().getResourceAsStream("/image/mylogo1.png"));
        ImageView imageView = new ImageView(image);
        imageView.setTranslateX(170);
        imageView.setTranslateY(30);

        Text text2 = new Text("Ingot Analysis");
        text2.setX(470);
        text2.setY(50);
        text2.setStyle(
                "-fx-font: 25px Georgia;"
                        + "-fx-fill: linear-gradient(from 0% 0% to 100% 200%, repeat,gray 0%, Black 50%);"
                        + "-fx-stroke-width: 1.5;"
                        + "-fx-font-weight: bold;"
        );

        Tooltip tooltip1 = new Tooltip("Enter the ingot weight");
        tooltip1.setGraphic( new ImageView(new Image(getClass().getResourceAsStream("/image/mylogomini.png"))));
        tooltip1.setStyle(
                "-fx-text-fill: white;"
                        + "-fx-background-color: Black;"
                        + "-fx-opacity: 0.8;"
                        + "-fx-font-size: 10px;"
                         );


        Tooltip tooltip2 = new Tooltip("Enter the gold caliber");
        tooltip2.setGraphic( new ImageView(new Image(getClass().getResourceAsStream("/image/mylogomini.png"))));
        tooltip2.setStyle(
                "-fx-text-fill: white;"
                        + "-fx-background-color: Black;"
                        + "-fx-opacity: 0.8;"
                        + "-fx-font-size: 10px;"
        );

        Tooltip tooltip3 = new Tooltip("Enter the silver caliber");
        tooltip3.setGraphic( new ImageView(new Image(getClass().getResourceAsStream("/image/mylogomini.png"))));
        tooltip3.setStyle(
                "-fx-text-fill: white;"
                        + "-fx-background-color: Black;"
                        + "-fx-opacity: 0.8;"
                        + "-fx-font-size: 10px;"
        );

        Tooltip tooltip4 = new Tooltip("Enter the copper caliber");
        tooltip4.setGraphic( new ImageView(new Image(getClass().getResourceAsStream("/image/mylogomini.png"))));
        tooltip4.setStyle(
                "-fx-text-fill: white;"
                        + "-fx-background-color: Black;"
                        + "-fx-opacity: 0.8;"
                        + "-fx-font-size: 10px;"
        );


        textFieldW = new TextField();
        textFieldW.setFocusTraversable(false);
        textFieldW.setPromptText("INGOT Weight");
        textFieldW.setTooltip(tooltip1);
        textFieldW.setPrefWidth(150);
        textFieldW.setFont(Font.font("Georgia",15));
        textFieldW.setTranslateX(70);
        textFieldW.setTranslateY(200);
        textFieldW.setBackground(new Background(new BackgroundFill(Color.rgb(230,221,237), new CornerRadii(5), Insets.EMPTY)));

        textFieldG = new TextField();
        textFieldG.setPromptText("GOLD Caliber");
        textFieldG.setFocusTraversable(false);
        textFieldG.setTooltip(tooltip2);
        textFieldG.setPrefWidth(150);
        textFieldG.setTranslateX(70);
        textFieldG.setTranslateY(250);
        textFieldG.setFont(Font.font("Georgia",15));
        textFieldG.setBackground(new Background(new BackgroundFill(Color.rgb(230,221,237), new CornerRadii(5), Insets.EMPTY)));

        textFieldS = new TextField();
        textFieldS.setPromptText("SILVER Caliber");
        textFieldS.setTooltip(tooltip3);
        textFieldS.setFocusTraversable(false);
        textFieldS.setPrefWidth(150);
        textFieldS.setFont(Font.font("Georgia",18));
        textFieldS.setTranslateX(70);
        textFieldS.setTranslateY(300);
        textFieldS.setBackground(new Background(new BackgroundFill(Color.rgb(230,221,237), new CornerRadii(5), Insets.EMPTY)));


        textFieldC = new TextField();
        textFieldC.setPromptText("Copper Caliber");
        textFieldC.setTooltip(tooltip4);
        textFieldC.setFocusTraversable(false);
        textFieldC.setPrefWidth(150);
        textFieldC.setTranslateX(70);
        textFieldC.setTranslateY(350);
        textFieldC.setFont(Font.font("Georgia",18));
        textFieldC.setBackground(new Background(new BackgroundFill(Color.rgb(230,221,237), new CornerRadii(5), Insets.EMPTY)));

        labelResult1 = new Label();
        labelResult1.setFont(Font.font("Georgia",FontWeight.BOLD,20));
        labelResult1.setTextFill(Color.WHITE);
        labelResult1.setTranslateX(390);
        labelResult1.setTranslateY(170);
        labelResult1.setBackground(new Background(new BackgroundFill(Color.rgb(115, 100, 132), new CornerRadii(5), Insets.EMPTY)));
        labelResult1.setOnMouseEntered((MouseEvent e) -> {
            labelResult1.setTextFill(Color.rgb(230, 221, 237));
            labelResult1.setScaleX(1.1);
            labelResult1.setScaleY(1.1);
        });
        labelResult1.setOnMouseExited((MouseEvent e) -> {
            labelResult1.setTextFill(Color.WHITE);
            labelResult1.setScaleX(1);
            labelResult1.setScaleY(1);
        });

        labelResult2 = new Label();
        labelResult2.setFont(Font.font("Georgia",FontWeight.BOLD,20));
        labelResult2.setTextFill(Color.WHITE);
        labelResult2.setTranslateX(390);
        labelResult2.setTranslateY(220);
        labelResult2.setBackground(new Background(new BackgroundFill(Color.rgb(115, 100, 132), new CornerRadii(5), Insets.EMPTY)));
        labelResult2.setOnMouseEntered((MouseEvent e) -> {
            labelResult2.setTextFill(Color.rgb(230, 221, 237));
            labelResult2.setScaleX(1.1);
            labelResult2.setScaleY(1.1);
        });
        labelResult2.setOnMouseExited((MouseEvent e) -> {
            labelResult2.setTextFill(Color.WHITE);
            labelResult2.setScaleX(1);
            labelResult2.setScaleY(1);
        });

        labelResult3 = new Label();
        labelResult3.setFont(Font.font("Georgia",FontWeight.BOLD,20));
        labelResult3.setTextFill(Color.WHITE);
        labelResult3.setTranslateX(390);
        labelResult3.setTranslateY(270);
        labelResult3.setBackground(new Background(new BackgroundFill(Color.rgb(115, 100, 132), new CornerRadii(5), Insets.EMPTY)));
        labelResult3.setOnMouseEntered((MouseEvent e) -> {
            labelResult3.setTextFill(Color.rgb(230, 221, 237));
            labelResult3.setScaleX(1.1);
            labelResult3.setScaleY(1.1);
        });
        labelResult3.setOnMouseExited((MouseEvent e) -> {
            labelResult3.setTextFill(Color.WHITE);
            labelResult3.setScaleX(1);
            labelResult3.setScaleY(1);
        });


        labelResult4 = new Label();
        labelResult4.setFont(Font.font("Georgia",FontWeight.BOLD,20));
        labelResult4.setTextFill(Color.WHITE);
        labelResult4.setTranslateX(360);
        labelResult4.setTranslateY(320);
        labelResult4.setBackground(new Background(new BackgroundFill(Color.rgb(115, 100, 132), new CornerRadii(5), Insets.EMPTY)));
        labelResult4.setOnMouseEntered((MouseEvent e) -> {
            labelResult4.setTextFill(Color.rgb(230, 221, 237));
            labelResult4.setScaleX(1.1);
            labelResult4.setScaleY(1.1);
        });
        labelResult4.setOnMouseExited((MouseEvent e) -> {
            labelResult4.setTextFill(Color.WHITE);
            labelResult4.setScaleX(1);
            labelResult4.setScaleY(1);
        });


        DropShadow shadow = new DropShadow(10, Color.BLACK);

        button = new Button();
        button.setTranslateX(450);
        button.setTranslateY(470);
        button.setPrefSize(220, 30);
        button.setFont(Font.font("Georgia",FontWeight.BOLD,15));
        button.setTextFill(Color.BLACK);
        button.setBackground(new Background(new BackgroundFill(Color.rgb(115, 100, 132), new CornerRadii(5), Insets.EMPTY)));
        button.setOnAction((ActionEvent m) -> {
            s.close();
            try {
                start(s);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        button.setDisable(true);


        btn = new Button("RESULT");
        btn.setTranslateX(40);
        btn.setTranslateY(420);
        btn.setPrefSize(220, 30);
        btn.setFont(Font.font("Georgia",FontWeight.BOLD,15));
        btn.setTextFill(Color.BLACK);
        btn.setBackground(new Background(new BackgroundFill(Color.rgb(230,221,237), new CornerRadii(5), Insets.EMPTY)));
        btn.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            btn.setEffect(shadow);
        });
        btn.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
            btn.setEffect(null);
        });
        btn.setOnAction((ActionEvent e) -> {
            ingotAnalyzes();
            labelResult1.setText("AMOUNT OF GOLD :" + result1);
            labelResult2.setText("AMOUNT OF SILVER :" + result2);
            labelResult3.setText("AMOUNT OF COPPER :" + result3);
            labelResult4.setText("AMOUNT OF IMPURITIES :" + result4);


            button.setDisable(false);
            button.setText("RESTART");
            button.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent m) -> {
                button.setEffect(shadow);
            });
            button.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent m) -> {
                button.setEffect(null);
            });

        });

        pane1.getChildren().addAll(imageView,text,text1,textFieldG,textFieldC,textFieldS,textFieldW,btn,button);

        pane.getChildren().addAll(pane1,text2,labelResult1,labelResult2,labelResult3,labelResult4);


        Scene scene = new Scene(pane, 800, 600);

        stage = new Stage();
        stage.setTitle("Jewelry Workshop");
        stage.setScene(scene);
        stage.show();
        s=stage;
    }
}
