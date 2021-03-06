/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.debugs.messaging.lang.string;

import com.debugs.messaging.lang.LObject;
import com.debugs.messaging.utils.Trimmer;

/**
 *
 * @author van de Bugs <van.de.bugs@gmail.com>
 */
public class LRTrim extends LTrim {

    public LRTrim(LObject value) {
        super(value);
    }

    public LRTrim(LObject value, LObject characters) {
        super(value, characters);
    }

    @Override
    protected String execute(Trimmer trimmer, String value) {
        return trimmer.trimRight(value);
    }
}
