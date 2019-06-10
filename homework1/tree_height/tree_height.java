import java.util.*;
import java.io.*;
import java.util.Queue;
import java.util.LinkedList;

public class tree_height {
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


	public class TreeHeight {
		int n;
		int parent[];
		List<Integer>[] children;
		
		void read() throws IOException {
			FastScanner in = new FastScanner();
			n = in.nextInt();
			parent = new int[n];
			children = new List[n];
			for (int i = 0; i < n; i++) {
				parent[i] = in.nextInt();
				children[i] = new ArrayList<>();
			}
		}
		int root(){
			int root = 0;
			for(int i = 0; i < parent.length; i++) {
				if(parent[i] == -1) {
					root = i;
					break;
				}
			}
			return root;
		}
		int lastNode(int root){
			Queue<Integer> node = new LinkedList<>();
			node.add(root);
			int tail = -1;
			while(node.size() != 0){
				tail = node.poll();
				node.addAll(getChildren(tail));
			}
			return tail;
		}
		void preProcess(){
			for(int i = 0; i < parent.length; i++){
				if(parent[i] != -1) {
					children[parent[i]].add(i);
				}
			}
		}
		List<Integer> getChildren(int node){
			return children[node];
		}
		int nodeHeight(int node){
			int height = 1;
			int temp = node;
			while(parent[temp] != -1){
				temp = parent[temp];
				height++;
			}
			return height;
		}
		int computeHeight() {
                        // Replace this code with a faster implementation
			/*
			int maxHeight = 0;

			for (int vertex = 0; vertex < n; vertex++) {
				int height = 0;
				for (int i = vertex; i != -1; i = parent[i])
					height++;
				maxHeight = Math.max(maxHeight, height);
			}
			return maxHeight;
			 */
			preProcess();
			return nodeHeight(lastNode(root()));
		}
	}

	static public void main(String[] args) throws IOException {
            new Thread(null, new Runnable() {
                    public void run() {
                        try {
                            new tree_height().run();
                        } catch (IOException e) {
                        }
                    }
                }, "1", 1 << 26).start();
	}
	public void run() throws IOException {
		TreeHeight tree = new TreeHeight();
		tree.read();
		System.out.println(tree.computeHeight());
	}
}
