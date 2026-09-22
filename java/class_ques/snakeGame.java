//Design Snake Game
//
//Design a Snake game that is played on a device with screen size height x width. Play the game online if you are not familiar with the game.
//
//The snake is initially positioned at the top left corner (0, 0) with a length of 1 unit.
//
//You are given an array food where food[i] = (ri, ci) is the row and column position of a piece of food that the snake can eat. When a snake eats a piece of food, its length and the game's score both increase by 1.
//
//Each piece of food appears one by one on the screen, meaning the second piece of food will not appear until the snake eats the first piece of food.
//
//When a piece of food appears on the screen, it is guaranteed that it will not appear on a block occupied by the snake.
//
//The game is over if the snake goes out of bounds (hits a wall) or if its head occupies a space that its body occupies after moving (i.e. a snake of length 4 cannot run into itself).
//
//Implement the SnakeGame class:
//
//SnakeGame(int width, int height, int[][] food) Initializes the object with a screen of size height x width and the positions of the food.
//int move(String direction) Returns the score of the game after applying one direction move by the snake. If the game is over, return -1.
//
//Example 1
//
//Input :["SnakeGame", "move", "move", "move", "move", "move", "move"]
//
//        [[3, 2, [[1, 2], [0, 1]]], ["R"], ["D"], ["R"], ["U"], ["L"], ["U"]]
//
//Output : [null, 0, 0, 1, 1, 2, -1]
//
//Explanation :
//
//SnakeGame snakeGame = new SnakeGame(3, 2, [[1, 2], [0, 1]]);
//
//        snakeGame.move("R"); // return 0
//
//snakeGame.move("D"); // return 0
//
//snakeGame.move("R"); // return 1, snake eats the first piece of food. The second piece of food appears at (0, 1).
//
//snakeGame.move("U"); // return 1
//
//snakeGame.move("L"); // return 2, snake eats the second food. No more food appears.
//
//snakeGame.move("U"); // return -1, game over because snake collides with border

package class_ques;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class snakeGame {
    int height = 0;
    int width = 0;
    int [][] list;
    int pos;
    Deque<int[]> deque;
    snakeGame (int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.list = food;
        deque = new LinkedList<>();
        pos = 0;
        deque.add(new int[]{0, 0});
    }

    int move (String direction) {
        int[] head = deque.getFirst();
        int i = head[0];
        int j = head[1];

        if (direction.equals("U")) i--;
        else if (direction.equals("L")) j--;
        else if (direction.equals("R")) j++;
        else if (direction.equals("D")) i++;

        if (i < 0 || i >= height || j < 0 || j >= width) return -1;

        int []curr = new int[]{i, j};

        for (int[] temp : deque) {
            if (temp[0] == curr[0] && temp[1] == curr[1]) {
                if (temp[0] != deque.getLast()[0] || temp[1] != deque.getLast()[1]) {
                    return -1;
                }
            }
        }

        if (pos < list.length && i == list[pos][0] && j == list[pos][1]) {
            pos++;
        } else  {
            deque.removeLast();
        }
        deque.addFirst(curr);
        return pos;

    }

    public static void main(String[] args) {

        int[][] food = {{1, 2}, {0, 1}};

        snakeGame game = new snakeGame(3, 2, food);

        System.out.println(game.move("R"));
        System.out.println(game.move("D"));
        System.out.println(game.move("R"));
        System.out.println(game.move("U"));
        System.out.println(game.move("L"));
        System.out.println(game.move("U"));
    }
}





// sir's logic (its better to use hashSet and create aCoordinate class)


//import java.util.*;
//
//class SnakeGame {
//
//
//    class Coordinate {
//        int x;
//        int y;
//
//        Coordinate(int x, int y) {
//            this.x = x;
//            this.y = y;
//        }
//
//        public booleans equals(Coordinate that) {
//            return this.x == that.x && this.y == that.y;
//        }
//    }
//
//    private Deque<Coordinate> snakeTracker;
//    private Set<Coordinate> usedCoordinates;
//    private int width;
//    private int height;
//    private int food[][];
//    private int foodIndex;
//
//
//    public SnakeGame(int width, int height, int[][] food) {
//        this.snakeTracker = new ArrayDeque<>();
//        this.width = width;
//        this.height = heigth;
//        this.food = food;
//        this.foodIndex = 0;
//        this.usedCoordinates = new HashSet<>();
//
//        // starting Index for the snake
//        Coordinate start = new Coordinate(0 , 0);
//        snakeTracker.addFirst(start);
//        usedCoordinates.add(start);
//    }
//
//    public int move(String direction) {
//        Coordinate headCoordinates = snakeTracker.peekFirst();
//        Coordinate newCoordinates = moveSnake(direction, headCoordinates);
//
//        if (isCoordinatesInvalid(newCoordinates)) {
//            return -1;
//        }
//
//        boolean isFoodEaten = (foodIndex < food.length()) &&
//                (newCoordinates.x == food[foodIndex][0] && newCoordinates.y == food[foodIndex][1]);
//
//        // when the food is not eaten
//        if (!isFoodEaten) {
//            Coordinate tail = snakeTracker.removeLast();
//            usedCoordinates.remove(tail);
//        }
//
//        // If the collision has happened
//        if(usedCoordinates.contains(newCoordinates)) {
//            return -1;
//        }
//
//        // Add the new Box where snake has moved.
//        snakeTracker.addFirst(newCoordinates);
//        usedCoordinates.add(usedCoordinates);
//
//        if (isFoodEaten) {
//            foodIndex++;
//        }
//
//        return snakeTracker.length() - 1;
//
//    }
//
//    private Coordinate moveSnake(String direction , Coordinate current) {
//        if (direction.equals("U") {
//            return new Coordinate(current.x-- , current.y);
//        } else if (direction.equals("D") {
//            return new Coordinate(current.x++ , current.y);
//        } else if (direction.equals("L") {
//            return new Coordinate(current.x , current.y--);
//        } else if (direction.equals("R") {
//            return new Coordinate(current.x , current.y++);
//        }
//
//        throw new IllegalArgumentException("Direction Not supported");
//    }
//
//    private boolean isCoordinatesInvalid(Coordinate coordinate) {
//        if (coordinate.x < 0 || coordinate.y < 0 || coordinate.x >= height || coordinate.y >= width) {
//            return true;
//        }
//        return false;
//    }
//}
//
///**
// * Your SnakeGame object will be instantiated and called as such:
// * SnakeGame obj = new SnakeGame(width, height, food);
// * int param_1 = obj.move(direction);
// */