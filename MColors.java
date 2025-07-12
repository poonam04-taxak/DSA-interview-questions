
public class MColors {
    
    public static boolean graphColoring(boolean[][] graph, int m, int n) {
        int[] color = new int[n]; // color[i] = 0 means uncolored
        return solve(0, color, graph, m, n);
    }

    private static boolean solve(int node, int[] color, boolean[][] graph, int m, int n) {
        if (node == n) {
            return true; // all vertices are colored
        }

        for (int c = 1; c <= m; c++) {
            if (isSafe(node, color, graph, n, c)) {
                color[node] = c; // assign color
                if (solve(node + 1, color, graph, m, n)) {
                    return true;
                }
                color[node] = 0; // backtrack
            }
        }
        return false; // no color fits
    }

    private static boolean isSafe(int node, int[] color, boolean[][] graph, int n, int c) {
        for (int k = 0; k < n; k++) {
            if (graph[node][k] && color[k] == c) {
                return false; // adjacent has same color
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 4; // vertices
        int m = 3; // colors

        // Example graph:
        // 0-1
        // | |
        // 2-3
        boolean[][] graph = {
            {false, true, true, false},
            {true, false, true, true},
            {true, true, false, true},
            {false, true, true, false}
        };

        if (graphColoring(graph, m, n)) {
            System.out.println("Coloring is possible with " + m + " colors.");
        } else {
            System.out.println("Coloring is NOT possible with " + m + " colors.");
        }
    }
}
