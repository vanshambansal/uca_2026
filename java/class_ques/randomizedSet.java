package class_ques;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

class RandomizedSet {

    ArrayList<Integer> arr;
    HashMap<Integer, Integer> hash;
    Random random;

    RandomizedSet() {
        arr = new ArrayList<>();
        hash = new HashMap<>();
        random = new Random();
    }

    boolean insert(int num) {
        if (hash.containsKey(num)) return false;
        int index = arr.size();
        hash.put(num, index);
        arr.add(num);
        return true;
    }

    boolean remove(int num) {
        if (!hash.containsKey(num)) return false;
        int index = hash.get(num);

        int lastIndex = arr.size() - 1;
        int lastValue = arr.get(lastIndex);

        arr.set(index, lastValue);
        hash.put(lastValue, index);

        hash.remove(num);
        arr.remove(lastIndex);

        return true;
    }

    int getRandom() {
        int index = random.nextInt(arr.size());
        return arr.get(index);
    }

}
