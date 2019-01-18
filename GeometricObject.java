/**
 *
 * Author Justin Baja, Adnan Albared
 *
 * This Class creates a Geometric Object which is inherited by the other shape classes
 *
 */
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class GeometricObject {

    /** Color of the object **/
    private Color color;
    /** Stroke Color **/
    private Color strokeColor;
    /** Stroke width **/
    private double strokeWidth;
    /** Starting X position **/
    private double startX;
    /** Starting Y position **/
    private double startY;
    /** Ending X position **/
    private double endX;
    /** Ending Y position **/
    private double endY;

    /** Color of the shape **/
    public void setColor(Color color) {
        this.color = color;
    }

    /** Color of the stroke/border **/
    public void setStrokeColor(Color strokeColor){
        this.strokeColor = strokeColor;
    }

    /** Stroke Width **/
    public void setStrokeWidth( double strokeWidth ){
        this.strokeWidth = strokeWidth;
    }

    /** Sets the starting x position **/
    public void setStartX( double startX ){
        this.startX = startX;
    }

    /** Sets the starting y position **/
    public void setStartY( double startY ){
        this.startY = startY;
    }

    /** Sets the ending x position **/
    public void setEndX(double endX) {
        this.endX = endX;
    }

    /** Sets the ending y position **/
    public void setEndY(double endY) {
        this.endY = endY;
    }

    /** Returns starting x position **/
    public double getStartX() {
        return startX;
    }

    /** Returns the starting y position **/
    public double getStartY() {
        return startY;
    }

    /** Returns the ending x position **/
    public double getEndX(){
        return endX;
    }

    /** Returns the ending y position **/
    public double getEndY(){
        return endY;
    }

    /** Returns the fill color **/
    public Color getColor() {
        return color;
    }

    /** Returns the stroke color **/
    public Color getStrokeColor() {
        return strokeColor;
    }

    /** Returns the stroke width **/
    public double getStrokeWidth() {
        return strokeWidth;
    }

    /** A abstract class that draws the shapes **/
    public abstract void draw(GraphicsContext gc);

    /** A abstract class that returns the type of object **/
    public abstract String getType();

}
