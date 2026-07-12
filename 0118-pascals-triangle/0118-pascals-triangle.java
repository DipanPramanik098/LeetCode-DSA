class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> v = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> a = new ArrayList<>(Collections.nCopies(i + 1, 0));
            v.add(a);

            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    v.get(i).set(j, 1);
                } else {
                    int val = v.get(i - 1).get(j - 1) + v.get(i - 1).get(j);
                    v.get(i).set(j, val);
                }
            }
        }

        return v;
    }
}