class Solution {
    static final class Event {
        double y, x1, x2;
        int delta;
        Event(double y, double x1, double x2, int delta) {
            this.y = y; 
            this.x1 = x1; 
            this.x2 = x2; 
            this.delta = delta;
        }
    }

    static final class Slab {
        double y, nextY, coverX, pref;
        Slab(double y, double nextY, double coverX, double pref) {
            this.y = y; 
            this.nextY = nextY; 
            this.coverX = coverX; 
            this.pref = pref;
        }
    }

    static final class SegTree {
        final int n;
        final int[] cover;
        final double[] len;
        final double[] xs;

        SegTree(double[] xs) {
            this.xs = xs;
            this.n = xs.length - 1;
            int sz = 4 * Math.max(1, n);
            this.cover = new int[sz];
            this.len = new double[sz];
        }

        void add(int ql, int qr, int delta) {
            if (ql >= qr || n <= 0) return;
            add(1, 0, n, ql, qr, delta);
        }

        private void add(int node, int l, int r, int ql, int qr, int delta) {
            if (qr <= l || r <= ql) return;
            if (ql <= l && r <= qr) {
                cover[node] += delta;
                pull(node, l, r);
                return;
            }
            int m = (l + r) >>> 1;
            add(node << 1, l, m, ql, qr, delta);
            add(node << 1 | 1, m, r, ql, qr, delta);
            pull(node, l, r);
        }

        private void pull(int node, int l, int r) {
            if (cover[node] > 0) len[node] = xs[r] - xs[l];
            else if (r - l == 1) len[node] = 0.0;
            else len[node] = len[node << 1] + len[node << 1 | 1];
        }

        double covered() { 
            return (n <= 0) ? 0.0 : len[1]; 
        }
    }

    public double separateSquares(int[][] squares) {
        int n = squares.length;

        double[] xs = new double[2 * n];
        Event[] ev = new Event[2 * n];
        int xi = 0, ei = 0;
        for (int[] s : squares) {
            double x1 = s[0], y1 = s[1], side = s[2];
            double x2 = x1 + side, y2 = y1 + side;
            xs[xi++] = x1; xs[xi++] = x2;
            ev[ei++] = new Event(y1, x1, x2, +1);
            ev[ei++] = new Event(y2, x1, x2, -1);
        }

        Arrays.sort(xs);
        double[] xuniq = new double[xs.length];
        int k = 0;
        for (int i = 0; i < xs.length; i++) if (i == 0 || xs[i] != xs[i - 1]) xuniq[k++] = xs[i];
        xuniq = Arrays.copyOf(xuniq, k);

        Arrays.sort(ev, Comparator.comparingDouble(a -> a.y));
        SegTree st = new SegTree(xuniq);

        ArrayList<Slab> slabs = new ArrayList<>();
        double area = 0.0;

        int idx = 0;
        while (idx < ev.length) {
            double y = ev[idx].y;

            while (idx < ev.length && ev[idx].y == y) {
                int l = Arrays.binarySearch(xuniq, ev[idx].x1);
                int r = Arrays.binarySearch(xuniq, ev[idx].x2);
                st.add(l, r, ev[idx].delta);
                idx++;
            }

            if (idx >= ev.length) break;
            double nextY = ev[idx].y;
            double dy = nextY - y;
            if (dy <= 0) continue;

            double coverX = st.covered();
            slabs.add(new Slab(y, nextY, coverX, area));
            area += coverX * dy;
        }

        double half = area / 2.0;

        for (Slab s : slabs) {
            double slabArea = s.coverX * (s.nextY - s.y);
            if (half <= s.pref + slabArea + 1e-15) {
                if (s.coverX == 0.0) return s.y;
                return s.y + (half - s.pref) / s.coverX;
            }
        }
        return slabs.isEmpty() ? squares[0][1] : slabs.get(slabs.size() - 1).nextY;
    }
}
