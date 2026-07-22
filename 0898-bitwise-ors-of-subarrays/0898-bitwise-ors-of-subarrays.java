class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> result = new HashSet<>();
        Set<Integer> current = new HashSet<>();

        for(int i=0; i<arr.length; i++){
            int num = arr[i];

            Set<Integer> next = new HashSet<>();
            next.add(num);

            for(int value : current){
                next.add(value | num);
            }
            result.addAll(next);
            current = next;
        }
        return result.size();
    }
}