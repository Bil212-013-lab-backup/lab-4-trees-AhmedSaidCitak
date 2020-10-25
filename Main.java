import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Tree tree = new Tree();
		Scanner keyboard = new Scanner (System.in);
		int length = Integer.parseInt(args[1]);
	
		String input = "";
		int count = 0;						// satir sayisi
		int number;							// bir satirdaki eleman sayisi
		
		while(true) {
			input = keyboard.nextLine();
			number = 0;
			
			if(input.equals("$")) {			
				break;
			}
			
			input = input.replace(" ", "");		
			input = input + "|";
			
			for(int i=0, j=0; i<input.length(); i++) {
				if(input.charAt(i) == '|') {
					Node newNode = new Node(Integer.parseInt(input.substring(j,i)),length);
					tree.addTree(tree.root(),newNode);
					number++;
					int temp = i+1;
					if(temp != input.length())
						j=temp;
				}
					
			}
			
			if(number > Math.pow(length, count)) {
				System.out.println("Tree olusturulamaz.");
				System.exit(0);
			}
			count++;
		}
		
		tree.inOrderTraversal(tree.root());		
		
	}

}
