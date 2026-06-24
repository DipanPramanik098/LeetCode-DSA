class Solution {

    // Parent Array
    static ArrayList<Integer> parent = new ArrayList<>();

    // Rank Array
    static ArrayList<Integer> rank = new ArrayList<>();

    public static int find(int node) {

        // Base Case
        if (parent.get(node) == node) {
            return node;
        }

        // Path Compression
        int ultimateParent = find(parent.get(node));

        parent.set(node, ultimateParent);

        return parent.get(node);
    }

    public static void union(int u, int v) {

        int up_u = find(u);
        int up_v = find(v);

        // Already in same component
        if (up_u == up_v) {
            return;
        }

        // Attach smaller rank tree
        // under larger rank tree

        if (rank.get(up_u) > rank.get(up_v)) {

            parent.set(up_v, up_u);

        } else if (rank.get(up_v) > rank.get(up_u)) {

            parent.set(up_u, up_v);

        } else {

            parent.set(up_v, up_u);

            rank.set(up_u, rank.get(up_u) + 1);
        }
    }
    public int makeConnected(int n, int[][] connections) {
        
        //check edge count
        int l = connections.length;
        if(l < n-1) return -1;
        
        // Initialize DSU
        parent.clear();
        rank.clear();

        for (int i = 0; i < n; i++) {

            parent.add(i);
            rank.add(0);
        }

        int component = n;

        for(int [] a : connections){
            if(find(a[0]) != find(a[1])){
                union(a[0],a[1]);
                component--;
            }
        }
        return component - 1;
    }
}