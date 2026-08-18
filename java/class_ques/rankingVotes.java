//    In a special ranking system, each voter gives a rank from highest to lowest to all teams participating in the competition.
//
//            The ordering of teams is decided by who received the most position-one votes. If two or more teams tie in the first position, we consider the second position to resolve the conflict, if they tie again, we continue this process until the ties are resolved. If two or more teams are still tied after considering all positions, we rank them alphabetically based on their team letter.
//
//            You are given an array of strings votes which is the votes of all voters in the ranking systems. Sort all teams according to the ranking system described above.
//
//            Return a string of all teams sorted by the ranking system.
//
//

// check lc 1366. Rank Teams by Votes
package class_ques;

import java.util.HashMap;
import java.util.Map;
import java.util.PrimitiveIterator;
import java.util.PriorityQueue;

public class rankingVotes {
    static class Node {
        int[] votes;
        char c;
        Node (char c, int[] votes) {
            this.c = c;
            this.votes = votes;
        }

    }

    public static String rankTeams(String[] votes) {
        HashMap<Character, int[]>hash = new HashMap<>();

        int n = votes[0].length();
        for (String vote : votes) {
            for (int i = 0; i < n; i++) {
                char team = vote.charAt(i);
                hash.putIfAbsent(team, new int[n]);
                hash.get(team)[i]++;
            }
        }
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> {
            for (int i = 0; i < n; i++) {
                if (a.votes[i] != b.votes[i]) {
                    return b.votes[i] - a.votes[i];
                }
            }
            return a.c - b.c;
        }
        );

        for (Map.Entry<Character, int[]>entry : hash.entrySet()) {
            pq.offer(new Node(entry.getKey(), entry.getValue()));
        }

        StringBuilder sb =  new StringBuilder();

        while (!pq.isEmpty()) {
            char c = pq.poll().c;
            sb.append(c);
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        String [] votes = {"abc", "acb", "abc", "acb", "acb"};
        System.out.println(rankTeams(votes));
    }

}


