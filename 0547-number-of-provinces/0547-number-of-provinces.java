class Solution {
    public static void dfs(HashMap<Integer, ArrayList<Integer>> graph, int v, HashSet<Integer> vis){
        vis.add(v);
        for(int nbr : graph.get(v)){
            if(!vis.contains(nbr)){
                dfs(graph, nbr, vis);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        // Build graph first
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        
        // Initilize
        for(int i=1; i<=isConnected.length; i++){
            graph.put(i, new ArrayList<>());
        }

        int n= isConnected.length;
        // add edge
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(isConnected[i][j] == 1){
                    graph.get(i+1).add(j+1);
                    graph.get(j+1).add(i+1);
                }
            }
        }
        // graph created

        int count = 0;
        // dfs call
        HashSet<Integer> vis = new HashSet<>();
        for(int i=1;i<=n; i++){
            if(!vis.contains(i)){
                dfs(graph, i, vis);
                count++;
            }
        }
        return count;
    }
}