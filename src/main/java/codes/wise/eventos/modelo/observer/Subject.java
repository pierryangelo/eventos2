package codes.wise.eventos.modelo.observer;

import java.util.List;

import com.google.common.collect.Lists;

public abstract class Subject {
	private List<Observer> observers;
	protected StringBuilder notification;
	
	public Subject() {
		this.observers = Lists.newArrayList();
	}
	
	public void attach(Observer obs) {
		this.observers.add(obs);
	}
	
	public void detach(Observer obs) {
		this.observers.remove(obs);
	}
	
	public void notifyObservers() { 
		this.observers.forEach(o -> o.update(this.notification));
	}
	
	public abstract void setNotification(String string);
	
	public String getNotification() {
		return this.notification.toString();
	}
	
	public void clearNotification() {
		this.notification.setLength(0);
	}
}