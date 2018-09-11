package core.inheritance;

public class Main {
    public static void main(String[] args) {
        AbstractCar anonimious = new AbstractCar() {
            @Override
            public void run() {
                System.out.println("Run");
            }
        };
        AudiR8 audiR8 = new AudiR8();

        System.out.println(audiR8.runMessage("R8"));
        System.out.println(anonimious.runMessage("Abstract"));
    }
}
