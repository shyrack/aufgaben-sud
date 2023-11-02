package util.sql;

public class Cell {

    private String columnName;
    private Object value;

    public Cell(String columnName, Object value) {
        this.columnName = columnName;
        this.value = value;
    }

    public String getColumnName() {
        return this.columnName;
    }

    public Object getValue() {
        return this.value;
    }

}
