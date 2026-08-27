class Solution {
    static class Edge{
        int src, dest, wt;
        public Edge(int s, int d, int w){
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    public static void createGraph(int [][] flights, int n, HashMap<Integer, ArrayList<Edge>> G){
        for(int i=0; i<n; i++){
            G.put(i, new ArrayList<>());
        }

        // add edge
        for(int i=0; i<flights.length; i++){
            int from = flights[i][0];
            int to = flights[i][1];
            int price = flights[i][2];
            G.get(from).add(new Edge(from, to, price));
        }
    }

    static class Pair{
        int node;
        int cost;
        int stops;

        Pair(int node, int cost, int stops) {
            this.node = node;
            this.cost = cost;
            this.stops = stops;
        }
    }
    public static int cheapestFlight(int n, int [][] flights, int src,int dest, int k, int [] dist, HashMap<Integer, ArrayList<Edge>> G){
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        Queue<Pair> pq = new LinkedList<>();

        pq.offer(new Pair(src, 0, 0));

        while(!pq.isEmpty()){
            Pair curr = pq.remove();
            if(curr.stops > k) break;
            // add curr nbrs
            for(Edge nbr : G.get(curr.node)){
                int u = nbr.src;
                int v = nbr.dest;
                int cost = nbr.wt;

                if(curr.cost + cost < dist[v] && curr.stops <= k){
                    dist[v] = curr.cost + cost;
                    pq.offer(new Pair(v, dist[v], curr.stops + 1));
                }
            }
        }
        return dist[dest] == Integer.MAX_VALUE ? -1 : dist[dest];
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        HashMap<Integer, ArrayList<Edge>> G = new HashMap<>();
        createGraph(flights, n, G);
        int [] dist = new int[n];
        return cheapestFlight(n,flights,src, dst, k, dist, G);
    }
}