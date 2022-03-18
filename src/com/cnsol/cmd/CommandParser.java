package com.cnsol.cmd;

/**
 * CommandParser interface for obtaining command name and parameters when trying to execute a command with type T.
 * @param <T> type this command parser is able to parse into command name and parameters
 * @author ks120
 * @version 0.1
 */
public interface CommandParser<T> {
    /**
     * Converts the given specification of execution to execution information containing command name and String, String parameter map.<br>
     * The Information has to be returned with a bundle(commandName, parameters) call.<br>
     * Whenever this method returns null no command will be executed.
     * @param executionSpecification Information with which a Command execution will be invoked.
     * @return Execution information containing command Name and String, String parameter map.
     */
    CommandExecutionSpecification getExecutionSpecification(T executionSpecification);
}
