package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    record Trap(
            int duration,
            int deadline
    ) {

        @Override
        public String toString() {
            return "Trap{" +
                   "duration=" + duration +
                   ", deadline=" + deadline +
                   '}';
        }
    }

    static List<Trap> getTraps() {
        File file = new File("I Want to Play a Game/src/main/resources/hyperskill-dataset-125875973.txt");

        List<Trap> traps = new ArrayList<>();

        try (var scanner = new Scanner(file)) {
            int N = scanner.nextInt();
            scanner.nextLine();

            for (int i = 0; i < N; i++) {
                var data = Arrays.stream(scanner.nextLine().split(" "))
                        .map(Integer::parseInt)
                        .toList();

                traps.add(new Trap(data.getFirst(), data.getLast()));
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return traps;
    }

    static int numberOfSavedPeople() {
        var traps = getTraps();
        var totalTime = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());

        traps.sort(Comparator.comparing(Trap::deadline));

        for (var trap : traps) {
            heap.add(trap.duration);
            totalTime += trap.duration;

            if (totalTime > trap.deadline) {
                totalTime -= heap.poll();
            }
        }

        return heap.size();
    }

    public static void main(String[] args) {
        System.out.println(numberOfSavedPeople());
    }
}