package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GrassFieldTest {

    @Test
    void canMoveToTest(){
        //given
        IWorldMap grassFieldMap = new GrassField(10);
        String[] move = {};
        MoveDirection[] directions = new OptionsParser().parse(move);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(2,1), new Vector2d(-3,-10) };

        //when
        SimulationEngine engine = new SimulationEngine(directions, grassFieldMap, positions);
        boolean try1 = grassFieldMap.canMoveTo(new Vector2d(2,2));
        boolean try2 = grassFieldMap.canMoveTo(new Vector2d(2,1));
        boolean try3 = grassFieldMap.canMoveTo(new Vector2d(-3,-10));
        boolean try4 = grassFieldMap.canMoveTo(new Vector2d(0,0));
        boolean try5 = grassFieldMap.canMoveTo(new Vector2d(110,-5000));


        //then
        Assertions.assertFalse(try1);
        Assertions.assertFalse(try2);
        Assertions.assertFalse(try3);
        Assertions.assertTrue(try4);
        Assertions.assertTrue(try5);
    }

    @Test
    void placeTest(){
        //given
        IWorldMap grassFieldMap = new GrassField(10);
        String[] move = {};
        MoveDirection[] directions = new OptionsParser().parse(move);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(2,1), new Vector2d(-3,-10) };

        //when
        SimulationEngine engine = new SimulationEngine(directions, grassFieldMap, positions);
//        boolean try1 = grassFieldMap.place(new Animal(grassFieldMap, new Vector2d(2,2)));
//        boolean try2 = grassFieldMap.place(new Animal(grassFieldMap, new Vector2d(2,1)));
//        boolean try3 = grassFieldMap.place(new Animal(grassFieldMap, new Vector2d(-3,-10)));
        boolean try4 = grassFieldMap.place(new Animal(grassFieldMap, new Vector2d(0,0)));
        boolean try5 = grassFieldMap.place(new Animal(grassFieldMap, new Vector2d(110,-5000)));


        //then
//        Assertions.assertFalse(try1);
//        Assertions.assertFalse(try2);
//        Assertions.assertFalse(try3);
        Exception exception1 = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            grassFieldMap.place(new Animal(grassFieldMap, new Vector2d(2,2)));});
        Exception exception2 = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            grassFieldMap.place(new Animal(grassFieldMap, new Vector2d(2,1)));});
        Exception exception3 = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            grassFieldMap.place(new Animal(grassFieldMap, new Vector2d(-3,-10)));});
//        Exception exception5 = Assertions.assertThrows(IllegalArgumentException.class, () -> {
//            grassFieldMap.place(new Animal(grassFieldMap, new Vector2d(110,-5000)));});

        Assertions.assertEquals("Position: (2, 2) is occupied", exception1.getMessage());
        Assertions.assertEquals("Position: (2, 1) is occupied", exception2.getMessage());
        Assertions.assertEquals("Position: (-3, -10) is occupied", exception3.getMessage());
        Assertions.assertTrue(try4);
        Assertions.assertTrue(try5);
    }

    @Test
    void isOccupiedTest(){
        //given
        IWorldMap grassFieldMap = new GrassField(10);
        String[] move = {};
        MoveDirection[] directions = new OptionsParser().parse(move);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(2,1), new Vector2d(-3,-10) };

        //when
        SimulationEngine engine = new SimulationEngine(directions, grassFieldMap, positions);
        boolean try1 = grassFieldMap.isOccupied(new Vector2d(2,2));
        boolean try2 = grassFieldMap.isOccupied(new Vector2d(2,1));
        boolean try3 = grassFieldMap.isOccupied(new Vector2d(-3,-10));
        boolean try4 = grassFieldMap.isOccupied(new Vector2d(1000,10000));
        boolean try5 = grassFieldMap.isOccupied(new Vector2d(-110,-5000));


        //then
        Assertions.assertTrue(try1);
        Assertions.assertTrue(try2);
        Assertions.assertTrue(try3);
        Assertions.assertFalse(try4);
        Assertions.assertFalse(try5);

    }

    @Test
    void objectAtTest(){
        //given
        IWorldMap grassFieldMap = new GrassField(10);
        String[] move = {};
        MoveDirection[] directions = new OptionsParser().parse(move);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(2,1), new Vector2d(-3,-10) };

        //when
        SimulationEngine engine = new SimulationEngine(directions, grassFieldMap, positions);
        Object try1 = grassFieldMap.objectAt(new Vector2d(2,2));
        Object try2 = grassFieldMap.objectAt(new Vector2d(2,1));
        Object try3 = grassFieldMap.objectAt(new Vector2d(-3,-10));
        Object try4 = grassFieldMap.objectAt(new Vector2d(1000,10000));
        Object try5 = grassFieldMap.objectAt(new Vector2d(-110,-5000));


        //then
        Assertions.assertNotNull(try1);
        Assertions.assertNotNull(try2);
        Assertions.assertNotNull(try3);
        assertNull(try4);
        assertNull(try5);
    }

}