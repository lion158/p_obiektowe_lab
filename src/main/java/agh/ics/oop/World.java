package agh.ics.oop;

import agh.ics.oop.gui.App;
import javafx.application.Application;

import javax.swing.text.Position;

public class World {

    public static void run(Direction[] directions){
        for(int i=0; i< directions.length-1;i++){
            System.out.print(directions[i] + ", ");


        }
        System.out.println(directions[directions.length-1]);

        // alternatywna opcja:

//        String joinedDirections = String.join( ", ", directions);
//        System.out.println(joinedDirections);


        for(Direction direction: directions){
            switch (direction){
                case f -> System.out.println("Zwierzak idzie do przodu");
                case b -> System.out.println("Zwierzak idzie do tyłu");
                case r -> System.out.println("Zwierzak skręca w prawo");
                case l -> System.out.println("Zwierzak skręca w lewo");
                //default -> null;
            }
        }

    }
    public static Direction [] change(String[] strings){
        Direction[] directions = new Direction[strings.length];
//        for(String string: strings){
//            switch (string){
//                case "f" -> directions
//
//            }
//        }

        for (int i = 0; i < strings.length; i++) {
            switch (strings[i]){
                case "f" -> directions[i] = Direction.f;
                case "b" -> directions[i] = Direction.b;
                case "r" -> directions[i] = Direction.r;
                case "l" -> directions[i] = Direction.l;
                //default -> null;
            }

        }

        return directions;
    }
    public static void main(String[] args){
        Application.launch(App.class, args);

//        System.out.println("System wystartował");

//        Direction qwerty = Direction.l;

//        Direction[] directions;
//        // switch casami
//        for(int i = 0; i < args.length; i++){
//            directions[i] = Direction.valueOf(args[i]);
//        }

//        Direction[] changeValue = change(args);
//
//
//        run(changeValue);
//        //run(directions);
//
//
//        Vector2d position1 = new Vector2d(1,2);
//        System.out.println(position1);
//        Vector2d position2 = new Vector2d(-2,1);
//        System.out.println(position2);
//        System.out.println(position1.add(position2));
//
//        MapDirection north = MapDirection.NORTH;
//
//        System.out.println(north.toUnitVector());

//        Animal animal = new Animal();
//        Vector2d position = new Vector2d(2,2);
//        System.out.println(animal.toString());
//        System.out.println(animal.getPosition());
//        System.out.println(animal.isAt(position));
//
//
//        System.out.println("move test:");
//        animal.move(MoveDirection.RIGHT);
//        animal.move(MoveDirection.FORWARD);
//        animal.move(MoveDirection.FORWARD);
//        animal.move(MoveDirection.FORWARD);
//        System.out.println(animal.toString());
//        System.out.println(animal.getPosition());
//
//
//        MoveDirection[] moveDirections = new OptionsParser().parse(args);
//
//        for(MoveDirection moveDirection : moveDirections){
//            animal.move(moveDirection);
//        }
//
//        System.out.println(animal.toString());



//        MoveDirection[] directions = new OptionsParser().parse(args);
//        IWorldMap map = new RectangularMap(10, 5);
//        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
//        System.out.println(map.toString());
//        IEngine engine = new SimulationEngine(directions, map, positions);
//        engine.run();
//        System.out.println(map.toString());

//        MoveDirection[] directions = new OptionsParser().parse(args);
////        AbstractWorldMap map = new RectangularMap(10, 5);
//        IWorldMap grasMap = new GrassField(3);
//        System.out.println(grasMap.toString());
//        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
//        IEngine engine = new SimulationEngine(directions, grasMap, positions);
//        engine.run();
////        System.out.println(map.toString());
//        System.out.println(grasMap.toString());


//        System.out.println("System zakończył działani


        try {
            System.out.println("System wystartował");

            MoveDirection[] directions = new OptionsParser().parse(args);
//            IWorldMap map = new RectangularMap(10, 5);
            IWorldMap map = new GrassField(15);
            Vector2d[] positions = { new Vector2d(2,2),new Vector2d(15,14), new Vector2d(3,4) };
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
        ////////////////////////////////////////////TESTY

    }
}
