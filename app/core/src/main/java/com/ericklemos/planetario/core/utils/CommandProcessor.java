package com.ericklemos.planetario.core.utils;

@FunctionalInterface
public interface CommandProcessor<R> {

    R process(CommandContext context);

}
