package patterns.designpatterns.structural.facade;

public class Main {
    public static void main(String[] args) {
        Gemstone emerald = new Emerald();
        Metal gold = new Gold();
        Form form = new Necklace();
        FacadeJewelleryMaker facadeJewelleryMaker = new FacadeJewelleryMaker();
        facadeJewelleryMaker.createJewelleryWith(emerald, gold, form);
    }
}

interface Gemstone {
    void addGemstones();
}

interface Metal {
    void addMetals();
}

interface Form {
    void makeForm();
}

class Emerald implements Gemstone {
    @Override
    public void addGemstones() {
        System.out.println("Emerald gemstones has been added");
    }
}

class Gold implements Metal {
    @Override
    public void addMetals() {
        System.out.println("Gold has been added");
    }
}

class Necklace implements Form {
    @Override
    public void makeForm() {
        System.out.println("The jewellery's form is a necklace");
    }
}

class FacadeJewelleryMaker {
    void createJewelleryWith(Gemstone gemstone, Metal metal, Form form){
        gemstone.addGemstones();
        metal.addMetals();
        form.makeForm();
    }
}
