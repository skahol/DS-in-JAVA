import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class parenChecker {
    public static boolean parenthesisChecker(String str){
        List<Character> al = new ArrayList();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i) == '{' || str.charAt(i) == '(' || str.charAt(i)=='['){
                al.add(str.charAt(i));
            }
            else if(str.charAt(i) == '}'){
                if(al.size()>0 && al.get(al.size()-1) == '{') {
                    al.remove(al.size()-1);
                }
                else{
                    return false;
                }
            }
            else if( str.charAt(i) == ')'){
                if((al.size()>0 && al.get(al.size()-1) == '(')) {
                    al.remove(al.size()-1);
                }
                else{
                    return false;
                }
            }
            else if( str.charAt(i) == ']'){
                if((al.size()>0 && al.get(al.size()-1) == '[')) {
                    al.remove(al.size()-1);
                }
                else{
                    return false;
                }
            }
        }
        if(al.size() != 0)
            return false;
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        boolean flag = parenthesisChecker(str);
        if(flag == true){
            System.out.println("valid");
        }
        else
            System.out.println("invalid");
    }
}
