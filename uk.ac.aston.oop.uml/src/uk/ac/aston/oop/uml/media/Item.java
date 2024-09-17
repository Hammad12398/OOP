package uk.ac.aston.oop.uml.media;


public abstract class Item {
    private String title;
    private int playMinutes;
    private String comment = ""; // Default empty comment
    private boolean owned = false; // Default not owned

    public Item(String title, int playMinutes) {
        this.title = title;
        this.playMinutes = playMinutes;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public boolean isOwned() {
        return owned;
    }

    public void setOwned(boolean owned) {
        this.owned = owned;
    }

    public int getPlayMinutes() {
        return playMinutes;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return String.format("%s%s: %d min - %s", 
                owned ? "*" : "", title, playMinutes, comment);
    }
}
