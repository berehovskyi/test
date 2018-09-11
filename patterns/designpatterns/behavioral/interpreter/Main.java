package patterns.designpatterns.behavioral.interpreter;

public class Main {
    public static void main(String[] args) {
        Expression isGemstone = InterpreterClient.getGemstoneExpression();
        Expression isPreciousMetal = InterpreterClient.getPreciousMetalExpression();

        System.out.println("Is Emerald a gemstone? " + isGemstone.interpret("Emerald"));
        System.out.println("Is Gold a precious metal? " + isPreciousMetal.interpret("Precious Metal"));
    }
}

interface Expression {
    Boolean interpret(String context);
}

class TerminalExpression implements Expression {
    private String data;

    public TerminalExpression(String data) {
        this.data = data;
    }

    @Override
    public Boolean interpret(String context) {
        return context.contains(data);
    }
}

class OrExpression implements Expression {
    private Expression expr1;
    private Expression expr2;

    public OrExpression(Expression expr1, Expression expr2) {
        this.expr1 = expr1;
        this.expr2 = expr2;
    }

    @Override
    public Boolean interpret(String context) {
        return expr1.interpret(context) || expr2.interpret(context);
    }
}

class AndExpression implements Expression {

    private Expression expr1;
    private Expression expr2;

    public AndExpression(Expression expr1, Expression expr2) {
        this.expr1 = expr1;
        this.expr2 = expr2;
    }

    @Override
    public Boolean interpret(String context) {
        return expr1.interpret(context) && expr2.interpret(context);
    }
}

class InterpreterClient {
    //Rule: Emerald and Turquoise are gemstones
    public static Expression getGemstoneExpression() {
        Expression emerald = new TerminalExpression("Emerald");
        Expression turquoise = new TerminalExpression("Turquoise");
        return new OrExpression(emerald, turquoise);
    }

    //Rule: Gold is a precious metal
    public static Expression getPreciousMetalExpression() {
        Expression gold = new TerminalExpression("Metal");
        Expression precious = new TerminalExpression("Precious");
        return new AndExpression(gold, precious);
    }
}