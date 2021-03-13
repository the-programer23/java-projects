package com.fabianpinzon;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
         String wrongName = "Favian Pinzon";
         String correctName = wrongName.replaceAll("v", "b");
        System.out.println(correctName);

        String alphaNumeric = "abcdEfg1234HJ56KKKKlll";
        System.out.println(alphaNumeric.replaceAll(".", "Y"));

        String badWord = "I hate you";
        System.out.println(badWord.replaceAll("^I hate", "I love"));

        String badWord2 = "I hate you, I hate you";
        System.out.println(badWord2.replaceAll("^I hate", "I admire"));
        System.out.println("***********Matches Method*************");
        System.out.println(badWord.matches("^hello"));
        //The matches method expects the whole string to return true
        System.out.println(badWord.matches("^I hate you"));

        String typoAtTheEnd = "My father wanted to speak to his motha";
        System.out.println(typoAtTheEnd.replaceAll("motha$", "mother"));

        String typoAtTheEnd2 = "My mother was crying because she thought she lost her doggy";
        System.out.println(typoAtTheEnd2.replaceAll("doggy$", "dog"));

        String typoAtTheBeginning = "bat da doggy was hiding in my mother's apartment";
        System.out.println(typoAtTheBeginning.replaceAll("^bat da doggy", "but the dog"));

        String hideFewChars = "Explanation";
        System.out.println(hideFewChars.replaceAll("[Expio]", "*"));

        String crypticMessage = "I asked three people if they saw the dog";
        //a or h get replaced by X if it is followed by s or r
        System.out.println(crypticMessage.replaceAll("[ah][sr]", "X"));

        System.out.println("harry".replaceAll("[Hh]arry", "Harry"));

        String newAlphaNumeric = "abcDeeeeF12Ghiiiijkl99z";
        //Replace everything except e and j
        System.out.println(newAlphaNumeric.replaceAll("[^ej]", "X"));
        //Regular expressions are case sensitive
        System.out.println(newAlphaNumeric.replaceAll("[abcde]", "X"));
        System.out.println(newAlphaNumeric.replaceAll("[a-fA-F3-8]", "X"));
        System.out.println(alphaNumeric.replaceAll("(?i)[a-f3-8]", "X"));
        //Replace digits in the string
        System.out.println(newAlphaNumeric.replaceAll("[0-9]", "X"));
        System.out.println(newAlphaNumeric.replaceAll("\\d", "X"));
        /////////////////////////
        //Replace all non digits
        System.out.println(newAlphaNumeric.replaceAll("\\D", "A"));
        //Remove white space and new lines from string
        System.out.println("****************");
        String hasWhiteSpace = "I have blanks and a tab\t, and also a new line\n";

        System.out.println(hasWhiteSpace);

        //remove all white space characters
        System.out.println(hasWhiteSpace.replaceAll("\\s", ""));
        //replace tab in string
        System.out.println(hasWhiteSpace.replaceAll("\t", ""));
        //Replace all characters, digits and underscore except white space
        System.out.println(hasWhiteSpace.replaceAll("\\w", "x"));
        //"\\W" replaces everything except characters, digits and underscore
        System.out.println(hasWhiteSpace.replaceAll("\\W", "X"));
        //"\\b" surrounds each word with the replacement
        System.out.println(hasWhiteSpace.replaceAll("\\b", "♡"));
        //"^" replaces at the beginning of the string
        System.out.println(hasWhiteSpace.replaceAll("^I have", "I got"));

        //Quantifiers
        String password = "abc444cde";
        //There has to be 3 fours after c
        System.out.println(password.replaceAll("^abc4{3}", "555"));
        //It removes all fours after c
        System.out.println(password.replaceAll("^abc4+", "555"));
        System.out.println(password.replaceAll("^abc4*", "555"));
        //if there are 1 to 3 fours after c then replace
        System.out.println(password.replaceAll("^abc4{1,3}", "555"));

        //Replace with X all occurrences of f followed by any number of g followed by at least 1 h
        //It is case sensitive
        String password2 = "abc555def666Ffggghhh1kl";
        System.out.println(password2.replaceAll("f+g*h", "X"));

        System.out.println("\n******************");
        StringBuilder htmlText = new StringBuilder("<h1>My heading</h1>");
        htmlText.append("<h2>Sub-heading</h2>");
        htmlText.append("<p>This is a paragraph about something</p>");
        htmlText.append("<p>This is another paragraph</p>");
        htmlText.append("<h2>Summary</h2>");


        //Match anything before and anything after the h2
        String h2Pattern = ".*<h2>.*";
        Pattern pattern = Pattern.compile(h2Pattern);
        Matcher matcher = pattern.matcher(htmlText);
        //Check if pattern is in StringBuilder
        System.out.println(matcher.matches());

        //matcher.reset() is user when using the same matcher
        //matcher.reset();
        //Check occurrences of <p> in htmlText and pinpoint the index where it starts and ends
        String pPattern = "<p>";
        Pattern pattern2 = Pattern.compile(pPattern);
        Matcher matcher2 = pattern2.matcher(htmlText);

        int count = 0;
        while(matcher2.find()){
            count++;
            System.out.println("Occurrence " + count + " : " + matcher2.start() + " to " + matcher2.end());
        }
        //We want the opening and closing h2 tag and everything in between. . means any character and * quantifier means 0 or more

        //Get all h2 elements and their content in the htmlText
        //This is a greedy quantifier
        String h2GroupPattern = "(<h2>.*</h2>)";
        Pattern groupPattern = Pattern.compile(h2GroupPattern);
        Matcher groupMatcher = groupPattern.matcher(htmlText);

        System.out.println(groupMatcher.matches());
        //groupMatcher.reset() was called because I am using groupMatcher again in the while loop
        groupMatcher.reset();


        while(groupMatcher.find()){
            System.out.println("Occurrence: " + groupMatcher.group(1));
        }

        //This is a lazy quantifier
        String h2GroupPattern2 = "(<h2>.*?</h2>)";
        Pattern GroupPattern2 = Pattern.compile(h2GroupPattern2);
        Matcher matcherPattern2 = GroupPattern2.matcher(htmlText);

        while(matcherPattern2.find()){
            System.out.println("Occurrence: " + matcherPattern2.group(1));
        }

        //Extract text between h2 elements
        String h2TextPattern = "(<h2>)(.+?)(</h2>)";
        Pattern textPattern = Pattern.compile(h2TextPattern);
        Matcher matcherTextPattern = textPattern.matcher(htmlText);

        while(matcherTextPattern.find()){
            System.out.println("Occurrence: " + matcherTextPattern.group(2));
        }
    }
}
