package patterns.designpatterns.structural.proxy;

public class Main {
    public static void main(String[] args) {
        Gemstone proxyGemstone = new ProxyGemstone(new Emerald());
        String color = proxyGemstone.getColor();
        System.out.println(color);
    }
}

class ProxyGemstone implements Gemstone {
    private Gemstone gemstone;

    ProxyGemstone(Gemstone gemstone) {
        this.gemstone = gemstone;
    }

    @Override
    public String getColor() {
        System.out.println("Doing additional logic there !!!");
        return gemstone.getColor();
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