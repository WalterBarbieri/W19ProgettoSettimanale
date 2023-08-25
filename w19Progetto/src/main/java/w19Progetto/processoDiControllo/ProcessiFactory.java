package w19Progetto.processoDiControllo;

import w19Progetto.centroControllo.ProxyCentroDiControllo;

public abstract class ProcessiFactory {

	public ProxyCentroDiControllo proxyControl;

	public ProcessoDiControllo installController(ProxyCentroDiControllo proxyControl) {
		ProcessoDiControllo pdc = createController(proxyControl);
		return pdc;

	}

	public abstract ProcessoDiControllo createController(ProxyCentroDiControllo proxyControl);

}
