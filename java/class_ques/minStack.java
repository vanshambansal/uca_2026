package class_ques;

//class MinStack {
//
//    int []arr;
//    int index;
//    int mini = Integer.MAX_VALUE;
//
//    MinStack () {
//        arr = new int[100];
//        index = -1;
//    }
//
//    public void push(int num){
//
//        if(index == -1) {
//
//            mini = num;
//            arr[++index] = num;
//
//        }
//        else if(num >= mini){
//            arr[++index] = num;
//
//        }else{
//            arr[++index] = 2 * num - mini;
//            mini = num;
//        }
//    }
//
//    public void pop(){
//
//        if(index == -1)return;
//
//        if(arr[index] >= mini){
//            index--;
//
//        }else{
//            mini = 2 * mini - arr[index];
//            index--;
//
//        }
//        if (index == -1) {
//            mini = Integer.MAX_VALUE;
//        }
//    }
//
//    public int top(){
//
//        if(index == -1){
//            System.out.println("stack is empty");
//            return -1;
//        }
//
//        if(arr[index] >= mini){
//            return arr[index];
//
//        }else{
//            return mini;
//        }
//    }
//
//    public int getMin(){
//
//        if(index == -1){
//            System.out.println("stack is empty");
//            return -1;
//        }
//        return mini;
//    }
//
//    public static void main(String[] args) {
//
//        MinStack m = new MinStack();
//        m.push(12);
//        m.push(13);
//        m.pop();
//        m.push(43);
//        System.out.println(m.top());
//        System.out.println(m.getMin());
//
//    }
//
//}







//class MinStack {
//
//    class Node {
//        int data;
//        Node next;
//        int currMin;
//        Node(int data) {
//            this.data = data;
//            this.currMin = data;
//        }
//    }
//
//    Node head;
//
//    public MinStack() {
//        head = null;
//    }
//
//
//    public void push(int val) {
//        Node newNode = new Node(val);
//
//        if (head != null) {
//            newNode.next = head;
//            newNode.currMin= Math.min(newNode.currMin, head.currMin);
//        }
//
//        head = newNode;
//    }
//
//    public void pop() {
//        validate();
//        head = head.next;
//    }
//
//    public int top() {
//        validate();
//        return head.data;
//    }
//
//    public int getMin() {
//        validate();
//        return head.currMin;
//    }
//
//    private void validate() throws Exception {
//        if (head == null) {
//            throw new Exception("No element is present");
//        }
//    }
//}