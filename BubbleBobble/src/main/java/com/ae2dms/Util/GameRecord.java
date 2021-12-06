package com.ae2dms.Util;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class GameRecord {

    ArrayList<String> name = new ArrayList<>();
    ArrayList<Integer> score = new ArrayList<>();
    ArrayList<Integer> timeConsumed = new ArrayList<>();

    int recordNum = 0;

    String gameDocument = "/gameRecord/records.txt";

    public GameRecord() {
    }


    public void readRecord() throws IOException {
        InputStream input = this.getClass().getResourceAsStream(gameDocument);
        Scanner scanner = new Scanner(input);

        while(scanner.hasNextLine()) {
            String currentRecord = scanner.nextLine();
            System.out.println(currentRecord);

            String[] parts = currentRecord.split(",");
            name.add(parts[0]);
            System.out.println("part1: " +name.get(recordNum));

            score.add(Integer.valueOf(Integer.parseInt(parts[1])));
            System.out.println("part1: " +score.get(recordNum));
            timeConsumed.add(Integer.valueOf(Integer.parseInt(parts[2])));
            System.out.println("part1: " +timeConsumed.get(recordNum));
            recordNum += 1;
            System.out.println();

        }
        sortRecord();

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
                System.out.println("create");
            } else {
                fos = new FileOutputStream(file, true);
                System.out.println("read");
            }

            OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
            osw.write(userName + ",");
            osw.write(score + ",");
            osw.write(timeConsumed+"");
            osw.write("\r\n");
            osw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
