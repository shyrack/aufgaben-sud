package sud.aufgaben.occupationalTherapy.form;

import java.io.IOException;

import sud.aufgaben.occupationalTherapy.CsvWriter;

public class Test {

    public static void main(String[] args) throws IOException {
        Polygon polygon = new Polygon(10, 5);
        Rectangle rectangle = new Rectangle(1, 1);
        Triangle triangle = new Triangle(1, 1, 1);
        Circle circle = new Circle(5);

        Form[] forms = {polygon, rectangle, triangle, circle};
        CsvWriter<Form> csvWriter = new CsvWriter<Form>("forms.csv");
        for (Form form : forms) {
            System.out.println("-----" + form.getClass().getName() + "-----");
            System.out.println("Fläche: " + form.area());
            System.out.println("Umfang: " + form.circumference());
            csvWriter.write(form);
        }
        csvWriter.close();
    }

}
