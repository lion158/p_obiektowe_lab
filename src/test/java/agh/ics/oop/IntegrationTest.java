package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IntegrationTest {

    @Test
    void shouldBeInTheCorrectOrientation(){
        //given
        //animal1
        Animal animal1 = new Animal();
        MoveDirection[] moveDirectionsForAnimal1 = {MoveDirection.FORWARD, MoveDirection.LEFT, MoveDirection.FORWARD, MoveDirection.RIGHT, MoveDirection.BACKWARD, MoveDirection.LEFT};
        MapDirection finalDirectionForAnimal1 = MapDirection.WEST;
        //animal2
        Animal animal2 = new Animal();
        MoveDirection[] moveDirectionsForAnimal2 = {MoveDirection.FORWARD, MoveDirection.RIGHT, MoveDirection.FORWARD, MoveDirection.RIGHT,};
        MapDirection finalDirectionForAnimal2 = MapDirection.SOUTH;
        //animal3
        Animal animal3 = new Animal();
        MoveDirection[] moveDirectionsForAnimal3 = {MoveDirection.BACKWARD, MoveDirection.LEFT, MoveDirection.LEFT, MoveDirection.FORWARD,MoveDirection.FORWARD,MoveDirection.FORWARD, MoveDirection.LEFT, MoveDirection.RIGHT};
        MapDirection finalDirectionForAnimal3 = MapDirection.SOUTH;


        //when
        //animal1
        for(MoveDirection moveDirection : moveDirectionsForAnimal1){
            animal1.move(moveDirection);
        }
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
        Assertions.assertEquals(finalDirectionForAnimal1,animal1.getDirection());
        //animal2
        Assertions.assertEquals(finalDirectionForAnimal2,animal2.getDirection());
        //animal3
        Assertions.assertEquals(finalDirectionForAnimal3,animal3.getDirection());
    }

    @Test
    void shouldBeInCorrectPosition(){
        //given
        //animal1
        Animal animal1 = new Animal();
        MoveDirection[] moveDirectionsForAnimal1 = {MoveDirection.FORWARD, MoveDirection.LEFT, MoveDirection.FORWARD, MoveDirection.RIGHT, MoveDirection.BACKWARD, MoveDirection.LEFT};
        Vector2d finalPositionForAnimal1 = new Vector2d(1,2);
        //animal2
        Animal animal2 = new Animal();
        MoveDirection[] moveDirectionsForAnimal2 = {MoveDirection.FORWARD, MoveDirection.RIGHT, MoveDirection.FORWARD, MoveDirection.FORWARD,MoveDirection.FORWARD,MoveDirection.LEFT,MoveDirection.FORWARD};
        Vector2d finalPositionForAnimal2 = new Vector2d(4,4);
        //animal3
        Animal animal3 = new Animal();
        MoveDirection[] moveDirectionsForAnimal3 = {MoveDirection.BACKWARD, MoveDirection.LEFT, MoveDirection.LEFT, MoveDirection.FORWARD,MoveDirection.FORWARD,MoveDirection.FORWARD, MoveDirection.LEFT, MoveDirection.FORWARD};
        Vector2d finalPositionForAnimal3 = new Vector2d(3,0);


        //when
        //animal1
        for(MoveDirection moveDirection : moveDirectionsForAnimal1){
            animal1.move(moveDirection);
        }
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
        Assertions.assertEquals(finalPositionForAnimal1,animal1.getPosition());
        //animal2
        Assertions.assertEquals(finalPositionForAnimal2,animal2.getPosition());
        //animal3
        Assertions.assertEquals(finalPositionForAnimal3,animal3.getPosition());
    }

    @Test
    void shouldBeWithinTheMap(){
        //given
        //animal1
        Animal animal1 = new Animal();
        MoveDirection[] moveDirectionsForAnimal1 = {MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD};
        Vector2d finalPositionForAnimal1 = new Vector2d(2,4);
        //animal2
        Animal animal2 = new Animal();
        MoveDirection[] moveDirectionsForAnimal2 = {MoveDirection.BACKWARD, MoveDirection.BACKWARD, MoveDirection.BACKWARD, MoveDirection.BACKWARD};
        Vector2d finalPositionForAnimal2 = new Vector2d(2,0);
        //animal3
        Animal animal3 = new Animal();
        MoveDirection[] moveDirectionsForAnimal3 = {MoveDirection.RIGHT, MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD,MoveDirection.FORWARD};
        Vector2d finalPositionForAnimal3 = new Vector2d(4,2);
        //animal4
        Animal animal4 = new Animal();
        MoveDirection[] moveDirectionsForAnimal4 = {MoveDirection.LEFT, MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD,MoveDirection.FORWARD};
        Vector2d finalPositionForAnimal4 = new Vector2d(0,2);


        //when
        //animal1
        for(MoveDirection moveDirection : moveDirectionsForAnimal1){
            animal1.move(moveDirection);
        }
        //animal2
        for(MoveDirection moveDirection : moveDirectionsForAnimal2){
            animal2.move(moveDirection);
        }
        //animal3
        for(MoveDirection moveDirection : moveDirectionsForAnimal3){
            animal3.move(moveDirection);
        }
        //animal4
        for(MoveDirection moveDirection : moveDirectionsForAnimal4){
            animal4.move(moveDirection);
        }

        //then
        //animal1
        Assertions.assertEquals(finalPositionForAnimal1,animal1.getPosition());
        //animal2
        Assertions.assertEquals(finalPositionForAnimal2,animal2.getPosition());
        //animal3
        Assertions.assertEquals(finalPositionForAnimal3,animal3.getPosition());
        //animal4
        Assertions.assertEquals(finalPositionForAnimal4,animal4.getPosition());
    }

    @Test
    void shouldCorrectlyInterpretStringArray(){
        //given
        //animal1
        Animal animal1 = new Animal();
        String[] input1 = new String[]{"f", "l", "forward", "right", "backward", "left"};
        MoveDirection[] moveDirectionsForAnimal1 = new OptionsParser().parse(input1);
        // MoveDirection[] moveDirectionsForAnimal1 = {MoveDirection.FORWARD, MoveDirection.LEFT, MoveDirection.FORWARD, MoveDirection.RIGHT, MoveDirection.BACKWARD, MoveDirection.LEFT};
        Vector2d finalPositionForAnimal1 = new Vector2d(1,2);
        //animal2
        Animal animal2 = new Animal();
        String[] input2 = new String[]{"f", "r", "forward", "forward", "f", "left", "f"};
        MoveDirection[] moveDirectionsForAnimal2 = new OptionsParser().parse(input2);
        //MoveDirection[] moveDirectionsForAnimal2 = {MoveDirection.FORWARD, MoveDirection.RIGHT, MoveDirection.FORWARD, MoveDirection.FORWARD,MoveDirection.FORWARD,MoveDirection.LEFT,MoveDirection.FORWARD};
        Vector2d finalPositionForAnimal2 = new Vector2d(4,4);
        //animal3
        Animal animal3 = new Animal();
        String[] input3 = new String[]{"b", "l", "left", "forward", "f", "f", "l", "forward"};
        MoveDirection[] moveDirectionsForAnimal3 = new OptionsParser().parse(input3);
        //MoveDirection[] moveDirectionsForAnimal3 = {MoveDirection.BACKWARD, MoveDirection.LEFT, MoveDirection.LEFT, MoveDirection.FORWARD,MoveDirection.FORWARD,MoveDirection.FORWARD, MoveDirection.LEFT, MoveDirection.FORWARD};
        Vector2d finalPositionForAnimal3 = new Vector2d(3,0);


        //when
        //animal1
        for(MoveDirection moveDirection : moveDirectionsForAnimal1){
            animal1.move(moveDirection);
        }
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
        Assertions.assertEquals(finalPositionForAnimal1,animal1.getPosition());
        //animal2
        Assertions.assertEquals(finalPositionForAnimal2,animal2.getPosition());
        //animal3
        Assertions.assertEquals(finalPositionForAnimal3,animal3.getPosition());

    }
}
