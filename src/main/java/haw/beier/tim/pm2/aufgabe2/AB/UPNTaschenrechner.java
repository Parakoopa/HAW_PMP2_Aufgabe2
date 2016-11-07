package haw.beier.tim.pm2.aufgabe2.AB;
import java.util.Scanner;
import java.util.Stack;

public final class UPNTaschenrechner {
	static int curToken = 0;

	public static Double process(String line) {
		Stack<Double> stack = new Stack<>();
		Scanner scanner = new Scanner(line).useDelimiter("\\s");

		String next;
		String nextToken = new String();
		try {
			while (scanner.hasNext()) {
				next = scanner.next();
				nextToken = Token.getToken(next, curToken);
				curToken++;

				switch (nextToken) {

				case "\\D":
					stack.push(Double.valueOf(next));
					break;
				case "+":
					stack.push(stack.pop() + stack.pop());
					break;
				case "-":
					stack.push(stack.pop() - stack.pop());
					break;
				case "*":
					stack.push(stack.pop() * stack.pop());
					break;
				case "/":
					stack.push(stack.pop() / stack.pop());
					break;
				}
			}
		} finally {
			if (scanner != null)
				scanner.close();
		}
		return stack.isEmpty() ? Double.NaN : stack.pop();
	}

	public static void main(String[] args) {
		while (true) {
			System.out.println("Insert term");
			Scanner scanner = new Scanner(System.in);
			String input = scanner.nextLine();
			System.out.println("Output term");
			System.out.println(String.join(" ", InfixToUPN.process(input)));
			System.out.println();
		}
	}
}
