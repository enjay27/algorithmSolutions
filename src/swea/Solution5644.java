package swea;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Solution5644 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        int[] moveX = {0, 0, 1, 0, -1};
        int[] moveY = {0, -1, 0, 1, 0};

        for (int tc = 1; tc <= test; tc++) {
            int moveCount = sc.nextInt();
            int chargerNumber = sc.nextInt();

            int[] moveA = new int[moveCount + 1];
            int[] moveB = new int[moveCount + 1];
            moveA[0] = 0;
            moveB[0] = 0;
            for (int i = 1; i <= moveCount; i++) {
                moveA[i] = sc.nextInt();
            }

            for (int i = 1; i <= moveCount; i++) {
                moveB[i] = sc.nextInt();
            }

            Charger[] chargers = new Charger[chargerNumber];

            for (int i = 0; i < chargerNumber; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                int range = sc.nextInt();
                int power = sc.nextInt();
                chargers[i] = new Charger(x, y, range, power);
            }

            Point personA = new Point(1, 1);
            Point personB = new Point(10, 10);

            List<Charger> chargerA = new ArrayList<>();
            List<Charger> chargerB = new ArrayList<>();
            int powerSum = 0;
            for (int i = 0; i <= moveCount; i++) {
                personA.x += moveX[moveA[i]];
                personA.y += moveY[moveA[i]];
                personB.x += moveX[moveB[i]];
                personB.y += moveY[moveB[i]];
                chargerA.clear();
                chargerB.clear();
                for (int j = 0; j < chargerNumber; j++) {
                    if (isCharged(personA, chargers[j])) {
                        chargerA.add(chargers[j]);
                    }
                    if (isCharged(personB, chargers[j])) {
                        chargerB.add(chargers[j]);
                    }
                }
                if (chargerA.size() == 0) {
                    if (!chargerB.isEmpty())
                        powerSum += chargerB.stream().mapToInt(Charger::getPower).max().getAsInt();
                } else if (chargerB.size() == 0) {
                    powerSum += chargerA.stream().mapToInt(Charger::getPower).max().getAsInt();
                } else {
                    chargerA.sort((a, b) -> b.power - a.power);
                    chargerB.sort((a, b) -> b.power - a.power);
                    if (chargerA.get(0).equals(chargerB.get(0))) {
                        int max = chargerA.get(0).power;
                        powerSum += max;
                        if (chargerA.size() > 1 && chargerB.size() > 1) {
                            powerSum += Math.max(chargerA.get(1).power, chargerB.get(1).power);
//                            powerSum += Math.max(max / 2, Math.max(chargerA.get(1).power, chargerB.get(1).power));
                        } else {
                            if (chargerA.size() > 1) {
                                powerSum += chargerA.get(1).power;
//                                powerSum += Math.max(max / 2, chargerA.get(1).power);
                            } else if (chargerB.size() > 1) {
                                powerSum += chargerB.get(1).power;
//                                powerSum += Math.max(max / 2, chargerB.get(1).power);
                            }
                        }
                    } else {
                        powerSum += chargerA.get(0).power + chargerB.get(0).power;
                    }
                }
            }
            System.out.printf("#%d %d\n", tc, powerSum);
        }
    }

    static boolean isCharged(Point person, Charger charger) {
        return Math.abs(person.x - charger.x) + Math.abs(person.y - charger.y) <= charger.range;
    }

    static class Charger {
        int x;
        int y;
        int range;
        int power;

        public Charger(int x, int y, int range, int power) {
            this.x = x;
            this.y = y;
            this.range = range;
            this.power = power;
        }

        public int getPower() {
            return power;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Charger charger = (Charger) o;
            return x == charger.x && y == charger.y && range == charger.range && power == charger.power;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y, range, power);
        }
    }

}
