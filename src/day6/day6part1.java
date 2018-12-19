package day6;

public class day6part1 {

//    public static void main(String[] args) {
//
//        int[] pos = {1, 1, 1, 6, 8, 3, 3, 4, 5, 5, 8, 9};
//        final int i = Math.abs(1 - 1) + Math.abs(1 - 6);
//
//        final int manhattan = manhattan(pos, 6);
//        System.out.println(manhattan);
//    }


    //    private static int manhattan(int[] pos, int tile) {
//        List<Integer> list = new ArrayList<>();
//        int[] dest = new int[]{
//                (tile - 1) % 10, (tile - 1) / 10
//        };
//        return Math.abs(dest[0] - pos[0]) + Math.abs(dest[1] - pos[1]);
//    }
    // Return the sum of distance between all
    // the pair of points.
    static int distancesum(int x[], int y[], int n) {
        int sum = 0;

        // for each point, finding distance to
        // rest of the point
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++) {
                final int distance = Math.abs(x[i] - x[j]) + Math.abs(y[i] - y[j]);

                System.out.println(distance);
                sum += distance;
            }
        return sum;
    }

    // Driven Program
    public static void main(String[] args) {

//        int[] pos = {1, 1, 1, 6, 8, 3, 3, 4, 5, 5, 8, 9};
//        final int i = Math.abs(1 - 1) + Math.abs(1 - 6);
//        System.out.println(i);

//        1, 1
//        1, 6
//        8, 3
//        3, 4
//        5, 5
//        8, 9


        int x[] = {1, 1, 8, 3, 5, 8};
        int y[] = {1, 6, 3, 4, 5, 9};
        int n = x.length;

        System.out.println(distancesum(x, y, n));
    }
}