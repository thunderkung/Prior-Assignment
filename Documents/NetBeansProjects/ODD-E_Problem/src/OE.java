
import java.util.Scanner;
import javax.xml.transform.Source;


public class OE {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] A = new int[3];
        int c = 1;
        while(c<=3){
            int in = scan.nextByte();
            A[c] = in;
            c++;
        }
        
    }
    String funcA(int[] A){
        String temp,A_result = "";
        for(int i = 1;i<=3;i++){
            if(A[i] % 2 == 0){
                temp = A_result + "Even" + A[i];
            }else{
                temp = A_result + "Odd" + A[i];
            }
        }
        return A_result;
    }
}
