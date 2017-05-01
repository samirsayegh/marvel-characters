package com.samirsayegh.marvelchars.model.services.base;

/**
 * Created by yormirsamir.sayegh on 26/04/2017.
 */

public interface BaseServiceResult {

    void noNetwork(String message);

    void error(String message);
}
