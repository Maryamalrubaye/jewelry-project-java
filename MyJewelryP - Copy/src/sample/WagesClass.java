package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class WagesClass extends Application {

   Stage sW;

    @Override
    public void start(Stage stage) throws Exception {

        Pane pane1 = new Pane();
        pane1.setStyle("-fx-background-color:#746580 ");
        pane1.setPrefSize(1200, 1000);
        pane1.setTranslateX(0);
        pane1.setTranslateY(0);

        Text text = new Text("{ Jewelry Manufacturing Wages }");
        text.setX(35);
        text.setY(45);
        text.setStyle(
                "-fx-font: 20px Georgia;"
                        + "-fx-fill: linear-gradient(from 0% 0% to 100% 200%, repeat, pink 0%, #e6dded 50%);"
                        + "-fx-stroke-width: 1.5;"
                        + "-fx-font-weight: bold;"
        );

        Text text1 = new Text();
        text1.setX(35);
        text1.setY(100);
        text1.setStyle(
                "-fx-font: 20px Georgia;"
                        + "-fx-fill: linear-gradient(from 0% 0% to 100% 200%, repeat, pink 0%, #e6dded 50%);"
                        + "-fx-stroke-width: 1.5;"
        );
        Wages handmade = Wages.Handmade;
        text1.setText(handmade+" : "+handmade.v);

        Text text2 = new Text();
        text2.setX(35);
        text2.setY(130);
        text2.setStyle(
                "-fx-font: 20px Georgia;"
                        + "-fx-fill: linear-gradient(from 0% 0% to 100% 200%, repeat, pink 0%, #e6dded 50%);"
                        + "-fx-stroke-width: 1.5;"
        );
        Wages laser = Wages.Laser;
        text2.setText(laser+" : "+laser.v);

        Text text3 = new Text();
        text3.setX(35);
        text3.setY(160);
        text3.setStyle(
                "-fx-font: 20px Georgia;"
                        + "-fx-fill: linear-gradient(from 0% 0% to 100% 200%, repeat, pink 0%, #e6dded 50%);"
                        + "-fx-stroke-width: 1.5;"
        );
        Wages special = Wages.Special;
        text3.setText(special+" : "+special.v);

        Text text4 = new Text();
        text4.setX(35);
        text4.setY(190);
        text4.setStyle(
                "-fx-font: 20px Georgia;"
                        + "-fx-fill: linear-gradient(from 0% 0% to 100% 200%, repeat, pink 0%, #e6dded 50%);"
                        + "-fx-stroke-width: 1.5;"
        );
        Wages polish = Wages.Polish;
        text4.setText(polish+" : "+polish.v);

        Text text5 = new Text();
        text5.setX(35);
        text5.setY(220);
        text5.setStyle(
                "-fx-font: 20px Georgia;"
                        + "-fx-fill: linear-gradient(from 0% 0% to 100% 200%, repeat, pink 0%, #e6dded 50%);"
                        + "-fx-stroke-width: 1.5;"
        );
        Wages prof = Wages.Professional;
        text5.setText(prof+" : "+prof.v);


        pane1.getChildren().addAll(text,text1,text2,text3,text4,text5);
        Scene scene = new Scene(pane1, 400, 350);
        stage = new Stage();
        stage.setTitle("Jewelry Workshop");
        stage.setScene(scene);
        stage.show();
        sW = stage;

    }


}



