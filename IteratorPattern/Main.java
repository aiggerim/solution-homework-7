package IteratorPattern;

public class Main {
    public static void main(String[] args) {
        Series series = new Series();

        for (int s = 1; s <= 2; s++) {
            Season season = new Season();
            for (int e = 1; e <= 3; e++) {
                season.addEpisode(new Episode("S" + s + "E" + e, 1500 + e * 100));
            }
            series.addSeason(season);
        }

        System.out.println("== Normal Order ==");
        for (Episode e : series.getSeasons().get(0)) {
            System.out.println(e);
        }

        System.out.println("\n== Reverse Order ==");
        EpisodeIterator rev = series.getSeasons().get(0).getReverseIterator();
        while (rev.hasNext()) {
            System.out.println(rev.next());
        }

        System.out.println("\n== Shuffle Order ==");
        EpisodeIterator shuffle = series.getSeasons().get(0).getShuffleIterator(42);
        while (shuffle.hasNext()) {
            System.out.println(shuffle.next());
        }

        System.out.println("\n== Binge Mode ==");
        EpisodeIterator binge = series.getBingeIterator();
        while (binge.hasNext()) {
            System.out.println(binge.next());
        }
    }
}

