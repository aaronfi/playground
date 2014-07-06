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
//    coding problem #2:  
//    01
//    02
//    03
//    04
//    05
//    06
//    07
//    08
//    09
//    10
//    11
//    12
//    13
//    14
//    15
//    16
//    17
//    18
//    19
//    20
//    21
//    22
//    23
//    24
//    25
//    26
//    27
//    28
//    29
//    30
//    31
//    32
//    33
//    34
//    35
//    36
//    37
//    38
//    39
//    40
//    41
//    42
//    43
//    44
//    45
//    46
//    47
//    48
//    49
//    50
//    51
//    52
//    53
//    54
//    55
//    56
//    57
//    58
//    59
//    60
//    61
//    62
//    63
//    64
//    65
//    66
//    67
//    68
//    69
//    70
//    71
//    72
//    73
//    74
//    75
//    76
//    77
//    78
//    79
//    80
//    81
//    82
//    83
//    84
//    85
//    86
//    87
//    88
//    89
//    90
//    91
//    92
//    93
//    94
//    95
//    96
//    97
//    98
//    99  
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
//    coding problem #3:  
//    01
//    02
//    03
//    04
//    05
//    06
//    07
//    08
//    09
//    10
//    11
//    12
//    13
//    14
//    15
//    16
//    17
//    18
//    19
//    20
//    21
//    22
//    23
//    24
//    25
//    26
//    27
//    28
//    29
//    30
//    31
//    32
//    33
//    34
//    35
//    36
//    37
//    38
//    39
//    40
//    41
//    42
//    43
//    44
//    45
//    46
//    47
//    48
//    49
//    50
//    51
//    52
//    53
//    54
//    55
//    56
//    57
//    58
//    59
//    60
//    61
//    62
//    63
//    64
//    65
//    66
//    67
//    68
//    69
//    70
//    71
//    72
//    73
//    74
//    75
//    76
//    77
//    78
//    79
//    80
//    81
//    82
//    83
//    84
//    85
//    86
//    87
//    88
//    89
//    90
//    91
//    92
//    93
//    94
//    95
//    96
//    97
//    98
//    99  
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
