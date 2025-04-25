package IteratorPattern;

import java.util.Iterator;
import java.util.List;

public class SeasonIterator implements EpisodeIterator, Iterator<Episode> {
    private final List<Episode> episodes;
    private int index = 0;

    public SeasonIterator(Season season) {
        this.episodes = season.getEpisodes();
    }

    @Override
    public boolean hasNext(){
        return index < episodes.size();
    }

    @Override
    public Episode next() {
        return episodes.get(index++);
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Remove not supported.");
    }
}
