package com.spt.api.rest.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * BDRent
 * User: maheraj
 * Date: 8/23/2015
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class Greeting {
    private final long id;
    private final String content;

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}