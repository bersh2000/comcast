package com.comcast.csv.interview.problems;

import java.awt.Rectangle;

/**
 * Using absolute coordinates for EVERYTHING, implement the following methods to position the inner rectangle relative
 * to the outer rectangle.
 */
public class PojoAlgProblem {

    /**
     * Put the inner rectangle so that it's bottom right corner aligns with the bottom right corner of the outer
     * rectangle.
     * 
     * @param inner the inner rectangle to position
     * @param outer the outer rectangle to use as a reference
     */
    public void bottomRight(Rectangle inner, Rectangle outer) {
        inner.setRect(outer.getX() + outer.getWidth() - inner.getWidth(),
                outer.getY()- outer.getHeight()+ inner.getHeight(),
                inner.getWidth(), inner.getHeight());

    }

    /**
     * Put the inner rectangle so that it is centered vertically and horizontally 
     * 
     * @param inner the inner rectangle to position
     * @param outer the outer rectangle to use as a reference
     */
    public void middleCenter(Rectangle inner, Rectangle outer) {
        inner.setRect(outer.getCenterX() - (inner.getX()/2.0),
                outer.getY() - (outer.getHeight() / 2.0) + (inner.getHeight()/2.0),
                inner.getWidth(),
                inner.getHeight()
                );
    }
}
