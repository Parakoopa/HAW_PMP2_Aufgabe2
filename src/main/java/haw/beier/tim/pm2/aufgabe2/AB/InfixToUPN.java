package haw.beier.tim.pm2.aufgabe2.AB;

import java.util.Queue;
import java.util.Stack;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;

public final class InfixToUPN {

	static int curToken = 0;

	public static Queue<String> process(String line) {
		// 1.
		LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>();
		Stack<String> stack = new Stack<>();
		// 2.
		Scanner scanner = new Scanner(line).useDelimiter("\\s");

		String next;
		String nextToken = new String();

		try {
			while (scanner.hasNext()) { // add null check for end of line?
				next = scanner.next();
				nextToken = Token.getToken(next, curToken);
				curToken++;
				// 3.
				if (nextToken == "\\d+") {
					queue.add(next);
				} else if (stack.isEmpty() || next == "("
						|| OpUtil.lowerPrecedence(stack.peek(), next)) {
					// 4.
					stack.add(next);
				} else {
					String top = stack.peek();
					if (OpUtil.higherPrecedence(stack.peek(), next)) {
						stack.pop();
						if (top == "(") {
							// do nothing
						} else {
							queue.add(next);
						}
					}
					// 5.
					while (!stack.isEmpty()
							&& OpUtil.higherPrecedence(top, next)) {

					}
						if (next != ")") {
							stack.add(next);
						}
				}
			}
		} finally {
			if (scanner != null)
				scanner.close();
		}
		return queue;
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
