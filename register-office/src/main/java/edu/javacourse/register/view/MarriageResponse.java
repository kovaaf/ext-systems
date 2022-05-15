package edu.javacourse.register.view;
/*
 *   Created by Kovalyov Anton 04.05.2022
 */

import java.io.Serializable;

public class MarriageResponse implements Serializable {
    private boolean exists;

    public boolean isExists() {
        return exists;
    }

    public void setExists(boolean exists) {
        this.exists = exists;
    }
}
