package baekjoon;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Solution17135 {
    static List<Point> enemies = new ArrayList<>();
    static int width;
    static int height;
    static int range;
    static int maxScore = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        height = sc.nextInt();
        width = sc.nextInt();
        range = sc.nextInt();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (sc.nextInt() == 1) {
                    enemies.add(new Point(j, i));
                }
            }
        }

        combination(0, new ArrayList<>());

        System.out.println(maxScore);

    }

    static void combination(int index, List<Point> archers) {
        if (archers.size() == 3) {
            ArrayList<Point> enemyCopies = new ArrayList<>();
            for (Point enemy : enemies) {
                enemyCopies.add(new Point(enemy));
            }
            int score = 0;
            for (int i = 0; i < height; i++) {
                Set<Integer> killedEnemies = new HashSet<>();
                for (Point archer : archers) {
                    int minDistanceEnemy = -1;
                    int prevX = Integer.MAX_VALUE;
                    int minDistance = Integer.MAX_VALUE;
                    for (int j = 0; j < enemyCopies.size(); j++) {
                        if (enemyCopies.get(j) == null) continue;
                        if (enemyCopies.get(j).y >= height) continue;

                        int distance = Math.abs(enemyCopies.get(j).x - archer.x) + Math.abs(enemyCopies.get(j).y - archer.y);

                        if (distance > range) continue;
                        if (minDistance < distance) continue;

                        if (minDistance > distance) {
                            minDistance = distance;
                            prevX = enemyCopies.get(j).x;
                            minDistanceEnemy = j;
                        }
                        if (enemyCopies.get(j).x <= prevX) {
                            prevX = enemyCopies.get(j).x;
                            minDistanceEnemy = j;
                        }
                    }
                    if (minDistanceEnemy != -1)
                        killedEnemies.add(minDistanceEnemy);
                }

                for (Integer killedEnemy : killedEnemies) {
                    enemyCopies.set(killedEnemy, null);
                    score++;
                }

                for (Point enemyCopy : enemyCopies) {
                    if (enemyCopy != null)
                        enemyCopy.y++;
                }
            }
            maxScore = Math.max(score, maxScore);
            return;
        }

        if (index == width) {
            return;
        }

        if (index - archers.size() > width - 3) {
            return;
        }

        combination(index + 1, archers);

        archers.add(new Point(index, height));
        combination(index + 1, archers);
        archers.remove(archers.size() - 1);

    }
}
