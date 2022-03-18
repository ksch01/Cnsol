package com.cnsol.parameters;

import java.util.function.Function;

/**
 * Interface for parameters structure.<br>
 * Key, value pairs can be queried where key is parameter name and value is parameter value.
 * @param <S> the type the parameter values are saved in
 * @author ks120
 * @version 0.1
 */
public interface Parameters<S> {

    /**
     * Returns weather there are any parameters saved by this instance.
     * @return weather there are any parameters
     */
    boolean hasParameters();

    /**
     * Returns how many parameters are saved to this instance.
     * @return how many parameters there are
     */
    int size();

    /**
     * Returns the parameter with the specified name in form of boolean parameter.
     * @param parameterName name of the parameter to be queried
     * @return boolean parameter information of the parameter with the specified name
     */
    Parameter<Boolean> getParameterBoolean(String parameterName);

    /**
     * Returns the parameter with the specified name in form of byte parameter.
     * @param parameterName name of the parameter to be queried
     * @return byte parameter information of the parameter with the specified name
     */
    Parameter<Byte> getParameterByte(String parameterName);

    /**
     * Returns the parameter with the specified name in form of short parameter.
     * @param parameterName name of the parameter to be queried
     * @return short parameter information of the parameter with the specified name
     */
    Parameter<Short> getParameterShort(String parameterName);

    /**
     * Returns the parameter with the specified name in form of integer parameter.
     * @param parameterName name of the parameter to be queried
     * @return integer parameter information of the parameter with the specified name
     */
    Parameter<Integer> getParameterInt(String parameterName);

    /**
     * Returns the parameter with the specified name in form of long parameter.
     * @param parameterName name of the parameter to be queried
     * @return long parameter information of the parameter with the specified name
     */
    Parameter<Long> getParameterLong(String parameterName);

    /**
     * Returns the parameter with the specified name in form of float parameter.
     * @param parameterName name of the parameter to be queried
     * @return float parameter information of the parameter with the specified name
     */
    Parameter<Float> getParameterFloat(String parameterName);

    /**
     * Returns the parameter with the specified name in form of double parameter.
     * @param parameterName name of the parameter to be queried
     * @return double parameter information of the parameter with the specified name
     */
    Parameter<Double> getParameterDouble(String parameterName);

    /**
     * Returns the parameter with the specified name in form of character parameter.
     * @param parameterName name of the parameter to be queried
     * @return character parameter information of the parameter with the specified name
     */
    Parameter<Character> getParameterChar(String parameterName);

    /**
     * Returns the parameter with the specified name in form of string parameter.
     * @param parameterName name of the parameter to be queried
     * @return string parameter information of the parameter with the specified name
     */
    Parameter<String> getParameterString(String parameterName);

    /**
     * Returns the parameter with the specified name in form of object parameter.
     * @param parameterName name of the parameter to be queried
     * @return object parameter information of the parameter with the specified name
     */
    Parameter<Object> getParameterObject(String parameterName);

    /**
     * Returns the parameter with the specified name in form of the specified type parameter.
     * @param parameterName name of the parameter to be queried
     * @param converterFunction function that converts an object of the saved type to the desired type
     * @param <T> desired parameter type
     * @return specified type parameter information of the parameter with the specified name
     */
    <T> Parameter<T> getParameter(String parameterName, Function<S, T> converterFunction);
}
