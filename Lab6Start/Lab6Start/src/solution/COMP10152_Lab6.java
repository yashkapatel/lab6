package solution;

import battleship.BattleShip;
import battleship.CellState;
import java.awt.Point;
import java.util.Random;
import java.util.Stack;

/**
 * Starting code for Comp10152 - Lab#6
 *
 * @author mark.yendt
 */
public class COMP10152_Lab6 {

    static final int NUMBEROFGAMES = 1000;
    static final int HUNT = 1;
    static CellState map[][];

    static Random r = new Random();
    static Stack X = new Stack();
    static Stack Y = new Stack();

    public static void startingSolution() {
        int totalShots = 0;
        System.out.println(BattleShip.version());
        for (int game = 0; game < NUMBEROFGAMES; game++) {

            BattleShip battleShip = new BattleShip();
            SampleBot sampleBot = new SampleBot(battleShip);

            // Call SampleBot Fire randomly - You need to make this better!
            while (!battleShip.allSunk()) {
                int x = (int) X.pop();
                int y = (int) Y.pop();
                sampleBot.fireShot(x, y);

            }
            int gameShots = battleShip.totalShotsTaken();
            totalShots += gameShots;
        }
        System.out.printf("SampleBot - The Average # of Shots required in %d games to sink all Ships = %.2f\n", NUMBEROFGAMES, (double) totalShots / NUMBEROFGAMES);

    }

    public static void main(String[] args) {
        startingSolution();
    }
} 
