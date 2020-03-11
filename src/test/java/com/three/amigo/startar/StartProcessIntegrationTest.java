package com.three.amigo.startar;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static junit.framework.TestCase.assertEquals;

@RunWith(PowerMockRunner.class)
@PrepareForTest( NameScoringProcess.class )
public class StartProcessIntegrationTest {
    NameScoringProcess classUnderTest = new NameScoringProcess();

    @Test
    public void getNameScore() throws Exception{
        Stream<String> stream = Files.lines(Paths.get(ClassLoader.getSystemResource("names.txt").toURI()));
        Integer totalNameScore = classUnderTest.start(stream,null);
        System.out.println("totalNameScore " + totalNameScore);
        assertEquals(871198282, totalNameScore.intValue());
    }
}