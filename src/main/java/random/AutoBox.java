package random;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class AutoBox {
    private static HashMap<String, String[] > nToC = new HashMap<>();

    static {
        nToC.put("2", new String[] {"a", "b", "c"});
        nToC.put("3", new String[] {"d", "e", "f"});
        nToC.put("4", new String[] {"g", "h", "i"});
        nToC.put("5", new String[] {"j", "k", "l"});
        nToC.put("6", new String[] {"m", "n", "o"});
        nToC.put("7", new String[] {"p", "q", "r", "s"});
        nToC.put("8", new String[] {"t", "u", "v"});
        nToC.put("9", new String[] {"w", "x", "y", "z"});
    }

    private List<String> combine(List<String> input) {
        List<String> result = new LinkedList<>();
        if (input.size() == 1) {
            for(String c: nToC.get(input.get(0))){
                result.add(c);
            }
            return result;
        }
        String first = input.get(0);
        List<String> rest = input.subList(1, input.size());
        List<String> partial = combine(rest);
        for(String c: nToC.get(first)){
            for(String s: partial){
                result.add(c + s);
            }
        }
        return result;
    }

    public List<String> letterCombinations(String digits) {
        if(digits.equals("")) {
            return new LinkedList<>();
        }
        LinkedList<String> input = new LinkedList<>(Arrays.asList(digits.split("")));
        return combine(input);
    }
}
