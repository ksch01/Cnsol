package com.cnsol.parameters;

import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

public class ObjectParameters implements Parameters<Object> {

    private final Map<String, Object> parameterMap;

    public ObjectParameters(Map<String, Object> parameterMap){
        Objects.requireNonNull(parameterMap);
        if(parameterMap.isEmpty())throw new IllegalArgumentException("Parameter map is not allowed to be empty. Use ObjectParameter.NONE instead.");
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

    public Object getValue(String parameterName){
        return parameterMap.get(parameterName);
    }

    @Override
    public Parameter<Boolean> getParameterBoolean(String parameterName) {
        Object parameterValue = getValue(parameterName);
        if(parameterValue == null)return new Parameter<>(Parameter.Status.NOT_FOUND);
        if(parameterValue instanceof Boolean)return new Parameter<>((Boolean)parameterValue);
        return new Parameter<>(Parameter.Status.WRONG_FORMAT);
    }

    @Override
    public Parameter<Byte> getParameterByte(String parameterName) {
        Object parameterValue = getValue(parameterName);
        if(parameterValue == null)return new Parameter<>(Parameter.Status.NOT_FOUND);
        if(parameterValue instanceof Byte)return new Parameter<>((Byte)parameterValue);
        return new Parameter<>(Parameter.Status.WRONG_FORMAT);
    }

    @Override
    public Parameter<Short> getParameterShort(String parameterName) {
        Object parameterValue = getValue(parameterName);
        if(parameterValue == null)return new Parameter<>(Parameter.Status.NOT_FOUND);
        if(parameterValue instanceof Short)return new Parameter<>((Short)parameterValue);
        return new Parameter<>(Parameter.Status.WRONG_FORMAT);
    }

    @Override
    public Parameter<Integer> getParameterInt(String parameterName) {
        Object parameterValue = getValue(parameterName);
        if(parameterValue == null)return new Parameter<>(Parameter.Status.NOT_FOUND);
        if(parameterValue instanceof Integer)return new Parameter<>((Integer)parameterValue);
        return new Parameter<>(Parameter.Status.WRONG_FORMAT);
    }

    @Override
    public Parameter<Long> getParameterLong(String parameterName) {
        Object parameterValue = getValue(parameterName);
        if(parameterValue == null)return new Parameter<>(Parameter.Status.NOT_FOUND);
        if(parameterValue instanceof Long)return new Parameter<>((Long)parameterValue);
        return new Parameter<>(Parameter.Status.WRONG_FORMAT);
    }

    @Override
    public Parameter<Float> getParameterFloat(String parameterName) {
        Object parameterValue = getValue(parameterName);
        if(parameterValue == null)return new Parameter<>(Parameter.Status.NOT_FOUND);
        if(parameterValue instanceof Float)return new Parameter<>((Float)parameterValue);
        return new Parameter<>(Parameter.Status.WRONG_FORMAT);
    }

    @Override
    public Parameter<Double> getParameterDouble(String parameterName) {
        Object parameterValue = getValue(parameterName);
        if(parameterValue == null)return new Parameter<>(Parameter.Status.NOT_FOUND);
        if(parameterValue instanceof Double)return new Parameter<>((Double)parameterValue);
        return new Parameter<>(Parameter.Status.WRONG_FORMAT);
    }

    @Override
    public Parameter<Character> getParameterChar(String parameterName) {
        Object parameterValue = getValue(parameterName);
        if(parameterValue == null)return new Parameter<>(Parameter.Status.NOT_FOUND);
        if(parameterValue instanceof Character)return new Parameter<>((Character) parameterValue);
        return new Parameter<>(Parameter.Status.WRONG_FORMAT);
    }

    @Override
    public Parameter<String> getParameterString(String parameterName) {
        Object parameterValue = getValue(parameterName);
        if(parameterValue == null)return new Parameter<>(Parameter.Status.NOT_FOUND);
        if(parameterValue instanceof String)return new Parameter<>((String) parameterValue);
        return new Parameter<>(Parameter.Status.WRONG_FORMAT);
    }

    @Override
    public Parameter<Object> getParameterObject(String parameterName) {
        Object parameterValue = getValue(parameterName);
        if(parameterValue == null)return new Parameter<>(Parameter.Status.NOT_FOUND);
        return new Parameter<>(parameterValue);
    }

    @Override
    public <T> Parameter<T> getParameter(String parameterName, Function<Object, T> converterFunction) {
        return null;
    }

    public <T> Parameter<T> getParameter(String parameterName, Class<T> typeClass){
        Object parameterValue = getValue(parameterName);
        if(parameterValue == null)return new Parameter<>(Parameter.Status.NOT_FOUND);
        try{
            return new Parameter<>(typeClass.cast(parameterValue));
        }catch(ClassCastException e){
            return new Parameter<>(Parameter.Status.WRONG_FORMAT);
        }
    }
}
