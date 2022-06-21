import java.awt.Color;
import java.sql.SQLException;

import com.thehowtotutorial.splashscreen.JSplash;

public class SplashExample {

	public static void main(String[] args) throws InterruptedException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		JSplash splash = new JSplash(SplashExample.class.getResource("/img/welcome.jpg"),
				true, true, false, "Ver1.0", null, Color.red, Color.black);
		splash.splashOn();
		 for(int i=1;i<=100;i++) {
	         splash.setProgress(i,"Loading Database...");
	         Thread.sleep(10);
		 }
		splash.splashOff();

		WinMain win = new WinMain();
		win.setVisible(true);
//		win.setModal(true);
	}

}
