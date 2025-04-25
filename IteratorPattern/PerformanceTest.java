package IteratorPattern;

import java.util.*;

class PerformanceTest {

    public static void main(String[] args) {
        final int EPISODE_COUNT = 10_000;
        Season season = new Season();
        Random rand = new Random();

        for (int i = 0; i < EPISODE_COUNT; i++) {
            season.addEpisode(new Episode("Episode " + (i + 1), 1000 + rand.nextInt(300)));
        }

        testIterator("Normal", new SeasonIterator(season));
        testIterator("Reverse", new ReverseSeasonIterator(season));
        testIterator("Shuffle", new ShuffleSeasonIterator(season, 12345L));
    }

    private static void testIterator(String label, EpisodeIterator iterator) {
        long start = System.nanoTime();
        int count = 0;
        while (iterator.hasNext()) {
            iterator.next();
            count++;
        }
        long end = System.nanoTime();
        long timeMs = (end - start) / 1_000_000;

        System.out.printf("%-10s: %6d episodes in %5d ms\n", label, count, timeMs);
    }
}
