package inerclasses;

import inerclasses.Parcell2.Contents;

public class Test {
	//No enclosing instance of type Parcell2 is accessible. 
	//Must qualify the allocation with an enclosing instance of type Parcell2 (e.g. x.new A() where x is an instance of Parcell2).
	//!Contents c = new Contents();
	
	//!Parcell2.Contents c = new Contents();
	
	Parcell2 p = new Parcell2();
	Parcell2.Contents c = p.contents();
}
