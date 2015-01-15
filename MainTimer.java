package jp.ac.keio.sfc.obpro;

import java.util.Timer;


public class MainTimer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Timer timer = new Timer(1000, this);
		timer.start();
		timer.stop();
	}

}
