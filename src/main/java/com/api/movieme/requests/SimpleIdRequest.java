package com.api.movieme.requests;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class SimpleIdRequest implements Serializable {

    private int id;
}
