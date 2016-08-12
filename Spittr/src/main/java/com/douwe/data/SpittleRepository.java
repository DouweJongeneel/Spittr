package com.douwe.data;

import com.douwe.Spittle;

import java.util.ArrayList;

/**
 * Created by Milan_Verheij on 03-08-16.
 *
 * Interface voor repository die alle spittles fetched
 */
public interface SpittleRepository {
    ArrayList<Spittle> findSpittles(long max, int count);

    Spittle findOne(long id);
}
