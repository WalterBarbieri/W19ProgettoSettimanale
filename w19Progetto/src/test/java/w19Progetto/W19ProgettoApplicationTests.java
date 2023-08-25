package w19Progetto;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import w19Progetto.centroControllo.CentroDiControllo;
import w19Progetto.centroControllo.ProxyCentroDiControllo;
import w19Progetto.sonda.Sonda;

@SpringBootTest
class W19ProgettoApplicationTests {

	private CentroDiControllo mockCentroDiControllo;
	private ProxyCentroDiControllo proxyControl;

	@BeforeEach
	public void setup() {
		mockCentroDiControllo = mock(CentroDiControllo.class);
		proxyControl = new ProxyCentroDiControllo(mockCentroDiControllo);
	}

	@Test
	void checkOperatorsAlarm() {
		Sonda sonda = new Sonda(234.8, 57.3);
		sonda.setLivelloFumo(6);

		proxyControl.receiveAlarm(sonda);
		verify(mockCentroDiControllo).sendAlarmToOperators(mockCentroDiControllo.alarmUrl(sonda));
	}

	@Test
	void checkOperatorsAlarm2() {
		Sonda sonda = new Sonda(234.8, 57.3);
		sonda.setLivelloFumo(6);

		Sonda sonda2 = new Sonda(52.6, 82.3);
		sonda2.setLivelloFumo(6);

		proxyControl.receiveAlarm(sonda);
		verify(mockCentroDiControllo).sendAlarmToOperators(mockCentroDiControllo.alarmUrl(sonda2));
	}

}
