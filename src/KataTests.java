import java.util.HashMap;

public class KataTests {

	public static void main(String[] args) {
		System.out.println(findEvenIndex(new int[] {4, 5, 6, 7, 8, 9, 10, 9, 8, 7, 6, 5, 4}));
	}
	
	public static int findEvenIndex(int[] arr) {
	    if (arr.length == 0)
	      return 0;
	      
	    for (int i = 0; i < arr.length; i++) {
	      int leftSum = 0;
	      int rightSum = 0;
	      
	      for (int j = 0; j < i; j++) {
	        leftSum += arr[j];
	      }
	      
	      for (int j = i+1; j < arr.length; j++) {
	        rightSum += arr[j];
	      }
	      
	      if (leftSum == rightSum)
	        return i;
	    }
	    
	    return -1;
	  }
	
	public static String encode(String word){
		  
		HashMap<Character, Integer> charMap = new HashMap<>();
	    char[] chars = word.toLowerCase().toCharArray();
	    
	    for (char c : word.toCharArray()) {
	      if (charMap.containsKey(c)) {
	        int val = charMap.get(c) + 1;
	        charMap.replace(c, val);
	      } else {
	        charMap.put(c, 1);
	      }
	    }
	    
	    String out = "";
	    for (char c : chars) {
	      if (charMap.get(c) == 1)
	        out += "(";
	      else
	        out += ")";
	    }
	    
	    return out;
	  }
	
	public static void maskify(String str) {
		//throw new UnsupportedOperationException("Unimplemented");
		if (str.length() <= 4) {
			System.out.println(str);
			return;
		}
		
		int len = str.substring(0, str.length()-4).length();
		String s = "";
		for (int i = 0; i < len; i++)  {
			s += "#";
		}
		
		System.out.println(s += str.substring(len, str.length()));
		
	}
	
	public static String encrypt(final String text, final int n) {
	    if (text == null || n <= 0 || text.equals(""))
	        return text;
	    
	    String newText = text;
	    int len = newText.length();
	    for (int i = 0; i < n; i++) {
	    
	        String first = "";
	        String second = "";
	        char[] txt = newText.toCharArray();
	        
	        for (int s = 0; s < len; s++) {
	            if (s % 2 == 0)
	                second += txt[s];
	            else
	                first += txt[s];
	        }
	        
	        newText = first + second;
	    }
	    
	    return newText;   
	  }
	
	public static String decrypt(final String encryptedText, final int n) {
	    if (encryptedText == null || n <= 0 || encryptedText.equals(""))
	        return encryptedText;
	    
	    String text = encryptedText;
	    int lastIndex = text.length() / 2;
	    
	    for (int i = 0; i < n; i++) {
	        char[] first = text.substring(0, lastIndex).toCharArray();
	        char[] second = text.substring(lastIndex, text.length()).toCharArray();
	        
	        String out = "";
	        int s = 0;
	        while (s < second.length) {
	            out += second[s];
	            
	            if (s < first.length)
	              out += first[s];
	            
	            s++;
	        }
	        
	        text = out;
	    }
	    
	    return text;
	  }

}
