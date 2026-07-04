class Solution {
    public int findKthPositive(int[] arr, int k) {
        int n = arr.length;
        int missingCount =0;
        int current =1;
        int index =0;
        while (true) {
            if (index < n && arr[index] ==current){
                index++;
            } else {
                missingCount++;
                if(missingCount ==k){
                    return current;
                }
            }
            current++;
        }

        }
    }
