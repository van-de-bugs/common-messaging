/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.debugs.messaging.lang;

import com.debugs.messaging.Field;
import com.debugs.messaging.MessageBundle;
import com.debugs.messaging.type.TNull;
import com.debugs.messaging.type.TObject;

/**
 *
 * @author van de Bugs <van.de.bugs@gmail.com>
 */
public class LNotEmpty extends LOp {
    
    public LNotEmpty(LObject value1, LObject value2) {
        super(value1, value2);
    }

    @Override
    public TObject evaluate(MessageBundle bundle, Field field, Object value) throws Exception {
        TObject evaluatedValue1 = getValue1().evaluate(bundle, field, value);
        if (evaluatedValue1.size() == 0) {
            TObject evaluatedValue2 = getValue2().evaluate(bundle, field, value);
            return evaluatedValue2.size() > 0 ? evaluatedValue2 : TNull.newInstance();
        } else {
            return evaluatedValue1;
        }
    }
}
