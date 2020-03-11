package com.three.amigo.startar;

/*
 * Assumption :
 * 1. Assuming do not have memory constrains to load the whole file in memory.
 *
 */


import com.three.amigo.service.NameScoreService;
import com.three.amigo.service.NameScoreServiceImpl;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class NameScoringProcess {

    NameScoreService nameScoreService;

    public static void main(String[] args) throws Exception {
        NameScoringProcess nameScoringProcess = new NameScoringProcess();

        //Validation : expect not null args argument to go next steps
        nameScoringProcess.validation(args);

        //processing
        Integer totalNameScoreCount = nameScoringProcess.start(Files.lines(Paths.get(args[0])), (args.length>=2)? args[1]: "");

        //result
        System.out.println("Total Name Score is " + totalNameScoreCount + "  for file " + args[0]);
    }


    public Integer start(Stream<String> lines, String departmentName) throws Exception {
        try {
            nameScoreService = new NameScoreServiceImpl(departmentName);
            return nameScoreService.getNameScore(lines);
        } catch (Exception ex) {
            throw new Exception("Exception occurred , Please provide the valid name files & Department name. \n " + ex);
        }
    }


    void validation(String[] args) throws Exception {
        if (args == null || args.length < 1) {
            throw new Exception("Name score utility expects a source file path & source of executor to execute. \n " +
                    " Run CLI command as  java StartProcess 'c:/file/location/name.txt' 'DefaultDept' ");
        }
    }
}
