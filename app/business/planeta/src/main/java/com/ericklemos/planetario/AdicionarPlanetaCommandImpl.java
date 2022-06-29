package com.ericklemos.planetario;

import com.ericklemos.planetario.commands.AdicionarPlanetaCommand;
import com.ericklemos.planetario.utils.CommandContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AdicionarPlanetaCommandImpl implements AdicionarPlanetaCommand {

    @Override
    public Planeta process(CommandContext context) {
        return null;
    }

}
