package com.cnsol.console;

import com.cnsol.cmd.CommandExecutionSpecification;
import com.cnsol.cmd.CommandParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StringCommandParser implements CommandParser<String> {

    public static final StringCommandParser instance = new StringCommandParser();

    private StringCommandParser(){}

    @Override
    public CommandExecutionSpecification getExecutionSpecification(String executionSpecification) {
        return readLine(executionSpecification);
    }

    private CommandExecutionSpecification readLine(String line){
        if(line == null) return null;
        ArrayList<String> words = new ArrayList<>();
        boolean space = true;
        int lineLength = line.length();
        StringBuilder currentWord = new StringBuilder();
        String command;
        for(int i = 0; i < lineLength; i++){
            char currentChar = line.charAt(i);
            if(space){
                if(currentChar != ' '){
                    space = false;
                    currentWord.append(currentChar);
                }
            }else{
                if(currentChar == ' '){
                    space = true;
                    words.add(currentWord.toString());
                    currentWord = new StringBuilder();
                }else{
                    currentWord.append(currentChar);
                }
            }
        }
        if(!space){
            words.add(currentWord.toString());
        }

        if(words.size() == 0){
            return null;
        }else{
            command = words.get(0);
            words.remove(0);
        }

        int length = words.size();
        Map<String,String> parameters = new HashMap<>();

        for(int i = 0; i < length; i++){
            parameters.put(""+i, words.get(i));
        }
        return new CommandExecutionSpecification(command, parameters);
    }
}
