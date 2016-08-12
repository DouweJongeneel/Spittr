package com.douwe.data;

import com.douwe.Spitter;

/**
 * Created by Milan_Verheij on 03-08-16.
 */
public interface SpitterRepository {
    Spitter save(Spitter spitter);

    Spitter findByUsername(String username);
}
