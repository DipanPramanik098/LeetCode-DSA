class Solution {
        public boolean solve(HashMap<Integer, ArrayList<Integer>> graph, ArrayList<Integer> ans){
        // store indegree 
        HashMap<Integer, Integer> indegree = new HashMap<>();
        // Initilize with 0
        for(int node: graph.keySet()){
            indegree.put(node,0);
        }
        // calculate indegree
        for(int node: graph.keySet()){
            for(int nbr : graph.get(node)){
                indegree.put(nbr, indegree.get(nbr)+1);
            }
        }

        Queue<Integer>q = new LinkedList<>();

        //  add all indegree 0 node-- 
        for(int node : indegree.keySet()){
            if(indegree.get(node) == 0) q.offer(node);
        }

        int processed = 0;
        while(!q.isEmpty()){
            int c = q.poll();
            processed++;
            ans.add(c);
            for(int nbr: graph.get(c)){
                indegree.put(nbr, indegree.get(nbr)-1);

                if(indegree.get(nbr) == 0) q.offer(nbr);
            }
        }
        return processed == graph.size();
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Graph Banao
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        // Initialize graph
        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new ArrayList<>());
        }
        for(int[] pre : prerequisites){
            int u = pre[0];
            int v = pre[1];
            
            graph.get(v).add(u); // v -> u
        }
        ArrayList<Integer> ans = new ArrayList<>();

        if (solve(graph, ans)) {
            int[] result = new int[ans.size()];

            for (int i = 0; i < ans.size(); i++) {
                result[i] = ans.get(i);
            }

            return result;
        }

        return new int[0];
    }
}