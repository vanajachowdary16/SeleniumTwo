package java.Strings;

public class ReverseString {
	  public static void main(String[] args) {
	        System.out.println("Working with string");
	    
	        
	        String s = "Iam learning Strings Concept in java";
	        String[] words = s.split(" ");
	        StringBuilder reverse = new StringBuilder();
	        for(int i=words.length-1; i>=0; i--)
	        {
	            reverse.append(words[i]).append(" ");
	        }
	         System.out.println(reverse.toString().trim());
	   
	}

}
