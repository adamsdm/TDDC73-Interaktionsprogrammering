package com.example.adamsoderstrom.passwordstrengthmeter;

/**
 * Created by adamsoderstrom on 26/11/17.
 */

public interface PasswordMeterAlgorithm {
    /**
     *  Returns an integer in the range 0 to 100 representing the strength of the password.
     *  0 represents a very weak password, while 100 represents a strong password
     * @param   password    the password string
     * @return  strength    the returned value, [0 - 100],
     */
    int evaluatePassword(String password);

}
