package com.example.linktracker.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LinkNotFoundException extends Exception {
    private static final String MESSAGE = "link not Found";

    public static String getMESSAGE() {
        return MESSAGE;
    }
}
