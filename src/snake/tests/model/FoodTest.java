package snake.tests.model;

import snake.model.Cell;
import snake.model.Food;
import snake.model.SnakeGame;
import org.junit.Before;
import org.junit.Test;

import static snake.model.Food.DECAY_AMOUNT;
import static snake.model.Food.INITIAL_NUTRITIONAL_VALUE;
import static org.junit.Assert.*;

// jUnit tests for Food class
public class FoodTest {
    private Food testFood;
    private int zeroNutritient;

    @Before
    public void runBefore() {
        testFood = new Food(new Cell(SnakeGame.BOARD_ROWS / 2, SnakeGame.BOARD_COLS / 2));
        zeroNutritient = 0;
    }

    @Test
    public void testConstructor() {
        //TODO: YOU DO NOT HAVE TO FINISH THIS BUT IT WOULD BE HELPFUL
    }


    @Test
    public void testDecay() {
        //TODO: YOU DO NOT HAVE TO FINISH THIS BUT IT WOULD BE HELPFUL
    }

    @Test
    public void testDecayExceed() {
        //TODO: YOU DO NOT HAVE TO FINISH THIS BUT IT WOULD BE HELPFUL
    }

}