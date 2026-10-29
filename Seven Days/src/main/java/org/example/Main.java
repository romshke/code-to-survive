package org.example;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    record Data(
            int N,
            int M,
            int X,
            List<Route> routes
    ) {
    }

    record Route(
            int from,
            int to
    ) {
    }

    static int numberOfCursedTapesInStoreX() {
        Data data = getData();
        int[] numberOfCursedTapesInStores = new int[data.N];
        numberOfCursedTapesInStores[1]++;
        Set<Integer> storesWithCursedTapes = new HashSet<>();
        storesWithCursedTapes.add(1);

        for (int day = 0; day < 7; day++) {
            var todayCursedStores = new ArrayList<Integer>();
            var todayNumberOfCursedTapesInStores = numberOfCursedTapesInStores.clone();

            for (var route : data.routes) {
                if (storesWithCursedTapes.contains(route.from)) {
                    todayCursedStores.add(route.to);
                    todayNumberOfCursedTapesInStores[route.to] += numberOfCursedTapesInStores[route.from];
                }
            }

            storesWithCursedTapes.addAll(todayCursedStores);
            numberOfCursedTapesInStores = todayNumberOfCursedTapesInStores;
        }

        return numberOfCursedTapesInStores[data.X];
    }

    static Data getData() {
        File file = new File("Seven Days/src/main/resources/hyperskill-dataset-125861057.txt");
        int N, M, X;
        List<Route> routes = new ArrayList<>();

        try (var scanner = new Scanner(file)) {
            N = scanner.nextInt() + 1;
            M = scanner.nextInt();
            X = scanner.nextInt();
            scanner.nextLine();

            for (int i = 0; i < M; i++) {
                var route = scanner.nextLine().split(" ");

                int from = Integer.parseInt(route[0]);
                int to = Integer.parseInt(route[1]);

                routes.add(new Route(from, to));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return new Data(N, M, X, routes);
    }

    public static void main(String[] args) {
        var start = System.currentTimeMillis();
        System.out.println(numberOfCursedTapesInStoreX());
        System.out.println(System.currentTimeMillis() - start);

    }
}