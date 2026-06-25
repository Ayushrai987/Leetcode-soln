class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> freq = new HashMap<>();
       List<Integer> result = new ArrayList<>();



        for (int num : nums1){
            freq.put(num, freq.getOrDefault(num,0)+1);


        }
        for (int num : nums2){
            if(freq.containsKey(num) && freq.get(num)>0){
                result.add(num);
                freq.put(num, freq.get(num)-1);
            }
        }
        int[] output = new int[result.size()];
        for (int i =0; i<result.size(); i++){
            output[i]= result.get(i);
        }
        return output;

    }
}