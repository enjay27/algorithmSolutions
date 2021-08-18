package baekjoon;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution2839_withMapping {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int sugar = sc.nextInt();

        int add = 0;
        if (sugar > 15) {
            add = sugar / 15 - 1;
            sugar = sugar % 15 + 15;
        }

        Map<Integer, Integer> resultMap = new HashMap<>();
        resultMap.put(1, -1);resultMap.put(2, -1);resultMap.put(3, 1);resultMap.put(4, -1);
        resultMap.put(5, 1);resultMap.put(6, 2);resultMap.put(7, -1);resultMap.put(8, 2);
        resultMap.put(9, 3);resultMap.put(10, 2);resultMap.put(11, 3);resultMap.put(12, 4);
        resultMap.put(13, 3);resultMap.put(14, 4);resultMap.put(15, 3);resultMap.put(16, 4);
        resultMap.put(17, 5);resultMap.put(18, 4);resultMap.put(19, 5);resultMap.put(20, 4);
        resultMap.put(21, 5);resultMap.put(22, 6);resultMap.put(23, 5);resultMap.put(24, 6);
        resultMap.put(25, 5);resultMap.put(26, 6);resultMap.put(27, 7);resultMap.put(28, 6);
        resultMap.put(29, 7);

        int result = resultMap.get(sugar);
        if (result == -1) {
            System.out.println(-1);
        } else {
            System.out.println(add * 3 + result);
        }
    }
}
