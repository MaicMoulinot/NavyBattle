package com.sinkanic;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.sinkanic.business.CellTest;
import com.sinkanic.business.GameTest;
import com.sinkanic.ships.ShipTest;

@RunWith(Suite.class)
@SuiteClasses({ ShipTest.class, CellTest.class, GameTest.class })
public class AllTests {

}
