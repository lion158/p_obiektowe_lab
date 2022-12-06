package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class IntegrationTest {

    @Test
    void integrationTests() {
        //given
        String[] move = {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};
        MoveDirection[] directions = new OptionsParser().parse(move);
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);

        Vector2d expectedPositionAnimal1 = new Vector2d(2,0);
        Vector2d expectedPositionAnimal2 = new Vector2d(3,5);

        //when
        engine.run();

        //then
        Assertions.assertTrue(map.isOccupied(expectedPositionAnimal1));
        Assertions.assertTrue(map.isOccupied(expectedPositionAnimal2));
        Assertions.assertFalse(map.isOccupied(new Vector2d(0,0)));
        Assertions.assertFalse(map.isOccupied(new Vector2d(2,3)));
    }

    @Test
    void integrationTest2(){
        //given
        String[] move = {"f", "f", "f", "l", "r", "f", "f", "f", "f", "f", "f", "f", "f", "f", "f", "f", "f", "f", "f", "f", "f", "f", "f", "f"};
        MoveDirection[] directions = new OptionsParser().parse(move);
        IWorldMap map = new RectangularMap(7, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(2,3), new Vector2d(2,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);

        Vector2d expectedPositionAnimal1 = new Vector2d(0,2);
        Vector2d expectedPositionAnimal2 = new Vector2d(7,3);
        Vector2d expectedPositionAnimal3 = new Vector2d(2,5);

        //when
        engine.run();

        //then
        Assertions.assertTrue(map.isOccupied(expectedPositionAnimal1));
        Assertions.assertTrue(map.isOccupied(expectedPositionAnimal2));
        Assertions.assertTrue(map.isOccupied(expectedPositionAnimal3));
        Assertions.assertFalse(map.isOccupied(new Vector2d(0,0)));
        Assertions.assertFalse(map.isOccupied(new Vector2d(2,2)));
    }



//    @Test
//    void shouldBeInTheCorrectOrientation(){
//        //given
//        //animal1
//        Animal animal1 = new Animal();
//        MoveDirection[] moveDirectionsForAnimal1 = {MoveDirection.FORWARD, MoveDirection.LEFT, MoveDirection.FORWARD, MoveDirection.RIGHT, MoveDirection.BACKWARD, MoveDirection.LEFT};
//        MapDirection finalDirectionForAnimal1 = MapDirection.WEST;
//        //animal2
//        Animal animal2 = new Animal();
//        MoveDirection[] moveDirectionsForAnimal2 = {MoveDirection.FORWARD, MoveDirection.RIGHT, MoveDirection.FORWARD, MoveDirection.RIGHT,};
//        MapDirection finalDirectionForAnimal2 = MapDirection.SOUTH;
//        //animal3
//        Animal animal3 = new Animal();
//        MoveDirection[] moveDirectionsForAnimal3 = {MoveDirection.BACKWARD, MoveDirection.LEFT, MoveDirection.LEFT, MoveDirection.FORWARD,MoveDirection.FORWARD,MoveDirection.FORWARD, MoveDirection.LEFT, MoveDirection.RIGHT};
//        MapDirection finalDirectionForAnimal3 = MapDirection.SOUTH;
//
//
//        //when
//        //animal1
//        for(MoveDirection moveDirection : moveDirectionsForAnimal1){
//            animal1.move(moveDirection);
//        }
//        //animal2
//        for(MoveDirection moveDirection : moveDirectionsForAnimal2){
//            animal2.move(moveDirection);
//        }
//        //animal3
//        for(MoveDirection moveDirection : moveDirectionsForAnimal3){
//            animal3.move(moveDirection);
//        }
//
//        //then
//        //animal1
//        Assertions.assertEquals(finalDirectionForAnimal1,animal1.getDirection());
//        //animal2
//        Assertions.assertEquals(finalDirectionForAnimal2,animal2.getDirection());
//        //animal3
//        Assertions.assertEquals(finalDirectionForAnimal3,animal3.getDirection());
//    }
//
//    @Test
//    void shouldBeInCorrectPosition(){
//        //given
//        //animal1
//        Animal animal1 = new Animal();
//        MoveDirection[] moveDirectionsForAnimal1 = {MoveDirection.FORWARD, MoveDirection.LEFT, MoveDirection.FORWARD, MoveDirection.RIGHT, MoveDirection.BACKWARD, MoveDirection.LEFT};
//        Vector2d finalPositionForAnimal1 = new Vector2d(1,2);
//        //animal2
//        Animal animal2 = new Animal();
//        MoveDirection[] moveDirectionsForAnimal2 = {MoveDirection.FORWARD, MoveDirection.RIGHT, MoveDirection.FORWARD, MoveDirection.FORWARD,MoveDirection.FORWARD,MoveDirection.LEFT,MoveDirection.FORWARD};
//        Vector2d finalPositionForAnimal2 = new Vector2d(4,4);
//        //animal3
//        Animal animal3 = new Animal();
//        MoveDirection[] moveDirectionsForAnimal3 = {MoveDirection.BACKWARD, MoveDirection.LEFT, MoveDirection.LEFT, MoveDirection.FORWARD,MoveDirection.FORWARD,MoveDirection.FORWARD, MoveDirection.LEFT, MoveDirection.FORWARD};
//        Vector2d finalPositionForAnimal3 = new Vector2d(3,0);
//
//
//        //when
//        //animal1
//        for(MoveDirection moveDirection : moveDirectionsForAnimal1){
//            animal1.move(moveDirection);
//        }
//        //animal2
//        for(MoveDirection moveDirection : moveDirectionsForAnimal2){
//            animal2.move(moveDirection);
//        }
//        //animal3
//        for(MoveDirection moveDirection : moveDirectionsForAnimal3){
//            animal3.move(moveDirection);
//        }
//
//        //then
//        //animal1
//        Assertions.assertEquals(finalPositionForAnimal1,animal1.getPosition());
//        //animal2
//        Assertions.assertEquals(finalPositionForAnimal2,animal2.getPosition());
//        //animal3
//        Assertions.assertEquals(finalPositionForAnimal3,animal3.getPosition());
//    }
//
//    @Test
//    void shouldBeWithinTheMap(){
//        //given
//        //animal1
//        Animal animal1 = new Animal();
//        MoveDirection[] moveDirectionsForAnimal1 = {MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD};
//        Vector2d finalPositionForAnimal1 = new Vector2d(2,4);
//        //animal2
//        Animal animal2 = new Animal();
//        MoveDirection[] moveDirectionsForAnimal2 = {MoveDirection.BACKWARD, MoveDirection.BACKWARD, MoveDirection.BACKWARD, MoveDirection.BACKWARD};
//        Vector2d finalPositionForAnimal2 = new Vector2d(2,0);
//        //animal3
//        Animal animal3 = new Animal();
//        MoveDirection[] moveDirectionsForAnimal3 = {MoveDirection.RIGHT, MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD,MoveDirection.FORWARD};
//        Vector2d finalPositionForAnimal3 = new Vector2d(4,2);
//        //animal4
//        Animal animal4 = new Animal();
//        MoveDirection[] moveDirectionsForAnimal4 = {MoveDirection.LEFT, MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD,MoveDirection.FORWARD};
//        Vector2d finalPositionForAnimal4 = new Vector2d(0,2);
//
//
//        //when
//        //animal1
//        for(MoveDirection moveDirection : moveDirectionsForAnimal1){
//            animal1.move(moveDirection);
//        }
//        //animal2
//        for(MoveDirection moveDirection : moveDirectionsForAnimal2){
//            animal2.move(moveDirection);
//        }
//        //animal3
//        for(MoveDirection moveDirection : moveDirectionsForAnimal3){
//            animal3.move(moveDirection);
//        }
//        //animal4
//        for(MoveDirection moveDirection : moveDirectionsForAnimal4){
//            animal4.move(moveDirection);
//        }
//
//        //then
//        //animal1
//        Assertions.assertEquals(finalPositionForAnimal1,animal1.getPosition());
//        //animal2
//        Assertions.assertEquals(finalPositionForAnimal2,animal2.getPosition());
//        //animal3
//        Assertions.assertEquals(finalPositionForAnimal3,animal3.getPosition());
//        //animal4
//        Assertions.assertEquals(finalPositionForAnimal4,animal4.getPosition());
//    }
//
    @Test
    void shouldCorrectlyInterpretStringArray(){
        //given
        IWorldMap map = new RectangularMap(4,7);
        Vector2d initialPosition = new Vector2d(2,2);

        //animal1
        Animal animal1 = new Animal(map, initialPosition);
        String[] input1 = new String[]{"x", "l", "forward", "right", "backward", "left"};
//        MoveDirection[] moveDirectionsForAnimal1 = new OptionsParser().parse(input1);
        // MoveDirection[] moveDirectionsForAnimal1 = {MoveDirection.FORWARD, MoveDirection.LEFT, MoveDirection.FORWARD, MoveDirection.RIGHT, MoveDirection.BACKWARD, MoveDirection.LEFT};
        Vector2d finalPositionForAnimal1 = new Vector2d(1,2);
        //animal2
        Animal animal2 = new Animal(map, initialPosition);
        String[] input2 = new String[]{"f", "r", "forward", "forward", "f", "left", "f"};
        MoveDirection[] moveDirectionsForAnimal2 = new OptionsParser().parse(input2);
        //MoveDirection[] moveDirectionsForAnimal2 = {MoveDirection.FORWARD, MoveDirection.RIGHT, MoveDirection.FORWARD, MoveDirection.FORWARD,MoveDirection.FORWARD,MoveDirection.LEFT,MoveDirection.FORWARD};
        Vector2d finalPositionForAnimal2 = new Vector2d(4,4);
        //animal3
        Animal animal3 = new Animal(map, initialPosition);
        String[] input3 = new String[]{"b", "l", "left", "forward", "f", "f", "l", "forward"};
        MoveDirection[] moveDirectionsForAnimal3 = new OptionsParser().parse(input3);
        //MoveDirection[] moveDirectionsForAnimal3 = {MoveDirection.BACKWARD, MoveDirection.LEFT, MoveDirection.LEFT, MoveDirection.FORWARD,MoveDirection.FORWARD,MoveDirection.FORWARD, MoveDirection.LEFT, MoveDirection.FORWARD};
        Vector2d finalPositionForAnimal3 = new Vector2d(3,0);


        //when
        //animal1
//        for(MoveDirection moveDirection : moveDirectionsForAnimal1){
//            animal1.move(moveDirection);
//        }

        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new OptionsParser().parse(input1);});

        //animal2
        for(MoveDirection moveDirection : moveDirectionsForAnimal2){
            animal2.move(moveDirection);
        }
        //animal3
        for(MoveDirection moveDirection : moveDirectionsForAnimal3){
            animal3.move(moveDirection);
        }

        //then
        //animal1
        Assertions.assertEquals("x is not legal move specification",exception.getMessage());
        //animal2
        Assertions.assertEquals(finalPositionForAnimal2,animal2.getPosition());
        //animal3
        Assertions.assertEquals(finalPositionForAnimal3,animal3.getPosition());

    }
}
