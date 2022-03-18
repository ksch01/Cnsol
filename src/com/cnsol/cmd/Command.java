package com.cnsol.cmd;

import com.cnsol.parameters.Parameters;

import java.util.Objects;
import java.util.function.Consumer;

/**
 * Command represents a Cnsol command.<br>
 * A Command is represented by a name and an execution.<br>
 * The name identifies this command. Each command Name is unique for one Cnsol instance.<br>
 * The execution will be invoked if the command is invoked.
 * @author ks120
 * @version 0.1
 */
public class Command {
    /**
     * Name of this Command.
     */
    public final String name;
    private final Consumer<Parameters<?>> execution;

    /**
     * Creates a new Command with the specified name and execution.<br>
     * The execution is a {@link Parameters} Consumer which is a functional Interface.
     * @param name Name of the command.
     * @param execution Parameters Consumer that will be invoked when this command is invoked.
     * @throws NullPointerException If either name or execution is null.
     */
    public Command(String name, Consumer<Parameters<?>> execution) throws NullPointerException{
        Objects.requireNonNull(name);
        Objects.requireNonNull(execution);
        this.name = name;
        this.execution = execution;
    }

    void run(Parameters<?> parameters){
        execution.accept(parameters);
    }
}
