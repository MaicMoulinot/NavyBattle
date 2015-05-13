package com.sinkanic;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.sinkanic.business.CellTest;
import com.sinkanic.business.GameTest;
import com.sinkanic.ships.AircraftCarrierTest;
import com.sinkanic.ships.BattleshipTest;
import com.sinkanic.ships.CruiserTest;
import com.sinkanic.ships.PatrolBoatTest;
import com.sinkanic.ships.ShipTest;
import com.sinkanic.ships.SubmarineTest;

@RunWith(Suite.class)
@SuiteClasses({ ShipTest.class, AircraftCarrierTest.class, BattleshipTest.class, 
	CruiserTest.class, PatrolBoatTest.class, SubmarineTest.class, CellTest.class, 
	GameTest.class })
public class AllTests {

}
