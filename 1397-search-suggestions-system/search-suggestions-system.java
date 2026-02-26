class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> result=new ArrayList<>();
        Arrays.sort(products);
        String prefix="";
        

        for(char c : searchWord.toCharArray()){
            prefix+=c;
            List<String> list=new ArrayList<>();
    
            for(String product : products){
                if(product.startsWith(prefix)){
                    list.add(product);
                }
                if(list.size()==3){
                    break;
                }
            }
            result.add(list);
        }
        return result;
    }
}