package designpatterns.creational.factory;

public class Main {
    public static void main(String[] args) {
        Factory gemstoneFactory = new Factory();
        Gemstone emerald = gemstoneFactory.getGemstoneByName("emerald");
        Gemstone turqouise = gemstoneFactory.getGemstoneByName("turquoise");
    }
}

class Factory {
    Gemstone getGemstoneByName(String name) {
        if (name.equalsIgnoreCase("Emerald")) {
            return new Emerald();
        } else if (name.equalsIgnoreCase("Turquoise")) {
            return new Turquoise();
        } else {
            throw new RuntimeException("There is no such gemstone as " + name);
        }
    }
}

interface Gemstone {
}

class Emerald implements Gemstone {
}

class Turquoise implements Gemstone {
}

