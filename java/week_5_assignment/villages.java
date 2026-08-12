package week_5_assignment;

import java.util.PriorityQueue;

class Solution {

    static class Villages {
        int pop;
        int count;

        Villages(int p) {
            pop = p;
            count = 1;
        }

        double load() {
            return (double) pop / count;
        }
    }

    static double minimumLoad(int[] population, int k) {


        PriorityQueue<Villages> pq = new PriorityQueue<>((a, b) -> Double.compare(b.load(), a.load()));

        for (int i : population) {
            pq.add(new Villages(i));
        }

        int remaining = k - population.length;

        while (remaining > 0) {

            Villages v = pq.poll();
            v.count++;
            pq.add(v);
            remaining--;

        }
        return pq.peek().load();
    }

    public static void main(String[] args) {
        int[] population = {200, 50, 20};
        int k = 5;

        System.out.println(minimumLoad(population, k));
    }

}
