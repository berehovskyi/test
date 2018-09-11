package core.inheritance;

public abstract class AbstractCar {
    public String name;
    public static Integer numberOfWheels;
    public static final String DEFAULT_MODEL;

    static {
        numberOfWheels = 4;
        DEFAULT_MODEL = "BASIC";
    }

    public AbstractCar() {
    }

    public AbstractCar(String name) {
        this.name = name;
    }

    public abstract void run();

    public static String message() {
        return "AbstractCar";
    }

    public String runMessage(String name) {
        return "Driving the " + name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static Integer getNumberOfWheels() {
        return numberOfWheels;
    }

    public static void setNumberOfWheels(Integer numberOfWheels) {
        AbstractCar.numberOfWheels = numberOfWheels;
    }

    public static String getDefaultModel() {
        return DEFAULT_MODEL;
    }
}
