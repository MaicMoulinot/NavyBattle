package com.sinkanic;

import java.awt.EventQueue;

import com.sinkanic.gui.FenetreDemarrage;

public class Main {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new FenetreDemarrage();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}


