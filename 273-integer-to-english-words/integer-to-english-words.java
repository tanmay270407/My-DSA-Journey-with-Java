class Solution {
    String[] below20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
                        "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
                        "Eighteen", "Nineteen"};
    String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    
    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        return helper(num).trim();
    }
    
    private String helper(int num) {
        if (num == 0) return "";
        
        if (num < 20) return below20[num];
        
        if (num < 100)
            return tens[num / 10] + (num % 10 != 0 ? " " + helper(num % 10) : "");
        
        if (num < 1000)
            return below20[num / 100] + " Hundred" + (num % 100 != 0 ? " " + helper(num % 100) : "");
        
        if (num < 1_000_000)
            return helper(num / 1000) + " Thousand" + (num % 1000 != 0 ? " " + helper(num % 1000) : "");
        
        if (num < 1_000_000_000)
            return helper(num / 1_000_000) + " Million" + (num % 1_000_000 != 0 ? " " + helper(num % 1_000_000) : "");
        
        return helper(num / 1_000_000_000) + " Billion" + (num % 1_000_000_000 != 0 ? " " + helper(num % 1_000_000_000) : "");
    }
}