package w19Progetto.sonda;

import java.util.Random;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Sonda {
	private int sondaId;
	private double longitudine;
	private double latitudine;
	private int livelloFumo = 0;
	private AlarmSubscriber alarmSubscriber;

	Random rnd = new Random();

	public Sonda(double longitudine, double latitudine) {
		this.sondaId = rnd.nextInt(10000);
		this.longitudine = longitudine;
		this.latitudine = latitudine;
	}

	public void setAlarmSubscriber(AlarmSubscriber alarmSubscriber) {
		this.alarmSubscriber = alarmSubscriber;
	}

	public void sendSignal() {
		if (alarmSubscriber != null) {
			this.livelloFumo = new Random().nextInt(10) + 1;
			alarmSubscriber.receiveAlarm(this);
		}
	}

	@Override
	public String toString() {
		return "Sonda [sondaId=" + sondaId + ", longitudine=" + longitudine + ", latitudine=" + latitudine
				+ ", livelloFumo=" + livelloFumo + "]";
	}

}
