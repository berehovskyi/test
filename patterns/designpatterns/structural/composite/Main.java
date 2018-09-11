package patterns.designpatterns.structural.composite;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CompositeJewellery compositeJewellery = new CompositeJewellery();
        compositeJewellery.addGemstone(new Emerald());
        compositeJewellery.addMetal(new Gold());
    }
}

class CompositeJewellery {
    private List<Gemstone> gemstones;
    private List<Metal> metals;

    CompositeJewellery() {
        gemstones = new ArrayList<>();
        metals = new ArrayList<>();
    }

    void addGemstone(Gemstone gemstone) {
        gemstones.add(gemstone);
    }

    void removeGemstone(Gemstone gemstone) {
        gemstones.remove(gemstone);
    }

    void addMetal(Metal metal) {
        metals.remove(metal);
    }

    void removeMetal(Metal metal) {
        metals.remove(metal);
    }

    public List<Gemstone> getGemstones() {
        return gemstones;
    }

    public void setGemstones(List<Gemstone> gemstones) {
        this.gemstones = gemstones;
    }

    public List<Metal> getMetals() {
        return metals;
    }

    public void setMetals(List<Metal> metals) {
        this.metals = metals;
    }
}

interface Gemstone {
}

interface Metal {
}

class Emerald implements Gemstone {
}

class Gold implements Metal {
}
