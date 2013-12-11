/*
 *
 * Gergana Nikolova Project
 */
package com.skrill.interns.threads;

public class Toilet {

	public static boolean occupied = false;
	public static int toiletPaper = 10;

	public static void occupyToilet() {
		System.out.println(" occupied the toilet");
		occupied = true;
		toiletPaper--;

	}

	public static void leaveToilet() {
		System.out.println(" left the toilet");
		occupied = false;
	}

	public static int getToiletPaper() {
		return toiletPaper;
	}

}
