package com.cnsol.cmd;
import com.cnsol.parameters.StringParameters;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

/**
 * Cnsol is a command execution tool.<br>
 * A Cnsol instance resembles a virtual console where commands can be specified and executed with defined parameters.
 * @param <T> type this Cnsol accepts.
 * @author ks120
 * @version 0.1
 */
public class Cnsol<T> {
    private CommandParser<T> commandParser;
    private final Collection<Command> commands;

    /**
     * Creates a new Cnsol instance which uses the specified command Supplier to get the Name and Parameters for the Command execution when run is invoked.<br>
     * This constructor uses an ArrayList as Collection for the Commands of this Cnsol.
     * @param commandParser CommandSupplier to get Name and Parameters for a Command.
     * @throws NullPointerException If the specified CommandSupplier is null.
     */
    public Cnsol(CommandParser<T> commandParser) throws NullPointerException{
        setCommandParser(commandParser);
        commands = new ArrayList<>();
    }
    private void setCommandParser(CommandParser<T> commandParser){
        Objects.requireNonNull(commandParser);
        this.commandParser = commandParser;
    }

    /**
     * Adds the specified command to this Cnsol instance.<br>
     * If a command with the name of the specified command (Case is ignored) already exists the existing command will be replaced instead.
     * @param command Command to be added to this Cnsol instance.
     * @throws NullPointerException If the specified command is null.
     */
    public void addCommand(Command command)throws NullPointerException{
        Objects.requireNonNull(command);
        boolean existsAlready = false;
        for(Command cmd : commands){
            if(cmd.name.equalsIgnoreCase(command.name)){
                commands.remove(cmd);
                commands.add(command);
                existsAlready = true;
            }
        }
        if(!existsAlready)commands.add(command);
    }

    /**
     * Runs one Command on this Cnsol instance.<br>
     * First the Execution containing name of command and names and values of all specified parameters is obtained by the commandParser.<br>
     * If a Command with this name exists for this Cnsol instance this command will then be executed with the specified parameters.<br>
     * If no Command with this name exists for this Cnsol no Command will be executed.<br>
     * If the given commandSpecification is null no command will be executed.
     * @param commandSpecification specification containing command name and possibly names and values of parameters in any form
     */
    public void run(T commandSpecification){
        if(commandSpecification != null) {
            CommandExecutionSpecification execution = commandParser.getExecutionSpecification(commandSpecification);
            if(execution != null) {
                for (Command command : commands) {
                    if (command.name.equalsIgnoreCase(execution.commandName)) {
                        command.run(new StringParameters(execution.parameters));
                        break;
                    }
                }
            }
        }
    }
}
