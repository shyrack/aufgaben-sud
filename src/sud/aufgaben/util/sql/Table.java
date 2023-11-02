package util.sql;

import java.util.List;

import util.HelperFunctions;

public class Table {

    private String name;
    private Column[] columns;

    public Table(String name, Column[] columns) {
        this.name = name;
        this.columns = columns;
    }

    public String generateCreateTableQuery() {
        StringBuilder builder = new StringBuilder();
        builder.append("CREATE TABLE ");
        builder.append(name);
        builder.append(" ");
        builder.append("(");
        List<String> columnStrings = HelperFunctions.map(columns,
                (column) -> column.getName() + " " + column.getType());
        String[] columnStringArr = new String[columnStrings.size()];
        columnStrings.toArray(columnStringArr);
        builder.append(HelperFunctions.join((String[]) columnStringArr, ", "));
        builder.append(");");
        return builder.toString();
    }

}
