package inerclasses.controller;

/**
 * 内部类与控制框架  :   命令模式的一个例子
 * @author admin
 *
 */
public class GreenhouseController {
	public static void main(String[] args) {
		GreenhouseControllers gc = new GreenhouseControllers();
		
		gc.addEvent(gc.new Bell(900));
		Event[] eventList = {
				gc.new ThermostatNight(0),
				gc.new LightOn(200),
				gc.new LightOff(400),
				gc.new WaterOn(600),
				gc.new WaterOff(800),
				gc.new ThermostatDay(1400)
		};
		gc.addEvent(gc.new Restart(2000, eventList));
		if (args.length == 1) 
			gc.addEvent(new GreenhouseControllers().terminate(new Integer(args[0])));
		gc.run();
		
	}
}
