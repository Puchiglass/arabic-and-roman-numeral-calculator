public class Main {
    public static void main(String[] args) {
        java.util.Scanner in = new java.util.Scanner(System.in);
        String str = in.nextLine();
        System.out.println(calc(str));
    }

    public static String calc(String str{
        String[] arr = str.split(" ");
        if(arr.length > 3) System.err.println("throws Exception");

        int a, b, result = 0;

        if(isArab(arr[0].charAt(0)) && isArab(arr[2].charAt(0))){
            a = fromRoman(arr[0]);
            b = fromRoman(arr[2]);
        }
        else if(!isArab(arr[0].charAt(0)) && !isArab(arr[2].charAt(0))){
            a = Integer.parseInt(arr[0]);
            b = Integer.parseInt(arr[2]);
        }
        else {
            System.err.print("throws Exception");
            return "";
        }

        switch (arr[1]) {
            case "+" -> result = a + b;
            case "-" -> result = a - b;
            case "*" -> result = a * b;
            case "/" -> result = a / b;
        }

        if(isArab(arr[0].charAt(0)) && isArab(arr[2].charAt(0))){
            if(result > 0) return toRoman(result);
            else{
                System.err.print("throws Exception");
                return "";
            }
        }
        else if(!isArab(arr[0].charAt(0)) && !isArab(arr[2].charAt(0))){
            return String.valueOf(result);
        }
        System.err.print("throws Exception");
        return "";
    }
    private static boolean isArab(char ch){
        final char[] ARAB_NUMERAL = {'I', 'V', 'X'};

        for(char x : ARAB_NUMERAL){ if(x == ch) return true; }
        return false;
    }
    private static int fromRoman(String romanNumeral){
        final String[] ROMAN_NUMBERS = {"X", "IX", "V", "IV", "I"};
        final int[] ARABIC_NUMBERS = {10, 9, 5, 4, 1};

        String remainingValue = romanNumeral;
        int result = 0;

        for(int i = 0; i<ROMAN_NUMBERS.length; i++) {
            while(remainingValue.startsWith(ROMAN_NUMBERS[i])) {
                remainingValue = remainingValue.substring(ROMAN_NUMBERS[i].length());
                result += ARABIC_NUMBERS[i];
            }
        }
        return result;
    }
    private static String toRoman(int n){
        final String[] ROMAN_NUMBERS = {"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        final int[] ARABIC_NUMBERS = {100, 90, 50, 40, 10, 9, 5, 4, 1};
        int remainingValue = n;
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < ARABIC_NUMBERS.length; i++) {
            while (remainingValue >= ARABIC_NUMBERS[i]) {
                remainingValue -= ARABIC_NUMBERS[i];
                result.append(ROMAN_NUMBERS[i]);
            }
        }

        return result.toString();
    }

}