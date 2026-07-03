class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int j=0;
        int ans=0;
        int[] map=new int[2001];
        int unique=0;

        for(int i=0;i<nums.length;i++) {
            map[nums[i]]++;
            if(map[nums[i]]==1) {
                unique++;
                ans=0;
            }
            while(j<i && map[nums[j]]>1) {
                map[nums[j]]--;
                j++;
            }
            ans+=j+1;
        }
        return ans; 
    }
}