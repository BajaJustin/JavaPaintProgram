/**
 *
 * Author Justin Baja, Adnan Albared
 *
 * This class creates a circle object for the paint program
 */

import javafx.scene.canvas.GraphicsContext;

/** Circle Class **/
public class CircleShape extends GeometricObject {

    /** Radius of the circle **/
    private double radius;
    /** half radius of the circle **/
    private double hr;

    /** Draws the circle object **/
    public void draw( GraphicsContext gc ){

        // circles radius
        radius = Math.sqrt(Math.pow(super.getStartX() - super.getEndX(), 2)
                + Math.pow(super.getStartY() - super.getEndY(), 2));

        // Half the radius
        hr = radius / 2;

        gc.setFill(getColor());
        gc.setStroke(getStrokeColor());
        gc.setLineWidth(getStrokeWidth());
        gc.fillOval(super.getStartX() - hr, super.getStartY() - hr, radius , radius );
        gc.strokeOval(super.getStartX() - hr, super.getStartY() - hr, radius , radius );
    }

    /** Returns the object type **/
    public String getType() {
        return "Circle";
    }
}