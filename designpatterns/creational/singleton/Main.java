package designpatterns.creational.singleton;

public class Main {
    public static void main(String[] args) {
        AmethystSingleton amethyst = AmethystSingleton.getInstance();
        RubySingleton ruby = RubySingleton.getInstance();
        EmeraldSingleton emerald = EmeraldSingleton.EMERALD_SINGLETON;
    }
}

class AmethystSingleton {
    private AmethystSingleton() {
    }

    private static class SingletonHolder {
        public static final AmethystSingleton INSTANCE = new AmethystSingleton();
    }

    public static AmethystSingleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}

class RubySingleton {
    private static RubySingleton instance;

    private RubySingleton() {
    }

    public static synchronized RubySingleton getInstance() {
        if (instance == null) {
            instance = new RubySingleton();
        }
        return instance;
    }
}

enum EmeraldSingleton {
    EMERALD_SINGLETON
}


