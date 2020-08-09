import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import javax.swing.*;

public class WithUI extends JFrame{
/**
*
*/
private static final long serialVersionUID = 1L;

JPanel p1,p2,p3,p4;
JTextField ins,del,find;
JButton ins_but,del_but,find_but,print_but;
JLabel bst_heading,ht,v; 

//DrawPanel panel = new DrawPanel();
String p = " ";



class Node{
Node left = null;
Node right = null;
int value;

Node(int val){
this.value = val;
}
}

WithUI(){

//int v_count = 0;

//Creating UI
p1 = new JPanel();
p2 = new JPanel();
p3 = new JPanel();
p4 = new JPanel();
ins = new JTextField(7);
del = new JTextField(7);
find = new JTextField(7);
ins_but = new JButton("Insert");
del_but = new JButton("Delete");
find_but = new JButton("Find");
print_but = new JButton("Print");
bst_heading = new JLabel("Binary Search Tree");
ht = new JLabel("Height of the tree:");
v = new JLabel("Number of vertices:");
Font f1 = new Font("Calibri",Font.BOLD,70);
bst_heading.setFont(f1);
bst_heading.setForeground(Color.yellow);
p1.setBackground(Color.green.darker().darker());
p1.setBounds(0,0,800,100);
p1.add(bst_heading);
p2.setLayout(new FlowLayout(FlowLayout.LEFT));
p2.add(ins); p2.add(ins_but);
p2.add(del); p2.add(del_but);
p2.add(find); p2.add(find_but);
p2.add(print_but);
p2.setBackground(Color.LIGHT_GRAY);
p2.setBounds(0,100,800,50);
p3.add(p1);
p3.add(p2);
p3.setBounds(0,0,800,150);
add(p3);
setLayout(null);
//add(panel);
setFocusable(true);

//Creating main node

Node nodeMain = new Node(15);
//v_count++;
nodeMain.left = null;
nodeMain.right = null;
JLabel mainLabel = new JLabel(String.valueOf(nodeMain.value)); // LABEL1
add(mainLabel);
mainLabel.setBackground(Color.green.darker().darker());
mainLabel.setOpaque(true);
mainLabel.setBounds(400,200,25,25);
mainLabel.setForeground(Color.yellow);

//Insertion

ins_but.addActionListener(new ActionListener() {

public void actionPerformed(ActionEvent e) {

int left = 400;
int down = 200;
int val = Integer.parseInt(ins.getText());

JLabel label = new JLabel(ins.getText());
label.setForeground(Color.yellow);
String s = insertNode(val, nodeMain, left, down);
String[] nums = s.split("\\s+");
add(label);
int[] numsInt = { 400, 200, 400, 200 };
numsInt[0] = Integer.parseInt(nums[0]);
numsInt[1] = Integer.parseInt(nums[1]);
numsInt[2] = Integer.parseInt(nums[2]);
numsInt[3] = Integer.parseInt(nums[3]);
label.setBounds(numsInt[0], numsInt[1], 25, 25);
label.setBackground(Color.green.darker().darker());
label.setOpaque(true);
Graphics g = getGraphics();
g.drawLine(numsInt[2] + 25, numsInt[3] + 55, numsInt[0] + 20, numsInt[1] + 30); // messy part
System.out.println(nums[2] + " " + nums[3] + "     " + nums[0] + " " + nums[1]);
System.out.println(numsInt[0] + " " + numsInt[1] + " " + numsInt[2] + " " + numsInt[3] + " ");
System.out.println();

}

});

}

//Finding height



public static void main(String[] args) {
JFrame frame = new WithUI();
frame.setSize(800, 800);
frame.setVisible(true);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

}

String insertNode(int value, Node nodeMain, int left, int down) {
Node newNode = new Node(value);
if (nodeMain.value > newNode.value && nodeMain.left != null) {
if (left == 400 && down == 200)
insertNode(newNode.value, nodeMain.left, left - 100, down + 60);
else
insertNode(newNode.value, nodeMain.left, left - 30, down + 30);
}

else if (nodeMain.value < newNode.value && nodeMain.right != null) {
if (left == 400 && down == 200)
insertNode(newNode.value, nodeMain.right, left + 100, down + 60);
else
insertNode(newNode.value, nodeMain.right, left + 30, down + 30);
}

else if (nodeMain.left == null && nodeMain.value > newNode.value) {
nodeMain.left = newNode;

if (left == 400 && down == 200)
p = String.valueOf(left - 100) + " " + String.valueOf(down + 60) + " " + String.valueOf(left) + " "
+ String.valueOf(down);
else
p = String.valueOf(left - 30) + " " + String.valueOf(down + 30) + " " + String.valueOf(left) + " "
+ String.valueOf(down);
return p;

} else if (nodeMain.right == null && nodeMain.value < newNode.value) {
nodeMain.right = newNode;

if (left == 400 && down == 200)
p = String.valueOf(left + 100) + " " + String.valueOf(down + 60) + " " + String.valueOf(left) + " "
+ String.valueOf(down);

else
p = String.valueOf(left + 30) + " " + String.valueOf(down + 30) + " " + String.valueOf(left) + " "
+ String.valueOf(down);
return p;

}
return p;

}
}

