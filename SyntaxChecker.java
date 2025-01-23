//(c) A+ Computer Science
//www.apluscompsci.com

//Name -

import java.util.*;
import static java.lang.System.*;

public class SyntaxChecker {
    private String exp;
    private Stack<Character> symbols;

    public SyntaxChecker() {
        exp = "";
        symbols = new Stack<>();
    }

    public SyntaxChecker(String s) {
        exp = s;
        symbols = new Stack<>();
    }

    public void setExpression(String s) {
        exp = s;
        symbols.clear();
    }

    public boolean checkExpression() {
        Map<Character, Character> matchingPairs = new HashMap<>();
        matchingPairs.put('}', '{');
        matchingPairs.put(')', '(');
        matchingPairs.put(']', '[');
        matchingPairs.put('>', '<');

        for (char c : exp.toCharArray()) {
            if (matchingPairs.containsValue(c)) {
                symbols.push(c);
            } else if (matchingPairs.containsKey(c)) {
                if (symbols.isEmpty() || symbols.pop() != matchingPairs.get(c)) {
                    return false;
                }
            }
        }

        return symbols.isEmpty();
    }

    @Override
    public String toString() {
        return exp + (checkExpression() ? " is correct." : " is incorrect.");
    }

    public static void main(String[] args) {
        // Sample data
        String[] testCases = {
            "(abc(def)",
            "[{}]",
            "[",
            "[{<()>}]",
            "{<html[value=4](12)>{$x}}",
            "[one]{three}(four)",
            "car(cdr(a)(b)))",
            "car(cdr(a)(b))"
        };

        // Process each test case
        for (String test : testCases) {
            SyntaxChecker checker = new SyntaxChecker(test);
            out.println(checker);
        }
    }
}
