package uk.ac.aston.oop.uml.media;

import java.util.ArrayList;
import java.util.List;


public class Database {
    private List<Item> items;

    public Database() {
        items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    
    public void print() {
        items.forEach(System.out::println);
    }

    public static void main(String[] args) {
        Database db = new Database();
        db.addItem(new Video("Some Movie", "Some Director", 120));
        db.addItem(new CD("Some Album", "Some Artist", 10, 40));
        db.print();
    }
}
