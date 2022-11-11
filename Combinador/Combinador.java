public class Combinador {
	
	public static String combinador(String s1, String s2) {
        StringBuilder result = new StringBuilder();
 

        for (int i = 0; i < s1.length() || i < s2.length(); i++) {
 
            if (i < s1.length())
                result.append(s1.charAt(i));
 

            if (i < s2.length())
                result.append(s2.charAt(i));
        }
 
        return result.toString();
		
	}

	public static void main(String[] args) {
		
		String entrada = MyIO.readLine();

		while(!entrada.trim().equals("FIM") && (entrada != null || entrada != "")) {
			String str1 = entrada.split(" ")[0];
			String str2 = entrada.split(" ")[1];
			MyIO.println(combinador(str1, str2));
			entrada = MyIO.readLine();
		}
	}

}
