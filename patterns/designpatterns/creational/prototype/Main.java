package patterns.designpatterns.creational.prototype;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        EmeraldPrototype emeraldPrototype = new EmeraldPrototype(500);
        emeraldPrototype.setWeight(700);
        EmeraldPrototype emeraldClone = emeraldPrototype.clone();
    }
}

class EmeraldPrototype implements Cloneable {

    private Integer weight;

    public EmeraldPrototype(Integer weight) {
        this.weight = weight;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Override
    public EmeraldPrototype clone() throws CloneNotSupportedException {
        return (EmeraldPrototype) super.clone();
    }
}
