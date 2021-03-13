package com.company;

public class Main {

    public static void main(String[] args) {
	    int myValue = 1000;

	    int myMinIntValue = Integer.MIN_VALUE;
	    int myMaxIntValue = Integer.MAX_VALUE;
        System.out.println("Integer Minimum  Value = " + myMinIntValue);
        System.out.println("Integer Maximum  Value = " + myMaxIntValue);
        System.out.println("Busted max value = " + (myMaxIntValue + 1));
        System.out.println("Busted min value = " + (myMinIntValue - 1));

        int myMaxIntTest = 2_147_483_647;

        byte myByteMinValue = Byte.MIN_VALUE;
        byte myByteMaxValue = Byte.MAX_VALUE;
        System.out.println("Byte minimum value = " + myByteMinValue);
        System.out.println("Byte maximum value = " + myByteMaxValue);

        short myShortMinValue = Short.MIN_VALUE;
        short myShortMaxValue = Short.MAX_VALUE;
        System.out.println("Short minimum value = " + myShortMinValue);
        System.out.println("Short maximum value = " + myShortMaxValue);
        
        long myLongValue = 2_147_483_647_153L;
        long myLongMinValue = Long.MIN_VALUE;
        long myLongMaxValue = Long.MAX_VALUE;
        System.out.println("Long minimum value = " + myLongMinValue);
        System.out.println("Long maximum value = " + myLongMaxValue);
        System.out.println(myLongValue);

        short bigShortLiteralValue = 32767;

        int myTotal = (myMinIntValue / 2);

        byte myNewByteValue = (byte) (myByteMinValue / 2);
        short myNewShortValue = (short) (myShortMinValue / 2);

        byte myChallengeByteNumber = 98;
        short myChallengeShortNumber = 1297;
        int myChallengeIntNumber = 1239;
        long myChallengeLongNumber = 50000L + 10L * (myChallengeByteNumber + myChallengeShortNumber + myChallengeIntNumber);

        System.out.println(myChallengeLongNumber);

        short myMostRecentShortValue =(short) (100 + 10 *
                (myChallengeByteNumber + myChallengeIntNumber));
    }
}
