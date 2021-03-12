package com.example.linktracker.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LinkStatus {
    private String url;
    private Integer linkId;
    private Boolean status;
    private Integer metric;
    private String password;
}
