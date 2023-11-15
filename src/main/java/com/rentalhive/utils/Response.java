package com.rentalhive.utils;

import java.util.List;

public class Response<T> {
    private String message;
    private T result;
    private List<Error> errors;
}
