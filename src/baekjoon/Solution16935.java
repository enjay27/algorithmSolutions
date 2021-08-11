package baekjoon;

import java.util.Scanner;

public class Solution16935 {
    static int[][] rectangle = new int[100][100];
    static int height;
    static int width;
    static int times;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        height = sc.nextInt();
        width = sc.nextInt();
        times = sc.nextInt();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                rectangle[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < times; i++) {
            OperateType.getType(sc.nextInt()).operate();
        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(rectangle[i][j] + " ");
            }
            System.out.println();
        }
    }

    enum OperateType {
        REVERSE_UP_DOWN(1) {
            @Override
            void operate() {
                for (int i = 0; i < height / 2; i++) {
                    for (int j = 0; j < width; j++) {
                        int temp = rectangle[i][j];
                        rectangle[i][j] = rectangle[height - i - 1][j];
                        rectangle[height - i - 1][j] = temp;
                    }
                }
            }
        },
        REVERSE_LEFT_RIGHT(2) {
            @Override
            void operate() {
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < width / 2; j++) {
                        int temp = rectangle[i][j];
                        rectangle[i][j] = rectangle[i][width - j - 1];
                        rectangle[i][width - j - 1] = temp;
                    }
                }
            }
        },
        ROTATE_RIGHT(3) {
            @Override
            void operate() {
                int[][] tempArr = new int[width][height];
                for (int j = 0; j < width; j++) {
                    for (int i = height - 1; i >= 0; i--) {
                        tempArr[j][height - 1 - i] = rectangle[i][j];
                    }
                }
                int temp = width;
                width = height;
                height = temp;
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < width; j++) {
                        rectangle[i][j] = tempArr[i][j];
                    }
                }
            }
        },
        ROTATE_LEFT(4) {
            @Override
            void operate() {
                int[][] tempArr = new int[width][height];
                for (int j = width - 1; j >= 0; j--) {
                    for (int i = 0; i < height; i++) {
                        tempArr[width - 1 - j][i] = rectangle[i][j];
                    }
                }
                int temp = width;
                width = height;
                height = temp;
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < width; j++) {
                        rectangle[i][j] = tempArr[i][j];
                    }
                }
            }
        },
        DIVIDE_ROTATE_RIGHT(5) {
            @Override
            void operate() {
                int[][] tempArr = new int[height / 2][width / 2];

                for (int i = 0; i < height / 2; i++) {
                    for (int j = 0; j < width / 2; j++) {
                        tempArr[i][j] = rectangle[i][j];
                        rectangle[i][j] = rectangle[i + height / 2][j];
                    }
                }
                for (int i = height / 2; i < height; i++) {
                    for (int j = 0; j < width / 2; j++) {
                        rectangle[i][j] = rectangle[i][j + width / 2];
                    }
                }
                for (int i = height / 2; i < height; i++) {
                    for (int j = width / 2; j < width; j++) {
                        rectangle[i][j] = rectangle[i - height / 2][j];
                    }
                }
                for (int i = 0; i < height / 2; i++) {
                    for (int j = width / 2; j < width; j++) {
                        rectangle[i][j] = tempArr[i][j - width / 2];
                    }
                }
            }
        },
        DIVIDE_ROTATE_LEFT(6) {
            @Override
            void operate() {
                int[][] tempArr = new int[height / 2][width / 2];

                for (int i = 0; i < height / 2; i++) {
                    for (int j = 0; j < width / 2; j++) {
                        tempArr[i][j] = rectangle[i][j];
                        rectangle[i][j] = rectangle[i][j + width / 2];
                    }
                }
                for (int i = 0; i < height / 2; i++) {
                    for (int j = width / 2; j < width; j++) {
                        rectangle[i][j] = rectangle[i + height / 2][j];
                    }
                }
                for (int i = height / 2; i < height; i++) {
                    for (int j = width / 2; j < width; j++) {
                        rectangle[i][j] = rectangle[i][j - width / 2];
                    }
                }
                for (int i = height / 2; i < height; i++) {
                    for (int j = 0; j < width / 2; j++) {
                        rectangle[i][j] = tempArr[i - height / 2][j];
                    }
                }
            }
        };

        final int type;

        OperateType(int type) {
            this.type = type;
        }

        static OperateType getType(int type) {
            for (OperateType value : OperateType.values()) {
                if (value.type == type) {
                    return value;
                }
            }
            return null;
        }

        abstract void operate();
    }
}
