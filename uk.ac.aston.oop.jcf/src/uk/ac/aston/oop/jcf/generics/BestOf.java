package uk.ac.aston.oop.jcf.generics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BestOf<T extends Comparable<? super T>> {

	private final List<T> items = new ArrayList<>();
	private final int maxItems;

	public BestOf(int maxItems) {
		this.maxItems = maxItems; 
	}

	public List<T> getItems() {
		return Collections.unmodifiableList(items);
	}

	public void add(T c) {
		items.add(c);
		Collections.sort(items);
		if (items.size() > maxItems) {
			items.remove(0);
		}
	}
	
	public static void main(String[] args) {
		final BestOf<Integer> bestScores = new BestOf<>(3);
		bestScores.add(3000);
		bestScores.add(4200);
		bestScores.add(2600);
		bestScores.add(1500);

		for (int c : bestScores.getItems()) {
			System.out.println(c);
		}
	}
}
