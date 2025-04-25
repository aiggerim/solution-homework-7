package IteratorPattern;
import java.util.*;
public class Season implements Iterable<Episode> {
    private final List<Episode> episodes = new ArrayList<>();

    public void addEpisode(Episode e) {
        episodes.add(e);
    }

    public List<Episode> getEpisodes() {
        return episodes;
    }

    @Override
    public Iterator<Episode> iterator(){
        return new SeasonIterator(this);
    }

    public EpisodeIterator getSeasonIterator(){
        return new SeasonIterator(this);
    }

    public EpisodeIterator getReverseIterator(){
        return new ReverseSeasonIterator(this);
    }

    public EpisodeIterator getShuffleIterator(long seed){
        return new ShuffleSeasonIterator(this, seed);
    }
}
