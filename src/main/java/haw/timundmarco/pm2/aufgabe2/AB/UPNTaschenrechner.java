package haw.timundmarco.pm2.aufgabe2.AB;

import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;

public class UPNTaschenrechner {

    public static Double process(String line) {
        Stack<Double> resultStack = new Stack<>();
        Scanner scanner = new Scanner(line).useDelimiter("\\s");

        String next;
        Token tokenNext;
        try {
            while (scanner.hasNext()) {
                next = scanner.next();

                tokenNext = Token.getToken(next);
                Double o1, o2;
                switch (tokenNext) {
                    case NUMBER:
                        resultStack.push(Double.valueOf(next));
                        break;
                    case PLUS:
                        resultStack.push(resultStack.pop()+resultStack.pop());
                        break;
                    case MINUS:
                        o2 = resultStack.pop();
                        o1 = resultStack.pop();
                        resultStack.push(o1-o2);
                        break;
                    case MULTIPLICATION:
                        resultStack.push(resultStack.pop()*resultStack.pop());
                        break;
                    case DIVISION:
                        o2 = resultStack.pop();
                        o1 = resultStack.pop();
                        resultStack.push(o1/o2);
                        break;
                    default:
                        throw new NoTokenMatchException("Unsupported Token for calculation "+tokenNext);
                }
            }
        } catch (NoTokenMatchException | EmptyStackException e) {
            e.printStackTrace();
            //throw e;
        }
        scanner.close();
        return resultStack.isEmpty() ? Double.NaN : resultStack.pop();
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println(">> INPUT");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            System.out.println(">> RESULT");
            System.out.println(UPNTaschenrechner.process(String.join(" ", InfixToUPN.process(input))));
            System.out.println();
        }
    }
}
