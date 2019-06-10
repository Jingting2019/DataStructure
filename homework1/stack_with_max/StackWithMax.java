import java.util.*;
import java.io.*;
class Node {
    Node(int value, int curMax){
        this.value = value;
        this.curMax = curMax;
    }
    int value;
    int curMax;
}

public class StackWithMax {
    class FastScanner {
        StringTokenizer tok = new StringTokenizer("");
        BufferedReader in;

        FastScanner() {
            in = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws IOException {
            while (!tok.hasMoreElements())
                tok = new StringTokenizer(in.readLine());
            return tok.nextToken();
        }
        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }

    public void solve() throws IOException {
        FastScanner scanner = new FastScanner();
        int queries = scanner.nextInt();
        Stack<Node> stack = new Stack<Node>();

        for (int qi = 0; qi < queries; ++qi) {
            String operation = scanner.next();
            if ("push".equals(operation)) {
                int value = scanner.nextInt();
                int curMax;
                if(stack.size() == 0) {
                    curMax = 0;
                }
                else {
                    curMax = stack.peek().curMax;
                }
                if(value > curMax) {
                    curMax = value;
                }
                Node element = new Node(value, curMax);
                stack.push(element);
            } else if ("pop".equals(operation)) {
                stack.pop();

            } else if ("max".equals(operation)) {
                System.out.println(stack.peek().curMax);
            }
        }
    }

    static public void main(String[] args) throws IOException {
        new StackWithMax().solve();
    }
}
