package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Vector2dTest {

    //given

    //when

    //then

    @Test
    void equalsTest(){
        Vector2d v1 = new Vector2d(1,1);
        Vector2d v2 = new Vector2d(1,1);

        Vector2d v3 = new Vector2d(-2,-4);
        Vector2d v4 = new Vector2d(-2,-4);

        Vector2d v5 = new Vector2d(-2,3);
        Vector2d v6 = new Vector2d(-2,3);

        //Object.equals
        Assertions.assertEquals(true, v1.equals(v2) );
        Assertions.assertEquals(true,v3.equals(v4));
        Assertions.assertEquals(true, v5.equals(v6));
        Assertions.assertEquals(false, v2.equals(v4));
        Assertions.assertEquals(false, v5.equals(v1));
    }

    @Test
    void toStringTest(){
        Vector2d v1 = new Vector2d(1,1);
        Vector2d v2 = new Vector2d(-2,-4);
        Vector2d v3 = new Vector2d(-2,3);
        Vector2d v4 = new Vector2d(0,0);


        Assertions.assertEquals("(1, 1)", v1.toString());
        Assertions.assertEquals("(-2, -4)", v2.toString());
        Assertions.assertEquals("(-2, 3)", v3.toString());
        Assertions.assertEquals("(0, 0)", v4.toString());
    }

    @Test
    void precedesTest(){
        Vector2d v1 = new Vector2d(1,1);
        Vector2d v2 = new Vector2d(2,2);

        Vector2d v3 = new Vector2d(-2,-4);
        Vector2d v4 = new Vector2d(0,-4);

        Vector2d v5 = new Vector2d(-2,3);
        Vector2d v6 = new Vector2d(558839993,233212222);

        Assertions.assertEquals(true, v1.precedes(v2));
        Assertions.assertEquals(true, v3.precedes(v4));
        Assertions.assertEquals(true, v5.precedes(v6));
        Assertions.assertEquals(false, v2.precedes(v1));
        Assertions.assertEquals(false, v4.precedes(v3));
        Assertions.assertEquals(false, v6.precedes(v2));
    }

    @Test
    void followsTest(){
        Vector2d v1 = new Vector2d(1,1);
        Vector2d v2 = new Vector2d(2,2);

        Vector2d v3 = new Vector2d(-2,-4);
        Vector2d v4 = new Vector2d(0,-4);

        Vector2d v5 = new Vector2d(-2,3);
        Vector2d v6 = new Vector2d(558839993,233212222);


        Assertions.assertEquals(true, v2.follows(v1));
        Assertions.assertEquals(true, v4.follows(v3));
        Assertions.assertEquals(true, v6.follows(v5));
        Assertions.assertEquals(false, v1.follows(v2));
        Assertions.assertEquals(false, v3.follows(v4));
        Assertions.assertEquals(false, v2.follows(v6));
    }

    @Test
    void upperRightTest(){
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(2,1);
        Vector2d v3 = new Vector2d(1,2);
        Vector2d v4 = new Vector2d(-1,-2);
        Vector2d v5 = new Vector2d(-10,-20);

        Assertions.assertEquals( new Vector2d(2,2), v1.upperRight(v2));
        Assertions.assertEquals( new Vector2d(1,2), v1.upperRight(v3));
        Assertions.assertEquals( new Vector2d(-1,-2), v4.upperRight(v5));

    }

    @Test
    void lowerLeftTest(){
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(2,1);
        Vector2d v3 = new Vector2d(1,2);
        Vector2d v4 = new Vector2d(-1,-2);
        Vector2d v5 = new Vector2d(-10,-20);

        Assertions.assertEquals( new Vector2d(1,1), v1.lowerLeft(v2));
        Assertions.assertEquals( new Vector2d(1,2), v1.lowerLeft(v3));
        Assertions.assertEquals( new Vector2d(-10,-20), v4.lowerLeft(v5));
    }

    @Test
    void addTest(){
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(2,1);
        Vector2d v3 = new Vector2d(0,0);
        Vector2d v4 = new Vector2d(-1,-2);

        Assertions.assertEquals(new Vector2d(3,3),v1.add(v2));
        Assertions.assertEquals(new Vector2d(1,2),v1.add(v3));
        Assertions.assertEquals(new Vector2d(0,0),v1.add(v4));
    }

    @Test
    void subtractTest(){
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(2,1);
        Vector2d v3 = new Vector2d(0,0);
        Vector2d v4 = new Vector2d(-1,-2);

        Assertions.assertEquals(new Vector2d(-1,1),v1.subtract(v2));
        Assertions.assertEquals(new Vector2d(1,2),v1.subtract(v3));
        Assertions.assertEquals(new Vector2d(2,4),v1.subtract(v4));
    }

    @Test
    void oppositeTest(){
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(-2,-1);
        Vector2d v3 = new Vector2d(0,0);
        Vector2d v4 = new Vector2d(-1,2);

        Assertions.assertEquals(new Vector2d(-1,-2),v1.opposite());
        Assertions.assertEquals(new Vector2d(2,1),v2.opposite());
        Assertions.assertEquals(new Vector2d(0,0),v3.opposite());
        Assertions.assertEquals(new Vector2d(1,-2),v4.opposite());
    }

}
