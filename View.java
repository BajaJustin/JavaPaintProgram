/**
 *
 * Authors Justin Baja, Adnan Albared
 *
 * This class acts as a View class and displays the paint program
 *
 */
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import java.util.ArrayList;

public class View extends Application {
    /** Width for the canvas and scene **/
    private final double WIDTH;
    /** Height for the canvas and scene **/
    private final double HEIGHT;
    /** Declaring the canvas **/
    private Canvas canvas;
    /** Declaring GraphicsContext **/
    private GraphicsContext gc;
    /** Declares a Geometric object **/
    private GeometricObject c;
    /** Creates an Array list of Geometric Objects **/
    private ArrayList<GeometricObject> canvasShapes = new ArrayList<>();

    {
        WIDTH = 1366;
        HEIGHT = 768;
    }

    public static void main(String[] args) {
        launch(args);
    }

    /** Updates the canvas **/
    public void updateCanvas() {

        gc.clearRect(0, 0, WIDTH, HEIGHT);

        /** Draw all other objects **/
        for (int i = 0; i < canvasShapes.size(); i++)
            canvasShapes.get(i).draw(gc);
    }

    /** ------------------------------ Mouse Events ------------------------------ **/

    /** On Click Mouse Event **/
    public void pressHandler(MouseEvent me) {

        if (me.getButton().equals(MouseButton.PRIMARY))
            try {
                c.setStartX(me.getX());
                c.setStartY(me.getY());

            } catch (Exception ex) {
                new Alert(Alert.AlertType.WARNING, "Please select a shape").showAndWait();
            }

    }

    /** On mouse release mouse event **/
    private void releaseHandler(MouseEvent me) {
        if (c != null)
            canvasShapes.add(c);

        switch (c.getType()) {
            case "Circle":
                c = new CircleShape();
                break;
            case "Line":
                c = new LineShape();
                break;
            case "Rectanglee":
                c = new RectangleShape();
                break;
        }
    }

    /** On drag mouse event **/
    public void dragHandler(MouseEvent me) {
        try {
            c.setEndX(me.getX());
            c.setEndY(me.getY());
            updateCanvas();
            c.draw(gc);
        } catch (Exception ex) {
            new Alert(Alert.AlertType.WARNING, "Please select a shape").showAndWait();
        }
    }

    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        Scene scene = new Scene(root, WIDTH, HEIGHT);
        primaryStage.setTitle("Paint Program");
        primaryStage.setScene(scene);

        // Disables the ability to resize the window
        primaryStage.setResizable(false);

        canvas = new Canvas(WIDTH, HEIGHT);
        gc = canvas.getGraphicsContext2D();

        /** ------------------------------ Buttons ------------------------------ **/

        /** Allows the user to create a circle **/
        Button circle = new Button("Circle");
        circle.setLayoutX(50);
        circle.setLayoutY(625);
        circle.setPrefWidth(100);

        /** Allows the user to create a rectangle **/
        Button rectangle = new Button("Rectangle");
        rectangle.setLayoutX(175);
        rectangle.setLayoutY(625);
        rectangle.setPrefWidth(100);

        /** Allows the user to create a line **/
        Button line = new Button("Line");
        line.setLayoutX(300);
        line.setLayoutY(625);
        line.setPrefWidth(100);

        /** Fills the border/outline of the shapes color **/
        ColorPicker outline = new ColorPicker();
        outline.setValue(Color.BLACK);
        outline.setLayoutX(50);
        outline.setLayoutY(695);
        outline.setPrefWidth(100);

        /** Fills the shape with color **/
        ColorPicker fill = new ColorPicker();
        fill.setValue(Color.BLACK);
        fill.setLayoutX(175);
        fill.setLayoutY(695);
        fill.setPrefWidth(100);

        /** A button which removes the last shape created **/
        Button undo = new Button("Undo");
        undo.setLayoutX(600);
        undo.setLayoutY(625);
        undo.setPrefWidth(100);

        /** A button which clears the canvas **/
        Button clear = new Button("Clear All");
        clear.setLayoutX(725);
        clear.setLayoutY(625);
        clear.setPrefWidth(100);

        /** A button which removes the shapes color **/
        Button removeColor = new Button("Remove Color");
        removeColor.setLayoutX(850);
        removeColor.setLayoutY(625);
        removeColor.setPrefWidth(100);

        /** A button which deleted selected shape **/
        Button delete = new Button("Delete");
        delete.setLayoutX(600);
        delete.setLayoutY(695);
        delete.setPrefWidth(100);

        /** Moves the shape to the front **/
        Button moveToFront = new Button("Move to Front");
        moveToFront.setLayoutX(725);
        moveToFront.setLayoutY(695);
        moveToFront.setPrefWidth(100);

