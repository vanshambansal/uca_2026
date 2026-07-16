import java.util.*;
class Pair{
    int first;
    String second;
    Pair(int a, String b){
        this.first = a;
        this.second = b;
    }

}
class RobotMessage {

//    HashMap<String, Integer> mpp = new HashMap<>();
//
//    void printMessage(int time, String message) {
//
//        if (!mpp.containsKey(message)) {
//            System.out.println(message);
//            mpp.put(message, time);
//            return;
//        }
//
//        if (time - mpp.get(message) >= 10) {
//            System.out.println(message);
//            mpp.put(message, time);
//        }
//    }
    Queue<Pair>q = new ArrayDeque<>();
    HashMap<String, Pair> mpp = new HashMap<>();
    void printMessage(int time, String message){


        while(!q.isEmpty() && (time- q.peek().first)>=10){

            Pair front = q.poll();
            if(mpp.containsKey(front.second)){

                System.out.println(front.second + " " + front.first);


                mpp.remove(front.second);

            }
        }

        if(mpp.containsKey(message)){

            mpp.remove(message);
            return;
        }

        Pair p = new Pair(time , message);
        q.offer(p);
        mpp.put(message, p);

    }

    public static void main(String[] args) {

        RobotMessage logger = new RobotMessage();

        logger.printMessage(1, "foo");
        logger.printMessage(2, "bar");
        logger.printMessage(4, "foo");
        logger.printMessage(13, "foo");
        logger.printMessage(14, "foo");
        logger.printMessage(15, "foo");
        logger.printMessage(46, "foo");
        logger.printMessage(100, "foo");
    }
}



//class RobotMessageTracker {
//
//    class MessageNode {
//        long timeStamp;
//        String message;
//        String status;
//
//        MessageNode(long timeStamp, String message) {
//            this.timeStamp = timeStamp;
//            this.message = message;
//            this.status = "ON_HOLD";
//        }
//    }
//
//    public Map<String, MessageNode> messageTracker;
//    public Queue<MessageNode> queue;
//
//    RobotMessageTracker() {
//        messageTracker = new HashMap<>();
//        queue = new LinkedList<>();
//    }
//
//
//
//
//    public void shouldPrintMessage(long timeStamp, String message ) {
//
//        MessageNode newMessage  = new MessageNode(timeStamp, message);
//        MessageNode prevMessage = messageTracker.get(message);
//
//
//
//        // Check Whether this message was in the past
//
//        if (prevMessage != null && (newMessage.timeStamp - prevMessage.timeStamp) < 10) {
//            prevMessage.status = "CANCELLED";
//            newMessage.status = "CANCELLED";
//        }
//
//        // Hold this message for future refernce
//        messageTracker.put(message, newMessage);
//        queue.offer(newMessage);
//
//        // print All the valid Message, Time window has breached of 10 seconds.
//
//        while(!queue.isEmpty() && (timeStamp - q.peek().timeStamp) >= 10) {
//            Message messageFromQueue = q.poll();
//            if (messageFromQueue.status.equals("ON_HOLD") {
//                System.out.println(messageFromQueue.timeStamp + " " + messageFromQueue.message);
//            }
//        }
//
//    }
//}
