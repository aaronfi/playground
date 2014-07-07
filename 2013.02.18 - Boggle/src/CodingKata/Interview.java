package CodingKata;

public class Interview {
    
    public static void main(String[] args) {
        Boolean b = Boolean.parseBoolean(null);
        System.out.println(b);
    }
}

//package MyKata;
//
//import java.util.*;
//
//    // Input: �67798657456587998876756�
//    // Output: �67798657456587998876757�
//    //
//    //
//    // add-one-in-string-land
//    //
//    //
//    // BigDecimal
//    // 
//    // 
//    // manually doing this, with the strings and chars themselves
//
//
//    public static String addOneTakeFour(String s) {
//        if (s == null) return null;
//
//        char[] c = s.toCharArray();
//        int i = c.length-1;
//
//        int x;
//        do { 
//           x = (int) c[i] + 1;
//           c[i] = x == 10 ? '0' : Char.valueOf(x);   
//           i--;
//        } while (i >= 0 && x == 10);
//
//        Strint retVal = "";
//        if (i == -1) {  // then carryover past original start of the string has occurred
//            retVal = "1";
//        }
//        retVal += String.valueOf(c);
//        return retVal;
//    }
//
//
//    public static String addOneTakeThree(String s) {
//        if (s == null) return null;
//
//        char[] c = s.toCharArray();
//        boolean needsCarryOver = true;
//        boolean leftMostOverflow = false;
//        int i = c.length-1;
//
//        while (needsCarryOver) {
//            int x = Integer.valueOf(c[i]);
//            x++;
//            if (x <= 9) {
//               c[i] = Char.valueOf(i);  // TODO(aaronfi) not sure this would work.
//               needsCarryOver = false;     
//            } else {           
//               c[i] = Char.valueOf(x % 10);  
//               i--;
//               if (i < 0) {
//                   needsCarryOver = false;
//                   leftMostOverflow = true;
//               }                       
//            }  
//        }
//
//        String retVal = "";
//        if (leftMostOverflow) {
//            retVal = "1";
//        }
//        retVal += String.valueOf(c);
//        return retVal;
//    }
//
//
//
//
//
//    public static String addOneTakeTwo(String s) {
//        if (s == null) return null;
//
//        char[] c = s.toCharArray();
//        int carryOverToAdd = 1;
//        boolean needsCarryOver = true;
//        boolean leftMostOverflow = false;
//        int i = c.length-1;
//
//        while (needsCarryOver) {
//
//            int x = Integer.valueOf(c[i]);
//            x += carryOverToAdd;
//            if (x <= 9) {
//               c[i] = Char.valueOf(i);  // TODO(aaronfi) not sure this would work.
//               needsCarryOver = false;     
//            } else {
//               // addition overflow... TODO:  handle case where carryover to beginning of string 
//               
//               c[i] = Char.valueOf(x % 10);  
//               carryOverToAdd = x / 10; 
//               i--;  // TODO:  need to check for when i < 0;
//               if (i < 0) {
//                   needsCarryOver = false;
//                   leftMostOverflow = true;
//               }                       
//            }  
//        }
//
//        return String.valueOf( leftMostOverflow ? Char.valueOf(x/10) : '' + c );
//    }
//
//
//
//
//
//
//    public static String addOne(String s) {
//        if (s == null) return null;
//
//        char[] c = s.toCharArray();
//        
//        boolean needsCarryOver = true;
//        int i = c.length-1;
//
//        while (needsCarryOver) {
//
//            int x = Integer.valueOf(c[i]);
//            x++;
//            if (x <= 9) {
//               c[i] = Char.valueOf(i);  // TODO(aaronfi) not sure this would work.     
//            } else {
//               // addition overflow... TODO:  handle case where carryover to beginning of string 
//               
//               int modulus = x % 10;
//               c[i] = Char.valueOf(modulus);  
//
//               
//                           
//
//            }  
//        }
//    }
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//      test cases in summation:  your original one;  109;
//
//
//
//
//
//
//
//
//
//
//
//
//    s --> "9"
//    // not null
//
//    char[]:  ['9']
//    i --> 0
//
//
//
//     c[0] --> '9' --> 9 + 1 --> x == 10
//    c[0] --> '0'
//    i --> -1
//
//
//
//
//
//
//
//    "10"
