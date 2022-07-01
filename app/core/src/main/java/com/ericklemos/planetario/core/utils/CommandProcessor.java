package com.ericklemos.planetario.core.utils;

public interface CommandProcessor<R> {

    R process(CommandContext context);

}
