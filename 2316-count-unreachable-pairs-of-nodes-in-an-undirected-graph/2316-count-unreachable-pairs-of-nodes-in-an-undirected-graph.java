class Solution {

    // Parent Array
    static ArrayList<Integer> parent = new ArrayList<>();

    // Rank Array
    static ArrayList<Integer> rank = new ArrayList<>();

    public static int find(int node) {

        if (parent.get(node) == node)
            return node;

        int ultimateParent = find(parent.get(node));

        parent.set(node, ultimateParent);

        return ultimateParent;
    }

    public static void union(int u, int v) {

        int up_u = find(u);
        int up_v = find(v);

        if (up_u == up_v)
            return;

        if (rank.get(up_u) > rank.get(up_v)) {

            parent.set(up_v, up_u);

        } else if (rank.get(up_v) > rank.get(up_u)) {

            parent.set(up_u, up_v);

        } else {

            parent.set(up_v, up_u);

            rank.set(up_u, rank.get(up_u) + 1);
        }
    }

    public long countPairs(int n, int[][] edges) {

        parent.clear();
        rank.clear();

        for (int i = 0; i < n; i++) {

            parent.add(i);
            rank.add(0);
        }

        // Build connected components
        for (int[] edge : edges) {

            union(edge[0], edge[1]);
        }

        // Parent -> Component Size
        HashMap<Integer, Integer> mp = new HashMap<>();

        for (int i = 0; i < n; i++) {

            int p = find(i);

            mp.put(p, mp.getOrDefault(p, 0) + 1);
        }

        long res = 0;

        int remain = n;

        for (int size : mp.values()) {

            res += (long) size * (remain - size);

            remain -= size;
        }

        return res;
    }
}