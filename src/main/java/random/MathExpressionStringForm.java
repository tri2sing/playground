package random;

import java.util.LinkedList;
import java.util.List;

public class MathExpressionStringForm {

    public static List<String> tokenize(String expression) {
        List<String> tokens = new LinkedList<>();
        expression = expression.trim().replace(" ", "");
        int start = 0;
        int end;
        for(int i = 0; i < expression.length(); i++){
            if(expression.charAt(i) == '+' || expression.charAt(i) == '*'){
                tokens.add(expression.substring(start, i));
                tokens.add(expression.substring(i, i + 1));
                start = i + 1;
            }
        }
        tokens.add(expression.substring(start));

        return tokens;
    }

    public static long calculate(String expression){

        return 0;

    }
}

