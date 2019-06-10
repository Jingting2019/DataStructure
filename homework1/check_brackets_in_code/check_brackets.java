import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Stack;
/*
class Bracket {
    Bracket(char type, int position) {
        this.type = type;
        this.position = position;
    }
    boolean Match(char c) {
        if (this.type == '[' && c == ']')
            return true;
        if (this.type == '{' && c == '}')
            return true;
        if (this.type == '(' && c == ')')
            return true;
        return false;
    }
    char type;
    int position;
}
*/

class check_brackets {
    public static boolean Match(char a, char b){
        if (b == '[' && a == ']')
            return true;
        if (b == '{' && a == '}')
            return true;
        if (b == '(' && a == ')')
            return true;
        else return false;
    }
    public static void main(String[] args) throws IOException {
        InputStreamReader input_stream = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input_stream);
        String text = reader.readLine();
        int result = 0;

        Stack<Integer> opening_brackets_stack = new Stack<Integer>();
        for (int position = 0; position < text.length(); ++position) {
            char next = text.charAt(position);

            if (next == '(' || next == '[' || next == '{') {
                // Process opening bracket, write your code here
                opening_brackets_stack.push(position);
            }

            if (next == ')' || next == ']' || next == '}') {
                // Process closing bracket, write your code here
                if(opening_brackets_stack.empty()) {
                    result = 1+ position;
                    break;
                }
                else {
                    if(Match(next, text.charAt(opening_brackets_stack.pop()))) {

                    }
                    else {
                        result = 1 + position;
                        break;
                        }
                }
            }
        }
        // Printing answer, write your code here
        if(result == 0) {
            if(!opening_brackets_stack.empty()){
                result = 1 + opening_brackets_stack.pop();
                System.out.println(result);
            }
            else System.out.println("Success");
        }
        else System.out.println(result);
    }

}
