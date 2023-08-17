// package sud.aufgaben.occupationalTherapy.observer;

// import java.util.Random;

// public class Main_WetterstationTestlauf {

// 	static Random zM = new Random();

// 	public static void main(String[] args) {

// 		System.out.println("--------------WETTERSTATION TESTLAUF--------------");

// 		WeatherData wetterDaten = new WeatherData(26, 20, 1000);

// //ROL START hier wurden Teile gelöscht, um nicht zu viel des Lösungswegs vorzugeben

// 		AktuelleBedingungen aktuell = new AktuelleBedingungen( );
// 		WetterVorhersage vorhersage = new WetterVorhersage( );

// //ROL ENDE
// 		try {
// 			for (int i = 0; i < 50; i++) {
// 				int welcher = zM.nextInt(3);
// 				float wert = 0f;
// 				switch (welcher) {
// 				case 0:
// 					wetterDaten.setTemperatur(wetterDaten.getTemperatur() + (zM.nextInt(8) - 4));
// 					break;
// 				case 1:
// 					wert = wetterDaten.getFeuchtigkeit() + zM.nextInt(40) - 20;
// 					if (wert >= 0)
// 						wetterDaten.setFeuchtigkeit(wert);
// 					break;
// 				case 2:
// 					wert = wetterDaten.getLuftdruck() + zM.nextInt(30) - 15;
// 					if (wert >= 650)
// 						wetterDaten.setLuftdruck(wert);
// 					break;
// 				}
// 				Thread.sleep(1000);
// 			}
// 			wetterDaten.removeObserver(aktuell);
// 			Thread.sleep(500);
// 			wetterDaten.setMesswerte(28, 16, 78);
// 		} catch (InterruptedException e) {
// 			// TODO Auto-generated catch block
// 			e.printStackTrace();
// 		}
// 	}

// }
