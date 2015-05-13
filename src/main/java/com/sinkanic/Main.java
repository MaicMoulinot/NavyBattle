package com.sinkanic;

import java.awt.EventQueue;

public class Main {

	/**
	 * @param args String[]
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//new FenetreDemarrage();
					new SinkanicApp();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}


