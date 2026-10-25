const int N = 10001;
int root[N], Rank[N];
class UnionFind {
public:
    UnionFind(int n) {
        iota(root, root+n, 0);
        memset(Rank, 0, sizeof(int)*n);    
    }

    int find(int x) {
        return (x == root[x]) ? x : root[x] = find(root[x]);
    }

    bool Union(int x, int y) {
        x = find(x), y = find(y);
        if (x == y) return 0;
        if (Rank[x] > Rank[y]) swap(x, y);
        root[x] = y;
        Rank[y] += (Rank[x] == Rank[y]);
        return 1;
    }
};
class Solution {
public:
    static inline int idx(int i, int j, int m){ return i * m + j; }
    static int closedIsland(vector<vector<int>>& grid) {
        const int n = grid.size(), m = grid[0].size(), B = n * m;
        UnionFind G(B + 1);
        int count=0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    count++;
                    int id = i * m + j;
                    if (i == 0 || i == n-1 || j == 0 || j == m - 1) count -= G.Union(id, B);
                    if (j + 1 < m && grid[i][j + 1] == 0) count -= G.Union(id, id + 1);
                    if (i + 1 < n && grid[i + 1][j] == 0) count -= G.Union(id, id + m);
                }
            }
        }
        return count;
    }
};