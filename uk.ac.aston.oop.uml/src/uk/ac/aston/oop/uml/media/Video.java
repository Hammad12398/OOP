package uk.ac.aston.oop.uml.media;

public class Video extends Item {
    private final String director;

    public Video(String title, String director, int playMinutes) {
        super(title, playMinutes);
        this.director = director;
    }

    public String getDirector() {
        return director;
    }

    @Override
    public String toString() {
        return String.format("Director: %s\n%s", director, super.toString());
    }
}
