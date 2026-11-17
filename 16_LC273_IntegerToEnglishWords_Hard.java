class Solution {
    private static final String[] BELOW_TWENTY = {
        "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
        "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen",
        "Seventeen", "Eighteen", "Nineteen"
    };

    private static final String[] TENS = {
        "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };

    private static final String[] THOUSANDS = {
        "", "Thousand", "Million", "Billion"
    };

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }

        int scaleIndex = 0;
        String words = "";

        while (num > 0) {
            int chunk = num % 1000;
            if (chunk != 0) {
                words = helper(chunk) + THOUSANDS[scaleIndex] + " " + words;
            }
            num /= 1000;
            scaleIndex++;
        }

        return words.trim();
    }

    private String helper(int n) {
        if (n == 0) {
            return "";
        } else if (n < 20) {
            return BELOW_TWENTY[n] + " ";
        } else if (n < 100) {
            return TENS[n / 10] + " " + helper(n % 10);
        } else {
            return BELOW_TWENTY[n / 100] + " Hundred " + helper(n % 100);
        }
    }
}
