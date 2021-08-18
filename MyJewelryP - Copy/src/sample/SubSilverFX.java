package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SubSilverFX extends Application {

    TableView<SubTable> table = new TableView<SubTable>();
    ObservableList<SubTable> sub = FXCollections.observableArrayList();
    HBox hBox = new HBox();
    static double resultSum = 0;
    ChoiceBox choiceBox =new ChoiceBox();

    public void start(Stage stage) {

        Text text = new Text("Subtraction For Silver");
        text.setStyle(
                "-fx-font: 30px Georgia;"
                        + "-fx-fill: linear-gradient(from 0% 0% to 100% 200%, repeat, Pink 0%, lavender 50%);"
                        + "-fx-stroke-width: 1.5;"
        );

        Image image1 = new Image(getClass().getResourceAsStream("/image/mylogomini.png"));
        ImageView imageView1 = new ImageView(image1);


        Image image2 = new Image(getClass().getResourceAsStream("/image/mylogomini.png"));
        ImageView imageView2 = new ImageView(image2);



        TableColumn fColumn = new TableColumn("In-Quantity");
        fColumn.setMinWidth(150);
        fColumn.setCellValueFactory(new PropertyValueFactory<SubTable, String>("fColumn"));


        TableColumn sColumn = new TableColumn("Out-Quantity");
        sColumn.setMinWidth(150);
        sColumn.setCellValueFactory(new PropertyValueFactory<SubTable, String>("sColumn"));


        TableColumn resultColumn = new TableColumn("Sub-Result");
        resultColumn.setMinWidth(300);
        resultColumn.setCellValueFactory(new PropertyValueFactory<SubTable, String>("resultColumn"));

        table.setEditable(true);
        table.setItems(sub);
        table.getColumns().addAll(fColumn, sColumn, resultColumn);

        Tooltip tooltip1 = new Tooltip("Enter input Quantity in grams");
        tooltip1.setGraphic( new ImageView(new Image(getClass().getResourceAsStream("/image/mylogomini.png"))));
        tooltip1.setStyle(
                "-fx-text-fill: white;"
                        + "-fx-background-color: Black;"
                        + "-fx-opacity: 0.8;"
                        + "-fx-font-size: 10px;"
        );
        Tooltip tooltip2 = new Tooltip("Enter output Quantity in grams");
        tooltip1.setGraphic( new ImageView(new Image(getClass().getResourceAsStream("/image/mylogomini.png"))));
        tooltip1.setStyle(
                "-fx-text-fill: white;"
                        + "-fx-background-color: Black;"
                        + "-fx-opacity: 0.8;"
                        + "-fx-font-size: 10px;"
        );

        TextField textField1 = new TextField();
        textField1.setPromptText("In-Quantity");
        textField1.setFont(Font.font("Georgia", 15));
        textField1.setBackground(new Background(new BackgroundFill(Color.rgb(230,221,237), new CornerRadii(5), Insets.EMPTY)));
        textField1.setTooltip(tooltip1);
        textField1.setMaxWidth(fColumn.getPrefWidth());

        TextField textField2 = new TextField();
        textField2.setPromptText("Out-Quantity");
        textField2.setFont(Font.font("Georgia", 15));
        textField2.setBackground(new Background(new BackgroundFill(Color.rgb(230,221,237), new CornerRadii(5), Insets.EMPTY)));
        textField2.setTooltip(tooltip2);
        textField2.setMaxWidth(sColumn.getPrefWidth());

        Button button = new Button("ADD");
        button.setFont(Font.font("Georgia", 15));
        button.setBackground(new Background(new BackgroundFill(Color.rgb(230,221,237), new CornerRadii(5), Insets.EMPTY)));
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String num1 = textField1.getText();
                String num2 = textField2.getText();
                if (correctInput(num1, num2)) {
                    String result = calSubtract(num1, num2);
                    SubTable row = new SubTable(num1, num2, result);
                    sub.add(row);
                    resultSum = resultSum + Double.parseDouble(result);
                }
                textField1.clear();
                textField2.clear();
            }
        });

        choiceBox.getItems().addAll("Save","Restart & Save");
        choiceBox.setBackground(new Background(new BackgroundFill(Color.rgb(230,221,237), new CornerRadii(5), Insets.EMPTY)));
        choiceBox.setMaxSize(200,20);
        choiceBox.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String choice = (String) choiceBox.getValue();
                CalculationForSilver s = new CalculationForSilver();
                s.subtraction(choice,resultSum);
            }
        });

        Label labelsumResult = new Label();
        labelsumResult.setFont(Font.font("Georgia", 20));
        labelsumResult.setBackground(new Background(new BackgroundFill(Color.rgb(230,221,237), new CornerRadii(5), Insets.EMPTY)));


        Label labeltotalResult = new Label();
        labeltotalResult.setFont(Font.font("Georgia", 20));
        labeltotalResult.setBackground(new Background(new BackgroundFill(Color.rgb(230,221,237), new CornerRadii(5), Insets.EMPTY)));


        Button btnSum = new Button("Sum-Result");
        btnSum.setPrefSize(200,20);
        btnSum.setFont(Font.font("Georgia", 15));
        btnSum.setBackground(new Background(new BackgroundFill(Color.rgb(230,221,237), new CornerRadii(5), Insets.EMPTY)));

        btnSum.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                labelsumResult.setText((String.valueOf(resultSum)));
            }
        });

        Button btnTotal = new Button("Total Quantity Defiance");
        btnTotal.setPrefSize(200,20);
        btnTotal.setFont(Font.font("Georgia", 15));
        btnTotal.setBackground(new Background(new BackgroundFill(Color.rgb(230,221,237), new CornerRadii(5), Insets.EMPTY)));

        btnTotal.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                CalculationForSilver silver = new CalculationForSilver();
                String s = silver.total();
                labeltotalResult.setText(s);
            }
        });

        Button btnExit = new Button("EXIT");
        btnExit.setPrefSize(200,20);
        btnExit.setFont(Font.font("Georgia", 15));
        btnExit.setBackground(new Background(new BackgroundFill(Color.rgb(230,221,237), new CornerRadii(5), Insets.EMPTY)));
        btnExit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.close();
                Silver silver = new Silver();
                try {
                    silver.start(new Stage());
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });


        hBox.getChildren().addAll(textField1, textField2, button);
        hBox.setSpacing(4);
        hBox.setAlignment(Pos.CENTER);

        HBox hBox1 = new HBox(4);
        hBox1.getChildren().addAll(btnSum,labelsumResult);
        hBox1.setAlignment(Pos.CENTER);

        HBox hBox2 = new HBox(4);
        hBox2.getChildren().addAll(btnTotal,labeltotalResult);
        hBox2.setAlignment(Pos.CENTER);

        HBox hBox3 = new HBox(125);
        hBox3.getChildren().addAll(imageView1,text,imageView2);
        hBox3.setAlignment(Pos.CENTER);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(hBox3,table, hBox,choiceBox,hBox1,hBox2,btnExit);
        table.setStyle("-fx-background-color: #e6dded ");
        fColumn.setStyle("-fx-background-color: #e6dded ");
        sColumn.setStyle("-fx-background-color: #e6dded ");
        resultColumn.setStyle("-fx-background-color: #e6dded ");
        vBox.setStyle("-fx-background-color: #746580 ");
        vBox.setPrefSize(600,600);
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(10);

        Pane pane1 = new Pane();
        pane1.setStyle("-fx-background-color: #746580 ");
        pane1.setPrefSize(1600, 1400);
        pane1.setTranslateX(0);
        pane1.setTranslateY(0);
        pane1.getChildren().add(vBox);

        Group root = new Group();
        Scene scene = new Scene(root,600,600);
        stage.setTitle("Subtraction Table");
        root.getChildren().addAll(pane1);
        stage.setScene(scene);
        stage.show();
    }


    private boolean correctInput(String first, String second) {
        try {
            double num1 = Double.valueOf(first);
            double num2 = Double.valueOf(second);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    private String calSubtract(String first, String second) {
        double num1 = Double.valueOf(first);
        double num2 = Double.valueOf(second);
        return Double.toString(num1 - num2);
    }
}