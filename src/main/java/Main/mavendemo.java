package Main;

import java.io.IOException;

public class mavendemo extends Utility {
		public mavendemo() throws IOException {
		super();
		
		}

		public void method() throws InterruptedException 
		{
			String usrnmElmnt=prop.getProperty("username");
			 sendData(usrnmElmnt);
			String paswrdElmnt=prop.getProperty("password");
			sendData(paswrdElmnt);
			Thread.sleep(2500);
			String lognElmnt=prop.getProperty("login");
			clickElement(lognElmnt); 
			Thread.sleep(3000);
			String frm=prop.getProperty("logout");
			web_Element(frm);
			Thread.sleep(4000);
			String lgoutfunct=prop.getProperty("clicklogout");
			clickElement(lgoutfunct);
		}
		
}
