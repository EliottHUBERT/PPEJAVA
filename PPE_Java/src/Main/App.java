package Main;
import Controller.Login_Controller;
import Views.F_Login;
import Views.F_Main;

public class App {

	public static void main(String[] args) {
		F_Login f_login = new F_Login();
		new Login_Controller(f_login).init();
	}

}

