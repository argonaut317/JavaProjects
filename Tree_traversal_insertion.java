import java.io.*;
import java.util.*;
 class Node{

     int data;
     Node left, right;

     public Node(int value){
         data  = value;
         left = null;
         right = null;

     }
    

}

class BinaryTree{

    Node root;

    BinaryTree(){

        root = null;
    }

    void insertion(int value){

        //initialize the queue
        Queue<Node> Q = new LinkedList<>();
        Node temp;
        Node newNode = new Node(value);
        //newNode.left = newNode.right =  null;

        if(root==null){
            root =  new Node(value);
            return;
        }
         Q.add(root);
        while(!Q.isEmpty()){

            temp = Q.peek();
            Q.remove();
            //System.out.print(temp.data);

            if(temp.left!=null){
                Q.add(temp.left);
            }
            else{
                temp.left = newNode;
                break;

            }

          

            if(temp.right!=null){
               Q.add(temp.right);

            }
            else{
                temp.right = newNode;
                break ;
            }
           


        }

    }

    void printPreOrder(Node root){

        if(root==null){
            return; 
        }

        System.out.print(root.data + " ");
        printPreOrder(root.left);
        printPreOrder(root.right);

    }


    void printPreOrderNonRecursive(Node root){

      
        if(root==null){
            return;
        }

        Stack<Node> Stk = new Stack<Node>();

       

        while(true){

            while(root!=null){
                System.out.print(" "+root.data);
                Stk.push(root);
                root = root.left;



            }

            if(Stk.isEmpty()){
                break;
            }

            root  = Stk.pop();
            root = root.right;

            
            



        }





    }


    void printInorderNonrecursion(Node root){

        Stack<Node> Stk = new Stack<Node>();

        while(true){

            while(root!=null){
                Stk.push(root);
                root = root.left;
            }

            if(Stk.isEmpty()){
                break;
            }

            root = Stk.pop();
            System.out.print(" "+ root.data);
            root = root.right;



        }



    }

    void printPostOrderNonRecursion(Node root){

        Stack<Node> Stk = new Stack<Node>();
        Node prev = null;

        while(true){


            while(root!=null){
                Stk.push(root);
                root = root.left;
                
            }

        if(Stk.isEmpty()){
            break;
        }

        
        root = Stk.peek();
        
        
        if(root.right==null || root.right==prev){
            System.out.print(" "+ root.data);
            Stk.pop();
            prev = root;
            root = null;
        }
        else{
            root = root.right;
        }




        }



    }


    void printInOrder(Node root){

        if(root==null){
            return;
        }

        printInOrder(root.left);
        System.out.print(root.data+" ");
        printInOrder(root.right);
    }


    void printPostOrder(Node root){
        if(root==null){
            return;
        }

        printPostOrder(root.left);
        printPostOrder(root.right);
        System.out.print(root.data+" ");
    }


    void levelOrderTraversal(Node root){

        if(root==null){
            return;
        }

            Queue<Node> Q = new LinkedList<>();
            Q.add(root);

            while(!Q.isEmpty()){

                root = Q.peek();
                Q.remove();
                System.out.print(" "+ root.data);

                if(root.left!=null){
                    Q.add(root.left);
                }
                if(root.right!=null){
                    Q.add(root.right);
                }


            }
    }

}

public class Tree_traversal_insertion{

public static void main(String args[]){

ArrayList<Integer> Arr = new ArrayList<Integer>(Arrays.asList(7,3,1,6,9,2,42,11,57));

 BinaryTree Tree = new BinaryTree();
       for(int i=0;i<Arr.size();i++){
           Tree.insertion(Arr.get(i));
       }
       Tree.printPreOrder(Tree.root); 
       System.out.println();
       Tree.printPreOrderNonRecursive(Tree.root);
      System.out.println();
      Tree.printPostOrderNonRecursion(Tree.root);
       System.out.println();
       Tree.printPostOrder(Tree.root);
       System.out.println();
       Tree.printInOrder(Tree.root);
        System.out.println();
       Tree.printInorderNonrecursion(Tree.root);
       System.out.println();
       Tree.levelOrderTraversal(Tree.root);

       

}




}