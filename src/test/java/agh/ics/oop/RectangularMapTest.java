package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangularMapTest {
    @Test
    void canMoveToTest(){
        //given
        IWorldMap rectangularMap = new RectangularMap(10, 12);
        String[] move = {};
        MoveDirection[] directions = new OptionsParser().parse(move);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(2,1),}; //new Vector2d(-3,-10) };

        //when

        SimulationEngine engine = new SimulationEngine(directions, rectangularMap, positions);
        boolean try1 = rectangularMap.canMoveTo(new Vector2d(2,2));
        boolean try2 = rectangularMap.canMoveTo(new Vector2d(2,1));
//        boolean try3 = rectangularMap.canMoveTo(new Vector2d(-3,-10));
//        boolean try4 = rectangularMap.canMoveTo(new Vector2d(0,0));
//        boolean try5 = rectangularMap.canMoveTo(new Vector2d(110,-5000));


        //then
        Assertions.assertFalse(try1);
        Assertions.assertFalse(try2);
//        Exception exception3 = assertThrows(IllegalArgumentException.class,() ->{
//            rectangularMap.canMoveTo(new Vector2d(-3,-10));
//        });

//        Assertions.assertEquals("Position: (-3, -10) is not legal (outside the map)", exception3.getMessage());
//        Assertions.assertFalse(try3);
//        Assertions.assertTrue(try4);
//        Assertions.assertFalse(try5);
    }

    @Test
    void placeTest(){
        //given
        IWorldMap rectangularMap = new RectangularMap(10,12);
        String[] move = {};
        MoveDirection[] directions = new OptionsParser().parse(move);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(2,1)};

        //when
        SimulationEngine engine = new SimulationEngine(directions, rectangularMap, positions);
//        boolean try1 = rectangularMap.place(new Animal(rectangularMap, new Vector2d(2,2)));
//        boolean try2 = rectangularMap.place(new Animal(rectangularMap, new Vector2d(2,1)));
//        boolean try3 = rectangularMap.place(new Animal(rectangularMap, new Vector2d(-3,-10)));
        boolean try4 = rectangularMap.place(new Animal(rectangularMap, new Vector2d(0,0)));
//        boolean try5 = rectangularMap.place(new Animal(rectangularMap, new Vector2d(110,-5000)));


        Exception exception1 = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            rectangularMap.place(new Animal(rectangularMap, new Vector2d(2,2)));});
        Exception exception2 = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            rectangularMap.place(new Animal(rectangularMap, new Vector2d(2,1)));});
        Exception exception3 = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            rectangularMap.place(new Animal(rectangularMap, new Vector2d(-3,-10)));});
        Exception exception5 = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            rectangularMap.place(new Animal(rectangularMap, new Vector2d(110,-5000)));});

        //then
//        Assertions.assertFalse(try1);
//        Assertions.assertFalse(try2);
//        Assertions.assertFalse(try3);

        Assertions.assertEquals("Position: (2, 2) is occupied", exception1.getMessage());
        Assertions.assertEquals("Position: (2, 1) is occupied", exception2.getMessage());
        Assertions.assertEquals("Position: (-3, -10) is not legal (outside the map)", exception3.getMessage());
        Assertions.assertTrue(try4);
        Assertions.assertEquals("Position: (110, -5000) is not legal (outside the map)", exception5.getMessage());
    }

    @Test
    void isOccupiedTest(){
        //given
        IWorldMap rectangularMap = new RectangularMap(10,12);
        String[] move = {};
        MoveDirection[] directions = new OptionsParser().parse(move);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(2,1)};

        //when
        SimulationEngine engine = new SimulationEngine(directions, rectangularMap, positions);
        boolean try1 = rectangularMap.isOccupied(new Vector2d(2,2));
        boolean try2 = rectangularMap.isOccupied(new Vector2d(2,1));
        boolean try3 = rectangularMap.isOccupied(new Vector2d(-3,-10));
        boolean try4 = rectangularMap.isOccupied(new Vector2d(1,1));
        boolean try5 = rectangularMap.isOccupied(new Vector2d(-110,-5000));


        //then
        Assertions.assertTrue(try1);
        Assertions.assertTrue(try2);
        Assertions.assertFalse(try3);
        Assertions.assertFalse(try4);
        Assertions.assertFalse(try5);

    }

    @Test
    void objectAtTest(){
        //given
        IWorldMap rectangularMap = new RectangularMap(10, 12);
        String[] move = {};
        MoveDirection[] directions = new OptionsParser().parse(move);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(2,1),};

        //when
        SimulationEngine engine = new SimulationEngine(directions, rectangularMap, positions);
        Object try1 = rectangularMap.objectAt(new Vector2d(2,2));
        Object try2 = rectangularMap.objectAt(new Vector2d(2,1));
        Object try3 = rectangularMap.objectAt(new Vector2d(-3,-10));
        Object try4 = rectangularMap.objectAt(new Vector2d(1,1));
        Object try5 = rectangularMap.objectAt(new Vector2d(-110,-5000));


        //then
        Assertions.assertNotNull(try1);
        Assertions.assertNotNull(try2);
        assertNull(try3);
        assertNull(try4);
        assertNull(try5);
    }

}