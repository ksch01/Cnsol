package com.cnsol.parameters;

import java.util.Collections;
import java.util.IllegalFormatException;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

/**
 * @author ks120
 * @version 0.2
 */
public class StringParameters implements Parameters<String>{

    public static final StringParameters NONE = new StringParameters(Collections.emptyMap());

    private final Map<String, String> parameterMap;

    public StringParameters(Map<String, String> parameterMap) throws NullPointerException, IllegalArgumentException{
        Objects.requireNonNull(parameterMap);
        if(parameterMap.isEmpty())throw new IllegalArgumentException("Parameter map is not allowed to be empty. Use StringParameters.NONE instead.");
        this.parameterMap = parameterMap;
    }

    @Override
    public boolean hasParameters() {
        return !parameterMap.isEmpty();
    }

    @Override
    public int size() {
        return parameterMap.size();
    }

    private String getValue(String parameterName){
        return parameterMap.get(parameterName);
    }

    @Override
    public Parameter<Boolean> getParameterBoolean(String parameterName) {
        String parameterValue = getValue(parameterName);
        if(parameterValue == null)return new Parameter<>(Parameter.Status.NOT_FOUND);
        if(parameterValue.equals("true"))return new Parameter<>(true);
        if(parameterValue.equals("false"))return new Parameter<>(false);
        return new Parameter<>(Parameter.Status.WRONG_FORMAT);
    }

    @Override
    public Parameter<Byte> getParameterByte(String parameterName) {
        String parameterValue = getValue(parameterName);
        if(parameterValue == null)return new Parameter<>(Parameter.Status.NOT_FOUND);
        try{
            return new Parameter<>(Byte.parseByte(parameterValue));
        }catch(NumberFormatException e){
            return new Parameter<>(Parameter.Status.WRONG_FORMAT);
        }
    }

    @Override
    public Parameter<Short> getParameterShort(String parameterName) {
        String parameterValue = getValue(parameterName);
        if(parameterValue == null)return new Parameter<>(Parameter.Status.NOT_FOUND);
        try{
            return new Parameter<>(Short.parseShort(parameterValue));
        }catch(NumberFormatException e){
            return new Parameter<>(Parameter.Status.WRONG_FORMAT);
        }
    }

    @Override
    public Parameter<Integer> getParameterInt(String parameterName) {
        String parameterValue = getValue(parameterName);
        if(parameterValue == null)return new Parameter<>(Parameter.Status.NOT_FOUND);
        try{
            return new Parameter<>(Integer.parseInt(parameterValue));
        }catch(NumberFormatException e){
            return new Parameter<>(Parameter.Status.WRONG_FORMAT);
        }
    }

    @Override
    public Parameter<Long> getParameterLong(String parameterName) {
        String parameterValue = getValue(parameterName);
        if(parameterValue == null)return new Parameter<>(Parameter.Status.NOT_FOUND);
        try{
            return new Parameter<>(Long.parseLong(parameterValue));
        }catch(NumberFormatException e){
            return new Parameter<>(Parameter.Status.WRONG_FORMAT);
        }
    }

    @Override
    public Parameter<Float> getParameterFloat(String parameterName) {
        String parameterValue = getValue(parameterName);
        if(parameterValue == null)return new Parameter<>(Parameter.Status.NOT_FOUND);
        try{
            return new Parameter<>(Float.parseFloat(parameterValue));
        }catch(NumberFormatException e){
            return new Parameter<>(Parameter.Status.WRONG_FORMAT);
        }
    }

    @Override
    public Parameter<Double> getParameterDouble(String parameterName) {
        String parameterValue = getValue(parameterName);
        if(parameterValue == null)return new Parameter<>(Parameter.Status.NOT_FOUND);
        try{
            return new Parameter<>(Double.parseDouble(parameterValue));
        }catch(NumberFormatException e){
            return new Parameter<>(Parameter.Status.WRONG_FORMAT);
        }
    }

    @Override
    public Parameter<Character> getParameterChar(String parameterName) {
        String parameterValue = getValue(parameterName);
        if(parameterValue == null)return new Parameter<>(Parameter.Status.NOT_FOUND);
        if(parameterValue.length() != 1)return new Parameter<>(Parameter.Status.WRONG_FORMAT);
        return new Parameter<>(parameterValue.charAt(0));
    }

    @Override
    public Parameter<String> getParameterString(String parameterName) {
        String parameterValue = getValue(parameterName);
        if(parameterValue == null)return new Parameter<>(Parameter.Status.NOT_FOUND);
        return new Parameter<>(parameterValue);
    }

    @Override
    public Parameter<Object> getParameterObject(String parameterName) {
        String parameterValue = getValue(parameterName);
        if(parameterValue == null)return new Parameter<>(Parameter.Status.NOT_FOUND);
        return new Parameter<>(parameterValue);
    }

    @Override
    public <T> Parameter<T> getParameter(String parameterName, Function<String, T> converterFunction) {
        String parameterValue = getValue(parameterName);
        if(parameterValue == null)return new Parameter<>(Parameter.Status.NOT_FOUND);
        try {
            return new Parameter<>(converterFunction.apply(parameterValue));
        }catch(IllegalFormatException e){
            return new Parameter<>(Parameter.Status.WRONG_FORMAT);
        }
    }
}
