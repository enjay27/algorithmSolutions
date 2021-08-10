package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution2941 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> alphabet = new ArrayList<>();
        alphabet.add("c=");
        alphabet.add("c-");
        alphabet.add("dz=");
        alphabet.add("d-");
        alphabet.add("lj");
        alphabet.add("nj");
        alphabet.add("s=");
        alphabet.add("z=");

        String input = sc.next();

        char[] chars = input.toCharArray();

        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (char aChar : chars) {
            sb.append(aChar);
            for (String s : alphabet) {
                if (sb.toString().contains(s)) {
                    count += sb.length() - s.length() + 1;
                    sb.setLength(0);
                    break;
                }
            }
        }

        count += sb.length();

        System.out.println("count = " + count);

    }
}
