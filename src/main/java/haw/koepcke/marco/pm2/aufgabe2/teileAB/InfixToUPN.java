package haw.koepcke.marco.pm2.aufgabe2.teileAB;

import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

public final class InfixToUPN {
    // TODO: Exception sollte weitergereicht werden
    public static Queue<String> process(String line) {
        //1. Lege eine Queue und einen Stack an.
        Stack<String> stack = new Stack<>();
        LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>();
        //2. Lies die Zeichenkette von links nach rechts
        Scanner scanner = new Scanner(line).useDelimiter("\\s");
        String next;
        Tokens tokenNext;
        try {
            while (scanner.hasNext()) {
                next = scanner.next();
                tokenNext = Tokens.getToken(next);
                if (tokenNext == Tokens.NUMBER) {
                    //3. Wird eine Zahl gelesen wird, dann schreibe diese in die Queue
                    queue.add(next);
                } else if (
                        stack.isEmpty()
                        || Tokens.OPEN.matches(stack.peek())
                        || OpUtil.lowerPrecedence(stack.peek(), next)
                        ) {
                    //4. Wird ein Operator (Variable op) gelesen, dann
                    //    a. wenn der Stack leer ist oder das oberster Element des Stacks die öffnende
                    //       Klammer ist ('(') oder das oberste Element des Stacks geringere Präzedenz als op
                    //       hat, dann lege op auf den Stack. Präzedenzregel: '(' vor '/' vor '*' vor '-' vor '+'
                    //       vor ')'
                    stack.add(next);
                } else {
                    //    b. sonst: nehme solange Operatoren vom Stack und schreibe diese in die Queue, wie
                    //       die Operatoren auf dem Stack höhere Präzedenz als op haben. Öffnende
                    //       Klammern '(' werden vom Stack genommen und nicht in die Queue geschrieben.
                    //       Danach wird op auf den Stack gelegt. Ausnahme: Schließende Klammern werden
                    //       nicht auf den Stack gelegt.
                    String stackTop;
                    do {
                        stackTop = stack.pop();
                        if (!Tokens.OPEN.matches(stackTop)) {
                            queue.add(stackTop);
                        }
                    } while (!stack.isEmpty() && OpUtil.higherPrecedence(stackTop, next));
                    if (tokenNext != Tokens.CLOSE) {
                        stack.add(next);
                    }
                }
            }
        } catch (NoTokenMatchException e) {
            e.printStackTrace();
        }
        //5. Wenn die Eingabe abgearbeitet ist, dann nehme alle noch verbliebenen Operatoren vom
        //   Stack und schreibe diese in die Queue. Öffnende Klammern '(' werden vom Stack
        //   genommen und nicht in die Queue geschrieben.
        while (!stack.isEmpty()) {
            String stackTop = stack.pop();
            if (!Tokens.OPEN.matches(stackTop)) {
                queue.add(stackTop);
            }
        }
        return queue;
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println(">> INPUT");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            System.out.println(">> OUTPUT");
            System.out.println(String.join(" ", InfixToUPN.process(input)));
            System.out.println();
        }
    }
}
