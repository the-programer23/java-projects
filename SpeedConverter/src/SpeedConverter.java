public class SpeedConverter {
    public static long toMilesPerHour(double kilometerPerHour) {
        if (kilometerPerHour < 0) {
            return -1;
        }
        return Math.round(kilometerPerHour / 1.609);
    }

    public static void printConversion(double kilometersPerHour) {
        if (kilometersPerHour < 0) {
            System.out.println("Invalid Value");
        } else {
            long milesPerHour = toMilesPerHour(kilometersPerHour);
            System.out.println(kilometersPerHour + " km/h = " + milesPerHour + " mi/h");
        }
    }

    public static void printMegaBytesAndKiloBytes(int kiloBytes) {
        if (kiloBytes < 0) {
            System.out.println("Invalid Value");
        } else {
            int YY = kiloBytes / 1024;
            int ZZ = kiloBytes % 1024;
            System.out.println(kiloBytes + "KB" + " = " + YY + "MB and " + ZZ + " KB");
        }
    }

    public static boolean shouldWakeUp(boolean barking, int hourOfDay) {

        if (!barking) {
            return false;
        } else if (hourOfDay < 0 || hourOfDay > 23) {
            return false;
        } else return hourOfDay < 8 || hourOfDay > 22;
    }

    public static boolean isLeapYear(int year) {
        if (year >= 1 && year <= 9999) {
            if (year % 4 == 0) {
                if (year % 100 == 0) {
                    if (year % 400 == 0) {
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    return true;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public static boolean areEqualByThreeDecimalPlaces(double firstNum, double secondNum) {
        firstNum *= 1000;
        secondNum *= 1000;

        if ((int)firstNum == (int)secondNum) {
            return true;
        }
        return false;
    }

    public static boolean hasEqualSum(int firstNum, int secondNum, int thirdNum) {
        if(firstNum + secondNum == thirdNum){
            return true;
        }else {
            return false;
        }
    }

    public static boolean hasTeen(int first, int second, int third){
        if(first >= 13 && first<=19 || second >= 13 && second<=19 || third >= 13 && third<=19){
            return true;
        }else {
            return false;
        }
    }

    public static boolean isTeen(int person) {
        if(person >= 13 && person<=19){
            return true;
        }else {
            return false;
        }
    }
}
