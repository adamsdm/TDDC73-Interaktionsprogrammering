package sample;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Window;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;


public class Controller {

    // Get variables from ID
    @FXML private VBox mainPane;
    @FXML private ImageView imageView;
    @FXML private Slider zoomSlider;


    private FileChooser fileChooser;
    private File file;


    public void initialize(){
        zoomSlider.valueProperty().addListener((observable, oldValue, newValue) -> {

            double zoom = (double)newValue  / 100;

            System.out.println(zoom);

            imageView.setScaleX(zoom);
            imageView.setScaleY(zoom);
        });
    }


    /**
     * Opens an open file dialog and sets the active image to the selected file
     * @param ae The actual Action event
     * @throws MalformedURLException
     */
    public void handleOpenClick(ActionEvent ae) throws MalformedURLException {
        FileChooser.ExtensionFilter openExtFilter =
                new FileChooser.ExtensionFilter("Images", "*.png", "*.jpg", "*.jpeg");
        fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(openExtFilter);
        file = fileChooser.showOpenDialog(mainPane.getScene().getWindow());

        if (file != null)
        {

            imageView.setImage(new Image(file.toURI().toURL().toExternalForm()));

        }
    }

    /**
     * Opens a save file dialog which saves the image to the given destination with the selected extention
     */
    public void handleSaveClick(){

        if(imageView.getImage() == null){
            return;
        }

        fileChooser = new FileChooser();
        fileChooser.setTitle("Save Image");
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Png", ".png")
        );
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("jpg", ".jpg")
        );
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("jpeg", ".jpeg")
        );

        File file = fileChooser.showSaveDialog(mainPane.getScene().getWindow());
        if (file != null) {
            try {
                ImageIO.write(SwingFXUtils.fromFXImage(imageView.getImage(), null), "png", file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public void rotateCW(){
        System.out.println("CW");
        imageView.setRotate(imageView.getRotate() + 90);
    }

    public void rotateCCW(){
        System.out.println("CW");
        imageView.setRotate(imageView.getRotate() - 90);
    }


}
