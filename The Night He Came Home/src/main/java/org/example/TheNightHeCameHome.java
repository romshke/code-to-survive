package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TheNightHeCameHome {

    public static int rejectedReports() {
        File file = new File("The Night He Came Home/src/main/resources/hyperskill-dataset-125821667.txt");
        var result = 0;

        try (var scanner = new Scanner(file)) {
            var data = getData(scanner);
            var currentReport = new Report(data);

            data = getData(scanner);
            var nextReport = new Report(data);

            while (scanner.hasNext()) {
                var timestampsDifference = Math.abs(currentReport.timestamp - nextReport.timestamp);
                var houseNumbersDifference = Math.abs(currentReport.houseNumber - nextReport.houseNumber);

                if (timestampsDifference < houseNumbersDifference) {
                    result++;
                } else {
                    currentReport.setTimestamp(nextReport.timestamp);
                    currentReport.setHouseNumber(nextReport.houseNumber);
                }

                data = getData(scanner);
                nextReport.setTimestamp(data.getFirst());
                nextReport.setHouseNumber(data.getLast());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    private static List<Integer> getData(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .toList();
    }

    static class Report {
        int timestamp;
        int houseNumber;

        public Report(List<Integer> data) {
            this.timestamp = data.getFirst();
            this.houseNumber = data.getLast();
        }

        public void setTimestamp(int timestamp) {
            this.timestamp = timestamp;
        }

        public void setHouseNumber(int houseNumber) {
            this.houseNumber = houseNumber;
        }
    }

    public static void main(String[] args) {
        System.out.println(rejectedReports());
    }
}
