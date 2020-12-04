package utils;

import interfaces.IRetrievable;
import models.DataWrapper;

public class Retriever<T> implements IRetrievable {

    @Override
    public T getData() {
        String payload = "{data:{names:['LU XIANZE', 'LIM LING HUI', 'YAW JIAN HAO']}}";
        return (T) DataWrapper.fromJSON(payload);
    }
}
