package patterns.designpatterns.creational.abstractFactory;

public class Main {
    public static void main(String[] args) {
        AbstractFactory abstractFactory = new AbstractFactory();
        Factory gemstoneFactory = abstractFactory.getFactoryByType("Gemstone Factory");
        Factory metalFactory = abstractFactory.getFactoryByType("Metal Factory");
        Gemstone emerald = (Gemstone) gemstoneFactory.getByType("Emerald");
        Metal gold = (Metal) metalFactory.getByType("Gold");
    }
}

class AbstractFactory {
    Factory getFactoryByType(String type) {
        if (type.equalsIgnoreCase("Gemstone Factory")) {
            return new GemstoneFactory();
        } else if (type.equalsIgnoreCase("Metal Factory")) {
            return new MetalFactory();
        } else {
            return null;
        }
    }
}

interface Factory<T> {
    T getByType(String name);
}

class GemstoneFactory implements Factory {
    @Override
    public Gemstone getByType(String type) {
        if (type.equalsIgnoreCase("Emerald")) {
            return new Emerald();
        } else if (type.equalsIgnoreCase("Turquoise")) {
            return new Turquoise();
        } else {
            return null;
        }
    }
}

class MetalFactory implements Factory {
    @Override
    public Metal getByType(String type) {
        if (type.equalsIgnoreCase("Gold")) {
            return new Gold();
        } else if (type.equalsIgnoreCase("Platinum")) {
            return new Platinum();
        } else {
            return null;
        }
    }
}

interface Gemstone {
}

interface Metal {
}

class Emerald implements Gemstone {
}

class Turquoise implements Gemstone {
}

class Gold implements Metal {
}

class Platinum implements Metal {
}