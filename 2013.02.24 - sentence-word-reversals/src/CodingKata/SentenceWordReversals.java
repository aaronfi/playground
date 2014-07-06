package CodingKata;

import java.util.Arrays;
import java.util.Stack;

public class SentenceWordReversals {

    public static String reverseEachWord(String s) {
        if (s == null) return null;
        char[] sentence = s.toCharArray();
        
        boolean inWord = false;
        int wordStart = -1, wordEnd = -1;
        for(int i=0; i<sentence.length; i++) {
            if (!inWord && sentence[i] != ' ') {
                inWord = true;
                wordStart = i;
            } else if (inWord && (sentence[i] == ' ' || i == sentence.length-1)) {
                if (sentence[i] == ' ') wordEnd = i-1;
                if (i == sentence.length-1) wordEnd = i;

                inWord = false;
                //System.out.println(i + ":" + wordStart + " " + wordEnd);
                // reverse individual word;
                // h e l l o   g o o d b  y  e
                // 0 1 2 3 4 5 6 7 8 9 10 11 12
                int wordLength = (wordEnd - wordStart) + 1; 
                for (int j=0; j<=wordLength/2; j++) {
                    char c = sentence[wordStart + j];
                    sentence[wordStart + j] = sentence[wordEnd - j];
                    sentence[wordEnd - j] = c;
                }
            } 
        }
        return String.valueOf(sentence);
    }

    public static String reverseWordOrder(String s) {
        if (s == null) return null;
        
        char[] sentence = s.toCharArray();
        char[] newSentence = new char[sentence.length];
        for(int i=0; i<newSentence.length; i++) newSentence[i] = ' ';  // super hacky.
        
        boolean inWord = false;
        int wordStart = -1, wordEnd = -1;
        for(int i=0; i<sentence.length; i++) {
            if (!inWord && sentence[i] != ' ') {
                inWord = true;
                wordStart = i;
            } else if (inWord && (sentence[i] == ' ' || i == sentence.length-1)) {
                if (sentence[i] == ' ') wordEnd = i-1;
                if (i == sentence.length-1) wordEnd = i;
                
                inWord = false;
                int offset = sentence.length - wordEnd - 1;

                //System.out.println("i:" + i + " offset: " + offset + " wordStart: " + wordStart + " wordEnd: " + wordEnd);
                for(int j=wordStart; j<=wordEnd; j++) {
                    newSentence[offset + (j-wordStart)] = sentence[j];
                }
            }
        }
        
        return String.valueOf(newSentence);
    }
    
    public static String reverseWordOrder2(String s) {
        if (s == null) return null;
        
        char[] sentence = s.toCharArray();
        Stack<char[]> stack = new Stack<char[]>();
                
        boolean inWord = false;
        int wordStart = -1, wordEnd = -1;
        for(int i=0; i<sentence.length; i++) {
            if (!inWord && sentence[i] != ' ') {
                inWord = true;
                wordStart = i;
            } else if (inWord && (sentence[i] == ' ' || i == sentence.length-1)) {
                if (sentence[i] == ' ') wordEnd = i;
                if (i == sentence.length-1) wordEnd = i+1;
                
                inWord = false;

                stack.push(Arrays.copyOfRange(sentence, wordStart, wordEnd));
            }
        }
            
        StringBuilder sb = new StringBuilder();
        while(! stack.isEmpty()) {
            sb.append(stack.pop());
            sb.append(' ');
        }
        sb.deleteCharAt(sb.length()-1);
        
        return sb.toString();
    }
}
