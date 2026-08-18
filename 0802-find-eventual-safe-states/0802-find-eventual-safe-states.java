class Solution {
    public static boolean dfs(
            int v,
            List<List<Integer>> g,
            int[] vis,
            int[] path,
            int[] check
    ) {

        // Mark node as visited
        vis[v] = 1;

        // Mark node as part of current DFS path
        path[v] = 1;

        // Visit all neighbours
        for (int nbr : g.get(v)) {

            // If neighbour is not visited
            if (vis[nbr] == 0) {

                // If cycle is found
                if (dfs(nbr, g, vis, path, check)) {
                    return true;
                }

            }

            // Neighbour is already in current DFS path
            else if (path[nbr] == 1) {

                // Cycle detected
                return true;
            }
        }

        // Remove node from current DFS path
        path[v] = 0;

        // No cycle found, so node is safe
        check[v] = 1;

        return false;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {

        int V = graph.length;

        // Convert int[][] to adjacency list
        List<List<Integer>> g = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            g.add(new ArrayList<>());

            for (int nbr : graph[i]) {
                g.get(i).add(nbr);
            }
        }

        int[] vis = new int[V];
        int[] path = new int[V];
        int[] check = new int[V];

        // Run DFS for every node
        for (int i = 0; i < V; i++) {

            if (vis[i] == 0) {
                dfs(i, g, vis, path, check);
            }
        }

        // Collect safe nodes
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < V; i++) {

            if (check[i] == 1) {
                ans.add(i);
            }
        }

        return ans;
    }
}
