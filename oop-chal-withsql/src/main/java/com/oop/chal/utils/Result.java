package com.oop.chal.utils;

public class Result<T> {
    private final boolean success;
    private final T value;
    private final String error;
    
    private Result(boolean success, T value, String error) {
        this.success = success;
        this.value = value;
        this.error = error;
    }
    
    public static <T> Result<T> success(T value) {
        return new Result<>(true, value, null);
    }
    
    public static <T> Result<T> failure(String error) {
        return new Result<>(false, null, error);
    }
    
    public boolean isSuccess() {
        return success;
    }
    
    public boolean isFailure() {
        return !success;
    }
    
    public T getValue() {
        if (!success) {
            throw new IllegalStateException("Cannot get value from failed result");
        }
        return value;
    }
    
    public String getError() {
        return error;
    }
    
    public T getValueOrDefault(T defaultValue) {
        return success ? value : defaultValue;
    }
    
    @Override
    public String toString() {
        if (success) {
            return "Result{success=true, value=" + value + "}";
        } else {
            return "Result{success=false, error='" + error + "'}";
        }
    }
}