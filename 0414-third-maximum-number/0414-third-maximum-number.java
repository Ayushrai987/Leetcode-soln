class Solution {
    public int thirdMax(int[] nums) {
        Set<Integer> ans = new HashSet<>();
        for (int num: nums){
          ans.add(num);
            
        }
        List<Integer> list = new ArrayList<>(ans);
        Collections.sort(list, Collections.reverseOrder());

        if (list.size() >= 3){
            return list.get(2);

        } else {
            return list.get(0);
        }
    }
}