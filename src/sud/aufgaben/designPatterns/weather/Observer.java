package sud.aufgaben.designPatterns.weather;

public interface Observer<T> {
    void update(T data);
}
