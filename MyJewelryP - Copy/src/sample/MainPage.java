package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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

public class MainPage extends Application {
    Stage s2;
    Button btn1, btn2, btn3;

    @Override
    public void start(Stage stage) throws Exception {

        Pane pane1 = new Pane();
        pane1.setStyle("-fx-background-color:#e6dded ");
        pane1.setPrefSize(1200, 1000);
        pane1.setTranslateX(0);
        pane1.setTranslateY(0);

        Text text = new Text("Jewelry");
        text.setX(260);
        text.setY(70);
        text.setStyle(
                "-fx-font: 45px Georgia;"
                        + "-fx-fill: linear-gradient(from 0% 0% to 100% 200%, repeat, Black 0%, #746580 50%);"
                        + "-fx-stroke-width: 1.5;"
                        + "-fx-font-weight: bold;"
        );
        Text text1 = new Text("Workshop");
        text1.setX(285);
        text1.setY(120);
        text1.setStyle(
                "-fx-font: 45px Georgia;"
                        + "-fx-fill: linear-gradient(from 0% 0% to 100% 200%, repeat, #746580 0%, Black 50%);"
                        + "-fx-stroke-width: 1.5;"
                        + "-fx-font-weight: bold;"
        );


        Image image1 = new Image(getClass().getResourceAsStream("/image/darklogo.png"));
        ImageView imageView1 = new ImageView(image1);
        imageView1.setTranslateX(700);
        imageView1.setTranslateY(300);

        Image image = new Image(getClass().getResourceAsStream("/image/darklogo.png"));
        ImageView imageView = new ImageView(image);
        imageView.setTranslateX(45);
        imageView.setTranslateY(300);

        Pane paneB = new Pane();

        DropShadow shadow = new DropShadow(10, Color.BLACK);

        btn1 = new Button("Gold System");
        btn1.setTranslateX(260);
        btn1.setTranslateY(250);
        btn1.setPrefSize(270, 40);
        btn1.setTextFill(Color.WHITE);
        btn1.setFont(Font.font("Georgia", FontWeight.BOLD,20));
        btn1.setBackground(new Background(new BackgroundFill(Color.rgb(115, 100, 132), new CornerRadii(5), Insets.EMPTY)));
        btn1.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            btn1.setEffect(shadow);
        });
        btn1.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
            btn1.setEffect(null);
        });
        btn1.setOnAction((ActionEvent e) -> {
            Gold g = new Gold();
            try {
                g.start(new Stage());
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });


        btn2 = new Button("Silver System");
        btn2.setTranslateX(260);
        btn2.setTranslateY(300);
        btn2.setPrefSize(270, 40);
        btn2.setTextFill(Color.WHITE);
        btn2.setFont(Font.font("Georgia", FontWeight.BOLD,20));
        btn2.setBackground(new Background(new BackgroundFill(Color.rgb(115, 100, 132), new CornerRadii(5), Insets.EMPTY)));
        btn2.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            btn2.setEffect(shadow);
        });
        btn2.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
            btn2.setEffect(null);
        });
        btn2.setOnAction((ActionEvent e) -> {
            Silver s = new Silver();
            try {
                s.start(new Stage());
            } catch (Exception exception) {
                exception.printStackTrace();
            }

        });



        btn3 = new Button("Ingot Analysis");
        btn3.setTranslateX(260);
        btn3.setTranslateY(350);
        btn3.setPrefSize(270, 40);
        btn3.setFont(Font.font("Georgia", FontWeight.BOLD,20));
        btn3.setTextFill(Color.WHITE);
        btn3.setBackground(new Background(new BackgroundFill(Color.rgb(115, 100, 132), new CornerRadii(5), Insets.EMPTY)));
        btn3.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            btn3.setEffect(shadow);
        });
        btn3.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
            btn3.setEffect(null);
        });
        btn3.setOnAction((ActionEvent e) -> {

            InogtFX i = new InogtFX();
            try {
                i.start(new Stage());
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        Button btn4 = new Button("EXIT");
        btn4.setTranslateX(260);
        btn4.setTranslateY(400);
        btn4.setPrefSize(270, 40);
        btn4.setFont(Font.font("Georgia", FontWeight.BOLD,20));
        btn4.setTextFill(Color.WHITE);
        btn4.setBackground(new Background(new BackgroundFill(Color.rgb(115, 100, 132), new CornerRadii(5), Insets.EMPTY)));
        btn4.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            btn4.setEffect(shadow);
        });
        btn4.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
            btn4.setEffect(null);
        });
        btn4.setOnAction((ActionEvent e) -> {
            s2.close();
        });



        paneB.getChildren().addAll(btn1, btn2, btn3,btn4);

        pane1.getChildren().addAll(text, text1, imageView, imageView1, paneB);

        Scene scene = new Scene(pane1, 800, 600);
        stage = new Stage();
        stage.setTitle("Jewelry Workshop");
        stage.setScene(scene);
        stage.show();
        s2 = stage;
    }

}

