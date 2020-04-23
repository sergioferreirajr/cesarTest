import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class CesarsTest {

	private JFrame frmCesarsTest;
	private JTextField tf_insert;
	private JTextField tf_result;
	private JTextArea ta_logs = new JTextArea();
	private JTextArea ta_logs2 = new JTextArea();
	private char[] insertedTextCharArray;
	private char[] auxTextCharArray;
	private JTextField tf_correctWord;
	private JTextField tf_result2;
	private JTextField tf_jumbledWord;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CesarsTest window = new CesarsTest();
					window.frmCesarsTest.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CesarsTest() {
		initialize();
	}

	/**
	 * Take the text and replace spaces by '&32' - Question 1
	 */
	protected void replaceSpaces() {
		this.ta_logs.setText("");
		String textInserted = this.tf_insert.getText();
		List<Integer> spaces_positions = new ArrayList<Integer>();

		this.ta_logs.append("Starting...\n");
		this.ta_logs.append("The text inserted is: " + textInserted + "\n");

		this.ta_logs.append("--------------------------------------------\n");
		this.ta_logs.append("Spliting the string into an array...\n");
		this.insertedTextCharArray = textInserted.toCharArray();
		printArray(this.insertedTextCharArray);

		this.ta_logs.append("--------------------------------------------\n");
		this.ta_logs.append("Checking the number of spaces: ");
		int count_spaces = 0;
		char[] arrayAux = textInserted.trim().toCharArray();
		for (int i = 0; i < arrayAux.length; i++) {
			if (arrayAux[i] == ' ') {
				spaces_positions.add(i); //keeping the array position of the spaces
				count_spaces++;
			}
		}
		this.ta_logs.append(count_spaces + " spaces\n");
		int count_spaces_total = 0;
		for (char c : insertedTextCharArray) {
			if (c == ' ') {
				count_spaces_total++;
			}
		}

		int spaces_at_the_end = count_spaces_total - count_spaces;
		int count_chars = insertedTextCharArray.length - count_spaces_total;
		int needed_slots = count_chars + (count_spaces * 3);
		int index_chars_limit = insertedTextCharArray.length - count_spaces_total + count_spaces;

		this.ta_logs.append("--------------------------------------------\n");
		this.ta_logs.append("Checking if the number of array slots are enougth... \n");
		this.ta_logs.append("Originally, we have " + insertedTextCharArray.length + " characters\n");
		this.ta_logs.append(count_spaces + " are spaces between words\n");
		this.ta_logs.append(spaces_at_the_end + " are spaces at the end of the string\n");
		this.ta_logs.append(count_chars + " are characters not empty\n");
		this.ta_logs.append(index_chars_limit + " are number of characters not considering the empty spaces at the end not empty\n");
		this.ta_logs.append("Consedering the number os spaces between words, we need " + needed_slots + " array slots\n");

		if (needed_slots <= insertedTextCharArray.length) {
			this.ta_logs.append("The number of array slots are enougth... nothing to do here...\n");
			auxTextCharArray = insertedTextCharArray;
		} else {
			this.ta_logs.append("The number of array slots are not enougth... I have to change the array size.\n");
			auxTextCharArray = new char[needed_slots];
			for (int i = 0; i < auxTextCharArray.length; i++) {
				if (i < insertedTextCharArray.length) {
					auxTextCharArray[i] = insertedTextCharArray[i];
				}else {
					auxTextCharArray[i] = ' ';
				}
			}
		}
		printArray(auxTextCharArray);
		
		this.ta_logs.append("--------------------------------------------\n");
		this.ta_logs.append("Now, I will shift the non-space chars to the end of array. In order to create the correct number of spaces between words. \n");
		
		char[] finalTextCharArray = new char[needed_slots];
		int x = 0;
		int z = 0;
		for (int i = 0; i < spaces_positions.size(); i++) {
			int index = spaces_positions.get(i);
			for (int j = x; j < finalTextCharArray.length;) {
				if (z == index) {
					finalTextCharArray[j++] = '&';
					finalTextCharArray[j++] = '3';
					finalTextCharArray[j++] = '2';
					z++;
					x = j;
					break;
				} else {
					finalTextCharArray[j++] = auxTextCharArray[z++];
					x = j;
				}
			}
		}
		if( z <= (index_chars_limit-1)) {
			for (int i = z; i < index_chars_limit; i++) {
				finalTextCharArray[x++] = auxTextCharArray[i];
			}
		}
		
		this.printArray(finalTextCharArray);
		
		this.tf_result.setText(new String(finalTextCharArray));
	}
	
	/**
	 * Check if the jumbled word is partial-permutation - Question 2
	 */
	protected void checkJumbledWord() {
		this.ta_logs2.setText("");
		
		String correctWord = this.tf_correctWord.getText();
		String jumbledWord = this.tf_jumbledWord.getText();
		
		char[] correctChars = correctWord.toCharArray();
		char[] jumbledChars = jumbledWord.toCharArray();
		
		this.ta_logs2.append("Starting...\n");
		this.ta_logs2.append("--------------------------------------------\n");
		
		if (correctChars.length != jumbledChars.length) {
			this.ta_logs2.append("The words inserted have not the same number of letters.\n");
			this.tf_result2.setText("FALSE. It is not a partial-permutation");
			return;
		}
		
		this.ta_logs2.append("Checking the first condition...\n");
		this.ta_logs2.append("The first letter is equal?\n");
		
		if (correctChars[0] == jumbledChars[0]) {
			this.ta_logs2.append("YES\n");
		} else {
			this.ta_logs2.append("NO. That jumbled word is not a partial-permutation.\n");
			this.tf_result2.setText("FALSE. It is not a partial-permutation");
			return;
		}

		this.ta_logs2.append("--------------------------------------------\n");
		this.ta_logs2.append("Checking the second condition...\n");

		if (correctChars.length <= 3) {
			
			if(correctWord.equals(jumbledWord)) {
				this.ta_logs2.append("NO. The words are equals\n");
				this.tf_result2.setText("FALSE. It is not a partial-permutation");
				return;
			}
			
			this.ta_logs2.append("This word has lass then 4 letters\n");
			this.ta_logs2.append("So... this jumbled word is a partial-permutation.\n");
			this.tf_result2.setText("TRUE. It is a partial-permutation");
		} else {
			this.ta_logs2.append("How many letters have changed place?\n");
			
			Integer changed_count = 0;
			for (int i = 1; i < jumbledChars.length; i++) {
				if (jumbledChars[i] != correctChars[i]) {
					changed_count++;
				}
			}
			
			float minimum_indicator = 2.0f / 3.0f;
			float indicator = changed_count.floatValue() / jumbledChars.length;
			float percentage_indicator = indicator * 100;
			String COMMA_SEPERATED = "###,###.##";
			DecimalFormat decimalFormat = new DecimalFormat(COMMA_SEPERATED);
			String percentageStr = decimalFormat.format(percentage_indicator);

			this.ta_logs2.append("The number of changed place letters are: " + changed_count + "/" + jumbledChars.length
					+ "(" + percentageStr + "%)\n");

			this.ta_logs2.append("Does it have up to 2/3 of the letters have changed place? ...\n");
			if(indicator>minimum_indicator) {
				this.ta_logs2.append("NO. That jumbled word is not a partial-permutation.\n");
				this.tf_result2.setText("FALSE. It is not a partial-permutation");
			}else {
				this.ta_logs2.append("YES. This jumbled word is a partial-permutation.\n");
				this.tf_result2.setText("TRUE. It is a partial-permutation");
			}
		}		
	}
	

	private void printArray(char[] value) {
		this.ta_logs.append("--------------------------------------------\n");
		this.ta_logs.append("Now... the string array is:\n");
		String result = "| ";
		for (char c : value) {
			result = result + c + " |";
		}
		this.ta_logs.append(result + "\n");
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCesarsTest = new JFrame();
		frmCesarsTest.setTitle("Cesar's Test");
		frmCesarsTest.setBounds(100, 100, 1185, 800);
		frmCesarsTest.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		frmCesarsTest.getContentPane().setLayout(gridBagLayout);

		JLabel lbl_name = new JLabel("Name: Sérgio Claudio Menezes Ferreira Júnior");
		GridBagConstraints gbc_lbl_name = new GridBagConstraints();
		gbc_lbl_name.insets = new Insets(0, 0, 5, 0);
		gbc_lbl_name.anchor = GridBagConstraints.WEST;
		gbc_lbl_name.gridx = 0;
		gbc_lbl_name.gridy = 0;
		frmCesarsTest.getContentPane().add(lbl_name, gbc_lbl_name);

		JLabel lbl_purpose = new JLabel(
				"Purpose: Present the Cesar's Test solutions, in order to compete for the position of Technical leader Android");
		GridBagConstraints gbc_lbl_purpose = new GridBagConstraints();
		gbc_lbl_purpose.insets = new Insets(0, 0, 5, 0);
		gbc_lbl_purpose.anchor = GridBagConstraints.WEST;
		gbc_lbl_purpose.gridx = 0;
		gbc_lbl_purpose.gridy = 1;
		frmCesarsTest.getContentPane().add(lbl_purpose, gbc_lbl_purpose);

		JLabel lbl_date = new JLabel("Date: 21/04/2020");
		GridBagConstraints gbc_lbl_date = new GridBagConstraints();
		gbc_lbl_date.insets = new Insets(0, 0, 5, 0);
		gbc_lbl_date.anchor = GridBagConstraints.WEST;
		gbc_lbl_date.gridx = 0;
		gbc_lbl_date.gridy = 2;
		frmCesarsTest.getContentPane().add(lbl_date, gbc_lbl_date);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GridBagConstraints gbc_tabbedPane = new GridBagConstraints();
		gbc_tabbedPane.insets = new Insets(0, 0, 5, 0);
		gbc_tabbedPane.fill = GridBagConstraints.BOTH;
		gbc_tabbedPane.gridx = 0;
		gbc_tabbedPane.gridy = 3;
		frmCesarsTest.getContentPane().add(tabbedPane, gbc_tabbedPane);

		JPanel tb_question1 = new JPanel();
		tabbedPane.addTab("Question 1", null, tb_question1, null);
		GridBagLayout gbl_tb_question1 = new GridBagLayout();
		gbl_tb_question1.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_tb_question1.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_tb_question1.columnWeights = new double[] { 1.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_tb_question1.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		tb_question1.setLayout(gbl_tb_question1);

		JLabel lbl_question1_answer = new JLabel("1. Replacing characters in place:");
		GridBagConstraints gbc_lbl_question1_answer = new GridBagConstraints();
		gbc_lbl_question1_answer.gridwidth = 2;
		gbc_lbl_question1_answer.ipadx = 2;
		gbc_lbl_question1_answer.anchor = GridBagConstraints.WEST;
		gbc_lbl_question1_answer.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_question1_answer.gridx = 0;
		gbc_lbl_question1_answer.gridy = 0;
		tb_question1.add(lbl_question1_answer, gbc_lbl_question1_answer);

		JLabel lbl_question1_desc = new JLabel(
				"<html>Given an array of characters, write a method to replace all the spaces with “&32”.<br>You may assume that the array has sufficient slots at the end to hold the additional<br>characters, and that you are given the “true” length of the array. (Please perform this<br>operation in place with no other auxiliary structure).<br><br>Example:<br>Input: “User is not allowed            “, 19<br>Output: “User&32is&32not&32allowed”</html>");
		GridBagConstraints gbc_lbl_question1_desc = new GridBagConstraints();
		gbc_lbl_question1_desc.gridwidth = 2;
		gbc_lbl_question1_desc.ipadx = 2;
		gbc_lbl_question1_desc.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_question1_desc.anchor = GridBagConstraints.WEST;
		gbc_lbl_question1_desc.gridx = 0;
		gbc_lbl_question1_desc.gridy = 1;
		tb_question1.add(lbl_question1_desc, gbc_lbl_question1_desc);

		JSeparator separator = new JSeparator();
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.gridwidth = 2;
		gbc_separator.ipadx = 2;
		gbc_separator.insets = new Insets(0, 0, 5, 5);
		gbc_separator.gridx = 0;
		gbc_separator.gridy = 2;
		tb_question1.add(separator, gbc_separator);

		JLabel lblAnswer = new JLabel("SOLUTION:");
		GridBagConstraints gbc_lblAnswer = new GridBagConstraints();
		gbc_lblAnswer.gridwidth = 2;
		gbc_lblAnswer.insets = new Insets(0, 0, 5, 5);
		gbc_lblAnswer.anchor = GridBagConstraints.WEST;
		gbc_lblAnswer.gridx = 0;
		gbc_lblAnswer.gridy = 3;
		tb_question1.add(lblAnswer, gbc_lblAnswer);

		tf_insert = new JTextField();
		tf_insert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				replaceSpaces();
			}
		});
		tf_insert.setToolTipText(
				"Do not forget to insert the correct number of spaces at the end in order to define the correct size of the array");
		tf_insert.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_tf_insert = new GridBagConstraints();
		gbc_tf_insert.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_insert.insets = new Insets(0, 0, 5, 5);
		gbc_tf_insert.anchor = GridBagConstraints.WEST;
		gbc_tf_insert.gridx = 1;
		gbc_tf_insert.gridy = 5;
		tb_question1.add(tf_insert, gbc_tf_insert);
		tf_insert.setColumns(50);

		JLabel lblTextToBe = new JLabel("Text to be replaced:");
		GridBagConstraints gbc_lblTextToBe = new GridBagConstraints();
		gbc_lblTextToBe.insets = new Insets(0, 0, 5, 5);
		gbc_lblTextToBe.anchor = GridBagConstraints.WEST;
		gbc_lblTextToBe.gridx = 0;
		gbc_lblTextToBe.gridy = 5;
		tb_question1.add(lblTextToBe, gbc_lblTextToBe);

		JButton bt_execute = new JButton("Execute");
		bt_execute.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				replaceSpaces();
			}
		});
		GridBagConstraints gbc_bt_execute = new GridBagConstraints();
		gbc_bt_execute.insets = new Insets(0, 5, 5, 0);
		gbc_bt_execute.anchor = GridBagConstraints.WEST;
		gbc_bt_execute.weightx = 8.0;
		gbc_bt_execute.gridx = 2;
		gbc_bt_execute.gridy = 5;
		tb_question1.add(bt_execute, gbc_bt_execute);

		JLabel lblResult = new JLabel("RESULT =");
		GridBagConstraints gbc_lblResult = new GridBagConstraints();
		gbc_lblResult.anchor = GridBagConstraints.EAST;
		gbc_lblResult.insets = new Insets(0, 0, 5, 5);
		gbc_lblResult.gridx = 0;
		gbc_lblResult.gridy = 6;
		tb_question1.add(lblResult, gbc_lblResult);

		tf_result = new JTextField();
		tf_result.setEditable(false);
		GridBagConstraints gbc_tf_result = new GridBagConstraints();
		gbc_tf_result.anchor = GridBagConstraints.WEST;
		gbc_tf_result.insets = new Insets(0, 0, 5, 5);
		gbc_tf_result.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_result.gridx = 1;
		gbc_tf_result.gridy = 6;
		tb_question1.add(tf_result, gbc_tf_result);
		tf_result.setColumns(50);

		GridBagConstraints gbc_ta_logs = new GridBagConstraints();
		gbc_ta_logs.insets = new Insets(0, 0, 0, 5);
		gbc_ta_logs.fill = GridBagConstraints.BOTH;
		gbc_ta_logs.gridx = 1;
		gbc_ta_logs.gridy = 7;
		ta_logs.setEditable(false);
		JScrollPane sp = new JScrollPane(ta_logs); 
		tb_question1.add(sp, gbc_ta_logs);
		
		JPanel tb_question2 = new JPanel();
		tabbedPane.addTab("Question 2", null, tb_question2, null);
		GridBagLayout gbl_tb_question2 = new GridBagLayout();
		gbl_tb_question2.columnWidths = new int[]{0, 0, 0, 0};
		gbl_tb_question2.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_tb_question2.columnWeights = new double[]{1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_tb_question2.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		tb_question2.setLayout(gbl_tb_question2);
		
		JLabel lbl_question1_answer_1 = new JLabel("2. Check words with jumbled letters :");
		GridBagConstraints gbc_lbl_question1_answer_1 = new GridBagConstraints();
		gbc_lbl_question1_answer_1.ipadx = 2;
		gbc_lbl_question1_answer_1.anchor = GridBagConstraints.WEST;
		gbc_lbl_question1_answer_1.gridwidth = 2;
		gbc_lbl_question1_answer_1.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_question1_answer_1.gridx = 0;
		gbc_lbl_question1_answer_1.gridy = 0;
		tb_question2.add(lbl_question1_answer_1, gbc_lbl_question1_answer_1);
		
		JLabel lbl_question1_desc_1 = new JLabel("<html>\nOur brain can read texts even if letters are jumbled, like the following sentence: “ Yuo<br>\ncna porbalby raed tihs esaliy desptie teh msispeillgns.” Given two strings, write a<br>\nmethod to decide if one is a partial­permutation of the other. Consider a<br>\npartial­permutation only if:<br>\n<br>\n   - The first letter hasn’t changed place<br>\n   - If word has more than 3 letters, up to 2/3 of the letters have changed place<br>\n<br>\nExamples:<br>\n<br>\nyou, yuo ­=> true<br>\nprobably, porbalby =­> true<br>\ndespite, desptie ­=> true<br>\nmoon, nmoo ­=> false<br>\nmisspellings, mpeissngslli =­> false<br>\n</html>");
		GridBagConstraints gbc_lbl_question1_desc_1 = new GridBagConstraints();
		gbc_lbl_question1_desc_1.ipadx = 2;
		gbc_lbl_question1_desc_1.anchor = GridBagConstraints.WEST;
		gbc_lbl_question1_desc_1.gridwidth = 2;
		gbc_lbl_question1_desc_1.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_question1_desc_1.gridx = 0;
		gbc_lbl_question1_desc_1.gridy = 1;
		tb_question2.add(lbl_question1_desc_1, gbc_lbl_question1_desc_1);
		
		JSeparator separator_1 = new JSeparator();
		GridBagConstraints gbc_separator_1 = new GridBagConstraints();
		gbc_separator_1.ipadx = 2;
		gbc_separator_1.gridwidth = 2;
		gbc_separator_1.insets = new Insets(0, 0, 5, 5);
		gbc_separator_1.gridx = 0;
		gbc_separator_1.gridy = 2;
		tb_question2.add(separator_1, gbc_separator_1);
		
		JLabel lblAnswer_1 = new JLabel("SOLUTION:");
		GridBagConstraints gbc_lblAnswer_1 = new GridBagConstraints();
		gbc_lblAnswer_1.anchor = GridBagConstraints.WEST;
		gbc_lblAnswer_1.gridwidth = 2;
		gbc_lblAnswer_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblAnswer_1.gridx = 0;
		gbc_lblAnswer_1.gridy = 3;
		tb_question2.add(lblAnswer_1, gbc_lblAnswer_1);
		
		JLabel lblCorrectword = new JLabel("Correct word:");
		GridBagConstraints gbc_lblCorrectword = new GridBagConstraints();
		gbc_lblCorrectword.anchor = GridBagConstraints.EAST;
		gbc_lblCorrectword.insets = new Insets(0, 0, 5, 5);
		gbc_lblCorrectword.gridx = 0;
		gbc_lblCorrectword.gridy = 5;
		tb_question2.add(lblCorrectword, gbc_lblCorrectword);
		
		tf_correctWord = new JTextField();
		tf_correctWord.setToolTipText("Do not forget to insert the correct number of spaces at the end in order to define the correct size of the array");
		tf_correctWord.setHorizontalAlignment(SwingConstants.LEFT);
		tf_correctWord.setColumns(50);
		GridBagConstraints gbc_tf_correctWord = new GridBagConstraints();
		gbc_tf_correctWord.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_correctWord.anchor = GridBagConstraints.WEST;
		gbc_tf_correctWord.insets = new Insets(0, 0, 5, 5);
		gbc_tf_correctWord.gridx = 1;
		gbc_tf_correctWord.gridy = 5;
		tb_question2.add(tf_correctWord, gbc_tf_correctWord);
		
		JButton bt_check = new JButton("Check");
		bt_check.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkJumbledWord();
			}
		});
		GridBagConstraints gbc_bt_check = new GridBagConstraints();
		gbc_bt_check.weightx = 8.0;
		gbc_bt_check.anchor = GridBagConstraints.WEST;
		gbc_bt_check.insets = new Insets(0, 5, 5, 0);
		gbc_bt_check.gridx = 2;
		gbc_bt_check.gridy = 6;
		tb_question2.add(bt_check, gbc_bt_check);
		
		JLabel lblJumbledWord = new JLabel("Jumbled word:");
		GridBagConstraints gbc_lblJumbledWord = new GridBagConstraints();
		gbc_lblJumbledWord.anchor = GridBagConstraints.EAST;
		gbc_lblJumbledWord.insets = new Insets(0, 0, 5, 5);
		gbc_lblJumbledWord.gridx = 0;
		gbc_lblJumbledWord.gridy = 6;
		tb_question2.add(lblJumbledWord, gbc_lblJumbledWord);
		
		tf_jumbledWord = new JTextField();
		tf_jumbledWord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkJumbledWord();
			}
		});
		GridBagConstraints gbc_tf_jumbledWord = new GridBagConstraints();
		gbc_tf_jumbledWord.insets = new Insets(0, 0, 5, 5);
		gbc_tf_jumbledWord.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_jumbledWord.gridx = 1;
		gbc_tf_jumbledWord.gridy = 6;
		tb_question2.add(tf_jumbledWord, gbc_tf_jumbledWord);
		tf_jumbledWord.setColumns(10);
		
		JLabel lblResult_1 = new JLabel("RESULT =");
		GridBagConstraints gbc_lblResult_1 = new GridBagConstraints();
		gbc_lblResult_1.anchor = GridBagConstraints.EAST;
		gbc_lblResult_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblResult_1.gridx = 0;
		gbc_lblResult_1.gridy = 7;
		tb_question2.add(lblResult_1, gbc_lblResult_1);
		
		tf_result2 = new JTextField();
		tf_result2.setHorizontalAlignment(SwingConstants.LEFT);
		tf_result2.setEditable(false);
		tf_result2.setColumns(50);
		GridBagConstraints gbc_tf_result2 = new GridBagConstraints();
		gbc_tf_result2.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_result2.anchor = GridBagConstraints.WEST;
		gbc_tf_result2.insets = new Insets(0, 0, 5, 5);
		gbc_tf_result2.gridx = 1;
		gbc_tf_result2.gridy = 7;
		tb_question2.add(tf_result2, gbc_tf_result2);
		
		JScrollPane sp_1 = new JScrollPane(ta_logs2);
		GridBagConstraints gbc_sp_1 = new GridBagConstraints();
		gbc_sp_1.fill = GridBagConstraints.BOTH;
		gbc_sp_1.insets = new Insets(0, 0, 5, 5);
		gbc_sp_1.gridx = 1;
		gbc_sp_1.gridy = 8;
		tb_question2.add(sp_1, gbc_sp_1);

		JPanel tb_question3 = new JPanel();
		tabbedPane.addTab("Question 3", null, tb_question3, null);

		JPanel tb_question4 = new JPanel();
		tabbedPane.addTab("Question 4", null, tb_question4, null);

		JPanel tb_question5 = new JPanel();
		tabbedPane.addTab("Question 5", null, tb_question5, null);

		JPanel tb_question6 = new JPanel();
		tabbedPane.addTab("Question 6", null, tb_question6, null);

		JPanel tb_question7 = new JPanel();
		tabbedPane.addTab("Question 7", null, tb_question7, null);
	}
}
