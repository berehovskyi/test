package patterns.designpatterns.behavioral.chainofresponsibility;

public class Main {
    public static void main(String[] args) {
        JewelleryChain formBuilder = JewelleryChain.getJewelleryMakerChain();
        formBuilder.createJewelleryOf(JewelleryChain.NECKLACE, "Necklace");
        formBuilder.createJewelleryOf(JewelleryChain.RING, "Ring");
    }
}

abstract class JewelleryChain {
    public static final Integer RING;
    public static final Integer AMULET;
    public static final Integer NECKLACE;

    static {
        RING = 1;
        AMULET = 2;
        NECKLACE = 3;
    }

    protected Integer levelOfComplexity;
    protected JewelleryChain nextChain;

    void setNextChain(JewelleryChain makerChain) {
        this.nextChain = makerChain;
    }

    void createJewelleryOf(Integer levelOfComplexity, String form) {
        if (this.levelOfComplexity <= levelOfComplexity) {
            printForm(form);
        }
        if (nextChain != null) {
            nextChain.createJewelleryOf(levelOfComplexity, form);
        }
    }

    abstract void printForm(String form);

    static JewelleryChain getJewelleryMakerChain() {
        JewelleryChain formBuilder = new FormBuilder(JewelleryChain.RING);
        JewelleryChain gemstoneAppender = new GemstoneAppender(JewelleryChain.AMULET);
        JewelleryChain metalAppender = new MetalAppender(JewelleryChain.NECKLACE);
        formBuilder.setNextChain(gemstoneAppender);
        gemstoneAppender.setNextChain(metalAppender);
        return formBuilder;
    }
}

class FormBuilder extends JewelleryChain {
    public FormBuilder(Integer levelOfComplexity) {
        this.levelOfComplexity = levelOfComplexity;
    }

    @Override
    void printForm(String form) {
        System.out.println("Start of jewellery creating...");
        System.out.println(form + " form was created");
    }
}

class GemstoneAppender extends JewelleryChain {
    public GemstoneAppender(Integer levelOfComplexity) {
        this.levelOfComplexity = levelOfComplexity;
    }

    @Override
    void printForm(String form) {
        System.out.println("Added Gemstone to " + form);
    }
}

class MetalAppender extends JewelleryChain {
    public MetalAppender(Integer levelOfComplexity) {
        this.levelOfComplexity = levelOfComplexity;
    }

    @Override
    void printForm(String form) {
        System.out.println("Added Metal to " + form);
        System.out.println(form + " has been created");
    }
}