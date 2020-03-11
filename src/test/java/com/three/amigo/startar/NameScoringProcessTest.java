package com.three.amigo.startar;


import com.three.amigo.service.NameScoreService;
import com.three.amigo.service.NameScoreServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;


import java.util.Arrays;
import java.util.stream.Stream;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.powermock.configuration.ConfigurationType.PowerMock;
import org.powermock.api.mockito.PowerMockito;

@RunWith(PowerMockRunner.class)
@PrepareForTest( NameScoringProcess.class )
public class NameScoringProcessTest {


    NameScoringProcess nameScoringProcess  ;


    @Before
    public void setUp(){
        nameScoringProcess  = new NameScoringProcess ();
    }

    @Test
    public void testStart() throws Exception {
        final Stream<String> stream = Arrays.asList("LEANDRO","KRAIG").stream();

        NameScoreServiceImpl nameScoreService = mock(NameScoreServiceImpl.class);

        PowerMockito.whenNew(NameScoreServiceImpl.class).withAnyArguments().thenReturn(nameScoreService);

        when(nameScoreService.getNameScore(stream)).thenReturn(200);
        Integer actual = nameScoringProcess.start(stream,"defaultDepartment");
        assertEquals(200,actual.intValue());

    }

    @Test(expected=Exception.class)
    public void testValidate() throws Exception {
        String[] args = null;
        nameScoringProcess.validation(args);
    }

}