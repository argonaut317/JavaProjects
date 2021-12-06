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


    int MaximumElement(Node root){
        int max = Integer.MIN_VALUE;
        int rgt = Integer.MIN_VALUE ;
        int lft = Integer.MIN_VALUE;

        int root_val = root.data;

        if(root.left!=null){
           lft = MaximumElement(root.left);
        }
        if(root.right!=null){
           rgt =  MaximumElement(root.right);
        }
        if(lft>rgt){
            max = lft;
        }
        if(rgt>=lft){
            max = rgt;
        }
        if(root_val>max){
            max = root_val;
        }

        return max;


    }

}


public class FindMaximumElementBinaryTree{

public static void main(String args[]){

ArrayList<Integer> Arr = new ArrayList<Integer>(Arrays.asList(7,3,1,6,9,2,42,11,57));

 BinaryTree Tree = new BinaryTree();
       for(int i=0;i<Arr.size();i++){
           Tree.insertion(Arr.get(i));
       }
      System.out.print( Tree.MaximumElement(Tree.root));

       

}




}