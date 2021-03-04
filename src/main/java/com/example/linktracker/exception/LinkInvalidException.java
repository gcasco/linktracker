package com.example.linktracker.exception;

import lombok.Getter;
import lombok.Setter;

public class LinkInvalidException extends Exception{
    private static final String MESSAGE="The link is invalid";

    public static String getMESSAGE() {
        return MESSAGE;
    }
}
