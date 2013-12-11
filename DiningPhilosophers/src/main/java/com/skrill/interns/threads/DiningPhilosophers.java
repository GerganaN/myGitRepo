/*
 *
 * Gergana Nikolova Project
 */
package com.skrill.interns.threads;

public class DiningPhilosophers {

	public static void main(String[] args) {

		Thread einstein = new Thread(new Philosopher("Einstein",
				"The only real valuable thing is intuition."));
		Thread sophocle = new Thread(new Philosopher("Sophocle",
				"Rather fail with honor than succeed by fraud."));
		Thread socrates = new Thread(new Philosopher("Socrates",
				"The unexamined life is not worth living"));
		Thread aristotle = new Thread(
				new Philosopher("Aristotle",
						"There must then be a principle of such a kind that its substance is activity"));
		Thread plato = new Thread(
				new Philosopher(
						"Plato",
						"The object of knowledge is what exists and its function to know about reality."));

		System.out.println("\n *******DINNER STARTS******\n");
		einstein.start();
		sophocle.start();
		socrates.start();
		aristotle.start();
		plato.start();

		try {
			einstein.join();
			sophocle.join();
			socrates.join();
			aristotle.join();
			plato.join();

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("\n *****DINNER IS OVER!**********");

	}
}
