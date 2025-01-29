//(c) A+ Computer Science
//www.apluscompsci.com

//Name - Nathan Carrillo
import java.util.Stack;

public class SyntaxCheckRunner {
    public static void main(String[] args) {
        // Sample test cases
        String[] testCases = {
                "(abc(*def)",
                "[{}]",
                "[",
                "[{<()>}]",
                "{<html[value=4]*(12)>{$x}}",
                "[one]<two>{three}(four)",
                "car(cdr(a)(b)))",
                "car(cdr(a)(b))"
        };

        for (String testCase : testCases) {
            boolean result = isBalanced(testCase);
            System.out.println(testCase + " is " + (result ? "correct." : "incorrect."));
        }
    }

    public static boolean isBalanced(String symbols) {
        Stack<Character> stack = new Stack<>();
        String opening = "{([<";
        String closing = "})]>";

        for (char ch : symbols.toCharArray()) {
            if (opening.indexOf(ch) != -1) {
                // Push opening symbols onto the stack
                stack.push(ch);
            } else if (closing.indexOf(ch) != -1) {
                // Check if stack is empty or the top of the stack doesn't match
                if (stack.isEmpty() || closing.indexOf(ch) != opening.indexOf(stack.pop())) {
                    return false;
                }
            }
        }

        // If the stack is empty, the string is balanced
        return stack.isEmpty();
    }
}
