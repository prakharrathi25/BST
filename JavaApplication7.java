import javax.swing.*;
//import javax.*;
import java.awt.*;
import java.awt.Color;
import java.awt.Graphics.*;
import java.awt.event.*;
import javax.swing.UIManager;


import java.awt.image.BufferedImage;
public class JavaApplication7 extends JFrame {
    
    int arrayVertex[][]=new int[10][2];
int arrayLine[][] = new int [10][4];
int vertexCount,lineCount;
int values[] = new int[10];
int sizeAble=200;
    
    
    JTextField field = new JTextField();
    JTextField field2 = new JTextField();
    JButton button = new JButton("insert");
    JButton button2 = new JButton("delete");
    Node nodeMain= null;
    int k=0;
    JavaApplication7(){
        
        setLayout(null);
       
   
    add(button);
    add(field);
    add(button2);
    add(field2);
    button.setBounds(300, 0, 60, 30);
    field.setBounds(350, 0 , 120 , 30);
    field2.setBounds(500, 0, 120, 30);
    button2.setBounds(650, 0, 60, 30);
    button.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
    int a=Integer.parseInt(field.getText());
    if(nodeMain==null)
        nodeMain=new Node(a);
    else
    {
        insertNode(a,nodeMain);
    for(int i=0;i<10;++i)
        for(int j=0;j<2;++j)
            arrayVertex[i][j]=0;
    for(int i=0;i<10;++i)
        for(int j=0;j<4;++j)
            arrayLine[i][j]=0;
    vertexCount=0;lineCount=0;
    }
    preOrder(nodeMain,200,100);
    
    
    repaint();
    
    
    }
    
    });
    
    button2.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
    int a= Integer.parseInt(field2.getText());
   
    for(int i=0;i<10;++i)
        for(int j=0;j<2;++j)
            arrayVertex[i][j]=0;
    for(int i=0;i<10;++i)
        for(int j=0;j<4;++j)
            arrayLine[i][j]=0;
    vertexCount=0;lineCount=0;
    
    
    deleteRec(nodeMain,a);
    preOrder(nodeMain,200,100);
    repaint();
    
    }
    });
    
    }
    
    
    
    
    Node deleteRec(Node nodeMain, int value) 
    { 
        /* Base Case: If the tree is empty */
        if (nodeMain == null)  return nodeMain; 
  
        /* Otherwise, recur down the tree */
        if (value < nodeMain.value) 
            nodeMain.left = deleteRec(nodeMain.left, value); 
        else if (value > nodeMain.value) 
            nodeMain.right = deleteRec(nodeMain.right, value); 
  
        // if value is same as nodeMain's value, then This is the node 
        // to be deleted 
        else
        { 
            // node with only one child or no child 
            if (nodeMain.left == null) 
                return nodeMain.right; 
            else if (nodeMain.right == null) 
                return nodeMain.left; 
  
            // node with two children: Get the inorder successor (smallest 
            // in the right subtree) 
            nodeMain.value = minValue(nodeMain.right); 
  
            // Delete the inorder successor 
            nodeMain.right = deleteRec(nodeMain.right, nodeMain.value); 
        } 
  
        return nodeMain; 
    } 
  
    int minValue(Node nodeMain) 
    { 
        int minv = nodeMain.value; 
        while (nodeMain.left != null) 
        { 
            minv = nodeMain.left.value; 
            nodeMain = nodeMain.left; 
        } 
        return minv; 
    } 
    
    
    
    
    
   public void paint(Graphics g) {
      
       super.paint(g);
       Image img = createImageWithText();
      g.drawImage(img, 20,120,this);
   }
  
     
     
      private Image createImageWithText() {
      BufferedImage bufferedImage = new BufferedImage(700,700,BufferedImage.TYPE_INT_RGB);
      Graphics g = bufferedImage.getGraphics();
       g.fillRect(0, 0, bufferedImage.getWidth(), bufferedImage.getHeight());
       g.setColor(Color.white);
      for(int i=0;i<10;++i){
          if(arrayVertex[i][0]==0)
          break;
          String a= String.valueOf(values[i]);
    System.out.println(values[i]);
          g.setColor(Color.yellow.darker().darker());
      g.drawString(a,arrayVertex[i][0]+10, arrayVertex[i][1]+18);
      g.setColor(Color.green.darker().darker());
      g.drawOval(arrayVertex[i][0], arrayVertex[i][1], 30, 30);
      g.setColor(Color.black);
      
      g.drawLine(arrayLine[i][0]+10, arrayLine[i][1]+18, arrayLine[i][2]+10, arrayLine[i][3]+18);
      g.setColor(Color.yellow.darker().darker());
      
     
     
      }
      
     
      
      return bufferedImage;
   }
      
      
           public void insertNode(int value,Node nodeMain){
Node newNode= new Node(value);
if(nodeMain.value>newNode.value && nodeMain.left!=null){
insertNode(newNode.value,nodeMain.left);
}

else if(nodeMain.value<newNode.value && nodeMain.right!=null){
insertNode(newNode.value,nodeMain.right);
}

else if(nodeMain.left==null && nodeMain.value>newNode.value)
{ nodeMain.left=newNode;



}
else if(nodeMain.right==null&& nodeMain.value<newNode.value)
    nodeMain.right=newNode;
}
      
          
           
           
           
           void preOrder(Node nodeMain,int left,int down){
    arrayVertex[vertexCount][0]=left;
    arrayVertex[vertexCount][1]=down;
    values[vertexCount]=nodeMain.value;
    
    ++vertexCount;
    
if(nodeMain.left!=null){
     arrayLine[lineCount][0]=left;
    arrayLine[lineCount][1]=down;
    
    if(left==200&& down==100)
    {
     arrayLine[lineCount][2]=left-100;
    arrayLine[lineCount][3]=down+50;
    ++lineCount;
    preOrder(nodeMain.left,left-100,down+50);
    }
    else
    {
    arrayLine[lineCount][2]=left-30;
    arrayLine[lineCount][3]=down+50;
    ++lineCount;
    preOrder(nodeMain.left,left-30,down+50);
    }
    
    
    
    

}
if(nodeMain.right!=null){
        arrayLine[lineCount][0]=left;
    arrayLine[lineCount][1]=down;
    
    
   if(left==200&& down==100)
    {
     arrayLine[lineCount][2]=left+100;
    arrayLine[lineCount][3]=down+50;
    ++lineCount;
    preOrder(nodeMain.right,left+100,down+50);
    }
    else
    {
    arrayLine[lineCount][2]=left+30;
    arrayLine[lineCount][3]=down+50;
    ++lineCount;
    preOrder(nodeMain.right,left+30,down+50);
    }


}
}
     
     
class Node{
Node left=null;
Node right=null;
int value;
Node(int val){
this.value=val;
}
}
      
      
      
      
      public static void main(String[] args){
          
          JFrame frame= new JavaApplication7();
          frame.setSize(1000, 1000);
          frame.setVisible(true);
          
      }
    
    
} 