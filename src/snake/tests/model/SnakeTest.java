package snake.tests.model;

import snake.model.*;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

// jUnit tests for Snake class
public class SnakeTest {
    private Snake testSnake;

    @Before
    public void runBefore() {
        testSnake = new Snake(new Cell(SnakeGame.BOARD_ROWS / 2, SnakeGame.BOARD_COLS / 2));
    }


    @Test
    public void testConstructor() {
        assertEquals(1, testSnake.length());
        assertFalse(testSnake.canGrow());
    }

    @Test
    public void testMoveRight() {
        setSnakeDirection(testSnake, Direction.RIGHT);
        testSnake.move();
        assertEquals(new Cell(SnakeGame.BOARD_ROWS / 2, SnakeGame.BOARD_COLS / 2 + 1), testSnake.getPosition());
    }

    @Test
    public void testMoveLeft() {
        setSnakeDirection(testSnake, Direction.LEFT);
        testSnake.move();
        assertEquals(new Cell(SnakeGame.BOARD_ROWS / 2, SnakeGame.BOARD_COLS / 2 - 1), testSnake.getPosition());
    }

    @Test
    public void testMoveUp() {
        setSnakeDirection(testSnake, Direction.UP);
        testSnake.move();
        assertEquals(new Cell(SnakeGame.BOARD_ROWS / 2 - 1, SnakeGame.BOARD_COLS / 2), testSnake.getPosition());
    }

    @Test
    public void testMoveDown() {
        setSnakeDirection(testSnake, Direction.DOWN);
        testSnake.move();
        assertEquals(new Cell(SnakeGame.BOARD_ROWS / 2 + 1, SnakeGame.BOARD_COLS / 2), testSnake.getPosition());
    }

    @Test
    public void testMoveBody() {
        setSnakeDirection(testSnake, Direction.RIGHT);
        growBodyByTwo();
        testSnake.move();
        assertEquals(new Cell(SnakeGame.BOARD_ROWS / 2, SnakeGame.BOARD_COLS / 2 + 3), testSnake.getPosition());

        List<Cell> body = testSnake.getBodyPositions();
        assertEquals(2, body.size());
        assertEquals(new Cell(SnakeGame.BOARD_ROWS / 2, SnakeGame.BOARD_COLS / 2 + 2), body.get(0));
        assertEquals(new Cell(SnakeGame.BOARD_ROWS / 2, SnakeGame.BOARD_COLS / 2 + 1), body.get(1));
    }

    @Test
    public void testGrowOnFeed() {
        Food food = new Food(testSnake.getPosition(), Snake.NUTRITION_TO_GROW);
        testSnake.eat(food);
        assertEquals(1, testSnake.length());
        assertTrue(testSnake.canGrow());

        testSnake.move();
        assertEquals(2, testSnake.length());
        assertFalse(testSnake.canGrow());
    }

    // EFFECTS: rotate snake until it is facing in direction d
    private void setSnakeDirection(Snake snake, Direction d) {
        while (snake.getDirection() != d)
            snake.rotateLeft();
    }

    // MODIFIES: this
    // EFFECTS:  get snake to eat enough food so that its body has length 2
    private void growBodyByTwo() {
        Food food = new Food(testSnake.getPosition(), 2 * Snake.NUTRITION_TO_GROW);
        testSnake.eat(food);
        testSnake.move();
        testSnake.move();
    }

    @Test
    public void testRotateRightDown() {
        //TODO: YOU DO NOT HAVE TO FINISH THIS BUT IT WOULD BE HELPFUL
    }

    @Test
    public void testRotateRightLeft() {
        //TODO: YOU DO NOT HAVE TO FINISH THIS BUT IT WOULD BE HELPFUL
    }

    @Test
    public void testRotateRightUp() {
        //TODO: YOU DO NOT HAVE TO FINISH THIS BUT IT WOULD BE HELPFUL
    }

    @Test
    public void testRotateRightRight() {
        //TODO: YOU DO NOT HAVE TO FINISH THIS BUT IT WOULD BE HELPFUL
    }

    @Test
    public void testRotaeRightMultiple() {
        //TODO: YOU DO NOT HAVE TO FINISH THIS BUT IT WOULD BE HELPFUL
    }

    @Test
    public void testRotateLeftUp() {
        //TODO: YOU DO NOT HAVE TO FINISH THIS BUT IT WOULD BE HELPFUL
    }

    @Test
    public void testRotateLeftLeft() {
        //TODO: YOU DO NOT HAVE TO FINISH THIS BUT IT WOULD BE HELPFUL
    }

    @Test
    public void testRotateLeftDown() {
        //TODO: YOU DO NOT HAVE TO FINISH THIS BUT IT WOULD BE HELPFUL
    }

    @Test
    public void testRotateLeftRight() {
        //TODO: YOU DO NOT HAVE TO FINISH THIS BUT IT WOULD BE HELPFUL
    }

    @Test
    public void testRotateLeftMultiple() {
        //TODO: YOU DO NOT HAVE TO FINISH THIS BUT IT WOULD BE HELPFUL
    }

    @Test
    public void testEatNotEnoughToGrow() {
        Food newFood = new Food(testSnake.getPosition(), 10);
        testSnake.eat(newFood);
        assertFalse(testSnake.canGrow());
        assertEquals(1, testSnake.length());
    }

    @Test
    public void testEatEnoughToGrow() {
        Food newFood50 = new Food(testSnake.getPosition(), 50);
        testSnake.eat(newFood50);
        assertTrue(testSnake.canGrow());
        assertEquals(1, testSnake.length());
        testSnake.move();
        assertEquals(2, testSnake.length());
    }

    @Test
    public void testGrowByTwo() {
        growBodyByTwo();
        assertEquals(3, testSnake.length());
        assertFalse(testSnake.canGrow());
    }

    @Test
    public void testAmountConsumed() {
        Food newFood20 = new Food(testSnake.getPosition(), 20);
        testSnake.eat(newFood20);
        assertFalse(testSnake.canGrow());
        assertEquals(1, testSnake.length());
        testSnake.move();
    }

    @Test
    public void testEatMultipleTimes() {
        Food newFood20 = new Food(testSnake.getPosition(), 20);
        testSnake.eat(newFood20);
        testSnake.eat(newFood20);
        assertEquals(1, testSnake.length());
        assertFalse(testSnake.canGrow());
        testSnake.eat(newFood20);
        assertTrue(testSnake.canGrow());
        testSnake.move();
        assertEquals(2, testSnake.length());
    }
}