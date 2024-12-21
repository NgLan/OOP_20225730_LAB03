package hust.soict.dsai.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {

    @FXML
    private Pane drawingAreaPane;
    @FXML
    private RadioButton penRadioButton; // RadioButton cho Pen
    @FXML
    private RadioButton eraserRadioButton; // RadioButton cho Eraser
    @FXML
    private ToggleGroup identical; // ToggleGroup chứa các RadioButton
    
    private boolean isPen = false; // Biến xác định chế độ vẽ
    private boolean isEraser = false; // Biến xác định chế độ xóa

    @FXML
    private void penSelected() {
    	isPen = true; // Chế độ vẽ
        isEraser = false; 
    }

    @FXML
    private void eraserSelected() {
    	isPen = false;
        isEraser = true; // Chế độ Eraser
    }

    @FXML
    void clearButtonPressed(ActionEvent event) {
    	drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
    	if (isEraser) {
            // Xóa bằng cách vẽ màu trắng (màu nền)
            Circle erase = new Circle(event.getX(), event.getY(), 10, Color.WHITE); // Kích thước cục tẩy
            drawingAreaPane.getChildren().add(erase);
        } else if  (isPen) {
            // Vẽ bằng bút (màu đen)
        	Circle newCircle = new Circle(event.getX(), event.getY(), 4, Color.BLACK);
        	drawingAreaPane.getChildren().add(newCircle);
        }
    }
}
