package random;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class AutoBox {
    private static HashMap<Character, Character[] > nToC = new HashMap<>();

    static {
        nToC.put('2', new Character[] {'a', 'b', 'c'});
        nToC.put('3', new Character[] {'d', 'e', 'f'});
        nToC.put('4', new Character[] {'g', 'h', 'i'});
        nToC.put('5', new Character[] {'j', 'k', 'l'});
        nToC.put('6', new Character[] {'m', 'n', 'o'});
        nToC.put('7', new Character[] {'p', 'q', 'r', 's'});
        nToC.put('8', new Character[] {'t', 'u', 'v'});
        nToC.put('9', new Character[] {'w', 'x', 'y', 'z'});
    }

    private List<String> combine(List<Character> input) {
        List<String> result = new LinkedList<>();
        if (input.size() == 1) {
            for(Character c: nToC.get(input.get(0))){
                result.add(String.valueOf(c));
            }
            return result;
        }
        Character first = input.get(0);
        List<Character> rest = input.subList(1, input.size());
        List<String> partial = combine(rest);
        for(Character c: nToC.get(first)){
            for(String s: partial){
                result.add(String.valueOf(c) + s);
            }
        }
        return result;
    }

    public List<String> letterCombinations(String digits) {
        if(digits.equals("")) {
            return new LinkedList<>();
        }
        LinkedList<Character> input = new LinkedList<>();
        for(int i = 0; i < digits.length(); i++){
            input.add(digits.charAt(i));
        }
        return combine(input);
    }
}
