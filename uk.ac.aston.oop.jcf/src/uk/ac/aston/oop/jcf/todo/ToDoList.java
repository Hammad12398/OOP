package uk.ac.aston.oop.jcf.todo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class ToDoList implements Iterable<ToDoItem> {

	protected final List<ToDoItem> items = new ArrayList<>();

	@Override
	public Iterator<ToDoItem> iterator() {
		return items.iterator();
	}

	public boolean isEmpty() {
		return items.isEmpty();
	}

	public void add(ToDoItem toDoItem) {
		items.add(toDoItem);
	}

	public int size() {
		return items.size();
	}

	public void markDone(int i) {
		items.get(i).setDone(true);
	}

	public void remove(int i) {
		items.remove(i);
	}

	public void removeAllContaining(String substring) {
		for (Iterator<ToDoItem> it = iterator(); it.hasNext(); ) {
			ToDoItem item = it.next();
			if (item.getDescription().contains(substring)) {
				it.remove();
			}
		}
	}

	public void removeAllDone() {
		for (Iterator<ToDoItem> it = iterator(); it.hasNext(); ) {
			ToDoItem item = it.next();
			if (item.isDone()) {
				it.remove();
			}
		}
	}

	public void moveToTop(int i) {
		if (i > 0) {
			ToDoItem item = items.remove(i);
			items.add(0, item);
		}
	}

	public void shuffle(Random rnd) {
		for (int i = 0; i < items.size(); i++) {
			final ToDoItem item = items.get(i);
			final int otherPosition = rnd.nextInt(items.size());
			items.set(i, items.get(otherPosition));
			items.set(otherPosition, item);
		}
	}
}
