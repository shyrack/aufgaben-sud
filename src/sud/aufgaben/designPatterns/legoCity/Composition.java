package designPatterns.legoCity;

import java.util.ArrayList;
import java.util.List;

public class Composition extends Part {
    private List<Part> parts;

    public Composition() {
        this.parts = new ArrayList<>();
    }

    public void addPart(Part part) {
        this.parts.add(part);
    }

    @Override
    public double getPrice() {
        return this.parts.stream().mapToDouble(part -> part.getPrice()).sum();
    }

    public void removePart(Part part) {
        this.parts.remove(part);
    }
}
