class Solution {
    public int largestAltitude(int[] gain) {
        int altitude=0;
        int maxAltitude=0;

        for(int g=0;g<gain.length;g++){
            altitude+=gain[g];
            maxAltitude=Math.max(maxAltitude,altitude);
        }
    return maxAltitude;   
    }
}