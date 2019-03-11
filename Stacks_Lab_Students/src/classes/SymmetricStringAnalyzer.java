package classes;

public class SymmetricStringAnalyzer {
	private String s; 
	public SymmetricStringAnalyzer(String s) {
		this.s = s; 
	}
	
	/**
	 * Determines if the string s is symmetric
	 * @return true if it is; false, otherwise. 
	 */
	public boolean isValidContent() {  
		SLLStack<Character> stack = new SLLStack<Character>();
		if(s.length()%2!=0) return false;
		for (int i=0; i < s.length(); i++) { 
	        char c = s.charAt(i); 
	        if (Character.isLetter(c))
	           if (Character.isUpperCase(c))
	              stack.push(c);
	           else if (!Character.isLetter(c))
	                 return false; 
	               else {
	                 char t = stack.top(); 
	                 if (t == Character.toUpperCase(c))
	                    stack.pop();  
	                 else 
	                    return false; 
	                }
	            else 
	                return false; 
	    } 
	    return true; 
	}


	
	public String toString() { 
		return s; 
	}

//	public String parenthesizedExpression() throws StringIsNotSymmetricException {
//		if(!isValidContent()) 
//			throw new StringIsNotSymmetricException("The string is not symetric");
//		String str ="";
//		SLLStack<String> stack = new SLLStack<String>();
//		for (int i=0; i < s.length(); i++) { 
//	        char c = s.charAt(i); 
//	        if (Character.isLetter(c))
//	           if (Character.isUpperCase(c)) { stack.push("<"+c+" "); str += stack.top();}
//               else {
//            	   char t = stack.top().charAt(1);
//            	   if(t=='>')t = stack.top().charAt(0);
//                 if (t == Character.toUpperCase(c)) {
//                	 str += stack.top();
//                	 stack.pop(); 
//                	 
//                	 }  
//           		}
//	        
//		}
//		return str;
//	}
	public String parenthesizedExpression() throws StringIsNotSymmetricException {
		if(!isValidContent()) 
			throw new StringIsNotSymmetricException("The string is not symetric");
		String str ="";
		SLLStack<String> stack = new SLLStack<String>();
		for (int i=0; i < s.length(); i++) { 
	        char c = s.charAt(i); 
	        if (Character.isLetter(c))
	           if (Character.isUpperCase(c)) { stack.push("<"+c+" "); str += stack.top();}
               else {
            	   char t = stack.top().charAt(1);
            	   if(t=='>')t = stack.top().charAt(0);
                 if (t == Character.toUpperCase(c)) {
                	 str += c+"> ";
                	 stack.pop(); 
                	 
                	 }  
           		}
	        
		}
		return str;
	}
}
