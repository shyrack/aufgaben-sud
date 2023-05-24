package sud.aufgaben.util.sql;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import sud.aufgaben.util.HelperFunctions;

public class QueryGenerator {

    private final List<String> tables;

    public QueryGenerator(Class<?> clazz) {
        this.tables = new ArrayList<>();
    }

    public String generateTableCreateQuery(Class<?> clazz) {
        String simpleName = clazz.getSimpleName();
        Field[] fields = clazz.getDeclaredFields();
        List<Column> columns = HelperFunctions.map(fields, (field) -> {
            String fieldName = field.getName();
            Class<?> type = field.getType();
            return this.convertJavaToSQL_Type(fieldName, type);
        });
        Column[] columnArr = new Column[columns.size()];

        columns.toArray(columnArr);

        Table table = new Table(simpleName, columnArr);

        return table.generateCreateTableQuery();
    }

    private Column convertJavaToSQL_Type(String fieldName, Class<?> type) {
        String sqlType;

        if (type == byte.class || type == Byte.class) {
            sqlType = "TINYINT";
        } else if (type == short.class || type == Short.class) {
            sqlType = "SMALLINT";
        } else if (type == int.class || type == Integer.class) {
            sqlType = "INT";
        } else if (type == long.class || type == Long.class) {
            sqlType = "BIGINT";
        } else if (type == float.class || type == Float.class) {
            sqlType = "FLOAT";
        } else if (type == double.class || type == Double.class) {
            sqlType = "DOUBLE";
        } else if (type == boolean.class || type == Boolean.class) {
            sqlType = "BOOLEAN";
        } else if (type == char.class || type == Character.class) {
            sqlType = "CHAR";
        } else if (type == String.class) {
            sqlType = "VARCHAR(255)";
        } else {
            if (!this.tables.containsKey(fieldName))
                this.generateTableCreateQuery(type);
            return new Column(fieldName, "VARCHAR(255)");
        }

        return new Column(fieldName, sqlType);
    }

    public static void main(String[] args) {
        QueryGenerator generator = new QueryGenerator();
        String createTableQuery = generator.generateTableCreateQuery(Test.class);
        System.out.println(createTableQuery);
    }

}
