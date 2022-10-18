package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MapDirectionTest {

    @Test
    void nextTest(){
        MapDirection north = MapDirection.NORTH;
        MapDirection south = MapDirection.SOUTH;
        MapDirection east  = MapDirection.EAST;
        MapDirection west  = MapDirection.WEST;

        Assertions.assertEquals(MapDirection.EAST, north.next());
        Assertions.assertEquals(MapDirection.WEST, south.next());
        Assertions.assertEquals(MapDirection.SOUTH, east.next());
        Assertions.assertEquals(MapDirection.NORTH, west.next());
    }

    @Test
    void previousTest(){
        MapDirection north = MapDirection.NORTH;
        MapDirection south = MapDirection.SOUTH;
        MapDirection east  = MapDirection.EAST;
        MapDirection west  = MapDirection.WEST;

        Assertions.assertEquals( MapDirection.WEST, north.previous());
        Assertions.assertEquals( MapDirection.EAST, south.previous());
        Assertions.assertEquals( MapDirection.NORTH, east.previous());
        Assertions.assertEquals( MapDirection.SOUTH, west.previous());
    }
}
