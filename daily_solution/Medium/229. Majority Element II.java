class Solution {
    public List<Integer> majorityElement(int[] nums) {
        System.gc();
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer> result = new ArrayList<>();
        int equ = nums.length / 3;
        for (int key : map.keySet()) {
            if (map.get(key) > equ) {
                result.add(key);
            }
        }

        return result;
    }
}
