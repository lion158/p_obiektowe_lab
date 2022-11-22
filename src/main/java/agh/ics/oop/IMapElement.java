package agh.ics.oop;

public interface IMapElement {
    /**
     * @param element map element
     * @return Vector2d  of element position.
     */
    Vector2d getPosition(Object element);

    /**
     * @param position position to check
     * @return Return true if is at the position, false otherwise.
     */
    boolean isAt(Vector2d position);

}
