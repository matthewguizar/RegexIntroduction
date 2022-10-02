import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        //{quanitfier} checks for 3 e's to find match
        System.out.println(alphanumeric.replaceAll("^abcDe{3}", "YYY"));
        //+ checks to see if there are E's after no matter the number
        System.out.println(newAlphanumeric.replaceAll("^abcDe+", "yyy"));
        //checks if there are e's but work even if there aren't
        System.out.println(alphanumeric.replaceAll("^abcDe*", "xxx"));

        //checking for a range EX: 2-5 e's in string
        System.out.println(alphanumeric.replaceAll("^abcDe{2,5}", "lol"));
        //removes all occurences of H followed by any number of I's , followed by at least one J that come after I
        System.out.println(alphanumeric.replaceAll("h+i*j", "Y"));


        StringBuilder htmlText = new StringBuilder("<h1> My heading</h1>");
        htmlText.append("<h2>sub-heading</h2>");
        htmlText.append("<p> this is a paragraph about something</p>");
        htmlText.append("<p> another paragraph about something else</p>");
        htmlText.append("<h2>summary</h2>");
        htmlText.append("<p>here is the summary.</p>");
//      " . " matches every character and "*" matches every <h2>
        String h2Pattern = ".*<h2>.*";
        String regexPattern = "<h2>";
        //Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE
        Pattern pattern = Pattern.compile(regexPattern);
        Matcher matcher = pattern.matcher(htmlText);
        System.out.println(matcher.matches());
       
        //matches only occures once
        matcher.reset();
        int count = 0;
        while(matcher.find()){
            count++;
            System.out.println("Occurence " + count + " :" + matcher.start() + " to " + matcher.end());
        }
        // meanns every h2 tag and everything inbetween 
        //* == greedy quanitfier but adding ? makes it lazy
        String h2GroupPattern = "(<h2>.*?</h2>)";
        Pattern groupPattern = Pattern.compile(h2GroupPattern);
        Matcher groupMatcher = groupPattern.matcher(htmlText);
        System.out.println(groupMatcher.matches());
        groupMatcher.reset();

        while (groupMatcher.find()) {
            System.out.println("Occurence: " + groupMatcher.group(1));
        }
    }
}