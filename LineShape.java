/**
 *
 * Author Justin Baja, Adnan Albared
 *
 * This class creates a Line Object for the paint program
 *
 */
import javafx.scene.canvas.GraphicsContext;

public class LineShape extends GeometricObject {

    /** Draws a Line in the paint program **/
    public void draw( GraphicsContext gc ){

        gc.setStroke(super.getStrokeColor());
        gc.setLineWidth(getStrokeWidth());
        gc.strokeLine( super.getStartX(), super.getStartY(), super.getEndX(), super.getEndY() );

    }

    /** Returns the Object type **/
    public String getType() {
        return "Line";

    }
}

