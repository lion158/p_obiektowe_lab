package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

import java.util.Objects;


public class App extends Application{

    private IWorldMap map;
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
            IEngine engine = new SimulationEngine(directions, map, positions);
            engine.run();
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
//        Label label = new Label("Zwierzak");
//        Label label1 = new Label("Zwierzak1");
//        Label label2 = new Label("Zwierzak2");
//        Label label3 = new Label("Zwierzak3");
        GridPane gridPane = new GridPane();
        gridPane.setGridLinesVisible(true);
        ////////////////
//        gridPane.add(new Label("test1"), 0,0);
//        gridPane.add(new Label("test1"), 0,1);
        int minX = map.getLowerBound().x;
        int minY = map.getLowerBound().y;
        int maxX = map.getUpperBound().x;
        int maxY = map.getUpperBound().y;
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
                }
                else {
                    Label label = new Label(""+ returnObject(minX,maxY,i,j));
                    gridPane.add(label,i, j);
                    gridPane.setHalignment(label, HPos.CENTER);
                }
            }
        }

        for(int i=0; i< (maxX-minX + 2); i++){
            gridPane.getColumnConstraints().add(new ColumnConstraints(22));
        }
        for(int j=0; j< (maxY-minY + 2 ); j++){
            gridPane.getRowConstraints().add(new RowConstraints(22));
        }
//        gridPane.addRow(0,label );
//        gridPane.addRow(0,label1 );
//        gridPane.addRow(0,label2 );
//        gridPane.addColumn(0,label3);
//        double width = 50;
//        gridPane.getColumnConstraints().add(new ColumnConstraints(width));
//        double height = 50;
//        gridPane.getRowConstraints().add(new RowConstraints(height));
//        GridPane.setHalignment(label, HPos.CENTER)
        Scene scene = new Scene(gridPane, 400, 400);


        primaryStage.setScene(scene);
        primaryStage.show();


//        grid.setGridLinesVisible(true);
//        GridPane gridPane = new GridPane();
//        gridPane.add();
    }
    protected Object returnObject(int minX, int maxY, int i, int j){
        Object object = map.objectAt(new Vector2d(minX+i - 1,maxY-j + 1));
        return Objects.requireNonNullElse(object, "");
    }


}
