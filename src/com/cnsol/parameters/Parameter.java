package com.cnsol.parameters;

import java.util.Objects;

/**
 * Representing information of a parameter which was queried form a parameters instance.
 * @param <T> type of the parameter value
 * @author ks120
 * @version 0.2
 */
public class Parameter<T>{
    /**
     * Parameter Status
     */
    public enum Status{
        /**
         * Indicates that the parameter was successfully read with a valid value of the specified type T.<br>
         * The value of any parameter instance of this status is never null.
         */
        VALID,
        /**
         * Indicates that there was no parameter with the name that was queried.
         */
        NOT_FOUND,
        /**
         * Indicates that while there was a parameter with the specified name, the parameter could not be converted to the desired type.
         */
        WRONG_FORMAT,
        /**
         * Indicates that while there was a parameter with the specified name, the parameter was successfully converted with the conversion result being null.
         */
        NULL
    }

    /**
     * State of this Parameter
     */
    public final Status status;
    private final T value;

    /**
     * Creates a new parameter with the specified status.<br>
     * The specified status is not allowed to be {@link Status#VALID} or null.
     * @param status parameter status
     * @throws NullPointerException if the specified status is null
     * @throws IllegalArgumentException if the specified status is {@link Status#VALID}
     */
    public Parameter(Status status) throws IllegalArgumentException, NullPointerException{
        if(status == Status.VALID)throw new IllegalArgumentException("Value of parameter with status valid cannot be null.");
        this.status = status;
        this.value = null;
    }

    /**
     * Creates a new parameter with the specified value and the status {@link Status#VALID}.<br>
     * The specified value is not allowed to be null.
     * @param value parameter value
     * @throws NullPointerException if the specified value is null
     */
    public Parameter(T value) throws NullPointerException{
        Objects.requireNonNull(value);
        status = Status.VALID;
        this.value = value;
    }

    /**
     * Returns the value of this Parameter.<br>
     * This method does not return null in any case.
     * @return value of this Parameter
     * @throws IllegalStateException if this Parameter is not valid.
     */
    public T value() throws IllegalStateException{
        if(this.status == Status.VALID) return value;
        else throw new IllegalStateException("Parameter value cannot be read ("+status.name()+")");
    }

    /**
     * Returns the value of this Parameter if the status is {@link Status#VALID}.<br>
     * Else returns the given default value.<br>
     * This method does only return null if the given default value is null and the state is not {@link Status#VALID}.
     * @param defaultValue default value for the parameter
     * @return value of this Parameter or default value if not valid
     */
    public T value(T defaultValue){
        if(this.status == Status.VALID) return value;
        else return defaultValue;
    }
}
