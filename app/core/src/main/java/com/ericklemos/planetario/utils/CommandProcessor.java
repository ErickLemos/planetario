package com.ericklemos.planetario.utils;

public interface CommandProcessor<R> {

    R process(CommandContext context);

}
