package com.fabianpinzon;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Challenge {
    public static void main(String[] args) {
        String challenge1 = "I want a bike.";
        System.out.println(challenge1.matches("I want a bike."));

        // RegExp "\\w+" matches from a to z, A to Z from 0 to 9 and _

        String challenge2 = "I want a ball.";

        String regExp = "I want a \\w+.";

        System.out.println(challenge1.matches(regExp));
        System.out.println(challenge2.matches(regExp));

        String regExp1 = "I want a (bike|ball).";

        System.out.println(challenge1.matches(regExp1));
        System.out.println(challenge2.matches(regExp1));

        Pattern pattern = Pattern.compile("I want a \\w+.");
        Matcher matcher = pattern.matcher(challenge1);
        System.out.println(matcher.matches());

        matcher = pattern.matcher(challenge2);
        System.out.println(matcher.matches());
        //"\\s" catches the white space characters
        String challenge4 = "Replace all blanks with underscores";
        System.out.println(challenge4.replaceAll(" ", "_"));
        System.out.println(challenge4.replaceAll("\\s", "_"));

        String challenge5 = "aaabccccccccdddefffg";
        String challenge5Test = "a baby with blue eyes";
        System.out.println(challenge5.matches("[abcdefg]+"));
        System.out.println(challenge5Test.matches("[abywithlues ]+"));
        System.out.println(challenge5.matches("[a-g]+"));
        System.out.println(challenge5.matches("^a{3}bc{8}d{3}ef{3}g$"));
        System.out.println(challenge5.replaceAll("^a{3}bc{8}d{3}ef{3}g$", "REPLACED"));

        //The String must start with letters then a period then digits

        String challenge7 = "abc.135";
        //The + means the string can contain more than 1 character or number
        //d for digits
        //$ means the last character must end with a digit
        String regexLettersDotNumbers = "^[a-z]+\\.\\d+$";
        System.out.println(challenge7.matches(regexLettersDotNumbers));

        //Print all occurrences of digits in the following string;
        String challenge8 = "abcd.135uvqz.7tzik.999";

        String digitPattern = "[A-Za-z]+\\.(\\d+)";

        Pattern digitExtractionPattern = Pattern.compile(digitPattern);
        Matcher digitExtractionMatcher = digitExtractionPattern.matcher(challenge8);
        while (digitExtractionMatcher.find()){
            System.out.println("Occurrence: " + digitExtractionMatcher.group(1));
        }

        System.out.println("print all digits preceded by a . and character and followed by a tab");
        String challenge9 = "abcd.135\tuvqz.7\ttzik.999\t";
        Pattern pattern9 = Pattern.compile("[A-Za-z]+\\.(\\d+)\\s");
        Matcher matcher9 = pattern9.matcher(challenge9);
        while (matcher9.find()){
            System.out.println("Occurrence: " + matcher9.group(1));
            System.out.println("Index start: " + matcher9.start(1) + ", Index end: " + (matcher9.end(1) -1));
        }

        //Extract any characters from the curly braces;

        String challenge11 = "{0, 2}, {0, 5}, {1, 3}, {2, 4}";
        //The . matches any character, the + says we expect at least 1 character
        Pattern pattern11 = Pattern.compile("\\{(.+?)\\}");
        Matcher matcher11 = pattern11.matcher(challenge11);
        while (matcher11.find()){
            System.out.println("Occurrence: " + matcher11.group(1));
        }

        System.out.println("************");
        //Extract only numbers and the commas from the curly braces;
        String challenge11a = "{0, 2}, {0, 5}, {x, y}, {12, 33}";
        Pattern pattern11a = Pattern.compile("\\{(\\d+, \\d+)\\}");
        Matcher matcher11a = pattern11a.matcher(challenge11a);
        while(matcher11a.find()){
            System.out.println("Occurrence: " + matcher11a.group(1));
        }

        //Match digits (us zip code)
        String zip = "11111";
        System.out.println(zip.matches("^\\d{5}$"));

        String zip2 = "11111-1111";
        System.out.println(zip2.matches("^\\d{5}-\\d{4}$"));

        //Match first 5 digits and the - and the4 digits are optional
        System.out.println("******");
        System.out.println(zip.matches("^\\d{5}(-\\d{4})?$"));
        System.out.println(zip2.matches("^\\d{5}(-\\d{4})?$"));

    }
}
