package patterns.designpatterns.structural.adapter;

public class Main {
    public static void main(String[] args) {
        GemstoneColorIndicator indicator = new GemstoneColorIndicator();
        String color = indicator.determineTheColor(new MetalAdapter(new Gold()));
        System.out.println(color);
    }
}

class MetalAdapter implements Gemstone {

    private Metal metal;

    public MetalAdapter(Metal metal) {
        this.metal = metal;
    }

    @Override
    public String getColor() {
        return metal.getReflectionCoeff();
    }
}

interface Metal {
    String getReflectionCoeff();
}

class Gold implements Metal {
    @Override
    public String getReflectionCoeff() {
        return "0.27";
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

class GemstoneColorIndicator {
    public String determineTheColor(Gemstone gemstone) {
        return gemstone.getColor();
    }
}