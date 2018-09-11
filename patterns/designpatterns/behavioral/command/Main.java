package patterns.designpatterns.behavioral.command;

public class Main {
    public static void main(String[] args) {
        JewelleryCreator ringCreator = new RingCreator();
        Command createFormCommand = new CreateFormCommand(ringCreator);
        Command addMetalCommand = new AddMetalCommand(ringCreator);
        Command addGemstoneCommand = new AddGemstoneCommand(ringCreator);
        JewelleryInvoker jewelleryInvoker = new JewelleryInvoker(createFormCommand);
        jewelleryInvoker.execute();
        jewelleryInvoker = new JewelleryInvoker(addMetalCommand);
        jewelleryInvoker.execute();
        jewelleryInvoker = new JewelleryInvoker(addGemstoneCommand);
        jewelleryInvoker.execute();
    }
}

interface Command {
    void execute();
}

interface JewelleryCreator {
    void createForm();
    void addMetal();
    void addGemstone();
}

class RingCreator implements JewelleryCreator{
    @Override
    public void createForm() {
        System.out.println("Creating ring form...");
    }

    @Override
    public void addMetal() {
        System.out.println("By silver");
    }

    @Override
    public void addGemstone() {
        System.out.println("Adding amethyst gemstones...");
    }
}

class AmuletCreator implements JewelleryCreator {
    @Override
    public void createForm() {
        System.out.println("Creating amulet form");
    }

    @Override
    public void addMetal() {
        System.out.println("By gold");
    }

    @Override
    public void addGemstone() {
        System.out.println("Adding turquoise gemstones...");
    }
}

class CreateFormCommand implements Command {
    private JewelleryCreator creator;

    public CreateFormCommand(JewelleryCreator creator) {
        this.creator = creator;
    }

    @Override
    public void execute() {
        this.creator.createForm();
    }
}

class AddMetalCommand implements Command {
    private JewelleryCreator creator;

    public AddMetalCommand(JewelleryCreator creator) {
        this.creator = creator;
    }

    @Override
    public void execute() {
        this.creator.addMetal();
    }
}

class AddGemstoneCommand implements Command {
    private JewelleryCreator creator;

    public AddGemstoneCommand(JewelleryCreator creator) {
        this.creator = creator;
    }

    @Override
    public void execute() {
        this.creator.addGemstone();
    }
}

class JewelleryInvoker {
    private Command command;

    public JewelleryInvoker(Command command) {
        this.command = command;
    }

    public void execute() {
        this.command.execute();
    }
}