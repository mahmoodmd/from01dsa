import java.util.*;

public class BalanceParentheses {

    public static char[][] TOKENS = {{'{', '}'}, {'(', ')'}, {'[',']'}};

    public static boolean isOpenTerm(char c){
        for (char[] pair :TOKENS) {
            if(c == pair[0])
                return true;
        }
        return false;
    }

    public static boolean isMatching(char openTerm, char closeTerm){
        for (char[] pair :TOKENS) {
            if(openTerm == pair[0] && closeTerm == pair[1])
                return true;
        }
        return false;
    }

    public static boolean isBalance(String expression){
        Stack<Character> stack = new Stack<Character>();
        for(char c : expression.toCharArray()){
            if(isOpenTerm(c))
                stack.push(c);
            else if( stack.isEmpty() || isMatching(stack.pop(), c) == false)
                return false;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args){
        System.out.println("Terms are balance : " + isBalance("{[()]}"));
        System.out.println("Terms are balance : " + isBalance("({[()]}"));
        System.out.println("Terms are balance : " + isBalance("{[()]}}"));
    }
}
