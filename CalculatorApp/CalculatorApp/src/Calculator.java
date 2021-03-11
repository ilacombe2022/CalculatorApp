//Simple Calculator Application
//Created By Isaac Lacombe

//import needed packages
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener{

	JFrame frame;										//Create the frame of the GUI
	JTextField text;									//Add text field to display the numbers chosen
	JButton[] numbers = new JButton[10];							//list of numbers: 0-9
	JButton[] action = new JButton[12];							//list of functions for calculator to use			
	JButton add, sub, mul, div, neg, squ, srt, mod, dec, eql, del, clr; 
	JPanel panel;										//Panels to display option available for input
	
	Font f = new Font("Times New Roman", Font.BOLD, 20);					//Type of font being used
	
	double numOne = 0;													
	double numTwo = 0;									//Initial numbers, result, and operators
	double result = 0;
	char op;
	
	public Calculator(){
		
		frame = new JFrame("Calculator");						//Naming the frame of GUI
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);				//Allows GUI to exit the program
		frame.setSize(450, 580);							//Set the size of GUI
		frame.setLayout(null);											
		
		text = new JTextField();										
		text.setBounds(65, 40, 300, 50);						//Set size of text field
		text.setFont(f);
		text.setEditable(false);							//Prevents user input to be entered in the text field
		
		add = new JButton("+");											
		sub = new JButton("-");											
		mul = new JButton("*");											
		div = new JButton("/");
		dec = new JButton(".");
		eql = new JButton("=");								//All text to be displayed on buttons
		del = new JButton("BSC");
		clr = new JButton("Clear");
		neg = new JButton("(-x)");
		squ = new JButton("x^2");
		srt = new JButton("sqrt(x)");
		mod = new JButton("%");
		
		action[0] = add;
		action[1] = sub;
		action[2] = mul;
		action[3] = div;
		action[4] = neg;
		action[5] = squ;
		action[6] = srt;								//Each operator assigned to an index
		action[7] = mod;
		action[8] = dec;
		action[9] = eql;
		action[10] = del;
		action[11] = clr;
		
		for(int i = 0; i < action.length; i++) {
			action[i].addActionListener(this);							
			action[i].setFont(f);							//Allows operators to function, have certain fonts, and run until the program ends
			action[i].setFocusable(false);
		}
		
		for(int j = 0; j < numbers.length; j++) {
			numbers[j] = new JButton(String.valueOf(j));
			numbers[j].addActionListener(this);
			numbers[j].setFont(f);							//Allows numbers to function, have certain fonts, and run until the program ends
			numbers[j].setFocusable(false);
		}
		
		neg.setBounds(40, 420, 75, 50);
		squ.setBounds(115, 420, 100, 50);								
		srt.setBounds(215, 420, 100, 50);						//Display and set size of button outside of the grid
		mod.setBounds(315, 420, 75, 50);
		
		del.setBounds(65, 475, 150, 50);
		clr.setBounds(215, 475, 150, 50);
		
		panel = new JPanel();
		panel.setBounds(65, 100, 300, 300);						//Set the bound, color, and layout of the grid
		panel.setLayout(new GridLayout(4, 4, 10, 10));
		panel.setBackground(Color.BLACK);
		
		panel.add(numbers[1]);
		panel.add(numbers[2]);
		panel.add(numbers[3]);								//Add buttons on first row of grid
		panel.add(add);
		
		panel.add(numbers[4]);
		panel.add(numbers[5]);
		panel.add(numbers[6]);								//Add buttons on second row of grid
		panel.add(sub);
		
		panel.add(numbers[7]);
		panel.add(numbers[8]);
		panel.add(numbers[9]);								//Add buttons on third row of grid
		panel.add(mul);
		
		panel.add(dec);
		panel.add(numbers[0]);
		panel.add(eql);									//Add buttons on final row of grid
		panel.add(div);
		
		frame.add(panel);
		frame.add(neg);
		frame.add(mod);
		frame.add(squ);
		frame.add(srt);									//Adds panel, text field, and the rest of the buttons onto the frame
		frame.add(del);
		frame.add(clr);
		frame.add(text);
		
		frame.setVisible(true);								//Allows frames, panels, text fields, and buttons to be displayed on GUI
	}
	
	public static void main(String[] args) {
		Calculator c = new Calculator();						//Creates an object of constructor class

	}

	@Override
	public void actionPerformed(ActionEvent a) {						//Used to perform to action the class is implementing
		
		for(int i = 0; i < 10; i++) {
			if(a.getSource() == numbers[i]) {
				String readNum = text.getText().concat(String.valueOf(i));	//Allows numbers to always be pressed with button
				text.setText(readNum);
			}
		}
		
		if(a.getSource() == dec) {
			String readDec = text.getText().concat(String.valueOf("."));		//Allows decimal to always be pressed with button
			text.setText(readDec);
		}
		
		if(a.getSource() == add) {
			numOne = Double.parseDouble(text.getText());
			op = '+';								//Allows add to always be pressed with button
			text.setText("");
		}
		
		if(a.getSource() == sub) {
			numOne = Double.parseDouble(text.getText());
			op = '-';								//Allows sub to always be pressed with button
			text.setText("");
		}
		
		if(a.getSource() == mul) {
			numOne = Double.parseDouble(text.getText());
			op = '*';								//Allows mul to always be pressed with button
			text.setText("");
		}
		
		if(a.getSource() == div) {
			numOne = Double.parseDouble(text.getText());
			op = '/';								//Allows div to always be pressed with button
			text.setText("");
		}
		
		if(a.getSource() == mod) {
			numOne = Double.parseDouble(text.getText());
			op = '%';								//Allows mod to always be pressed with button
			text.setText("");
		}
		
		if(a.getSource() == eql) {
			numTwo = Double.parseDouble(text.getText());
			
			switch(op) {
			case '+':
				result = numOne + numTwo;
				break;
			case '-':
				result = numOne - numTwo;
				break;
			case '*':
				result = numOne * numTwo;					//If the equal button is pressed, it will calculate the result of the two operands
				break;
			case '/':
				result = numOne / numTwo;
				break;
			case '%':
				result = numOne % numTwo;
				break;
			}
			
			text.setText(String.valueOf(result));					//Display the result
			numOne = result;							//Set the result equal to the first number so we can use it again if we wanted
		}
		
		if(a.getSource() == clr) {
			text.setText("");							//Clear the text field
		}
		
		if(a.getSource() == del) {
			String back = text.getText();
			text.setText("");
			
			for(int j = 0; j < back.length() - 1; j++) {				//Clear whatever was added the end of the string and go back 1
				String travBack = text.getText();
				text.setText(travBack + back.charAt(j));
			}
		}
		
		if(a.getSource() == neg) {
			String changeNeg = text.getText();
			double tempNeg = Double.parseDouble(changeNeg);				//Display the number in the text field into negative or positive
			tempNeg *=-1;
			text.setText(String.valueOf(tempNeg));
		}
		
		if(a.getSource() == squ) {
			String changeSqu = text.getText();
			double tempSqu = Double.parseDouble(changeSqu);				//Display the squared the number that you input
			tempSqu *= tempSqu;
			text.setText(String.valueOf(tempSqu));
		}
		
		if(a.getSource() == srt) {
			String changeSrt = text.getText();
			double tempSrt = Double.parseDouble(changeSrt);				//Display the square root of the number that you input
			tempSrt = Math.sqrt(tempSrt);
			text.setText(String.valueOf(tempSrt));
		}
	}
}
