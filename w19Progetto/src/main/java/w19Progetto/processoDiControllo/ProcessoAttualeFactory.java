package w19Progetto.processoDiControllo;

import java.util.Random;

import org.springframework.stereotype.Component;

import w19Progetto.centroControllo.ProxyCentroDiControllo;

@Component
public class ProcessoAttualeFactory extends ProcessiFactory {

	public ProxyCentroDiControllo proxyControl;

	@Override
	public ProcessoDiControllo createController() {

		Random rnd = new Random();
		ProcessoAttuale pa = new ProcessoAttuale(rnd.nextInt(10000), proxyControl);
		return pa;
	}

}
