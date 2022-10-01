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
        
    }
}