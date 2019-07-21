import java.util.Scanner;
import java.util.Stack;

public class Postfix {
    public static int precedence(char a){
        if(a == '-') return 1;
        else if ( a == '+') return 2;
        else if( a=='*' || a=='/') return 3;     // multiply or divide
        else    // ^ of operator
            return 4;
    }
    public static String postfix(String str){
        Stack<String> stack = new Stack<>();
        stack.push("(");        // initialise stack with open brace
        String output = new String() ;
        for(int i=0;i<str.length();i++){
            if( (str.charAt(i)>=65 && str.charAt(i)<=90) || (str.charAt(i)>=97 && str.charAt(i)<=122) || (str.charAt(i)>=48 && str.charAt(i)<=57)) {     //
                output += str.charAt(i);
                System.out.println(output);
            }
            else if(str.charAt(i) == '('){
                stack.push(String.valueOf(str.charAt(i)));
            }
            else if(str.charAt(i) == ')'){
                while(!stack.peek().equals("(")){
                    output += stack.peek();
                    System.out.println(output);
                    stack.pop();
                }
                stack.pop();                                // popping open bracket
                if( stack.isEmpty() ) break;
            }
            else if(str.charAt(i)=='+' || str.charAt(i)=='-' || str.charAt(i)=='*' || str.charAt(i)=='/' || str.charAt(i)=='^' ){     // testcase stack[-,*,+]
                while((!stack.peek().equals("(")) && precedence(stack.peek().charAt(0)) >= precedence(str.charAt(i))) {
                    output = output + stack.peek();
                    stack.pop();
                    System.out.println(output);
                }
                stack.push(String.valueOf(str.charAt(i)));
            }
         }
        return output;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        str += ")";
        str = postfix(str);
        System.out.println(str);
    }
}
