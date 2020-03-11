package com.three.amigo.service;

import com.three.amigo.model.Name;
import com.three.amigo.startar.NameScoringProcess;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.Assert.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest( NameScoreServiceImpl.class )
public class NameScoreServiceImplTest {

    NameScoreServiceImpl classUnderTest = new NameScoreServiceImpl("");


    @Test
    public void testGetSortedNamesFromFile() {
        Stream<String> fileStream = Arrays.asList("JERE","HAI").stream();
        List<Name> names = classUnderTest.getSortedNamesFromFile(fileStream);
        assertEquals(2, names.size());
        assertTrue(names.get(0).getFirstName().equals("HAI"));
        assertTrue(names.get(1).getFirstName().equals("JERE"));
    }

    @Test
    public void testGetDepartmentName() throws Exception{
        String some = classUnderTest.getDepartmentName();
        assertEquals("",some);
    }

    @Test
    public void testGetNameScoreWithStream() throws Exception{
        Stream<String> fileStream = Arrays.asList("JERE","HAI").stream();
        Integer sum = classUnderTest.getNameScore(fileStream);
        assertEquals(94,sum.intValue());
    }

    @Test
    public void testGetNameScoreWithList() throws Exception{
        List<Name> nameList = Arrays.asList(new Name("PETER"),new Name("HAI"));
        Integer sum = classUnderTest.getNameScore(nameList);
        assertEquals(100,sum.intValue());
    }

    @Test
    public void testGetNameScoreWithName() throws Exception{
        Integer sum = classUnderTest.getNameScore(new Name("PETER"));
        assertEquals(64,sum.intValue());
    }
}