package w19Progetto.processoDiControllo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import w19Progetto.sonda.Sonda;

@Getter
@Setter
@ToString
public abstract class ProcessoDiControllo {
	protected int controllerId;

	public ProcessoDiControllo(int controllerId) {
		this.controllerId = controllerId;
	}

	public abstract void sendAlarm(Sonda sonda);
}
