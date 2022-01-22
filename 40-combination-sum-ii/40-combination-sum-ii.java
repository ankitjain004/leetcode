class Solution {
    List<List<Integer>> solution = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(candidates);
        int index = 0;
        combinationSum2Utils(candidates, target, 0, temp, 0);
        return solution;
    }

    public void combinationSum2Utils(int[] candidates, int target, int currSum, List<Integer> temp, int index) {
        int n = candidates.length;
        if (currSum == target) {
            solution.add(new ArrayList<>(temp));
            return;
        }
        if(currSum>target) return;

        for (int i = index; i < n; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) continue;
            if(candidates[i]>target) break;
            temp.add(candidates[i]);
            combinationSum2Utils(candidates, target, currSum + candidates[i], temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}