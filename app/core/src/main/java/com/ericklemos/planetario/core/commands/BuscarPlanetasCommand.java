package com.ericklemos.planetario.core.commands;

import com.ericklemos.planetario.Planeta;
import com.ericklemos.planetario.core.utils.CommandProcessor;

import java.util.List;

public interface BuscarPlanetasCommand extends CommandProcessor<List<Planeta>> {
}