        /** Moves the shape to the back **/
        Button moveToBack = new Button("Move to Back");
        moveToBack.setLayoutX(850);
        moveToBack.setLayoutY(695);
        moveToBack.setPrefWidth(100);

        /** ------------------------------ Labels ------------------------------  **/

        /** Label for the outline button **/
        Label outlineLabel = new Label("Outline");
        outlineLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 11));
        outlineLabel.setLayoutX(50);
        outlineLabel.setLayoutY(675);

        /** Label for the color fill button **/
        Label fillLabel = new Label("Fill");
        fillLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 11));
        fillLabel.setLayoutX(175);
        fillLabel.setLayoutY(675);

        /** Label for the color stroke button **/
        Label strokeLabel = new Label("Stroke Width");
        strokeLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 11));
        strokeLabel.setLayoutX(300);
        strokeLabel.setLayoutY(675);

        /** Instructions **/
        Label instructions = new Label();
        instructions.setText("Instructions \n" +
                "- Select a shape then a color to start drawing \n" +
                "- Left mouse click and drag to draw a new object \n" +
                "- Color/Create objects by using the buttons \n" +
                " \n Coming Soon \n" +
                "- Right mouse click to select the object \n" +
                "- Right mouse click and drag to move the object \n" +
                "- Delete/Move objects by using the buttons");
        instructions.setFont(Font.font("Verdana", FontWeight.BOLD, 11));
        instructions.setLayoutX(1000);
        instructions.setLayoutY(625);

        /** ------------------------------ Text Fields ------------------------------ **/

        /** Creates a text field that accepts number input from the user **/
        TextField strokeWidth = new TextField("2");
        strokeWidth.setLayoutX(300);
        strokeWidth.setLayoutY(695);
        strokeWidth.setPrefWidth(100);

        /** ------------------------------ On Action Events ------------------------------ **/

        /** Creates a Circle Object when circle button is clicked **/
        circle.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                c = new CircleShape();
            }
        });

        /** Creates a Rectangle Object when rectangle button is clicked **/
        rectangle.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                c = new RectangleShape();
            }
        });

        /** Creates a Line Object when line button is clicked **/
        line.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                c = new LineShape();
            }
        });

        /** Colors in the object when action is called **/
        outline.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try{
                    c.setStrokeColor(outline.getValue());
                }
                catch (NullPointerException ex){

                }
            }
        });

        /** Colors in the stroke width when action is called **/
        fill.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try{
                    c.setColor(fill.getValue());
                }
                catch (NullPointerException ex){

                }
            }
        });

        /** remove the latest shape **/
        undo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    canvasShapes.remove(canvasShapes.size() - 1);
                    updateCanvas();
                } catch (IndexOutOfBoundsException ex) {

                }
            }
        });

        /** Clears all the shapes on the screen **/
        clear.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                canvasShapes.clear();
                updateCanvas();
            }
        });

        /** Removes the color from the shape **/
        removeColor.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    canvasShapes.get(canvasShapes.size() - 1).setColor(Color.WHITE);
                    updateCanvas();
                } catch (IndexOutOfBoundsException ex) {

                }
            }
        });

        /** Changes stroke width when input is entered **/
        strokeWidth.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                try {
                    if (event.getCode() == KeyCode.ENTER) {
                        System.out.println(c.getStrokeWidth());
                        int input = Integer.parseInt(strokeWidth.getText());
                        c.setStrokeWidth(input);
                        System.out.println(c.getStrokeWidth());
                    }
                } catch (NumberFormatException ex) {
                    new Alert(Alert.AlertType.WARNING, "Invalid line width").showAndWait();
                }
            }
        });

        /** Called when left mouse button is clicked **/
        canvas.addEventHandler(MouseEvent.MOUSE_PRESSED, this::pressHandler);
        /** Called when mouse button is clicked and dragged **/
        canvas.addEventHandler(MouseEvent.MOUSE_DRAGGED, this::dragHandler);
        /** Called when mouse button is released **/
        canvas.addEventHandler(MouseEvent.MOUSE_RELEASED, this::releaseHandler);

        /** ------------------------------ Back Ground ------------------------------ **/
        Rectangle border = new Rectangle();
        border.setFill(Color.GREY);
        border.setWidth(WIDTH);
        border.setHeight(160);
        border.setLayoutY(616);


        root.getChildren().addAll(canvas, border, circle, rectangle, line, outline, outlineLabel, fill, fillLabel,
                strokeWidth, strokeLabel, undo, clear, removeColor, delete, moveToFront, moveToBack, instructions);


        primaryStage.show();
    }

}
