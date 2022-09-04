import java.util.Scanner;

public class Tester {
	public static BinarySearchTree<?> new_tree = new BinarySearchTree<>();
	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		buildSearchTree();
        new_tree.inOrder();
		try {
			System.out.println("\n Minimum is: " + new_tree.smallest());
		} catch (Exception e) {
			e.printStackTrace();
		}

        new_tree.print();
		deleteDemo();
		System.out.println("Done....");
	}

	public static void deleteDemo() {
		int num;
		System.out.println("-- Delete nodes --");
		do {
			System.out.print("type number (-1 to finish) --> ");
			num = input.nextInt();
			if (num == -1)
				break;
            new_tree.delete(num);
			System.out.print("\nRemoving " + num + ":\n ");
            new_tree.print();
		} while (true);
	}

	public static void buildSearchTree() {
		int num;
		System.out.println("-- Build Search Tree --");
		do {
			System.out.print("type number (-1 to finish) --> ");
			num = input.nextInt();
			if (num != -1)
                new_tree.add(num);
		} while (num != -1);
	}
}
