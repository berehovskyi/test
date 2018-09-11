package patterns.designpatterns.behavioral.iterator;

public class Main {
    public static void main(String[] args) {

    }
}

enum Gemstones {
    EMERALD, TURQUOISE, RUBY, AMETHYST;
}

interface Iterator {
    boolean hasNext();
    Object next();
}

interface Container {
    Iterator getIterator();
}

class Gemstone implements Container {
    private Gemstones TYPES;

    public Gemstone(Gemstones TYPES) {
        this.TYPES = TYPES;
    }

    public Gemstones getTYPES() {
        return TYPES;
    }

    public void setTYPES(Gemstones TYPES) {
        this.TYPES = TYPES;
    }

    @Override
    public Iterator getIterator() {
        return null;
    }

    private class GemstoneIterator implements Iterator {
        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Object next() {
            return null;
        }
    }
}