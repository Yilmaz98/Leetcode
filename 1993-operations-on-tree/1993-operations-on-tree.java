class LockingTree {
        int[] parent;
        List<Integer>[] tree;
        Map<Integer, Integer> locked; // node, user.

        public LockingTree(int[] parent) {
            int n = parent.length;
            tree = new ArrayList[n];
            locked = new HashMap<>();
            this.parent = parent;

            for (int i = 0; i < n; i++)
                tree[i] = new ArrayList<>();
            for (int i = 1; i < n; i++)
                tree[parent[i]].add(i);
        }

        public boolean lock(int num, int user) {
            if (locked.containsKey(num)) return false;
            locked.put(num, user);
            return true;
        }

        public boolean unlock(int num, int user) {
            if (!locked.containsKey(num) || locked.get(num) != user) return false;
            locked.remove(num, user);
            return true;
        }

        public boolean upgrade(int num, int user) {
            if (locked.containsKey(num)) return false;

            // check if all the ancestor nodes are unlocked.
            int curr = num;
            while (curr != -1) {
                curr = parent[curr];
                if (locked.containsKey(curr))
                    return false;
            }

            // check if num has at least one locked descendant
            int tmp = locked.size();
            dfs(num);
            if (tmp == locked.size()) return false;

            locked.put(num, user);
            return true;
        }

        public void dfs(int src) {
            if (locked.containsKey(src))
                locked.remove(src);
            for (int nbr : tree[src])
                dfs(nbr);
        }
    }