package com.three.amigo.service;

import com.google.common.base.Strings;
import com.three.amigo.Utils;
import com.three.amigo.design.NameScoreStrategy;
import com.three.amigo.model.Name;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.Stream;


@Setter
@Getter
public class NameScoreServiceImpl implements NameScoreService{

    private String departmentName;

    public NameScoreServiceImpl(String departmentName){
        this.departmentName=departmentName;
    }

    @Override
    public Integer getNameScore(Stream<String> fileStream) {
        List<Name> nameList =  getSortedNamesFromFile(fileStream);
        return getNameScore(nameList);
    }

    @Override
    public Integer getNameScore(List<Name> nameList) {
        return nameList.parallelStream()
                .mapToInt(name->getNameScore(name) * (nameList.indexOf(name)+1)).sum();
    }

    @Override
    public Integer getNameScore(Name name)  {
        NameScoreStrategy nameScoreStrategy = Utils.getNameScoreStrategyByDepartment(
                Strings.isNullOrEmpty(getDepartmentName())? NameScoreService.super.getDepartmentName():getDepartmentName());
        return  nameScoreStrategy.executeWithFirstName(name);

    }

    List<Name> getSortedNamesFromFile(Stream<String> fileStream){
        return fileStream.parallel().map(line->line.split(","))
                .flatMap(Arrays::stream)
                .map(firstName->new Name(firstName.replaceAll("\"", "")))
                .sorted()
                .collect(Collectors.toList());
    }
}
