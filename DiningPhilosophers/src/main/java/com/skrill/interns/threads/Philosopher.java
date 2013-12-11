/*
 *
 * Gergana Nikolova Project
 */
package com.skrill.interns.threads;

public class Philosopher implements Runnable {

	private String name;
	private String quote;

	public Philosopher(String name) {
		this.name = name;
	}

	public Philosopher(String name, String quote) {
		this.name = name;
		this.quote = quote;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getQuote() {
		return quote;
	}

	public void setQuote(String quote) {
		this.quote = quote;
	}

	public void eat() {
		System.out.println(name + " is eating. ");
	}

	public void think() {
		System.out.println(name + " is thinking : " + quote);
	}

	public void goToToilet() {

		System.out.print(name);
		Toilet.occupyToilet();
		try {
			Thread.sleep(1000);
			System.out.println(name
					+ " is doing his business in da toilet.....");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.out.print(name);
			Toilet.leaveToilet();

		}
	}

	public void run() {

		for (int i = 0; i < 20; i++) {
			eat();
			think();
			synchronized (Toilet.class) {

				goToToilet();
			}
			Thread.yield();
		}

	}
}
