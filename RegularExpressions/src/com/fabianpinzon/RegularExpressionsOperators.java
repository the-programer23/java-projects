package com.fabianpinzon;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionsOperators {
    public static void main(String[] args) {
        //or operator (|)
        System.out.println("harry".replaceAll("[H|h]arry", "Larry"));
        System.out.println("Harry".replaceAll("[H|h]arry", "Larry"));


        String tvTest = "tstvtkt";
        //"t[^v]" finds all t NOT followed by v and with a character in front of it
        //String tNotVRegExp = "t[^v]";
        //"t(?!v)" finds all t NOT followed by v, include t at the end of the string tvTest which is not followed by any character
        String tNotVRegExp = "t(?!v)";
        Pattern tNotvPattern = Pattern.compile(tNotVRegExp);
        Matcher tNotvMatcher = tNotvPattern.matcher(tvTest);

        int count = 0;

        while (tNotvMatcher.find()){
            count++;
            System.out.println("Occurrence " + count + " : " + tNotvMatcher.start() + " to " + tNotvMatcher.end());
        }
        //Al matches of t followed by v
        String tFollowedByv = "t(?=v)";
        Pattern patternTFollowedByv = Pattern.compile(tFollowedByv);
        Matcher tFollowedvMatcher = patternTFollowedByv.matcher(tvTest);

        int count2 = 0;
        while (tFollowedvMatcher.find()){
            count2++;
            System.out.println("Occurrence " + count2 + " : " + tFollowedvMatcher.start() + " to " + tFollowedvMatcher.end());
        }

        //RegExp to validate US phone number ^(\([0-9]{3}\) |[0-9]{3}-)[0-9]{3}-[0-9]{4}$
        String phone1 = "123456789"; // shouldn't match
        String phone2 = "(123) 456-7890"; // match
        String phone3 = "123 456-7890"; // shouldn't match
        System.out.println("phone1: " + phone1.matches("^(\\([0-9]{3}\\) |[0-9]{3}-)[0-9]{3}-[0-9]{4}$"));
        System.out.println("phone2: " + phone2.matches("^(\\([0-9]{3}\\) |[0-9]{3}-)[0-9]{3}-[0-9]{4}$"));
        System.out.println("phone3: " + phone3.matches("^(\\([0-9]{3}\\) |[0-9]{3}-)[0-9]{3}-[0-9]{4}$"));

        //RegExp to validate Visa card ^4[0-9]{12}(?:[0-9]{3})?$
        //this means the card must contain 13 digits or 16 digits and the first one must start with 4
        String visa1 = "4444444444444"; // match
        String visa2 = "3444444444444"; //doesn't match
        String visa3 = "4444444444444555";// match
        String visa4 = "4444"; //doesn't match

        System.out.println("visa1 " + visa1.matches("^4[0-9]{12}([0-9]{3})?$"));
        System.out.println("visa2 " + visa2.matches("^4[0-9]{12}([0-9]{3})?$"));
        System.out.println("visa3 " + visa3.matches("^4[0-9]{12}([0-9]{3})?$"));
        System.out.println("visa4 " + visa4.matches("^4[0-9]{12}([0-9]{3})?$"));
    }
}
