package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;

public class Controller {
    @FXML
    public TextArea textArea;
    @FXML
    public TextField textField;
    @FXML
    public Button Enter;
    @FXML
    public ColorPicker colorPicker;
    @FXML
    public Slider slider;
    @FXML
    public CheckBox checkBoxItalic;
    @FXML
    public CheckBox checkBoxBold;

String color = "white";
String boltStyle = "normal";
String italicStyle = "normal";
int clickSize = 8;



    public void onActionTextField(ActionEvent actionEvent) {
        textArea.appendText(textField.getText() + "\n");
        textField.setText("");
    }

    public void enterTextField(ActionEvent actionEvent) {
        onActionTextField(actionEvent);
    }



    public void onActionColorPicker(ActionEvent actionEvent) {
         color = colorPicker.getValue().toString();
        color = "#" + color.substring(2, 8);
//        textArea.setStyle("-fx-text-fill: darkgreen;" +
//                "-fx-control-inner-background: " + color + ";" +
//                "-fx-highlight-fill: red;" +
//                "-fx-highlight-text-fill: yellow;"
//                );
        setStyle();
    }

    public void onMouseMovedReleased(MouseEvent mouseEvent) {
//        textArea.setStyle("-fx-font-size: "+ (int) slider.getValue() +"px");
        clickSize = (int) slider.getValue();
        setStyle();
    }

    private void setStyle() {
        textArea.setStyle("-fx-text-fill: darkgreen;" +
                "-fx-control-inner-background: " + color + ";" +
                "-fx-highlight-fill: red;" +
                "-fx-highlight-text-fill: yellow;"+
                "-fx-font-size: " + clickSize + "px;" +
                "-fx-font-weight: " + boltStyle + ";" +
                "-fx-font-style: " + italicStyle+ ";"

        );
    }

    public void onActioncheckBox(ActionEvent actionEvent) {
        if (checkBoxBold.isSelected()) {
//            textArea.setStyle("-fx-font-weight: bold");
            boltStyle = "bold";
        } else {
            boltStyle = "normal";
        }
        if (checkBoxItalic.isSelected()) {
//            textArea.setStyle("-fx-font-style: italic");
            italicStyle = "italic";
        }else {
            italicStyle = "normal";
        }

//
//        if (!checkBoxBold.isSelected()) {
////            textArea.setStyle("-fx-font-weight: normal");
//            boltStyle = "normal";
////            italicStyle = "normal";
//        }
//
//        if (!checkBoxItalic.isSelected()) {
////            textArea.setStyle("-fx-font-weight: normal");
////            boltStyle = "normal";
//            italicStyle = "normal";
//        }
//        if (checkBoxBold.isSelected() && checkBoxItalic.isSelected()) {
//            textArea.setStyle("-fx-font-weight: bold;" +
//                    "-fx-font-style: italic");
//        }
        setStyle();

    }
}
