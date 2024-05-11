
public class Main {

	public static void main(String[] args) {
		
		AdminLogin.addSomeAdmins();
		SignUp.addsomeUsers();
		Admin.loc();
		Admin.inter();

		MainMenu main =new MainMenu();
		main.setVisible(true);
	}

}

