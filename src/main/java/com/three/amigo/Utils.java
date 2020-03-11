package com.three.amigo;

import com.google.common.collect.Lists;
import com.three.amigo.design.NameScoreStrategy;
import com.three.amigo.model.Name;

import java.util.HashMap;
import java.util.Map;

public class Utils {
    final static Map<String, NameScoreStrategy> map = new HashMap<>();
    static {
        NameScoreStrategy nameScoreStrategy =
                ((Name name) -> Lists.charactersOf(name.getFirstName()).stream()
                .map(individualCharacterOfName -> (int)individualCharacterOfName)
                .reduce(0, (a, b) -> a + b - 64));

        map.put("DefaultDept",nameScoreStrategy);

    }
    static public NameScoreStrategy getNameScoreStrategyByDepartment(String departmentName){
        return map.get(departmentName);
   }
}
