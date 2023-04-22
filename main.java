import java.util.Scanner;

class main {
    public static void main(String[] args) {

        
        Scanner input = new Scanner(System.in);

        BinaryTree tree = new BinaryTree();
        
        System.out.println("How many nodes?");
        int readInt = input.nextInt();

        for(int i = 0; i < readInt; i++){
            //System.out.println(i);
            System.out.println("Set value:");
            int readValue = input.nextInt();
            input.nextLine();
            
            System.out.println("Set string:");
            String readLine = input.nextLine();
            
            tree.addNode(readValue, readLine);

            
            
        }

        
        

        /*  
        tree.addNode(50, "key");
        tree.addNode(25, "lock");
        tree.addNode(15, "chair");
        tree.addNode(30, "door");
        tree.addNode(75, "fence");
        tree.addNode(85, "gate"); 
            */
        
        

        System.out.println("\n--------------------------\n");
        System.out.println("In Order Traversal: \n");
        tree.inOrderTraversal(tree.root);

        System.out.println("\nPre Order Traversal: \n");
        tree.preOrderTraversal(tree.root);
        System.out.println("\nPost Order Traversal: \n");
        tree.postOrderTraversal(tree.root);
        
        System.out.println("\n" + tree.minMaxValues(tree.root)); 


        System.out.println("\nSearch for # value:");
        readInt = input.nextInt();
        

        System.out.println("\n" + tree.findNode(readInt));

        

        

            
    }  
}


