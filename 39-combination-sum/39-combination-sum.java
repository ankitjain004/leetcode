class Solution {
    List<List<Integer>> list;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        combinationSumUtils(candidates, 0, temp, 0, target);

        return list;
    }

    public void combinationSumUtils(int[] candidates, int index, List<Integer> temp, int currSum, int target) {
        if (index > candidates.length - 1) return;
        if (currSum > target) return;
        if (currSum == target) {
            list.add(new ArrayList<>(temp));
            return;
        }
        temp.add(candidates[index]);
        combinationSumUtils(candidates, index, temp, currSum + candidates[index], target);
        temp.remove(temp.size() - 1);
        combinationSumUtils(candidates, index + 1, temp, currSum, target);
    }

}