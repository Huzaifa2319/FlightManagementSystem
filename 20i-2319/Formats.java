import java.util.ArrayList;

public class Formats {
	

	
	static public boolean PasswordFormat(String pass) {
		
		boolean specialcheck=false;
		boolean emptycheck=false;
		boolean numcheck=false;
		boolean capitalcheck=false;
		boolean smallcheck=false;
		
		String special = "!@#$%&*()'+,-./:;<=>?[]^_`{|}";
		String num= "0123456789";
		String capital="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String small="abcdefghijklmnopqrstuvwxyz";
		
		char[] passChar=pass.toCharArray();
		String[] p=new String[pass.length()];		
		for(int i=0;i<pass.length();i++) {
			p[i]=Character.toString(passChar[i]);
		}
		
		if(!pass.isEmpty()) {
			emptycheck=true;
		}
		
		for(int i=0;i<pass.length();i++) {
				if(special.contains(p[i])) {
					specialcheck= true;
				}
				if(num.contains(p[i])) {
					numcheck= true;
				}
				if(capital.contains(p[i])) {
					capitalcheck= true;
				}
				if(small.contains(p[i])) {
					smallcheck= true;
				}
			}
		
		if(smallcheck && capitalcheck && numcheck && specialcheck && emptycheck) {
			return true;
		}	
		return false;
		
	}
	
	static public boolean Passwordlength(String pass) {
		if(pass.length()>=8) {
			return true;
		}
		return false;
	}
	
	static public boolean Passwordmatch(String pass,String confirm) {
		if(pass.equals(confirm)) {
			return true;
		}
		return false;
	}

	
	static public boolean Namelength(String name) {
		if(name.length()<37 && name.length()>2) {
			return true;
		}
		return false;
	}
	
	static public boolean cniclength(String cnic) {
		if(cnic.length()==13) {
			return true;
		}
		return false;
	}
	
	static public boolean Passportlength(String passport) {
		if(passport.length()==9) {
			return true;
		}
		return false;
	}
	
	static boolean cnicavailable(ArrayList<User> user,String cnic) {
		for(User x: user) {
			if(x.CNIC.equalsIgnoreCase(cnic)) {
				return false;
			}
		}
		return true;
	}
	
	static boolean cnicFormat(String cnic){
		try {
			long temp=Long.parseLong(cnic);
			return true;
		}catch(Exception E) {
			return false;
		}
	}
	
	static boolean passportFormat(String passport){
		try {
			long temp=Long.parseLong(passport);
			return true;
		}catch(Exception E) {
			return false;
		}
	}
	
	static boolean NameFormatFun(String Name) {

		String specialCharactersString = "!@#$%&*()'+,-./:;<=>?[]^_`{|}0123456789";
		char[] NameChar=Name.toCharArray();
		String[] n=new String[Name.length()];		
		for(int i=0;i<Name.length();i++) {
			n[i]=Character.toString(NameChar[i]);
		}
		
		for(int i=0;i<Name.length();i++) {
				if(specialCharactersString.contains(n[i])) {
					return false;
				}
			}
		
		if(Name.isEmpty()) {
			return false;
		}
		
		return true;
	}
	
	static boolean usernameAvailable(ArrayList<User> user,String UserN) {
		for(User x: user) {
			if(x.userName.equalsIgnoreCase(UserN)) {
				return false;
			}
		}
		return true;
	}
	

	
	
	
}
