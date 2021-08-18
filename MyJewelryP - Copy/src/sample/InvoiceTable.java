package sample;

import javafx.beans.property.SimpleStringProperty;

public class InvoiceTable {
    private final SimpleStringProperty type;
    private final SimpleStringProperty grams;
    private final SimpleStringProperty price;


    public InvoiceTable(String type, String grams, String price) {
        this.type = new SimpleStringProperty(type);
        this.grams = new SimpleStringProperty(grams);
        this.price = new SimpleStringProperty(price);
    }

    public String getType() {
        return type.get();
    }

    public SimpleStringProperty typeProperty() {
        return type;
    }

    public void setType(String type) {
        this.type.set(type);
    }

    public String getGrams() {
        return grams.get();
    }

    public SimpleStringProperty gramsProperty() {
        return grams;
    }

    public void setGrams(String grams) {
        this.grams.set(grams);
    }

    public String getPrice() {
        return price.get();
    }

    public SimpleStringProperty priceProperty() {
        return price;
    }

    public void setPrice(String price) {
        this.price.set(price);
    }
}
