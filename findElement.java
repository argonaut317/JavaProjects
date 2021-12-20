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


   int FindElement(Node root,int data){

       if(root==null){
           return 0;
       }

       else{
           if(root.data==data){
               return 1;
           }
           else{
               int temp = FindElement(root.left,data);
               if(temp==1){
                   return temp;
               }
               else{
                    return FindElement(root.right,data);

               }

           }
       }
   }

   int FindElementNonRecursion(Node root,int data){

       if(root==null){
           return 0;
       }
       Node temp = null;

        Queue<Node> Q = new LinkedList<>();
        Q.add(root);

        while(!Q.isEmpty()){


            temp = Q.peek();
            Q.remove();

            if(temp.data==data){
                return 1;
            }

            if(temp.left!=null){
                Q.add(temp.left);
            }
            if(temp.right!=null){
                Q.add(temp.right);
            }
        }

        return 0;
   }

}


public class findElement{

public static void main(String args[]){

ArrayList<Integer> Arr = new ArrayList<Integer>(Arrays.asList(7,3,1,6,9,2,42,11,57));

 BinaryTree Tree = new BinaryTree();
       for(int i=0;i<Arr.size();i++){
           Tree.insertion(Arr.get(i));
       }
      System.out.print( Tree.FindElement(Tree.root,0));
      System.out.println();
      System.out.print(Tree.FindElementNonRecursion(Tree.root,57));
     
       

}




}