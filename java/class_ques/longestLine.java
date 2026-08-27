// LC - 149

package class_ques;

import java.util.HashMap;

public class longestLine {

    static int gcd(int a, int b) {

        int ans = 1;
        for (int i = 1 ; i <= Math.min(a, b); i++) {
            if((a % i == 0) && (b % i == 0)) {
                ans = i;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        int[][] points = {
                {1, 1},
                {2, 2},
                {3, 3},
                {4, 4},
                {1, 5},
                {2, 5},
                {3, 5}
        };
        int n = points.length;
        int answer = 0;

        for (int i = 0; i < n; i++) {
            HashMap <String, Integer> hash = new HashMap<>();

            for (int j = 0; j < n; j++) {

                if ( i == j) continue;

                int dx = points[i][0] - points[j][0];
                int dy = points[i][1] - points[j][1];

                if ( dx == 0) {
                    String slope = "vertical";
                    hash.put(slope, hash.getOrDefault(slope , 0) + 1);
                    continue;
                }

                if ( dy == 0) {
                    String slope = "horizontal";
                    hash.put(slope, hash.getOrDefault(slope , 0) + 1);
                    continue;
                }

                int g = gcd(Math.abs(dx), Math.abs(dy));

                dx /= g;
                dy /= g;

                if (dx < 0) {
                    dx = -dx;
                    dy = -dy;
                }


                String slope = dy + "/" + dx;

                hash.put(
                        slope,
                        hash.getOrDefault(slope, 0) + 1
                );
            }

            int best = 0;
            for ( int it : hash.values()) {
                best = Integer.max(best, it);
            }

            answer = Integer.max(answer, best + 1);

        }

        System.out.println(answer);

    }
}
