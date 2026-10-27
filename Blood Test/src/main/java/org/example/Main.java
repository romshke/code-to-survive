package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    record BloodTest(
            int crewMemberA,
            int crewMemberB,
            TestResult testResult
    ) {
    }

    enum TestResult {
        SAME, DIFFERENT
    }

    private static boolean classify(int a, int b, TestResult result, Set<Integer> humans, Set<Integer> aliens) {
        boolean aIsHuman = humans.contains(a);
        boolean bIsHuman = humans.contains(b);
        boolean aIsAlien = aliens.contains(a);
        boolean bIsAlien = aliens.contains(b);

        if (result == TestResult.SAME) {
            if (aIsHuman) { humans.add(b); return true; }
            if (bIsHuman) { humans.add(a); return true; }
            if (aIsAlien) { aliens.add(b); return true; }
            if (bIsAlien) { aliens.add(a); return true; }
        } else { // DIFFERENT
            if (aIsHuman) { aliens.add(b); return true; }
            if (bIsHuman) { aliens.add(a); return true; }
            if (aIsAlien) { humans.add(b); return true; }
            if (bIsAlien) { humans.add(a); return true; }
        }

        return false;
    }

    static int totalNumberOfAliens() {
        var file = new File("Blood Test/src/main/resources/hyperskill-dataset-125836174.txt");

        List<BloodTest> bloodTests = new ArrayList<>();
        Set<Integer> humans = new HashSet<>();
        Set<Integer> aliens = new HashSet<>();

        humans.add(1);

        try (var scanner = new Scanner(file)) {
            scanner.nextLine();

            int crewMemberA;
            int crewMemberB;
            TestResult testResult;

            while (scanner.hasNext()) {
                crewMemberA = scanner.nextInt();
                crewMemberB = scanner.nextInt();
                testResult = TestResult.valueOf(scanner.next());
                scanner.nextLine();

                if (!classify(crewMemberA, crewMemberB, testResult, humans, aliens)) {
                    bloodTests.add(new BloodTest(crewMemberA, crewMemberB, testResult));
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        while (!bloodTests.isEmpty()) {
            bloodTests.removeIf(bloodTest ->
                    classify(bloodTest.crewMemberA, bloodTest.crewMemberB, bloodTest.testResult, humans, aliens));
        }

        return aliens.size();
    }

    public static void main(String[] args) {
        System.out.println(totalNumberOfAliens());
    }
}