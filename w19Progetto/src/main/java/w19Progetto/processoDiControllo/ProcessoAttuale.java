package w19Progetto.processoDiControllo;

import w19Progetto.centroControllo.ProxyCentroDiControllo;
import w19Progetto.sonda.AlarmSubscriber;
import w19Progetto.sonda.Sonda;

public class ProcessoAttuale extends ProcessoDiControllo implements AlarmSubscriber {

	private ProxyCentroDiControllo proxyControl;

	public ProcessoAttuale(int controllerId, ProxyCentroDiControllo proxyControl) {
		super(controllerId);
		this.proxyControl = proxyControl;

	}

	@Override
	public void sendAlarm(Sonda sonda) {
		try {
			proxyControl.receiveAlarm(sonda);
			System.out.println("Invio Messaggio al centro di controllo effettuato con successo!");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Attenzione!!! Errore nell'invio del messaggio a lcentro di controllo!");
		}
	}

	@Override
	public void receiveAlarm(Sonda sonda) {
		System.out.println("Ricevuto correttamente allarme: " + sonda.toString());
		System.out.println("Invio Messaggio a centro di controllo...");

		sendAlarm(sonda);

	}

}
