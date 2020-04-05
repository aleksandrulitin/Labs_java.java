public class lab_addition
{
    public static void main(String[] args)
    {
        

        char c1 = 'A';
        char c2 = 'B';
        
        int unicodeValueA = c1;
        System.out.println ("Unicode value of " + c1 + ": " + unicodeValueA);
        int unicodeValueB = c2;
        System.out.println ("Unicode value of " + c2 + ": " + unicodeValueB);
           
        if (c1 == c2) 
        {
            System.out.println(c1 + " is the same as " + c2);
        }
        else if (c1 < c2) 
        {
            System.out.println(c1 + " comes before " + c2);
        }
        else 
        {
            System.out.println(c1 + " comes after " + c2);
        }


     
        String s = "a" + "bc";
        String t = "ab" + "c";
        System.out.println(s == t);

      
     
        String s1 = "ACTA";            
        String s2 = new String("ACTA");          
        
      
        if (s1 == s2) {   
            System.out.println(s1 + " is the same as " + s2);
        }
        else {
            System.out.println(s1 + " is different than " + s2);
        }
        
        System.out.println ("Actual: " + s1.equals(s2));    
        System.out.println ("Expected: true. " + s1 + " has the same data as " + s2); 
            
        String s3 = "ACTG";                     
        String s4 = "ACTG";
        
        if (s3.equals(s4)) {
            System.out.println(s3 + " is the same as " + s4);
        }
        else {
            System.out.println(s3 + " is different than " + s4);
        }

      

        String s5 = "Betty";
        String s6 = "Abby";
            
        if (s5.compareTo(s6) == 0) {
            System.out.println(s5 + " and " + s6 + " are the same.");
        }
        else {
            if (s5.compareTo(s6) < 0) {
                   System.out.println(s5 + " is less than " + s6);
            }
            else { 
                   
                   System.out.println(s5 + " is greater than " + s6);
            }
        }
    } 

} 