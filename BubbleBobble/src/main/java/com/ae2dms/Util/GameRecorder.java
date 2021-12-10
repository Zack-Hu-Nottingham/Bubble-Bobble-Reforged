package com.ae2dms.Util;

import java.io.*;
import java.util.ArrayList;

/**
 * The type Game recorder.
 */
public class GameRecorder {

    /**
     * The record keeper's name.
     */
    private ArrayList<String> name = new ArrayList<>();
    /**
     * The record keeper's score.
     */
    private ArrayList<Integer> score = new ArrayList<>();
    /**
     * The Time consumed of that record.
     */
    private ArrayList<Integer> timeConsumed = new ArrayList<>();

    /**
     * The total number of records.
     */
    int recordNum = 0;

    /**
     * The Game document's url.
     */
    String gameDocument = "src/main/resources/gameRecord/records.txt";

    /**
     * The Records.
     */
    BufferedReader bufferedReader;

    /**
     * One piece of Record, which contains: name, score and time consumed.
     */
    String record = null;

    /**
     * Instantiates a new Game recorder.
     */
    public GameRecorder() {
    }

    /**
     * Get highest score int.
     *
     * @return the int
     */
    public int getHighestScore(){
        readRecord();
        if (score.isEmpty()) {
            return 0;
        } else {
            return score.get(0);
        }
    }

    /**
     * Read record.
     */
    public void readRecord() {
        try {
            bufferedReader = new BufferedReader(new FileReader(gameDocument));
            String[] parts = null;
            do {
                record = bufferedReader.readLine();
                if (record != null) {
                    parts = record.split(",");
                    name.add(parts[0]);
                    score.add(Integer.valueOf(Integer.parseInt(parts[1])));
                    timeConsumed.add(Integer.valueOf(Integer.parseInt(parts[2])));
                    recordNum += 1;
                }
            } while(record != null);
            bufferedReader.close();
            sortRecord();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Sort the record that read from records.txt according to its score.
     */
    public void sortRecord() {
        for (int i = 0; i < recordNum; i++) {

            for (int j = 1; j < recordNum; j++) {
                if (score.get(j) > score.get(j-1)) {
                    score.add(j-1, score.get(j));
                    score.remove(j+1);

                    name.add(j-1, name.get(j));
                    name.remove(j+1);

                    timeConsumed.add(j-1, timeConsumed.get(j));
                    timeConsumed.remove(j+1);
                }
            }
        }

    }

    /**
     * Gets the arraylist of name, which is sorted by score in sortRecord().
     *
     * @return the name
     */
    public ArrayList<String> getName() {
        return name;
    }

    /**
     * Gets the arraylist of score, which is sorted from high to low.
     *
     * @return the score
     */
    public ArrayList<Integer> getScore() {
        return score;
    }

    /**
     * Gets time consumed.
     *
     * @return the time consumed
     */
    public ArrayList<Integer> getTimeConsumed() {
        return timeConsumed;
    }

    /**
     * Gets the total number of records.
     *
     * @return the record num
     */
    public int getRecordNum() {
        return recordNum;
    }

    /**
     * Save the specific record into file.
     *
     * @param userName     the user name
     * @param score        the score
     * @param timeConsumed the time consumed
     */
    public void saveRecord(String userName, int score, int timeConsumed) {
//        String filePath = "src/main/resources/gameRecord/records.txt";

        try {
            File file = new File(gameDocument);
            FileOutputStream fos = null;

            if (!file.exists()) {
                file.createNewFile();
                fos = new FileOutputStream(file);
            } else {
                fos = new FileOutputStream(file, true);
            }

            OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
            osw.write(userName + ",");
            osw.write(score + ",");
            osw.write(timeConsumed+"");
            osw.write("\r\n");
            osw.close();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
