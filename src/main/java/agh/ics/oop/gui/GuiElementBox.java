package agh.ics.oop.gui;

import agh.ics.oop.IMapElement;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class GuiElementBox {

    VBox vbox;
    public GuiElementBox(IMapElement element) throws FileNotFoundException {
        Image image = new Image(new FileInputStream(element.getPath()));
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(20);
        imageView.setFitHeight(20);
        Label label = new Label(element.getPosition().toString());
        vbox = new VBox(imageView);/////////////////////////label
        vbox.setAlignment(Pos.BASELINE_CENTER);
    }

    public VBox getVbox() {
        return vbox;
    }
}
