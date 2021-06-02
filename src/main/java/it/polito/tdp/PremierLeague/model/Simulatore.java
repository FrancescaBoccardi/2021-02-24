package it.polito.tdp.PremierLeague.model;

public class Simulatore {

	// input
	private int N;

	
	// modello del mondo
	private int n;
	private int giocatoriSq1;
	private int giocatoriSq2;
	private int sq1;
	private int sq2;
	private int sqBest;
	private int infortuni;
	
	// output
	private int goalSq1;
	private int espulsiSq1;
	private int goalSq2;
	private int espulsiSq2;
	
	
	public void init(int N, Match m, int sqBest) {
		this.N=N;
		this.n=1;
		this.goalSq1=0;
		this.goalSq2=0;
		this.espulsiSq1=0;
		this.espulsiSq2=0;
		this.giocatoriSq1=11;
		this.giocatoriSq2=11;
		this.sq1=m.getTeamHomeID();
		this.sq2=m.getTeamAwayID();
		this.sqBest = sqBest;
		this.infortuni=0;
		
		this.processEvent();
		
	}
	
	private void processEvent() {
		
		while(n<=N) {
			double rand = Math.random();
			
			if(rand<=0.5) {
				
				if((this.giocatoriSq1-this.espulsiSq1)>(this.giocatoriSq2-this.espulsiSq2)) {
					this.goalSq1++;
				} else if((this.giocatoriSq1-this.espulsiSq1)<(this.giocatoriSq2-this.espulsiSq2)) {
					this.goalSq2++;
				} else {
					if(sq1==sqBest) {
						this.goalSq1++;
					} else {
						this.goalSq2++;
					}
				}
			} else if(rand>=0.7) {
				
				if(Math.random()<=0.6) {
					if(sq1==sqBest) {
						this.espulsiSq1++;
					} else {
						this.espulsiSq2++;
					}
				} else {
					if(sq1==sqBest) {
						this.espulsiSq2++;
					} else {
						this.espulsiSq1++;
					}
				}
			} else {
				
				this.infortuni++;
				
				if(Math.random()<=0.5) {
					N += 2;
				} else {
					N += 3;
				}
			}
			
			n++;
		}
		
	
	}

	public int getSq1() {
		return sq1;
	}

	public int getSq2() {
		return sq2;
	}

	public int getGoalSq1() {
		return goalSq1;
	}

	public int getEspulsiSq1() {
		return espulsiSq1;
	}

	public int getGoalSq2() {
		return goalSq2;
	}

	public int getEspulsiSq2() {
		return espulsiSq2;
	}
	
	public int getInfortuni() {
		return this.infortuni;
	}
	
}
