public class Main {
    public static void main(String[] args) {
        String string = "I am a string. Yes, I am.";
        System.out.println(string);
        String yourString = string.replaceAll("I", "You");
        System.out.println(yourString);

        String alphanumeric = "abcDeeeF12Ghhiiiijkl99z";
        System.out.println(alphanumeric.replaceAll(".", "Y"));

        System.out.println(alphanumeric.replaceAll("^abcDeee", "YYY"));
        String second = "abcDeeeF12GhhabcDeeiiiijkl99z";
        System.out.println(second.replaceAll("^abcDeee", "YYY"));

        //entire expression must match for matches
        System.out.println(second.matches("abcDeeeF12GhhabcDeeiiiijkl99z"));
        System.out.println(alphanumeric.replaceAll("ijkl99z$", "THE END"));
        System.out.println(alphanumeric.replaceAll("[aei]", "X"));

        //removed if one of the letters from the first brackets are followed by any of the second letters
        System.out.println(alphanumeric.replaceAll("[aei][Fj]", "X"));
        
        System.out.println("harry".replaceAll("[Hh]arry", "Harry"));
        String newAlphanumeric = "abcDeeeF12Ghhiiiijkl99z";

        //replaces all characters not in the brackets
        System.out.println(newAlphanumeric.replaceAll("[^ej]", "X"));
        System.out.println(newAlphanumeric.replaceAll("[abcdef345678]", "X"));
        System.out.println(newAlphanumeric.replaceAll("[a-fA-F3-8]", "X"));

        //ignore case(case insensitivity)
        System.out.println(newAlphanumeric.replaceAll("(?i)[a-f3-9]", "X"));  


        //both replace 0-9
        System.out.println(newAlphanumeric.replaceAll("[0-9]", "X"));
        System.out.println(newAlphanumeric.replaceAll("\\d", "X"));

        //replaces all non digits
        System.out.println(newAlphanumeric.replaceAll("\\D", "X"));

        String whiteSpace = "I have blanks and \t a tab, and alos a new line \n";

        //removes all white space
        System.out.println(whiteSpace.replaceAll("\\s", ""));

        System.out.println(whiteSpace.replaceAll("\t", "X"));

        //removes all non white space characters
        System.out.println(whiteSpace.replaceAll("\\S", ""));

        //replaces A-Z, a-z, 0-9, and, _
        System.out.println(newAlphanumeric.replaceAll("\\w", "X"));
        //ignores A-Z, a-z, 0-9, and _
        System.out.println(newAlphanumeric.replaceAll("\\W", "X"));

        //each word becomes surrounded by replacement
        System.out.println(whiteSpace.replaceAll("\\b", "X"));

       
    }
}