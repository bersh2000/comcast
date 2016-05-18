package com.comcast.csv.interview.problems;

import com.comcast.csv.meme.Meme;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import static org.testng.Assert.*;

public class CollectionsProblemImplTest {

    private static final boolean ASCENDING = true;
    private static final boolean DESCENDING = false;


    @Test
    public void testSort() throws Exception {
        Collection<Meme> memes = new ArrayList<Meme>();
        Meme m = new Meme();
        m.setName("Test");
        m.setYear(1999);
        memes.add(m);

        m = new Meme();
        m.setName("Test");
        m.setYear(2000);
        memes.add(m);

        m.setName("Test");
        m.setYear(2999);
        memes.add(m);

        CollectionsProblemImpl t = new CollectionsProblemImpl();
        t.sort(memes, ASCENDING);
        int lastYear = -1;
        for (Iterator<Meme> iterator = memes.iterator(); iterator.hasNext(); ) {
            Meme next = iterator.next();
            if (lastYear != -1)
                assertTrue(next.getYear() >= lastYear);
            lastYear = next.getYear();
        }


        t.sort(memes, DESCENDING);
        lastYear = -1;
        for (Iterator<Meme> iterator = memes.iterator(); iterator.hasNext(); ) {
            Meme next = iterator.next();
            if (lastYear != -1)
                assertTrue(next.getYear() <= lastYear, "next.getYear() <= lastYear" + next.getYear() + " " + lastYear);
            lastYear = next.getYear();
        }


    }

    @Test
    public void testAddTag() throws Exception {
        Collection<Meme> memes = new ArrayList<Meme>();
        Meme m = new Meme();
        m.setName("Test");
        m.setYear(1999);
        memes.add(m);

        Meme m2 = new Meme();
        m2.setName("Test");
        m2.setYear(2000);
        m2.setTags(new String[] {"tag1", "tag2" });
        memes.add(m2);

        Meme m3 = new Meme();
        m3.setName("Test");
        m3.setYear(2000);
        m3.setTags(new String[] {"tag1"});

        memes.add(m3);

        CollectionsProblemImpl t = new CollectionsProblemImpl();
        t.addTag(memes, "testTag");

        assertEquals(m.getTags(), null);
        assertEquals(m2.getTags(), new String[] {"tag1", "tag2", "testTag" });
        assertEquals(m3.getTags(), new String[] {"tag1", "testTag" });


    }
}