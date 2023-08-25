package w19Progetto.processoDiControllo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class ProcessoAttualeFactory extends ProcessiFactory {

	@Override
	public ProcessoDiControllo createController() {

		Random rnd = new Random();
		ProcessoAttuale pa = new ProcessoAttuale(rnd.nextInt(10000));
		return pa;
	}

}
