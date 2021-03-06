/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.debugs.messaging.lang.list;

import com.debugs.messaging.Field;
import com.debugs.messaging.MessageBundle;
import com.debugs.messaging.lang.LObject;
import com.debugs.messaging.type.TInteger;
import com.debugs.messaging.type.TList;
import com.debugs.messaging.type.TNumber;
import com.debugs.messaging.type.TObject;

/**
 *
 * @author van de Bugs <van.de.bugs@gmail.com>
 */
public class LAt extends LObject {
    
    private LObject<TList> source;
    private LObject index;
    
    public LAt(LObject<TList> source, LObject index) {
        this.source = source;
        this.index = index;
    }

    public LObject<TList> getSource() {
        return source;
    }

    public void setSource(LObject<TList> source) {
        this.source = source;
    }

    public LObject getIndex() {
        return index;
    }

    public void setIndex(LObject index) {
        this.index = index;
    }

    @Override
    public TObject evaluate(MessageBundle bundle, Field field, Object value) throws Exception {
        TList evaluatedSource = source.evaluate(bundle, field, value);
        
        TObject evaluatedIndex = index.evaluate(bundle, field, value);
        TNumber parsedIndex = evaluatedIndex instanceof TNumber ?
                    (TNumber) evaluatedIndex :
                    TInteger.newInstance(evaluatedIndex.getValue());
        
        Object result = evaluatedSource.getValueAt(parsedIndex.integerValue());
        return TObject.newInstance(result);
    }

    @Override
    public Object[] params() {
        return new Object[] {source, index};
    }
}
