package com.three.amigo.design;

import com.three.amigo.model.Name;
//Strategy Design pattern is best way to accommodate future requirement for other departments.
public interface NameScoreStrategy {
    Integer executeWithFirstName(Name name);
}
