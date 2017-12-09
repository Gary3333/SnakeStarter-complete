package snake.model;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

// Represents a snake.
public class Snake {
    public static final int NUTRITION_TO_GROW = 50;
    private Cell head;
    private List<Cell> body;
    private Direction direction;
    private int nutritionConsumed;

    // EFFECTS: snake's head is at given position, body is empty and direction is right;
    //          snake has consumed no nutrition
    public Snake(Cell head) {
        body = new LinkedList<Cell>();
        direction = Direction.RIGHT;
        this.head = head;
        nutritionConsumed = 0;
    }

    public Cell getPosition() {
        return head;
    }

    public Direction getDirection() {
        return direction;
    }

    public List<Cell> getBodyPositions() {
        return Collections.unmodifiableList(body);
    }

    // MODIFIES: this
    // EFFECTS:  snake rotates left 90 degrees
    public void rotateLeft() {
     switch (direction){
         case UP:
             direction = Direction.LEFT;
             break;
         case DOWN:
             direction = Direction.RIGHT;
             break;
         case LEFT:
             direction = Direction.DOWN;
             break;
         case RIGHT:
             direction = Direction.UP;
             break;

     }
        //HINT: USE SWITCH
    }

    // MODIFIES: this
    // EFFECTS:  snake rotates right 90 degrees
    public void rotateRight() {
        switch (direction){
            case UP:
                direction = Direction.RIGHT;
                break;
            case DOWN:
                direction = Direction.LEFT;
                break;
            case LEFT:
                direction = Direction.UP;
                break;
            case RIGHT:
                direction = Direction.DOWN;
                break;
        }
    }

    // EFFECTS: returns length of snake (head & body)
    public int length() {
        return 1 + body.size();
    }

    // MODIFIES: this
    // EFFECTS:  snake moves one cell in current direction; if snake has consumed enough nutrition to
    //           grow, it grows by one cell and amount of nutrition needed to grow is deducted from
    //           nutrition consumed
    public void move() {

        body.add(0, new Cell(head.getRow(),head.getColumn()));
        if(canGrow())
            nutritionConsumed -= NUTRITION_TO_GROW;
        else
            body.remove(body.size()-1);
        moveHead();
        //HINT: FOR BODY LOOK UP THE DOCUMENTATION FOR LINKED LIST AND WHAT METHODS THEY HAVE
    }

    // EFFECTS: return true if snake has consumed enough nutrition to grow
    public boolean canGrow() {
        return nutritionConsumed >= NUTRITION_TO_GROW;
    }

    // MODIFIES: this
    // EFFECTS:  move head one cell in current direction
    private void moveHead() {

        switch(direction){
            case UP:
                head = new Cell(head.getRow()-1, head.getColumn());
                break;
            case DOWN:
                head = new Cell (head.getRow()+1, head.getColumn());
                break;
            case RIGHT:
                head = new Cell (head.getRow(),head.getColumn()+1);
                break;
            case LEFT:
                head = new Cell (head.getRow(),head.getColumn()-1);
                break;
        }

        //HINT: USE SWITCH
    }

    // MODIFIES: this
    // EFFECTS:  consumes all the nutritional value in food
    public void eat(Food food) {

        nutritionConsumed = nutritionConsumed + food.getNutritionalValue();

    }
}
