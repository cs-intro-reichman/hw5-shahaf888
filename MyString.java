

/**
 * A library of string functions.
 */
public class MyString {
    public static void main(String args[]) {
        String hello = "hello";
        System.out.println(countChar(hello, 'h'));
        System.out.println(countChar(hello, 'l'));
        System.out.println(countChar(hello, 'z'));
        System.out.println(spacedString(hello));
        System.out.println("spas in space -> " + subsetOf("spas", "space") + " (expected: true)");
        //// Put your other tests here.
        System.out.println("silent -> \"" + spacedString("silent") + "\" (expected: s i l e n t)");
        System.out.println("length 10 -> " + randomStringOfLetters(10));
        System.out.println("abc - abc -> " + remove("abc", "abc") + " (expected: )");
        System.out.println("empty string -> \"" + spacedString("") + "\" (expected: )");
        System.out.println("abc - b -> " + remove("abc", "b") + " (expected: ac)");

    }

    /**
     * Returns the number of times the given character appears in the given string.
     * Example: countChar("Center",'e') returns 2 and countChar("Center",'c') returns 0. 
     * 
     * @param str - a string
     * @param c - a character
     * @return the number of times c appears in str
     */
    public static int countChar(String str, char ch) {
        int counter = 0;
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) == ch){
                counter++;
            }
        }

        return counter;
    }

    /** Returns true if str1 is a subset string str2, false otherwise
     *  Examples:
     *  subsetOf("sap","space") returns true
     *  subsetOf("spa","space") returns true
     *  subsetOf("pass","space") returns false
     *  subsetOf("c","space") returns true
     *
     * @param str1 - a string
     * @param str2 - a string
     * @return true is str1 is a subset of str2, false otherwise
     */
    public static boolean subsetOf(String str1, String str2) {
        String helper = "";
        if (str1.length() > str2.length()){
            return false;
        }
        int indexForHelp = 0;
        for(int i = 0; i < str1.length(); i++){
            char c = str1.charAt(i);
            indexForHelp = str2.indexOf(c);
            if (indexForHelp == -1){
                return false;
            }
            else{
                //System.out.println("char : " + c);
                helper = str2.substring(0, indexForHelp);
                //System.out.println("helper1 = " + helper);
                helper = helper + str2.substring(indexForHelp + 1);
                //System.out.println("helper2 = " + str2.substring(indexForHelp + 1));
            }
            str2 = helper;
        }
        
        return true;
    }

    /** Returns a string which is the same as the given string, with a space
     * character inserted after each character in the given string, except
     * for the last character. 
     * Example: spacedString("silent") returns "s i l e n t"
     * 
     * @param str - a string
     * @return a string consisting of the characters of str, separated by spaces.
     */
    public static String spacedString(String str) {
        String helper = "";
        for (int i = 0; i < str.length(); i++){
            if (i != str.length()-1){
                helper = helper + str.charAt(i);
                helper = helper + " ";
            }
            else{
                helper = helper + str.charAt(i);
            }

        }
        return helper;
    }
  
    /**
     * Returns a string of n lowercase letters, selected randomly from 
     * the English alphabet 'a', 'b', 'c', ..., 'z'. Note that the same
     * letter can be selected more than once.
     * 
     * Example: randomStringOfLetters(3) can return "zoo"
     * 
     * @param n - the number of letter to select
     * @return a randomly generated string, consisting of 'n' lowercase letters
     */
    public static String randomStringOfLetters(int n) {
        String newStr = "";

        for (int i = 0; i < n; i++){
            int randomNum = (int) (Math.random() * 26);
            char c = (char) ('a' + randomNum);
            newStr = newStr + c;
        }
        return newStr;
    }

    /**
     * Returns a string consisting of the string str1, minus all the characters in the
     * string str2. Assumes (without checking) that str2 is a subset of str1.
     * Example: remove("meet","committee") returns "comit" 
     * 
     * @param str1 - a string
     * @param str2 - a string
     * @return a string consisting of str1 minus all the characters of str2
     */
    public static String remove(String str1, String str2) {
       String newSub = "";
       int indexForHelp = 0;
       for (int i = 0; i < str2.length(); i++){
        //System.out.println("char from str2: " + str2.charAt(i));
        indexForHelp = str1.indexOf(str2.charAt(i));
        //System.out.println("index: " + indexForHelp);
        newSub = str1.substring(0,indexForHelp);
        //System.out.println("newsub first= " + newSub);
        newSub = newSub + str1.substring(indexForHelp+1,str1.length());
        //System.out.println("newsub second= "+ newSub);
        str1 = newSub;
       }
        return newSub;
    }

    /**
     * Returns a string consisting of the given string, with the given 
     * character inserted randomly somewhere in the string.
     * For example, insertRandomly("s","cat") can return "scat", or "csat", or "cast", or "cats".  
     * @param ch - a character
     * @param str - a string
     * @return a string consisting of str with ch inserted somewhere
     */
    public static String insertRandomly(char ch, String str) {
         // Generate a random index between 0 and str.length()
         int randomIndex = (int) (Math.random() * (str.length() + 1));
         // Insert the character at the random index
         String result = str.substring(0, randomIndex) + ch + str.substring(randomIndex);
         return result;
    }    
}
