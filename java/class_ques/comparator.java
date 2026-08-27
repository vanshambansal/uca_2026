package class_ques;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class comparator {
//
//    static boolean isPrime(int num) {
//        for (int i = 2; i * i <= num; i++) {
//            if (num % i == 0) return false;
//        }
//        return true;
//    }

    static class UCAStudent implements Comparable<UCAStudent> {
        String studentName;
        double CGPA;

        UCAStudent(String studentName, double CGPA) {
            this.studentName = studentName;
            this.CGPA = CGPA;

        }
        public String toString() {
            return studentName + " " + CGPA;
        }

        public int compareTo(UCAStudent e2) {
            UCAStudent e1 = this;
            int val = Double.compare(e1.CGPA, e2.CGPA);
            if (val == 0) {
                return e2.studentName.compareTo(e1.studentName);
            }
            return val;
        }

    }

    public static void main(String[] args) {

//        List<Integer> list = new ArrayList<>();
//        list.add(2);
//        list.add(3);
//        list.add(100);
//        list.add(900);
//        list.add(600);
//        list.add(23);
//
//        Collections.sort(list, (e1, e2) -> {
//            if (isPrime(e1) && isPrime(e2)) {
//               return e1 - e2;
//            }
//            if (isPrime(e1) && !isPrime(e2)) {
//                return -1;
//            }
//            if (!isPrime(e1) && isPrime(e2)) {
//                return 1;
//            }
//            return e2 - e1;
//        });
//        System.out.println(list);

        List<UCAStudent>list = new ArrayList<>();
        list.add(new UCAStudent("A", 6.0d));
        list.add(new UCAStudent("B", 7.0d));
        list.add(new UCAStudent("C", 7.0d));

        Collections.sort(list);

        System.out.println(list);
    }
}
