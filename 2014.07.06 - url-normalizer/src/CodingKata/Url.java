package CodingKata;

import java.util.Stack;

public class Url
{
    public static String Normalize(String url) {
        if (url == null) {
            return null;
        }

        Stack<String> history = new Stack<String>();
        String[] tokens = url.split("/");

        for(String token : tokens) {
            if (token.equals(".")) {
                continue;
            } else if (token.equals("..")) {
                if (history.peek() == null) {
                    return null;
                } else {
                    history.pop();
                }
            } else {
                history.push(token);
            }
        }

        StringBuilder builder = new StringBuilder();

        while(!history.isEmpty()) {
            builder.insert(0, "/").insert(0, history.pop());
        }
        builder.deleteCharAt(builder.length()-1);

        return builder.toString();
    }
}
