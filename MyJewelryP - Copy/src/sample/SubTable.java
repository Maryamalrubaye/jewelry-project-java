package sample;

import javafx.beans.property.SimpleStringProperty;

public class SubTable {
    private final SimpleStringProperty fColumn;
    private final SimpleStringProperty sColumn;
    private final SimpleStringProperty resultColumn;


    SubTable(String fColumn, String sColumn, String resultColumn) {
        this.fColumn = new SimpleStringProperty(fColumn);
        this.sColumn = new SimpleStringProperty(sColumn);
        this.resultColumn = new SimpleStringProperty(resultColumn);
    }


    public String getFColumn() {
        return fColumn.get();
    }

    public void setFColumn(String fColumn) {
        this.fColumn.set(fColumn);
    }

    public String getSColumn() {
        return sColumn.get();
    }

    public void setSColumn(String sColumn) {
        this.sColumn.set(sColumn);
    }

    public String getResultColumn() {
        return resultColumn.get();
    }

    public void setResultColumn(String resultColumn) {
        this.resultColumn.set(resultColumn);
    }
}
