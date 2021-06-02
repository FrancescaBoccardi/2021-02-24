package it.polito.tdp.PremierLeague.model;

public class Evento {

	public enum EventType{
		GOAL,
		ESPULSIONE,
		INFORTUNIO
	};
	
	private EventType type;

	public Evento(EventType type) {
		this.type = type;
	}
	
	
	
	
	
}
