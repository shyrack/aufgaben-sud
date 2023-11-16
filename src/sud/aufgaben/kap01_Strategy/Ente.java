package kap01_Strategy;

public abstract class Ente {

	FlugVerhalten flugVerhalten;
	QuakVerhalten quakVerhalten;
	
	public Ente() {
		
	}
	
	public void doFliegen() {
		flugVerhalten.fliegen();
	}
	
	public void doQuaken() {
		quakVerhalten.quaken();
	}
	
	public void setFlugVerhalten(FlugVerhalten fv) {
		flugVerhalten = fv;
	}
	
	public void setQuakVerhalten(QuakVerhalten qv) {
		quakVerhalten = qv;
	}
	
	public void schwimmen() {
		System.out.println("Allen Enten schwimmen - auch Holzenten!");
	}
}
