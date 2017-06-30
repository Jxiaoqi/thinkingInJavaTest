package inerclasses.controller;

/**
 * 内部类 与 控制框架
 * 		1.接口描述了要控制的事件.因为其默认的行为是基于时间去执行控制,所以使用抽象类代替
 * 实际的接口.
 * @author admin
 *
 */
public abstract class Event {
	
	private long eventTime;
	protected long delayTime;
	
	public Event(long delayTime) {
		this.delayTime = delayTime;
	}
	
	public void start() {
		eventTime = System.nanoTime() + delayTime;
	}
	
	public boolean ready() {
		return System.nanoTime() >= eventTime;
	}
	
	public abstract void action();
}
