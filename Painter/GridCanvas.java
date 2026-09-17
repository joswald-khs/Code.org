import processing.core.*;
import processing.data.*;
import processing.event.*;
import processing.opengl.*;

/**
 * Write a description of class Test here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GridCanvas extends PApplet {
    private static GridCanvas canvasSingleton;
    private final static int DEFAULT_ROWS = 20;
    private final static int DEFAULT_COLS = 20;
    private final static int DEFAULT_SIZE = 20;
    final int rows;
    final int cols;
    final int size;

    Painter p;
    
    public static void main(String[] args){
        String[] processingArgs = {"Canvas"};
        PApplet.runSketch(processingArgs, GridCanvas.getCanvas());
    }    
    
    public static GridCanvas getCanvas() {
        if( canvasSingleton == null ) {
            canvasSingleton = new GridCanvas(DEFAULT_ROWS,DEFAULT_COLS,DEFAULT_SIZE);
        }
        return canvasSingleton;
    }
    
    public GridCanvas(int rows, int cols, int size) {
        super();
        this.rows = rows;
        this.cols = cols;
        this.size = size;
    }
    
    public int getNumberOfRows() { return rows; }
    public int getNumberOfCols() { return cols; }
    public int getSquareSize() { return size; }
    
    public void settings() {
        size(cols*size, rows*size);
    }
    
    public void setup() {

    }
    
    public void draw() {
        background(220);
        stroke(192);
        for( int i = 0; i < rows; i++ ) {
            line( 0, i * size, width, i * size );
        }
        for( int i = 0; i < cols; i++ ) {
            line( i * size, 0, i * size, height );
        }    
        if( p != null ) { p.draw(); }
    }
    
    public void addPainterToCanvas(Painter p) {
        this.p = p;
    }
}