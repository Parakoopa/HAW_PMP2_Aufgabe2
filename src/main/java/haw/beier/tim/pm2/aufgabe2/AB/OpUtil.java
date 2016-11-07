package haw.beier.tim.pm2.aufgabe2.AB;
import java.util.ArrayList;

public class OpUtil {
	public static int GetOpPriority(String op) {
		int opPriority;

		ArrayList<String> opList = new ArrayList<String>();
		opList.add("(");
		opList.add("/");
		opList.add("*");
		opList.add("-");
		opList.add("+");
		opList.add(")");

		opPriority = opList.indexOf(op);
		if(opPriority < 0 || opPriority > 5) throw new IndexOutOfBoundsException();
		return opPriority;
	}

	public static boolean lowerPrecedence(String op1, String op2) {
		int op1Priority = GetOpPriority(op1);
		int op2Priority = GetOpPriority(op2);

		return op1Priority < op2Priority;
	}

	public static boolean higherPrecedence(String op1, String op2) {
		int op1Priority = GetOpPriority(op1);
		int op2Priority = GetOpPriority(op2);

		return op1Priority > op2Priority;
	}
}
