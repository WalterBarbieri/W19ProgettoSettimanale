package w19Progetto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import w19Progetto.centroControllo.CentroDiControllo;
import w19Progetto.centroControllo.ProxyCentroDiControllo;
import w19Progetto.processoDiControllo.ProcessiFactory;
import w19Progetto.processoDiControllo.ProcessoDiControllo;
import w19Progetto.sonda.AlarmSubscriber;
import w19Progetto.sonda.Sonda;

@Component
public class ProgettoRunner implements CommandLineRunner {

	private final ProcessiFactory processiFactory;

	@Autowired
	public ProgettoRunner(ProcessiFactory processiFactory) {
		this.processiFactory = processiFactory;
	}

	@Override
	public void run(String... args) throws Exception {

		CentroDiControllo controlCenter = new CentroDiControllo();
		ProxyCentroDiControllo proxyControlCenter = new ProxyCentroDiControllo(controlCenter);
		Sonda sonda1 = new Sonda(64.2, 187.4);
		Sonda sonda2 = new Sonda(64.3, 187.6);
		Sonda sonda3 = new Sonda(122.8, 45.7);
		Sonda sonda4 = new Sonda(15.7, 342.4);
		ProcessoDiControllo processo1 = processiFactory.installController(proxyControlCenter);
		ProcessoDiControllo processo2 = processiFactory.installController(proxyControlCenter);
		sonda1.setAlarmSubscriber((AlarmSubscriber) processo1);
		sonda2.setAlarmSubscriber((AlarmSubscriber) processo1);
		sonda3.setAlarmSubscriber((AlarmSubscriber) processo2);
		sonda4.setAlarmSubscriber((AlarmSubscriber) processo2);
		sonda1.sendSignal();
		sonda2.sendSignal();
		sonda3.sendSignal();
		sonda4.sendSignal();

	}

}
