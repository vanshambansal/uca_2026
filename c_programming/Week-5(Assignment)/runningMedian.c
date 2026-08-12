    // Running Median in data stream
    // Given a stream of integers, design a consumer that supports the following two operations:

    // void insert(int num) – Reads the next number from the stream and stores it in the underlying data structure.
    // float getMedian() – Returns the median of all numbers received so far.
    // Your goal is to choose a data structure that keeps both operations as efficient as possible.

    // Explain your approach, discuss the data structure(s) used and their time complexities, and provide a link to your solution.


// it is tough to write in C but use minheap and maxheap to find the median of a stream of numbers
// so i wrote it in JAVA as it had prebuild heaps
// code for this

// https://github.com/vanshambansal/uca_2026/blob/main/java/week_5_assignment/runningMedian.java