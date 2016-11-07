package haw.koepcke.marco.pm2.aufgabe2.teileAB;

import java.util.ArrayList;
import java.util.Arrays;

public final class OpUtil {
    private final static ArrayList<String> operators = new ArrayList<>(Arrays.asList(
            "(", "/", "*", "-", "+", ")"
    ));
    static public boolean lowerPrecedence(String op1, String op2) {
        return operators.indexOf(op1) > operators.indexOf(op2);
    }
    static public boolean higherPrecedence(String op1, String op2) {
        return operators.indexOf(op1) < operators.indexOf(op2);
    }

}
