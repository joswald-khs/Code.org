
/**
 * Write a description of record Color here.
 *
 * @author (your name)
 * @version (a version number or a date)
 * @param x The sample x parameter of the record
 * @param y The sample y parameter of the record
 */
public record Color(int r, int g, int b) {
    public Color(int r, int g, int b) {
        if( r < 0 || r > 255 ) {
            throw new IllegalArgumentException(
                "r value is out of bounds [0,255]"
            );
        }
        if( g < 0 || g > 255 ) {
            throw new IllegalArgumentException(
                "g value is out of bounds [0,255]"
            );
        }
        if( b < 0 || b > 255 ) {
            throw new IllegalArgumentException(
                "r value is out of bounds [0,255]"
            );
        }    
        this.r = r;
        this.g = g;
        this.b = b;
    }
    
    public Color(int grayScale) {
        this(grayScale,grayScale,grayScale);
    }
    
    public int toColor() {
        return (GridCanvas.getCanvas()).color(this.r, this.g, this.b);
    }
}