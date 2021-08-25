package graph;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Kruskal {

    static int V, E;
    static int[][] edge;
    static int[] parents;

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("mst.txt"));
        Scanner sc = new Scanner(System.in);
        V = sc.nextInt();
        E = sc.nextInt();
        edge = new int[E][3];
        for (int i = 0; i < E; i++) {
            edge[i][0] = sc.nextInt();
            edge[i][1] = sc.nextInt();
            edge[i][2] = sc.nextInt();
        }

        Arrays.sort(edge, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {

                return Integer.compare(o1[2], o2[2]);
            }
        });

        parents = new int[V];
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }
        int count = 0;
        int reply = 0;
        for (int i = 0; i < E; i++) {
            if (findSet(edge[i][0]) != findSet(edge[i][1])) {
                count++;
                union(edge[i][0], edge[i][1]);
                reply += edge[1][2];
                if (count == V - 1) break;
            }
        }

    }

    static int findSet(int i) {
        if (parents[i] == i) return i;
        return findSet(parents[i]);
    }

    static void union(int i, int j) {
        int pi = findSet(i);
        int pj = findSet(j);
        if (pi >= pj) parents[pi] = pj;
        else parents[pj] = pi;
    }
}
