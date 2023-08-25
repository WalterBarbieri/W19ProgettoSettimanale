package w19Progetto.sonda;

public interface AlarmSubscriber {
	public void receiveAlarm(Sonda sonda);

	void sendAlarm(Sonda sonda);

}
