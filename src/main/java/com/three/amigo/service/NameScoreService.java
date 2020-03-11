package com.three.amigo.service;

import com.three.amigo.model.Name;

import java.util.List;
import java.util.stream.Stream;

public interface NameScoreService {
    Integer getNameScore(Stream<String> fileStream) throws Exception;
    Integer getNameScore(List<Name> nameList) throws Exception;
    Integer getNameScore(Name name) throws Exception;

    default String getDepartmentName(){
        return "DefaultDept";
    }
}
