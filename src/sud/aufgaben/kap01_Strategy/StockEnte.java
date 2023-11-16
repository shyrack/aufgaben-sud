package kap01_Strategy;

public class StockEnte extends Ente {

	public StockEnte() {
		quakVerhalten = new Quaken();
		flugVerhalten = new FliegtMitFluegeln();
	}
	
	public void anzeigen() {
		System.out.println("Ich bin eine echte Stockente.");
	}
}
