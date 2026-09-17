import java.util.List;
import java.util.ArrayList;

/**
 * Write a description of class Painter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Painter {
    private final GridCanvas sketch;
    Location location;
    List<PaintedLocation> paintedLocations;
    Color currentColor;
    Direction currentDirection;
    
    public Painter() {
        sketch = GridCanvas.getCanvas();
        location = new Location(0,0);
        currentColor = new Color(100,100,100);
        currentDirection = Direction.EAST;
        paintedLocations = new ArrayList<PaintedLocation>();
    }
    
    public void draw() { 
        float s = sketch.getSquareSize();
        float hs = s/2;
        float mult = hs * 0.9f;
        for( PaintedLocation pl : paintedLocations ) {
            sketch.fill(pl.c().toColor());
            
            sketch.square(pl.loc().x()*s, pl.loc().y()*s, s);            
        }
        sketch.fill(0);
        sketch.push();
        Location pixelLocation = gridLocationToPixels( location );
        sketch.translate( pixelLocation.x(), pixelLocation.y() );
        sketch.rotate( currentDirection.radians() );
        sketch.triangle( -mult, -hs*0.8f, -mult, hs*0.8f, mult, 0 );
        sketch.pop();
    }
    
    public void paint() {
        paintedLocations.add( new PaintedLocation( location, currentColor ) );
    }
    
    public void move() {
        Location change = currentDirection.change();
        location = new Location( location.x() + change.x(), location.y() + change.y() );
    }
    
    public void turnLeft() {
        currentDirection = currentDirection.left(); 
    }
    
    
    // center of square
    private Location gridLocationToPixels( Location loc ) {
        float s = sketch.getSquareSize();
        float hs = s/2;
        return new Location( (int) (loc.x() * s + hs), (int) (loc.y() * s + hs) );
    }
    
    private record PaintedLocation( Location loc, Color c ){}
    private enum Direction {
        NORTH {
            public float radians() { return 3 * GridCanvas.getCanvas().PI / 2; }
            public Location change() { return new Location(0,-1); }
            public Direction left() { return WEST; }                
        }, EAST {
            public float radians() { return 0; }
            public Location change() { return new Location(1,0); }
            public Direction left() { return NORTH; }
        }, SOUTH {
            public float radians() { return GridCanvas.getCanvas().PI / 2; }
            public Location change() { return new Location(0,1); }
            public Direction left() { return EAST; }
        }, WEST {
            public float radians() { return GridCanvas.getCanvas().PI; }
            public Location change() { return new Location(-1,0); }
            public Direction left() { return SOUTH; }
        };
        
        public abstract float radians();
        public abstract Location change();
        public abstract Direction left();
    }
}