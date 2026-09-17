
/**
 * Write a description of class SpiralPainter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SpiralPainter extends Painter {
    public void getToStartingPosition() {
        // Psuedocode
        // assume we are facing right
        // move
        // move
        // turn right
        // move 
        // move
        move();
        move();
        turnRight();
        move();
        move();
    }
    
    public void paintL( Color c ) {
        paint(c);
        move();
        paint(c);
        move();
        turnLeft();
        paint(c);
        move();
        paint(c);
    }
    
    public void paintSpiral( Color c ) {
        paintL(c);
        move();
        paint(c);
        turnLeft();
        move();
        paint(c);
        move();
        paint(c);
        paintL(c);
        move();
        paint(c);
        paintL(c);
        move();
        paint(c);
        move();
        paint(c);
        move();
        paint(c);
        paintL(c);
        move();
        paint(c);
        move();
        paint(c);
        move();
        paint(c);
        paintL(c);
        move();
        paint(c);
        move();
        paint(c);        
    }
}