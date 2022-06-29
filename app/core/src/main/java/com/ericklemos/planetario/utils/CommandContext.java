package com.ericklemos.planetario.utils;

import java.util.HashMap;
import java.util.Optional;

public class CommandContext extends HashMap<String, Object> {

    private static final String DATA = "data";

    public CommandContext() {
        super();
    }

    public CommandContext(Object data) {
        super.put(DATA, data);
    }

    public <T> T getData(Class<T> classe) {
        return getProperty(DATA, classe);
    }

    public void setData(Object data) {
        put(DATA, data);
    }

    public <R> R getProperty(String key, Class<R> classe) {
        return Optional.ofNullable(get(key))
                .map(classe::cast)
                .orElse(null);
    }

}
