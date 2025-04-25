package IteratorPattern;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;
public class ShuffleSeasonIterator implements EpisodeIterator {
    private final List<Episode> shuffled;
    private final Iterator<Episode> iterator;

    public ShuffleSeasonIterator(Season season, long seed) {
        this.shuffled = new ArrayList<>(season.getEpisodes());
        Collections.shuffle(shuffled, new Random(seed));
        this.iterator = shuffled.iterator();
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public Episode next() {
        return iterator.next();
    }
}
