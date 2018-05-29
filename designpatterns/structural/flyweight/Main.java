package designpatterns.structural.flyweight;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Gemstone gemstone = FlyweightGemstoneFactory.getGemstoneByColor(Color.GREEN);
        Gemstone emerald = FlyweightGemstoneFactory.getGemstoneByColor(Color.GREEN);
        System.out.println(gemstone == emerald);
    }
}

class Gemstone {
    private Color color;
    private String name;

    public Gemstone() {
    }

    public Gemstone(Color color, String name) {
        this.color = color;
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class FlyweightGemstoneFactory {
    private static Map<Color, Gemstone> gemstones;

    static {
        gemstones = new HashMap<>();
        gemstones.put(Color.RED, new Gemstone(Color.RED, "Ruby"));
        gemstones.put(Color.BLUE, new Gemstone(Color.BLUE, "Sapphire"));
    }

    public static Gemstone getGemstoneByColor(Color color) {
        Gemstone gemstone = gemstones.get(color);
        if (gemstone == null) {
            gemstones.put(color, new Gemstone(color, ""));
            return gemstones.get(color);
        }
        return gemstone;
    }

    // the same method using lambda expressions
    public static Gemstone getGemstoneByColorLambda(Color color) {
        return gemstones.computeIfAbsent(color, newColor -> new Gemstone(newColor, ""));
    }
}
