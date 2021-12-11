package com.ae2dms.util;

import org.junit.jupiter.api.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

class GameRecorderTest {

    @BeforeAll
    static void setUp() throws IOException {
        File file = new File("src/main/resources/gameRecord/records.txt");
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write("");
        fileWriter.flush();
        fileWriter.close();

        GameRecorder gameRecorder = new GameRecorder();
        gameRecorder.saveRecord("Zixiang Hu", 200, 106);
        gameRecorder.saveRecord("Bryan", 360, 60);
        gameRecorder.saveRecord("Yu Heng", 300, 54);
    }

    @Test
    void getHighestScore() {
        GameRecorder gameRecorder = new GameRecorder();
        int highestScore = gameRecorder.getHighestScore();
        Assertions.assertTrue(highestScore == 360);
    }

    @Test
    void readRecord() {
        GameRecorder gameRecorder = new GameRecorder();

        gameRecorder.readRecord();

        ArrayList<String> names = gameRecorder.getName();
        Assertions.assertEquals("Bryan", names.get(0));
        Assertions.assertEquals("Yu Heng", names.get(1));
        Assertions.assertEquals("Zixiang Hu", names.get(2));

        ArrayList<Integer> score = gameRecorder.getScore();
        Assertions.assertEquals(360, score.get(0).intValue());
        Assertions.assertEquals(300 ,score.get(1).intValue());
        Assertions.assertEquals(200, score.get(2).intValue());

        ArrayList<Integer> times = gameRecorder.getTimeConsumed();
        Assertions.assertEquals(60, times.get(0).intValue());
        Assertions.assertEquals(54, times.get(1).intValue());
        Assertions.assertEquals(106, times.get(2).intValue());
    }

    @Test
    void sortRecord() {
        GameRecorder gameRecorder = new GameRecorder();

        gameRecorder.readRecord();

        ArrayList<String> names = gameRecorder.getName();
        Assertions.assertEquals("Bryan", names.get(0));
        Assertions.assertEquals("Yu Heng", names.get(1));
        Assertions.assertEquals("Zixiang Hu", names.get(2));

        ArrayList<Integer> score = gameRecorder.getScore();
        Assertions.assertEquals(360, score.get(0).intValue());
        Assertions.assertEquals(300 ,score.get(1).intValue());
        Assertions.assertEquals(200, score.get(2).intValue());

        ArrayList<Integer> times = gameRecorder.getTimeConsumed();
        Assertions.assertEquals(60, times.get(0).intValue());
        Assertions.assertEquals(54, times.get(1).intValue());
        Assertions.assertEquals(106, times.get(2).intValue());
    }

    @Test
    void getName() {
        GameRecorder gameRecorder = new GameRecorder();

        gameRecorder.readRecord();

        ArrayList<String> names = gameRecorder.getName();
        Assertions.assertEquals("Bryan", names.get(0));
        Assertions.assertEquals("Yu Heng", names.get(1));
        Assertions.assertEquals("Zixiang Hu", names.get(2));
    }


    @Test
    void saveRecord() {
        GameRecorder gameRecorder = new GameRecorder();
        gameRecorder.saveRecord("Bob", 500, 50);
        gameRecorder.readRecord();

        Assertions.assertEquals("Bob", gameRecorder.getName().get(0));
        Assertions.assertEquals(500, gameRecorder.getScore().get(0).intValue());
        Assertions.assertEquals(50, gameRecorder.getTimeConsumed().get(0).intValue());

    }

    @Test
    void getScore() {
        GameRecorder gameRecorder = new GameRecorder();

        gameRecorder.readRecord();

        ArrayList<Integer> score = gameRecorder.getScore();
        Assertions.assertEquals(500, score.get(0).intValue());
        Assertions.assertEquals(360 ,score.get(1).intValue());
        Assertions.assertEquals(300, score.get(2).intValue());
    }

    @Test
    void getTimeConsumed() {
        GameRecorder gameRecorder = new GameRecorder();

        gameRecorder.readRecord();

        ArrayList<Integer> times = gameRecorder.getTimeConsumed();
        Assertions.assertEquals(50, times.get(0).intValue());
        Assertions.assertEquals(60, times.get(1).intValue());
        Assertions.assertEquals(54, times.get(2).intValue());
    }

    @Test
    void getRecordNum() {
        GameRecorder gameRecorder = new GameRecorder();

        gameRecorder.readRecord();

        int num = gameRecorder.getRecordNum();
        Assertions.assertEquals(3, num);
    }



}