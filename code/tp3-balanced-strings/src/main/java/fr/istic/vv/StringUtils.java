package fr.istic.vv;

import java.util.ArrayDeque;
import java.util.Deque;

public class StringUtils {

    private StringUtils() {}

    public static boolean isBalanced(String str) {
        Deque<Character> stack = new ArrayDeque<>();
        boolean result = true;
        for(int i=0; i<str.length(); i++) {
            switch (str.charAt(i)) {
                case '(' :
                case '[' :
                case '{' :
                    stack.push(str.charAt(i));
                    break;
                case ')' : {
                    if (stack.pop() != '(') result = false;
                    break;
                }
                case ']' : {
                    if (stack.pop() != '[') result = false;
                    break;
                }
                case '}' : {
                    if (stack.pop() != '{') result = false;
                    break;
                }
                default: break;
            }
        }
        return result;
    }

}
