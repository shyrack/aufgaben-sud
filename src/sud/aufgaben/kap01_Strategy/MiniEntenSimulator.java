package kap01_Strategy;

public class MiniEntenSimulator {

	public static void main (String[] args) {
		Ente mallard = new StockEnte();
		mallard.doQuaken();
		mallard.doFliegen();
		
		Ente modell = new ModellEnte();
		modell.doQuaken();
		modell.doFliegen();
		modell.setFlugVerhalten(new FliegtRaketenGetrieben());
		modell.doFliegen();
	}
}
