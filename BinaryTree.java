// Binary trees work best with random data because it allows the tree populate itself better. Organized data inc

public class BinaryTree {
    
    Node root;

    public void addNode(int key, String name) {

        Node newNode = new Node(key, name);

        if (root == null) {
            root = newNode;
        }
        else {
            Node focusNode = root;

            Node parent;

            while (true) {

                parent = focusNode;

                if( key < focusNode.key) {

                    focusNode = focusNode.leftChild;

                    if(focusNode == null) {
                        parent.leftChild = newNode;
                        return;
                    }
                }
                else {
                    focusNode = focusNode.rightChild;

                    if(focusNode == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    public String findNode(int key) {
        Node focusNode = root;

        while(focusNode.key != key) {
            if(key < focusNode.key) {
                focusNode = focusNode.leftChild;
            }

            else {
                focusNode = focusNode.rightChild;
            }

            if(focusNode == null) {
                return null;
            }
        }
        return "Found Node: " + focusNode.key + " String: " + focusNode.name;
    }


    public boolean remove(int key) {
        Node focusNode = root;
        Node parent = root;

        boolean isLeftChild = true;

        while(focusNode.key != key) {
            parent = focusNode;

            if(key < focusNode.key) {
                System.out.println("focusNode = " + focusNode.key);
                isLeftChild = true;
                focusNode = focusNode.leftChild;
            }

            else {
                System.out.println("focusNode = " + focusNode.key);
                isLeftChild = false;
                focusNode = focusNode.rightChild;
            }

            if(focusNode == null) {
                return false;
            }

            if(focusNode.leftChild == null && focusNode.rightChild == null) {

                if(focusNode == root) {
                    root = null;
                }
                else if(isLeftChild) {
                    parent.leftChild = null;
                }
    
                else {
                    parent.rightChild = null;
                }
            }
    
            else if(focusNode.rightChild == null) {

                if(focusNode == root) {
                    root = focusNode.leftChild;
                }
    
                else if(isLeftChild) {
                    parent.leftChild = focusNode.leftChild;
                }
    
                else {
                    parent.rightChild = focusNode.leftChild;
                }
            }

            else if(focusNode.leftChild == null) {
                if(focusNode == root) {
                    root = focusNode.rightChild;
                }

                else if (isLeftChild) {
                    parent.leftChild = focusNode.rightChild;
                }

                else {
                    parent.rightChild = focusNode.leftChild;
                }
            }

            else {
                Node replacementNode = getReplacementNode(focusNode);

                if(focusNode == root) {
                    root = replacementNode;
                }

                else if(isLeftChild) {
                    parent.leftChild = replacementNode;
                }

                else {
                    parent.rightChild = replacementNode;   
                }
                replacementNode.leftChild = focusNode.leftChild;
            }

            
        }
        return true;
    }
    public Node getReplacementNode(Node replacedNode){
            
        Node replacementParent = replacedNode;
        Node replacement = replacedNode;

    
        Node focusNode = replacedNode.rightChild;

        while(focusNode != null) {
            replacementParent = replacement;

            replacement = focusNode;

            focusNode = focusNode.leftChild;
        }
        
        if(replacement != replacedNode.rightChild) {
            replacementParent.leftChild = replacement.rightChild;
            replacement.rightChild = replacedNode.rightChild;
        }
        
        return replacement;
    }



    public void inOrderTraversal(Node focusNode) {

        

        if(focusNode != null) {
            inOrderTraversal(focusNode.leftChild);

            System.out.println("Key: " + focusNode.key + " String: " + focusNode.name);

            inOrderTraversal(focusNode.rightChild);
        }
    }

    public void preOrderTraversal(Node focusNode) {
        

        if(focusNode != null) {
            System.out.println("Key: " + focusNode.key + ", String: " + focusNode.name);

            preOrderTraversal(focusNode.leftChild);

            preOrderTraversal(focusNode.rightChild);

            
        }
    }

    public void postOrderTraversal(Node focusNode) {
        if(focusNode != null) {
            

            postOrderTraversal(focusNode.leftChild);

            postOrderTraversal(focusNode.rightChild);

            System.out.println("Key: " + focusNode.key + ", String: " + focusNode.name);

            
        }
    }

    
}




