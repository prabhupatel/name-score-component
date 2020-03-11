package com.three.amigo.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Name implements Comparable<Name>{

    private String firstName;

    public Name(String firstName){
        this.firstName=firstName;
    }

    @Override
    public int compareTo(Name o) {
        return this.firstName.compareTo(o.firstName);
    }
}
