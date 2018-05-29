package designpatterns.structural.bridge;

public class Main {
    public static void main(String[] args) {
        BridgeForm emeraldRing = new Ring(new Emerald());
        System.out.println(emeraldRing.getFormAndColor());
    }
}

interface Gemstone {
    String getColor();
}

class Emerald implements Gemstone {
    @Override
    public String getColor() {
        return "#50C878";
    }
}

abstract class BridgeForm {
    protected Gemstone gemstone;

    public BridgeForm(Gemstone gemstone) {
        this.gemstone = gemstone;
    }

    abstract String getFormAndColor();
}

class Ring extends BridgeForm {

    public Ring(Gemstone gemstone) {
        super(gemstone);
    }

    @Override
    public String getFormAndColor() {
        return "Ring with color " + gemstone.getColor();
    }
}


