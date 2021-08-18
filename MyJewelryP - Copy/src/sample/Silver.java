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

public class Silver extends Application {

    Button btn1, btn2, btn3;
Stage silver;
    @Override
    public void start(Stage stage) throws Exception {

        Pane pane1 = new Pane();
        pane1.setStyle("-fx-background-color: #746580 ");
        pane1.setPrefSize(1200, 1000);
        pane1.setTranslateX(0);
        pane1.setTranslateY(0);


        Text text = new Text("SILVER SYSTEM ");
        text.setX(250);
        text.setY(90);
        text.setStyle(
                "-fx-font: 35px Georgia;"
                        + "-fx-fill: linear-gradient(from 0% 0% to 100% 200%, repeat, pink 0%, #e6dded 50%);"
                        + "-fx-stroke-width: 1.5;"
                        + "-fx-font-weight: bold;"
        );

        Image image1 = new Image(getClass().getResourceAsStream("/image/gold.png"));
        ImageView imageView1 = new ImageView(image1);
        imageView1.setTranslateX(700);
        imageView1.setTranslateY(270);

        Image image = new Image(getClass().getResourceAsStream("/image/gold.png"));
        ImageView imageView = new ImageView(image);
        imageView.setTranslateX(45);
        imageView.setTranslateY(270);

        Pane paneB = new Pane();

        DropShadow shadow = new DropShadow(20, Color.BLACK);

        btn1 = new Button("Quantity Difference");
        btn1.setTranslateX(260);
        btn1.setTranslateY(250);
        btn1.setPrefSize(300, 40);
        btn1.setTextFill(Color.rgb(115, 100, 132));
        btn1.setFont(Font.font("Georgia", FontWeight.BOLD,20));
        btn1.setBackground(new Background(new BackgroundFill(Color.rgb(230,221,237), new CornerRadii(5), Insets.EMPTY)));
        btn1.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            btn1.setEffect(shadow);
        });
        btn1.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
            btn1.setEffect(null);
        });
        btn1.setOnAction((ActionEvent m) -> {
            SubSilverFX silverFX = new SubSilverFX();
            silver.close();
            try {
                silverFX.start(new Stage());
            } catch (Exception exception) {
                exception.printStackTrace();
            }

        });



        btn2 = new Button("Convert Grams to Dollars");
        btn2.setTranslateX(260);
        btn2.setTranslateY(300);
        btn2.setPrefSize(300, 40);
        btn2.setTextFill(Color.rgb(115, 100, 132));
        btn2.setFont(Font.font("Georgia", FontWeight.BOLD,20));
        btn2.setBackground(new Background(new BackgroundFill(Color.rgb(230,221,237), new CornerRadii(5), Insets.EMPTY)));
        btn2.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            btn2.setEffect(shadow);
        });
        btn2.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
            btn2.setEffect(null);
        });
        btn2.setOnAction((ActionEvent m) -> {
            DollarSFX d = new DollarSFX();
            silver.close();
            try {
                d.start(new Stage());
            } catch (Exception exception) {
                exception.printStackTrace();
            }

        });



        btn3 = new Button("Create Invoice");
        btn3.setTranslateX(260);
        btn3.setTranslateY(350);
        btn3.setPrefSize(300, 40);
        btn3.setFont(Font.font("Georgia", FontWeight.BOLD,20));
        btn3.setTextFill(Color.rgb(115, 100, 132));
        btn3.setBackground(new Background(new BackgroundFill(Color.rgb(230,221,237), new CornerRadii(5), Insets.EMPTY)));
        btn3.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            btn3.setEffect(shadow);
        });
        btn3.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
            btn3.setEffect(null);
        });
        btn3.setOnAction((ActionEvent e) -> {
            silver.close();
            InvoiceFX invoiceFX = new InvoiceFX();
            invoiceFX.start(new Stage());
        });


        paneB.getChildren().addAll(btn1, btn2, btn3);

        pane1.getChildren().addAll(text, imageView, imageView1, paneB);

        Scene scene = new Scene(pane1, 800, 600);
        stage = new Stage();
        stage.setTitle("Jewelry Workshop");
        stage.setScene(scene);
        stage.show();
        silver=stage;
    }
}
