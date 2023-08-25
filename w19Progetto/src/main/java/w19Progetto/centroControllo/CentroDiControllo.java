package w19Progetto.centroControllo;

import w19Progetto.sonda.Sonda;

public class CentroDiControllo {
	public void sendAlarmToOperators(String alarmUrl) {
		System.out.println("ALLARME INVIATO AGLI OPERATORI!!! " + alarmUrl);
	}

	public String alarmUrl(Sonda sonda) {
		return "http://host/alarm?=idsonda" + sonda.getSondaId() + "&lat=" + sonda.getLatitudine() + "&lon="
				+ sonda.getLongitudine() + "&smokelevel=" + sonda.getLivelloFumo();
	}

}
