package com.comcast.csv.interview.problems;

import com.comcast.csv.meme.Meme;

import java.util.*;

/**
 * Implement the specified interface.
 */
public class CollectionsProblemImpl implements CollectionsProblem {


    /**
     * Sorts a Collection of Memes by year
     * @param memes The Collection to sort
     * @param ascending true if the collection should be sorting in ascending order, otherwise false.
     */

    @Override
    public void sort(Collection<Meme> memes, final boolean ascending) {
        SortedSet<Meme> sortedSet = new TreeSet<Meme>(new Comparator<Meme>() {
            @Override
            public int compare(Meme o1, Meme o2) {
                if (ascending)
                    return o1.getYear()-o2.getYear();
                else
                    return o2.getYear()-o1.getYear();
            }
        });
        sortedSet.addAll(memes);
        memes.clear();
        memes.addAll(sortedSet);
    }

    /**
     * Adds a tag to all meme's that contain another tag
     * @param memes The collection of memes to mutate
     * @param tag The tag that is to be added
     */

    @Override
    public void addTag(Collection<Meme> memes, String tag) {
        for (Iterator<Meme> iterator = memes.iterator(); iterator.hasNext(); ) {
            Meme next = iterator.next();
            if (next.getTags() !=null && next.getTags().length>0) {
                next.setTags(Arrays.copyOf(next.getTags(), next.getTags().length+1));
                next.getTags()[next.getTags().length-1] = tag;
            }

        }
    }
}
