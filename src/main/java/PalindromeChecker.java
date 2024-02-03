import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class PalindromeChecker {
public void tester()
{
  // String lines[] = loadStrings("palindromes.txt");
  String[] lines = new String[6]; 
    try{
        File myFile = new File("palindromes.txt");
        Scanner myReader = new Scanner(myFile);
        int counter = 0;
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            lines[counter] = data;
            counter++;
        }
        myReader.close();
    }
    catch (FileNotFoundException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
    }
  String []newLines=new String[lines.length];
  String ben="";
  for(int i=0;i<lines.length;i++){ 
    ben=noCapitals(lines[i]);
    ben=noSpaces(ben);
    ben=onlyLetters(ben);
    newLines[i]=ben;
  }
  System.out.println("there are " + lines.length + " lines");
  for (int i=0; i < lines.length; i++) 
  {
    if(palindrome(lines[i])==true)
    {
      System.out.println(lines[i] + " IS a palindrome.");
    }
    else
    {
      System.out.println(lines[i] + " is NOT a palindrome.");
    }
  }
}
public  boolean palindrome(String word)
{
  String backwards=reverse(word);
  if(backwards.equals(word)){
    return true;
  }else
  return false;
}
public String reverse(String word)
{
    String s ="";
  if(word.length()>1){
  for(int i=word.length();i>0;i--){
    s=s+word.substring(i-1,i);
  }
  return s;
  }
  return word;
}
public String noCapitals(String sWord){
return sWord.toLowerCase();
}
public String noSpaces(String sWord){
  String s="";
  for(int i=0;i<sWord.length();i++){
    if(sWord.substring(i,i+1).equals(" ")){
      s=s+"";
    }else{
      s=s+sWord.substring(i,i+1);
    }
  }
  return s;
}
public String onlyLetters(String sString){
  String s="";
  for(int i=0;i<sString.length();i++){
    if(Character.isLetter(sString.charAt(i))==true){
      s=s+sString.substring(i,i+1);
    }
    s=s+"";
  }
  return s;
}
}
