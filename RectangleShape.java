/**
 *
 * Author Justin Baja, Adnan Albared
 *
 * This Class creates a rectangle for the paint program
 *
 */
import javafx.scene.canvas.GraphicsContext;

public class RectangleShape extends GeometricObject {

    /** Width of the rectangle **/
    private double width;
    /** Height of the rectangle **/
    private double height;

    /** Draws the rectangle **/
    public void draw(GraphicsContext gc){

        // Starting point
        width = super.getStartX() - super.getEndX();

        if (super.getStartX() < super.getEndX())
            width =  super.getEndX() - super.getStartX();

        // Starting point
        height = super.getStartY() - super.getEndY();

        if (super.getStartY() < super.getEndY())
            height = super.getEndY() - super.getStartY() ;

        // x position
        double x = super.getStartX();
        if (super.getStartX() > super.getEndX())
            x = super.getEndX();

        // y position
        double y = super.getStartY();
        if (super.getStartY() > super.getEndY())
            y = super.getEndY();

        gc.setFill(super.getColor());
        gc.setStroke(super.getStrokeColor());
        gc.setLineWidth(getStrokeWidth());
        gc.fillRect(x, y, width, height);
        gc.strokeRect(x, y, width, height);


    }

    /** Returns the object type **/
    public String getType() {
        return "Rectanglee";
    }



}