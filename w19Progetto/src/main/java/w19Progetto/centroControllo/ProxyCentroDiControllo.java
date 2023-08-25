package w19Progetto.centroControllo;

import w19Progetto.sonda.Sonda;

public class ProxyCentroDiControllo {
	private CentroDiControllo centroControllo;

	public ProxyCentroDiControllo(CentroDiControllo centroControllo) {
		this.centroControllo = centroControllo;
	}

	public void receiveAlarm(Sonda sonda) {
		if (sonda.getLivelloFumo() > 5) {
			centroControllo.sendAlarmToOperators(alarmUrl(sonda));
		}
	}

	public String alarmUrl(Sonda sonda) {
		return "http://host/alarm?=idsonda" + sonda.getSondaId() + "&lat=" + sonda.getLatitudine() + "&lon="
				+ sonda.getLongitudine() + "&smokelevel=" + sonda.getLivelloFumo();
	}

}
