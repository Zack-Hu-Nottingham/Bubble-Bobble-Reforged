package com.ae2dms.Util;

import java.io.*;
import java.util.ArrayList;

public class GameRecord {

    ArrayList<String> name = new ArrayList<>();
    ArrayList<Integer> score = new ArrayList<>();
    ArrayList<Integer> timeConsumed = new ArrayList<>();

    int recordNum = 0;

    String gameDocument = "src/main/resources/gameRecord/records.txt";

    BufferedReader records;

    String record = null;

    public GameRecord() {
    }


    public void readRecord() throws IOException {
        try {
            records = new BufferedReader(new FileReader(gameDocument));
            do {
                record = records.readLine();
                if (record != null) {
                    String[] parts = record.split(",");
                    name.add(parts[0]);
                    score.add(Integer.valueOf(Integer.parseInt(parts[1])));
                    timeConsumed.add(Integer.valueOf(Integer.parseInt(parts[2])));
                    recordNum += 1;
                }
            } while(record != null);
            records.close();

            sortRecord();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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

    public ArrayList<String> getName() {
        return name;
    }

    public ArrayList<Integer> getScore() {
        return score;
    }

    public ArrayList<Integer> getTimeConsumed() {
        return timeConsumed;
    }

    public int getRecordNum() {
        return recordNum;
    }

    public void saveRecord(String userName, int score, int timeConsumed) throws IOException {
        String filePath = "src/main/resources/gameRecord/records.txt";

        try {
            File file = new File(filePath);
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
