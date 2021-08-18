package sample;

import com.itextpdf.text.DocumentException;
import javafx.application.Application;
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

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import static javafx.collections.FXCollections.observableArrayList;

public class InvoiceFX extends Application {

    TableView<InvoiceTable> table = new TableView<>();
    ObservableList<InvoiceTable> invoiceTables = observableArrayList();
    HBox hBox = new HBox();
    static double resultSum = 0;
    String filename = "Invoice.txt";


    public void start(Stage stage) {


        Text text = new Text("Invoice Info");
        text.setStyle(
                "-fx-font: 30px Georgia;"
                        + "-fx-fill: linear-gradient(from 0% 0% to 100% 200%, repeat, Pink 0%, lavender 50%);"
                        + "-fx-stroke-width: 1.5;"
        );

        Image image1 = new Image(getClass().getResourceAsStream("/image/mylogomini.png"));
        ImageView imageView1 = new ImageView(image1);


        Image image2 = new Image(getClass().getResourceAsStream("/image/mylogomini.png"));
        ImageView imageView2 = new ImageView(image2);

        TextField fname = new TextField();
        fname.setPromptText("Name&Surname");
        fname.setFont(Font.font("Georgia", 15));
        fname.setBackground(new Background(new BackgroundFill(Color.rgb(230, 221, 237), new CornerRadii(5), Insets.EMPTY)));
        fname.setMaxWidth(200);
        fname.setFocusTraversable(false);

        TextField company = new TextField();
        company.setPromptText("Company name");
        company.setFont(Font.font("Georgia", 15));
        company.setBackground(new Background(new BackgroundFill(Color.rgb(230, 221, 237), new CornerRadii(5), Insets.EMPTY)));
        company.setMaxWidth(200);
        company.setFocusTraversable(false);

        TextField phone = new TextField();
        phone.setPromptText("Phone Number");
        phone.setFont(Font.font("Georgia", 15));
        phone.setBackground(new Background(new BackgroundFill(Color.rgb(230, 221, 237), new CornerRadii(5), Insets.EMPTY)));
        phone.setMaxWidth(200);
        phone.setFocusTraversable(false);

        TextField email = new TextField();
        email.setPromptText("E-Mail");
        email.setFont(Font.font("Georgia", 15));
        email.setBackground(new Background(new BackgroundFill(Color.rgb(230, 221, 237), new CornerRadii(5), Insets.EMPTY)));
        email.setMaxWidth(250);
        email.setFocusTraversable(false);


        TableColumn type = new TableColumn("Jewelry Type");
        type.setMinWidth(150);
        type.setCellValueFactory(new PropertyValueFactory<SubTable, String>("type"));


        TableColumn grams = new TableColumn("Grams");
        grams.setMinWidth(150);
        grams.setCellValueFactory(new PropertyValueFactory<SubTable, String>("grams"));


        TableColumn price = new TableColumn("Price");
        price.setMinWidth(300);
        price.setCellValueFactory(new PropertyValueFactory<SubTable, String>("price"));

        table.setEditable(true);
        table.setItems(invoiceTables);
        table.getColumns().addAll(type, grams, price);

        Tooltip tooltip1 = new Tooltip("Enter the jewelry type");
        tooltip1.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/image/mylogomini.png"))));
        tooltip1.setStyle(
                "-fx-text-fill: white;"
                        + "-fx-background-color: Black;"
                        + "-fx-opacity: 0.8;"
                        + "-fx-font-size: 10px;"
        );
        Tooltip tooltip2 = new Tooltip("Enter amount of grams");
        tooltip2.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/image/mylogomini.png"))));
        tooltip2.setStyle(
                "-fx-text-fill: white;"
                        + "-fx-background-color: Black;"
                        + "-fx-opacity: 0.8;"
                        + "-fx-font-size: 10px;"
        );

        Tooltip tooltip3 = new Tooltip("Enter price in $");
        tooltip3.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/image/mylogomini.png"))));
        tooltip3.setStyle(
                "-fx-text-fill: white;"
                        + "-fx-background-color: Black;"
                        + "-fx-opacity: 0.8;"
                        + "-fx-font-size: 10px;"
        );

        TextField textField1 = new TextField();
        textField1.setPromptText("type");
        textField1.setFont(Font.font("Georgia", 15));
        textField1.setBackground(new Background(new BackgroundFill(Color.rgb(230, 221, 237), new CornerRadii(5), Insets.EMPTY)));
        textField1.setTooltip(tooltip1);
        textField1.setMaxWidth(type.getPrefWidth());

        TextField textField2 = new TextField();
        textField2.setPromptText("Grams");
        textField2.setFont(Font.font("Georgia", 15));
        textField2.setBackground(new Background(new BackgroundFill(Color.rgb(230, 221, 237), new CornerRadii(5), Insets.EMPTY)));
        textField2.setTooltip(tooltip2);
        textField2.setMaxWidth(grams.getPrefWidth());

        TextField textField3 = new TextField();
        textField3.setPromptText("Price");
        textField3.setFont(Font.font("Georgia", 15));
        textField3.setBackground(new Background(new BackgroundFill(Color.rgb(230, 221, 237), new CornerRadii(5), Insets.EMPTY)));
        textField3.setTooltip(tooltip3);
        textField3.setMaxWidth(grams.getPrefWidth());

        Button button = new Button("ADD");
        button.setFont(Font.font("Georgia", 15));
        button.setBackground(new Background(new BackgroundFill(Color.rgb(230, 221, 237), new CornerRadii(5), Insets.EMPTY)));
        button.setMaxWidth(price.getPrefWidth());
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String type = textField1.getText();
                String grams = textField2.getText();
                String price = textField3.getText();
                if (correctInput(type,grams,price)) {
                    InvoiceTable row = new InvoiceTable(type, grams, price);
                    invoiceTables.add(row);
                    resultSum = resultSum + Double.parseDouble(price);
                    textField1.clear();
                    textField2.clear();
                    textField3.clear();
                    FileTable t = new FileTable();
                    t.getWriter(type,grams,price);
                } }       });

        ToggleButton btnSave = new ToggleButton("Save");
        btnSave.setFont(Font.font("Georgia", 15));
        btnSave.setBackground(new Background(new BackgroundFill(Color.rgb(230, 221, 237), new CornerRadii(5), Insets.EMPTY)));
        btnSave.setMaxWidth(200);
        btnSave.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String name = fname.getText();
                String comp = company.getText();
                String num = phone.getText();
                String mail = email.getText();
                if(btnSave.isSelected())
                    btnSave.setText("Saved");

                else
                    btnSave.setText("Save");
                try {
                    BufferedWriter writer1= new BufferedWriter(new FileWriter("table.txt",false));
                    BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
                    writer.write("Name and Surname : "+name);
                    writer.newLine();
                    writer.write("Company Name : "+comp);
                    writer.newLine();
                    writer.write("Phone Number : "+num);
                    writer.newLine();
                    writer.write("E-Mail Address : "+mail);
                    writer.close();

                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });

        TextField invoice = new TextField();
        invoice.setPromptText("Invoice Name");
        invoice.setFont(Font.font("Georgia", 15));
        invoice.setBackground(new Background(new BackgroundFill(Color.rgb(230, 221, 237), new CornerRadii(5), Insets.EMPTY)));
        invoice.setMaxWidth(200);
        invoice.setFocusTraversable(false);

        ToggleButton btnName = new ToggleButton("Set Invoice Name");
        btnName.setFont(Font.font("Georgia", 15));
        btnName.setBackground(new Background(new BackgroundFill(Color.rgb(230, 221, 237), new CornerRadii(5), Insets.EMPTY)));
        btnName.setMaxWidth(200);
        btnName.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(btnName.isSelected())
                    btnName.setText("Name Was Created");

                else
                    btnName.setText("Create Name");
                String s = invoice.getText();
                String s1 = String.valueOf(resultSum);
                PrintInvoice p = new PrintInvoice();
                try {
                    p.print(s,s1);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (DocumentException e) {
                    e.printStackTrace();
                }
            }
        });
        Label labelsumResult = new Label();
        labelsumResult.setFont(Font.font("Georgia", 20));
        labelsumResult.setBackground(new Background(new BackgroundFill(Color.rgb(230, 221, 237), new CornerRadii(5), Insets.EMPTY)));


        Button btnSum = new Button("Sum-Result");
        btnSum.setPrefSize(200, 20);
        btnSum.setFont(Font.font("Georgia", 15));
        btnSum.setBackground(new Background(new BackgroundFill(Color.rgb(230, 221, 237), new CornerRadii(5), Insets.EMPTY)));
        btnSum.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                labelsumResult.setText(String.valueOf(resultSum));
            }
        });

        Button btnclose = new Button("Exit");
        btnclose.setPrefSize(200, 20);
        btnclose.setFont(Font.font("Georgia", 15));
        btnclose.setBackground(new Background(new BackgroundFill(Color.rgb(230, 221, 237), new CornerRadii(5), Insets.EMPTY)));
        btnclose.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
               stage.close();
            }
        });



        hBox.getChildren().addAll(textField1, textField2,textField3, button);
        hBox.setSpacing(4);
        hBox.setAlignment(Pos.CENTER);

        HBox hBox1 = new HBox(4);
        hBox1.getChildren().addAll(btnSum, labelsumResult);
        hBox1.setAlignment(Pos.CENTER);

        HBox hBox2 = new HBox(4);
        hBox2.getChildren().addAll(fname,company,phone);


        HBox hBox3 = new HBox(125);
        hBox3.getChildren().addAll(imageView1, text, imageView2);
        hBox3.setAlignment(Pos.CENTER);

        HBox hBox4 = new HBox(4);
        hBox4.getChildren().addAll(invoice,btnName);
        hBox4.setAlignment(Pos.CENTER);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(hBox3,hBox2,email,btnSave, table, hBox,hBox4,  hBox1,btnclose);
        table.setStyle("-fx-background-color: #e6dded ");
        type.setStyle("-fx-background-color: #e6dded ");
        grams.setStyle("-fx-background-color: #e6dded ");
        price.setStyle("-fx-background-color: #e6dded ");
        vBox.setStyle("-fx-background-color: #746580 ");
        vBox.setPrefSize(600, 600);
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(10);

        Pane pane1 = new Pane();
        pane1.setStyle("-fx-background-color: #746580 ");
        pane1.setPrefSize(1600, 1400);
        pane1.setTranslateX(0);
        pane1.setTranslateY(0);
        pane1.getChildren().add(vBox);

        Group root = new Group();
        Scene scene = new Scene(root, 600, 600);
        stage.setTitle("Invoice");
        root.getChildren().addAll(pane1);
        stage.setScene(scene);
        stage.show();
    }

    private boolean correctInput(String first, String second ,String third) {
        try {
            String s = String.valueOf(first);
            double num1 = Double.valueOf(second);
            double num2 = Double.valueOf(third);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
