package w19Progetto.centroControllo;

import java.io.FileWriter;

import w19Progetto.sonda.Sonda;

public class ProxyCentroDiControllo {
	private CentroDiControllo centroControllo;
	private FileWriter fileWriter;

	public ProxyCentroDiControllo(CentroDiControllo centroControllo) {
		this.centroControllo = centroControllo;
		try {
			fileWriter = new FileWriter("alarmLog.txt", true);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Finto database non trovato");
		}
	}

	public void receiveAlarm(Sonda sonda) {
		try {
			fileWriter.write(sonda.toString() + "\n");
			fileWriter.flush();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Errore nella scrittura del finto database");
		}
		if (sonda.getLivelloFumo() > 5) {
			centroControllo.sendAlarmToOperators(alarmUrl(sonda));
		}
	}

	public String alarmUrl(Sonda sonda) {
		return "http://host/alarm?=idsonda" + sonda.getSondaId() + "&lat=" + sonda.getLatitudine() + "&lon="
				+ sonda.getLongitudine() + "&smokelevel=" + sonda.getLivelloFumo();
	}

}
