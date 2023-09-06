import java.util.HashMap;
import java.util.Stack;

public class c20 {
    public boolean isValid(String s) {

        if (s.length() % 2 == 1) return false;

        HashMap<Character, Character> map = new HashMap<>();
        Stack<Character> stack = new Stack<>();
        map.put('}','{');
        map.put(')','(');
        map.put(']','[');

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++){
            if (chars[i] == '{' || chars[i] == '['|| chars[i] == '('){
                stack.push(chars[i]);
            }else {
                char key = ' ';
                if (!stack.isEmpty()){
                     key = stack.pop();
                }
                if (map.get(chars[i]) != key) return false;
            }
        }
        if (stack.isEmpty()) return true;
        return false;
    }
}
