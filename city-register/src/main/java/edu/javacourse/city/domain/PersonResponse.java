package edu.javacourse.city.domain;
/*
 *   Created by Kovalyov Anton 21.04.2022
 */

public class PersonResponse {
    private boolean isRegistered;
    private boolean isTemporal;

    public boolean isRegistered() {
        return isRegistered;
    }

    public void setRegistered(boolean registered) {
        isRegistered = registered;
    }

    public boolean isTemporal() {
        return isTemporal;
    }

    public void setTemporal(boolean temporal) {
        isTemporal = temporal;
    }

    @Override
    public String toString() {
        return "PersonResponse{" +
                "isRegistered=" + isRegistered +
                ", isTemporal=" + isTemporal +
                '}';
    }
}
