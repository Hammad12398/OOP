package uk.ac.aston.oop.uml.media;

public class CD extends Item {
    private final String artist;
    private final int numberOfTracks;

    public CD(String title, String artist, int numberOfTracks, int playMinutes) {
        super(title, playMinutes);
        this.artist = artist;
        this.numberOfTracks = numberOfTracks;
    }

    public String getArtist() {
        return artist;
    }

    public int getNumberOfTracks() {
        return numberOfTracks;
    }

    @Override
    public String toString() {
        return String.format("Artist: %s. Number of tracks: %d\n%s", artist, numberOfTracks, super.toString());
    }
}
