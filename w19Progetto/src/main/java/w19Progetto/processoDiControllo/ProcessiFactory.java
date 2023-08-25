package w19Progetto.processoDiControllo;

public abstract class ProcessiFactory {
	public ProcessoDiControllo installController() {
		ProcessoDiControllo pdc = createController();
		return pdc;

	}

	public abstract ProcessoDiControllo createController();

}
