
import java.util.Scanner;
import javax.xml.transform.Source;


public class OE {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] A = new int[3];
        int c = 1;
            System.out.print("Please input 2 digit numbers : ");
            String in = scan.next();
            int a = Integer.parseInt(String.valueOf(in.charAt(0)));
            int b = Integer.parseInt(String.valueOf(in.charAt(1)));
            A[1] = a;
            A[2] = b;
            c++;
            
            String A_res = funcA(A);
            String B_res = funcB(A_res);
            String C_res = funcC(B_res);
            String D_res = funcD(C_res);
            String E_res = funcE(D_res);
            int F_res = funcF(A_res);
            
        System.out.println("Result of Function A : " + A_res);
        System.out.println("Result of Function B : " + B_res);
        System.out.println("Result of Function C : " + C_res);
        System.out.println("Result of Function D : " + D_res);
        System.out.println("Result of Function E : " + E_res);
        System.out.println("Result of Function F : " + F_res);
        
    }
    static String funcA(int[] A){
        String temp = "",A_result = "";
        for(int i = 1;i<3;i++){
            if(A[i] % 2 == 0){
                A_result = A_result + "Even" + A[i];
            }else{
                A_result = A_result + "Odd" + A[i];
            }
        }
        //System.out.println(A_result);
        return A_result;
    }
    
    static String funcB(String A){
        String b;
        if(A.charAt(0) == 'O'){
            if(A.charAt(4) == 'O'){
                b = "DDO" + A.charAt(3) + "DDO" + A.charAt(7);
            }else{
                b = "DDO" + A.charAt(3) + "NEVE" + A.charAt(8);
            }
        }else{
            if(A.charAt(5) == 'E'){
                b = "NEVE" + A.charAt(4) + "NEVE" + A.charAt(9);
            }else{
                b = "NEVE" + A.charAt(4) + "DDO" + A.charAt(8);
            }
        }
        //System.out.println(b);
        return b;
    }
    
    static String funcC(String B){
        String c = "";
        for(int i = 0;i<B.length();i++){
            if((int)B.charAt(i)>=49 && (int)B.charAt(i)<=57){
                c = c + B.charAt(i);
            }else{
                c = c + String.format("%d",(int)B.charAt(i));
            }
        }
        //System.out.println(c);
        return c;
    }
    
    static String funcD(String C){
        String d;
        if(C.charAt(0) == '6'){
            if(C.charAt(7) == '6'){
                d = "DDO" + C.charAt(6) + "DDO" + C.charAt(13);
            }else{
                d = "DDO" + C.charAt(6) + "NEVE" + C.charAt(15);
            }
        }else{
            if(C.charAt(5) == 'E'){
                d = "NEVE" + C.charAt(10) + "NEVE" + C.charAt(19);
            }else{
                d = "NEVE" + C.charAt(10) + "DDO" + C.charAt(8);
            }
        }
        //System.out.println(d);
        return d;
    }
    
    static String funcE(String D){
        String e;
        if(D.charAt(0) == 'D'){
            if(D.charAt(4) == 'D'){
                e = "Odd" + D.charAt(3) + "Odd" + D.charAt(7);
            }else{
                e = "Odd" + D.charAt(3) + "Even" + D.charAt(8);
            }
        }else{
            if(D.charAt(5) == 'N'){
                e = "Even" + D.charAt(4) + "Even" + D.charAt(9);
            }else{
                e = "Even" + D.charAt(4) + "Odd" + D.charAt(8);
            }
        }
        //System.out.println(e);
        return e;
        
    }
    
    static int funcF(String E){
        int f;
        String F ="";
        if(E.charAt(0) == 'O'){
            if(E.charAt(4) == 'O'){
                F = F + E.charAt(3) + E.charAt(7);
            }else{
                F = F + E.charAt(3) + E.charAt(8);
            }
        }else{
           if(E.charAt(5) == 'E'){
                F = F + E.charAt(4) + E.charAt(9);
            }else{
                F = F + E.charAt(4) + E.charAt(8);
            }
        }
        f = Integer.parseInt(F);
        //System.out.println(f);
        return f;
    }
}
