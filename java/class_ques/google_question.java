import java.util.*;

//    Question 1: Robot Message Rate Limiter (Easy)
//    Problem Statement
//
//    A robot continuously sends messages to a server. Due to a network issue, the same message may be sent multiple times.
//
//    Design a class RobotMessageTracker that decides whether a message should be printed.
//
//    Implement the function:
//
//    boolean shouldPrintMessage(int timestamp, String message)
//
//    where:
//
//    timestamp is given in seconds and is always in increasing order.
//    message is the text sent by the robot.
//    Rules
//    If the message has never been printed before, print it.
//    If the same message was printed within the last 10 seconds, do not print it.
//            Otherwise, print the message and update its last printed time.



//class RobotMessage {
//
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
//
//
//    public static void main(String[] args) {
//
//        RobotMessage logger = new RobotMessage();
//
//        logger.printMessage(1, "foo");
//        logger.printMessage(2, "bar");
//        logger.printMessage(4, "foo");
//        logger.printMessage(13, "foo");
//        logger.printMessage(46, "foo");
//    }
//}




//
//    Question 2: Robot Message Delayed Logger (Follow-up)
//    Problem Statement
//
//    Modify the previous logger.
//
//    Now, a message should not be printed immediately.
//
//            Instead, every incoming message waits for 10 seconds before it can be printed.
//
//    If another message with the same text arrives during those 10 seconds, none of the messages in that 10-second window should be printed.
//
//    Implement a logger that satisfies these conditions.





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
//        while(!queue.isEmpty() && (timeStamp - queue.peek().timeStamp) >= 10) {
//            MessageNode messageFromQueue = queue.poll();
//            if (messageFromQueue.status.equals("ON_HOLD")) {
//                System.out.println(messageFromQueue.timeStamp + " " + messageFromQueue.message);
//            }
//        }
//
//    }
//}


class robotMessage {

    class MessageNode {
        String msg;
        int timeStamp;
        String status;
        MessageNode(int timeStamp, String msg) {
            this.msg = msg;
            this.timeStamp = timeStamp;
            this.status = "ON_HOLD";
        }
    }

    Queue<MessageNode>q;
    HashMap<String, MessageNode>mpp;

    robotMessage() {
        q = new ArrayDeque<>();
        mpp = new HashMap<>();
    }

    void printMessage(int timeStamp, String message) {
        MessageNode newMsg = new MessageNode(timeStamp, message);
        MessageNode prevMsg = mpp.get(message);


        if(prevMsg != null && (timeStamp -  prevMsg.timeStamp) < 10) {
            newMsg.status = "CANCELLED";
            prevMsg.status = "CANCELLED";
        }

        q.offer(newMsg);
        mpp.put(message, newMsg);


        while(!q.isEmpty() && (timeStamp -  q.peek().timeStamp) >=10) {
            MessageNode m = q.poll();
            if(m.status.equals("ON_HOLD")){
                System.out.println(m.msg + " " + m.timeStamp);
            }
        }

    }


    public static void main(String[] args) {
        robotMessage logger = new robotMessage();

        logger.printMessage(1, "foo");
        logger.printMessage(2, "bar");
        logger.printMessage(4, "foo");
        logger.printMessage(13, "foo");
        logger.printMessage(46, "foo");
        logger.printMessage(116, "foo");
    }


}
