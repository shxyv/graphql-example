package com.learning.graphqlexampe.model;

import lombok.Data;

@Data
public class BookRequest {

    private String name;
    private String description;
    private String authorName;

}
