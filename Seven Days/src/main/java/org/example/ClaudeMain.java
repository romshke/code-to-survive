package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ClaudeMain {

    private static final String FILE_PATH = "Seven Days/src/main/resources/hyperskill-dataset-125861057.txt";
    private static final int EVENINGS = 7;

    public static void main(String[] args) throws IOException {
        var start = System.currentTimeMillis();

        File file = new File(FILE_PATH);

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            int[] from = new int[m];
            int[] to = new int[m];
            for (int i = 0; i < m; i++) {
                String line = br.readLine();
                while (line != null && line.isBlank()) {
                    line = br.readLine();
                }
                st = new StringTokenizer(line);
                from[i] = Integer.parseInt(st.nextToken());
                to[i] = Integer.parseInt(st.nextToken());
            }

            BigInteger[] cnt = new BigInteger[n + 1];
            Arrays.fill(cnt, BigInteger.ZERO);
            cnt[1] = BigInteger.ONE;

            for (int day = 0; day < EVENINGS; day++) {
                // Оригиналы остаются на месте
                BigInteger[] next = cnt.clone();
                // Копии считаются только по состоянию на начало вечера
                for (int i = 0; i < m; i++) {
                    next[to[i]] = next[to[i]].add(cnt[from[i]]);
                }
                cnt = next;
            }

            System.out.println(cnt[x]);
        }

        System.out.println(System.currentTimeMillis() - start);
    }
}
