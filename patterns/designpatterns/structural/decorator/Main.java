package patterns.designpatterns.structural.decorator;

public class Main {
    public static void main(String[] args) {
        Jewellery emeraldWithGold = new GoldenInclusion(new Emerald());
        Jewellery emeraldWithGoldAndPlatinum = new PlatinumInclusions(new GoldenInclusion(new Emerald()));
        Jewellery turquoiseWithPlatinum = new PlatinumInclusions(new Turquoise());
        System.out.println(emeraldWithGold.getJewelleryName());
        System.out.println(emeraldWithGoldAndPlatinum.getJewelleryName());
        System.out.println(turquoiseWithPlatinum.getJewelleryName());
    }
}

interface Jewellery {
    String getJewelleryName();
}

class Emerald implements Jewellery {
    @Override
    public String getJewelleryName() {
        return "Emerald";
    }
}

class Turquoise implements Jewellery {
    @Override
    public String getJewelleryName() {
        return "Turquoise";
    }
}

abstract class DecoratorJewellery implements Jewellery {
    private Jewellery gemstone;

    public DecoratorJewellery(Jewellery gemstone) {
        this.gemstone = gemstone;
    }

    @Override
    public String getJewelleryName() {
        return gemstone.getJewelleryName();
    }
}

class GoldenInclusion extends DecoratorJewellery {
    public GoldenInclusion(Jewellery gemstone) {
        super(gemstone);
    }

    public String getMetal() {
        return "Gold";
    }

    @Override
    public String getJewelleryName() {
        return super.getJewelleryName() + " with " + getMetal() + " inclusions";
    }
}

class PlatinumInclusions extends DecoratorJewellery {

    public PlatinumInclusions(Jewellery gemstone) {
        super(gemstone);
    }

    public String getMetal() {
        return "Platinum";
    }

    @Override
    public String getJewelleryName() {
        return super.getJewelleryName() + " with " + getMetal() + " inclusions";
    }
}
