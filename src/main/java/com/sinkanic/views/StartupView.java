package com.sinkanic.views;

import java.awt.HeadlessException;

import com.sinkanic.views.components.BasicView;

public class StartupView extends BasicView {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9218826288861126393L;

	public StartupView() throws HeadlessException {
		this("Sinkanic Startup View");
	}

	public StartupView(String title) throws HeadlessException {
		super(title);
		// TODO Auto-generated constructor stub
	}

}
