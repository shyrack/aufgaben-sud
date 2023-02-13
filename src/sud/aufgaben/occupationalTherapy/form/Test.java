package sud.aufgaben.occupationalTherapy.form;

public class Test {

    public static void main(String[] args) {
        Polygon polygon = new Polygon(5, 5);
        Rectangle rectangle = new Rectangle(1, 1);
        Triangle triangle = new Triangle(1, 1, 1);
        Circle circle = new Circle(5);

        Form[] forms = {polygon, rectangle, triangle, circle};
        for (Form form : forms) {
            System.out.println("-----" + form.getClass().getName() + "-----");
            System.out.println("Fläche: " + form.area());
            System.out.println("Umfang: " + form.circumference());
        }
    }

}
