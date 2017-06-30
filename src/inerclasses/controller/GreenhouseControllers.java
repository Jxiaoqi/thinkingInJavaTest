package inerclasses.controller;

public class GreenhouseControllers extends Controller{
	private boolean light = true;
	public class LightOn extends Event {

		public LightOn(long delayTime) {
			super(delayTime);
		}

		@Override
		public void action() {
			light = true;
		}
		
		@Override
		public String toString() {
			return "Light is on";
		}
	}
	
	public class LightOff extends Event {

		public LightOff(long delayTime) {
			super(delayTime);
		}

		@Override
		public void action() {
			light = false;
		}
		
		@Override
		public String toString() {
			return "Light is off"; 
		}
	}
	
	private boolean water = true;
	public class WaterOn extends Event {

		public WaterOn(long delayTime) {
			super(delayTime);
		}

		@Override
		public void action() {
			water = true;
		}
		
		@Override
		public String toString() {
			return "Water is on";
		}
	}
	
	public class WaterOff extends Event {

		public WaterOff(long delayTime) {
			super(delayTime);
		}

		@Override
		public void action() {
			water = false;
		}
		
		@Override
		public String toString() {
			return "water is off";
		}
	}
	
	private String thermostat = "Day";
	public class ThermostatNight extends Event {

		public ThermostatNight(long delayTime) {
			super(delayTime);
		}

		@Override
		public void action() {
			thermostat = "Night";
		}
		
		@Override
		public String toString() {
			return "Thremostat on night setting";
		}
	}
	
	public class ThermostatDay extends Event {

		public ThermostatDay(long delayTime) {
			super(delayTime);
		}

		@Override
		public void action() {
			thermostat = "Day";
		}
		
		@Override
		public String toString() {
			return "Thermostat on day setting";
		}
	}
	
	public class Bell extends Event {

		public Bell(long delayTime) {
			super(delayTime);
		}

		@Override
		public void action() {
			addEvent(new Bell(delayTime));
		}
		
		@Override
		public String toString() {
			return "Bing!";
		}
	}
	
	public class Restart extends Event {
		private Event[] eventList;
		public Restart(long delayTime, Event[] eventList) {
			super(delayTime);
			this.eventList = eventList;
			for (Event e : eventList) {
				addEvent(e);
			}
		}

		@Override
		public void action() {
			for (Event e : eventList) {
				e.start();
				addEvent(e);
			}
			start();
			addEvent(this);
		}
		
		@Override
		public String toString() {
			return "Restarting System";
		}
	}
	
	public static class Terminate extends Event {

		public Terminate(long delayTime) {
			super(delayTime);
		}

		@Override
		public void action() {
			System.exit(0);
		}
		
		@Override
		public String toString() {
			return "Terminating";
		}
		
	}
	
	public Terminate terminate(long delayTime) {
		return new Terminate(delayTime);
	}
	
	
}
