package sort;

import java.util.*;

public class Sort {
    static Integer[] data1 = {3, 6, 2, 1, 4, 9, 7, 8, 5};
    static List<Integer> data2 = new ArrayList<>(Arrays.asList(3, 6, 2, 1, 4, 9, 7, 8, 5));
    static Node[] nodes = {new Node(3,1), new Node(2,2), new Node(5,2), new Node(1,3), new Node(4,2)};
    static List<Node> nodeList = new ArrayList<>(Arrays.asList(new Node(3, 1), new Node(2, 2), new Node(5, 2), new Node(1, 3), new Node(4, 2)));
    public static void main(String[] args) {
//        for (int i = 0; i < data1.length; i++) {
//            for (int j = 0; j < data1.length - 1; j++) {
//                if (data1[j] > data1[j + 1]) {
//                    int tmp = data1[j];
//                    data1[j] = data1[j + 1];
//                    data1[j + 1] = tmp;
//                }
//            }
//        }
        Arrays.sort(data1, (o1, o2) -> o2 - o1);
        System.out.println(Arrays.toString(data1));

        data2.sort((o1, o2) -> Integer.compare(o2, o1));
        System.out.println(data2);

        Arrays.sort(nodes, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.level != o2.level ? o1.level - o2.level : o1.idx - o2.idx;
            }
        });
        System.out.println(Arrays.toString(nodes));

        nodeList.sort(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.level != o2.level ? o1.level - o2.level : o1.idx - o2.idx;
            }
        });
        System.out.println(nodeList);
    }
}
