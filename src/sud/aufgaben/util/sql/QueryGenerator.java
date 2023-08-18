package sud.aufgaben.util.sql;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import sud.aufgaben.util.HelperFunctions;

public class QueryGenerator<T> {

    private final Class<T> clazz;
    private final List<String> createdTables;

    public QueryGenerator(Class<T> clazz) {
        this.clazz = clazz;
        this.createdTables = new ArrayList<>();
    }

    public List<String> generateTableInsertQueries(T object) {
        String tableName = this.clazz.getSimpleName();
        Field[] fields = object.getClass().getFields();
        List<Cell> cells = HelperFunctions.map(fields, (field) -> {
            String fieldName = field.getName();
            try {
                Object value = field.get(object);
                return new Cell(fieldName, value);
            } catch (IllegalAccessException | IllegalArgumentException e) {
                e.printStackTrace();
                return null;
            }
        });
        

        return new ArrayList<>();
    }

    public List<String> generateTableCreateQueries() {
        return this.generateTableCreateQueries(this.clazz, new ArrayList<>());
    }

    public void reset() {
        this.createdTables.clear();
    }

    private List<String> generateTableCreateQueries(Class<?> clazz, List<String> tableQueries) {
        String simpleName = clazz.getSimpleName();
        Field[] fields = clazz.getDeclaredFields();

        createdTables.add(clazz.getName());

        List<Column> columns = HelperFunctions.map(fields, (field) -> {
            String fieldName = field.getName();
            Class<?> type = field.getType();
            return this.convertJavaToSQL_Type(fieldName, type, tableQueries);
        });
        Column[] columnArr = new Column[columns.size()];

        columns.toArray(columnArr);

        Table table = new Table(simpleName, columnArr);
        tableQueries.add(table.generateCreateTableQuery());

        return tableQueries;
    }

    private Column convertJavaToSQL_Type(String fieldName, Class<?> type, List<String> tableQueries) {
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
            if (!this.createdTables.contains(type.getName()))
                this.generateTableCreateQueries(type, tableQueries);
            return new Column(fieldName, "VARCHAR(255)");
        }

        return new Column(fieldName, sqlType);
    }

    public static void main(String[] args) {
        QueryGenerator<Test> generator = new QueryGenerator<>(Test.class);
        generator.generateTableCreateQueries().forEach(query -> System.out.println(query));
    }

}
