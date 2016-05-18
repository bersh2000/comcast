package com.comcast.csv.interview.problems;

import org.testng.annotations.Test;

import java.awt.*;

import static org.testng.Assert.*;

public class PojoAlgProblemTest {

    @Test
    public void testBottomRight() throws Exception {
        PojoAlgProblem p = new PojoAlgProblem();
        Rectangle inner = new Rectangle(-10, 10, 10, 10);
        Rectangle outer = new Rectangle(10, -10, 100, 100);
        p.bottomRight(inner, outer);
        assertEquals(inner.getX() + inner.getWidth(), outer.getX() + outer.getWidth());
        assertEquals(inner.getY() - inner.getHeight(), outer.getY() - outer.getHeight());

        System.out.print(inner.getX());
        System.out.print(inner.getY());
    }

    @Test
    public void testMiddleCenter() throws Exception {
        PojoAlgProblem p = new PojoAlgProblem();
        Rectangle inner = new Rectangle(10, 10, 10, 10);
        Rectangle outer = new Rectangle(0, 100, 100, 100);
        p.middleCenter(inner, outer);
        assertEquals(inner.getX() + inner.getWidth()/2.0, outer.getX() + outer.getWidth()/2.0, Double.toString(inner.getX()));
        assertEquals(inner.getY() - inner.getHeight()/2.0, outer.getY() - outer.getHeight()/2.0, Double.toString(inner.getY()));

    }
}

