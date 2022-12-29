package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.security.cert.PolicyNode;
import java.util.Objects;


public class App extends Application implements IPositionChange{

    private IWorldMap map;
    GridPane gridPane = new GridPane();
    SimulationEngine engine;
    @Override
    public void init(){
        String[] args = getParameters().getRaw().toArray(new String[0]);
//        Application.launch(App.class, args);
        try {
            System.out.println("System wystartował");

            MoveDirection[] directions = new OptionsParser().parse(args);
//            IWorldMap map = new RectangularMap(10, 5);
            map = new GrassField(10);
            Vector2d[] positions = { new Vector2d(2,2),new Vector2d(1,1), new Vector2d(3,4) };
            System.out.println(map.toString());
//            SimulationEngine engine = new SimulationEngine(directions, map, positions);
            engine = new SimulationEngine(directions, map, positions);
            engine.addObserver(this);
            engine.run();

            // new Threat threat.start
//            Thread thread = new Thread();
//            thread.start();

//            Thread engineThread = new Thread(engine);
//            engineThread.start();
            //////////////////////
            System.out.println(map.toString());
            System.out.println("System zakończył działanie");
        }
        catch (IllegalArgumentException ex){
            System.out.println("Exception: " + ex.getMessage());
            System.exit(0);
        }
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.show();

        gridPane.setGridLinesVisible(true);

        int minX = map.getLowerBound().x;
        int minY = map.getLowerBound().y;
        int maxX = map.getUpperBound().x;
        int maxY = map.getUpperBound().y;


        Button button1 = new Button("Start");
        TextField textField = new TextField();
        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //////engine.setfirection
                String text = textField.getText();
                System.out.println(text);
                Thread thread = new Thread(engine);
                thread.start();
            }
        });

        HBox hbox = new HBox(button1, textField);
        VBox vbox = new VBox(hbox, gridPane);

        //2 pętle for
        for(int i=0; i< (maxX-minX + 2); i++){
//            gridPane.getColumnConstraints().add(new ColumnConstraints(20));
            for(int j=0; j< (maxY-minY + 2 ); j++){
//                gridPane.getRowConstraints().add(new RowConstraints(15));
                if(j==0 && i==0){
                    Label label = new Label("y/x");
                    gridPane.add(label,i, j);
                    gridPane.setHalignment(label, HPos.CENTER);
                } else if (j==0 && i > 0) {
                    Label label = new Label(""+(minX+i - 1));
                    gridPane.add(label, i, j);
                    gridPane.setHalignment(label, HPos.CENTER);
                } else if (i == 0 && j > 0) {
                    Label label = new Label(""+(maxY-j + 1));
                    gridPane.add(label,i, j);
                    gridPane.setHalignment(label, HPos.CENTER);
                }else {
                    Object object = returnObject(minX,maxY,i,j);
                    Label label;
                    if (object.getClass() == Animal.class){
                        GuiElementBox element = new GuiElementBox((IMapElement) object);
                        gridPane.add(element.getVbox(), i, j);
//                        label = new Label(element.toString());

                    } else if (object.getClass() == Grass.class) {
                        GuiElementBox element = new GuiElementBox((IMapElement) object);
                        gridPane.add(element.getVbox(), i, j);
//                        label = new Label(element.toString());
                    } else {
                        label = new Label(""+ returnObject(minX,maxY,i,j) );
                        gridPane.add(label,i, j);
                    }
//                    GuiElementBox element = new GuiElementBox((IMapElement) object);
//                    Label label = new Label(""+ element);
//                    gridPane.add(label,i, j);
//                    gridPane.setHalignment(label, HPos.CENTER);
                }
//                else {
//                    Label label = new Label(""+ returnObject(minX,maxY,i,j));
//                    gridPane.add(label,i, j);
//                    gridPane.setHalignment(label, HPos.CENTER);
//                }
            }
        }

        for(int i=0; i< (maxX-minX + 2); i++){
            gridPane.getColumnConstraints().add(new ColumnConstraints(22));
        }
        for(int j=0; j< (maxY-minY + 2 ); j++){
            gridPane.getRowConstraints().add(new RowConstraints(22));
        }

        Scene scene = new Scene(vbox, 400, 400);


        primaryStage.setScene(scene);
        primaryStage.show();

    }
    protected Object returnObject(int minX, int maxY, int i, int j){
        Object object = map.objectAt(new Vector2d(minX+i - 1,maxY-j + 1));
        return Objects.requireNonNullElse(object, "");
    }
    @Override
    public void positionChanged() {
        Platform.runLater(() -> {
            //tutaj zrób grida
//            tutaj odmaluj
//            stage.setScen(ne S)
//                    stageshow
            gridPane.getChildren().clear();
            engine.run();
        });
    }
}
