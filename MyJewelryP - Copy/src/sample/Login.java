package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
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

public class Login extends Application implements EventHandler<ActionEvent> {


        String username = "Maryamalrubaye";
        String password = "Maryam20";
        String checkUser, checkPw;

        TextField textField;
        Button button;
        PasswordField passwordField;
        Label labelch;
        Stage s1;
@Override
public void start(Stage primaryStage) throws Exception {

        Pane paneL = new Pane();


        Label label1 = new Label("Username ");
        label1.setFont(Font.font("Georgia", 20));
        label1.setTextFill(Color.rgb(115, 100, 132));
        label1.setTranslateX(440);
        label1.setTranslateY(200);

        textField = new TextField();
        textField.setPrefWidth(200);
        textField.setFont(Font.font("Georgia", 15));
        textField.setTranslateX(440);
        textField.setTranslateY(230);

        Label label2 = new Label("Password ");
        label2.setFont(Font.font("Georgia", 20));
        label2.setTextFill(Color.rgb(115, 100, 132));
        label2.setTranslateX(440);
        label2.setTranslateY(290);

        labelch = new Label();
        labelch.setFont(Font.font("Georgia",20));
        labelch.setTextFill(Color.BLACK);
        labelch.setTranslateX(500);
        labelch.setTranslateY(480);

        passwordField = new PasswordField();
        passwordField.setPrefWidth(200);
        passwordField.setTranslateX(440);
        passwordField.setTranslateY(320);

        button = new Button("Login");
        button.setTranslateX(500);
        button.setTranslateY(400);
        button.setFont(Font.font("Georgia", 20));
        button.setTextFill(Color.rgb(230, 221, 237));
        button.setBackground(new Background(new BackgroundFill(Color.rgb(115, 100, 132), new CornerRadii(5), Insets.EMPTY)));
        button.setOnAction(this);

        paneL.getChildren().addAll(label1, textField, label2, passwordField, button,labelch);

        Image image = new Image(getClass().getResourceAsStream("/image/mylogo.png"));
        ImageView imageView  = new ImageView(image);
        imageView.setTranslateX(45);
        imageView.setTranslateY(180);

        Text text = new Text("Jewelry");
        text.setX(75);
        text.setY(290);
        text.setStyle(
        "-fx-font: 30px Georgia;"
        + "-fx-fill: linear-gradient(from 0% 0% to 100% 200%, repeat, Pink 0%, lavender 50%);"
        + "-fx-stroke-width: 1.5;"
        );
        Text text1 = new Text("Workshop");
        text1.setX(100);
        text1.setY(320);
        text1.setStyle(
        "-fx-font: 30px Georgia;"
        + "-fx-fill: linear-gradient(from 0% 0% to 100% 200%, repeat, Pink 0%, lavender 50%);"
        + "-fx-stroke-width: 1.5;"
        );

        Text text2 = new Text("Sign-in");
        text2.setX(370);
        text2.setY(130);
        text2.setStyle(
                "-fx-font: 40px Georgia;"
                        + "-fx-fill: linear-gradient(from 0% 0% to 100% 200%, repeat, black 0%, #746580 50%);"
                        + "-fx-stroke-width: 1.5;"
        );

        Pane pane = new Pane();
        pane.setStyle("-fx-background-color: #746580 ");
        pane.setPrefSize(330, 1000);
        pane.setTranslateX(0);
        pane.setTranslateY(0);
        pane.getChildren().addAll(imageView, text, text1);

        Pane pane1 = new Pane();
        pane1.setStyle("-fx-background-color:#e6dded ");
        pane1.setPrefSize(1200, 1000);
        pane1.setTranslateX(0);
        pane1.setTranslateY(0);
        pane1.getChildren().addAll(pane, paneL, text2);

        Scene scene = new Scene(pane1, 800, 600);
        Stage stage = new Stage();
        stage.setTitle("Jewelry Workshop");
        stage.setScene(scene);
        stage.show();
        s1=stage;


        }


public static void main(String[] args) {
        launch(args);
        }

@Override
public void handle(ActionEvent actionEvent) {
        checkUser = textField.getText().toString();
        checkPw = passwordField.getText().toString();
        if (checkUser.equals(username) && checkPw.equals(password)) {
                MainPage m = new MainPage();
                s1.close();
                try {
                        m.start(new Stage());
                } catch (Exception exception) {
                }

        } else if (checkUser.equals(username)) {
                passwordField.clear();
                labelch.setText("Wrong Password try again!");
                labelch.setTextFill(Color.BLACK);
                labelch.setTranslateX(450);
                labelch.setTranslateY(480);
        }
        else if (checkPw.equals(password)) {

                textField.clear();
                labelch.setText("Wrong Username try again!");
                labelch.setTextFill(Color.BLACK);
                labelch.setTranslateX(450);
                labelch.setTranslateY(480);





                }
        else {
                textField.clear();
                passwordField.clear();
                labelch.setText("Invalid Username and Password try again");
                labelch.setTextFill(Color.BLACK);
                labelch.setTranslateX(380);
                labelch.setTranslateY(480);


                }
        }
        }


