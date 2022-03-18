package com.cnsol.cmd;

import java.util.Map;
import java.util.Objects;

/**
 * Class containing the information for one specific command call.<br>
 * Instances contain name of the executed command as well as parameter names and values.
 * @author ks120
 * @version 0.1
 */
public class CommandExecutionSpecification {
    final String commandName;
    final Map<String,String> parameters;

    /**
     * Creates a new command execution specification with the given name and parameters.<br>
     * The fields cannot be accessed or manipulated after construction.
     * @param name name of the command that is executed
     * @param parameters parameters the command is executed with structure of String, String Map with parameter name as key and parameter value as value
     * @throws NullPointerException if any of the parameters of this method is null
     */
    public CommandExecutionSpecification(String name, Map<String, String> parameters) throws NullPointerException{
        Objects.requireNonNull(name);
        Objects.requireNonNull(parameters);
        this.commandName = name;
        this.parameters = parameters;
    }
}
