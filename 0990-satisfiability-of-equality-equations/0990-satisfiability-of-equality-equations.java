class Solution {

    static ArrayList<Integer> parent = new ArrayList<>();
    static ArrayList<Integer> rank = new ArrayList<>();

    public static int find(int node) {

        if(parent.get(node) == node)
            return node;

        int ultimateParent = find(parent.get(node));

        parent.set(node, ultimateParent);

        return parent.get(node);
    }

    public static void union(int u, int v) {

        int up_u = find(u);
        int up_v = find(v);

        if(up_u == up_v)
            return;

        if(rank.get(up_u) > rank.get(up_v)) {

            parent.set(up_v, up_u);

        }
        else if(rank.get(up_v) > rank.get(up_u)) {

            parent.set(up_u, up_v);

        }
        else {

            parent.set(up_v, up_u);

            rank.set(up_u, rank.get(up_u) + 1);
        }
    }

    public boolean equationsPossible(String[] equations) {

        parent.clear();
        rank.clear();

        for(int i = 0; i < 26; i++) {
            parent.add(i);
            rank.add(0);
        }

        // Process all ==
        for(String eq : equations) {

            if(eq.charAt(1) == '=') {

                int u = eq.charAt(0) - 'a';
                int v = eq.charAt(3) - 'a';

                union(u, v);
            }
        }

        // Check all !=
        for(String eq : equations) {

            if(eq.charAt(1) == '!') {

                int u = eq.charAt(0) - 'a';
                int v = eq.charAt(3) - 'a';

                if(find(u) == find(v))
                    return false;
            }
        }

        return true;
    }
}