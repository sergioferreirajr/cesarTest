package main;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedList;
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
/**
 * Program created as a test for Instituto Cesar.
 * It consists for 7 questions related to algorithms using
 * Arrays, Strings, LinkedLists and some code in Android.
 * 
 * @author Sérgio Ferreira Jr. (sergioferreirajr@gmail.com)
 * @since 25/04/2020
 */
public class CesarsTest {

	private JFrame frmCesarsTest;
	private JTextField tf_insert;
	private JTextField tf_result;
	private JTextArea ta_logs = new JTextArea();
	private JTextArea ta_logs2 = new JTextArea();
	private JTextArea ta_logs3 = new JTextArea();
	private JTextArea ta_logs5 = new JTextArea();
	private JTextArea ta_logs7 = new JTextArea();
	private char[] insertedTextCharArray;
	private char[] auxTextCharArray;
	private JTextField tf_correctWord;
	private JTextField tf_result2;
	private JTextField tf_jumbledWord;
	private JTextField tf_correctWord3;
	private JTextField tf_typoWord;
	private JTextField tf_result3;
	private JTextArea ta_initialList = new JTextArea();
	private JTextArea ta_finalList = new JTextArea();
	private JTextArea ta_list1 = new JTextArea();
	private JTextArea ta_list2 = new JTextArea();
	private JTextField tf_list1Intersection = new JTextField();
	private JTextField tf_list2Intersection = new JTextField();
	
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
		initLinkedListQuestion5();
		initLinkedList1Question7();
		initLinkedList2Question7();
	}
	
	private LinkedList<String> initLinkedListQuestion5() {
		LinkedList<String> linkedList1 = new LinkedList<String>();
		linkedList1.clear();
		linkedList1.add("A");
		linkedList1.add("B");
		linkedList1.add("A");
		linkedList1.add("C");
		linkedList1.add("D");
		linkedList1.add("A");
		linkedList1.add("E");
		linkedList1.add("B");
		linkedList1.add("F");
		linkedList1.add("C");
		linkedList1.add("A");
		
		ta_initialList.setText("");
		
		ta_initialList.append("Index    |   Email \n");
		
		for (int i = 0; i < linkedList1.size(); i++) {
			String element = linkedList1.get(i);
			ta_initialList.append(i + "            |   " + element +  "\n");
		}
		
		return linkedList1;
	}
	
	private LinkedList<String> initLinkedList1Question7() {
		LinkedList<String> linkedList2 = new LinkedList<String>();
		
		linkedList2.clear();
		linkedList2.add("A");
		linkedList2.add("B");
		linkedList2.add("C");
		linkedList2.add("D");
		linkedList2.add("E");
		linkedList2.add("F");
		linkedList2.add("G");
		linkedList2.add("H");
		linkedList2.add("I");
		linkedList2.add("J");
		
		ta_list1.setText("");
		
		ta_list1.append("Index    |   Value \n");
		
		for (int i = 0; i < linkedList2.size(); i++) {
			String element = linkedList2.get(i);
			ta_list1.append(i + "            |   " + element +  "\n");
		}
		
		return linkedList2;
	}
	
	private LinkedList<String> initLinkedList2Question7() {
		LinkedList<String> linkedList3 = new LinkedList<String>();
				
		linkedList3.clear();
		linkedList3.add("1");
		linkedList3.add("2");
		linkedList3.add("3");
		linkedList3.add("G");
		linkedList3.add("H");
		linkedList3.add("I");
		linkedList3.add("J");
		
		ta_list2.setText("");
		
		ta_list2.append("Index    |   Value \n");
		
		for (int i = 0; i < linkedList3.size(); i++) {
			String element = linkedList3.get(i);
			ta_list2.append(i + "            |   " + element +  "\n");
		}
		return linkedList3;
	}

	/**
	 * Take the text and replace spaces by '&32' - Question 1
	 * @return 
	 */
	protected char[] q1ReplaceSpaces(String textInserted) {
		this.ta_logs.setText("");
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
		
		char[] arrayAux = textInserted.replaceAll("\\s+$", "").toCharArray();
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
		return finalTextCharArray;
	}

	/**
	 * Check if the jumbled word is partial-permutation - Question 2
	 */
	protected boolean q2CheckJumbledWord(String correctWord, String jumbledWord) {
		
		boolean result = false;
		this.ta_logs2.setText("");
				
		char[] correctChars = correctWord.toCharArray();
		char[] jumbledChars = jumbledWord.toCharArray();
		
		this.ta_logs2.append("Starting...\n");
		this.ta_logs2.append("--------------------------------------------\n");
		
		if (correctChars.length != jumbledChars.length) {
			this.ta_logs2.append("The words inserted have not the same number of letters.\n");
			this.tf_result2.setText("FALSE. It is not a partial-permutation");
			return result;
		}
		
		this.ta_logs2.append("Checking the first condition...\n");
		this.ta_logs2.append("The first letter is equal?\n");
		
		if (correctChars[0] == jumbledChars[0]) {
			this.ta_logs2.append("YES\n");
		} else {
			this.ta_logs2.append("NO. That jumbled word is not a partial-permutation.\n");
			this.tf_result2.setText("FALSE. It is not a partial-permutation");
			return result;
		}

		this.ta_logs2.append("--------------------------------------------\n");
		this.ta_logs2.append("Checking the second condition...\n");

		if (correctChars.length <= 3) {
			
			if(correctWord.equals(jumbledWord)) {
				this.ta_logs2.append("NO. The words are equals\n");
				this.tf_result2.setText("FALSE. It is not a partial-permutation");
				return result;
			}
			
			this.ta_logs2.append("This word has lass then 4 letters\n");
			this.ta_logs2.append("So... this jumbled word is a partial-permutation.\n");
			this.tf_result2.setText("TRUE. It is a partial-permutation");
			result = true;
			return result;
		} else {
			
			if(correctWord.equals(jumbledWord)) {
				this.ta_logs2.append("NO. The words are equals\n");
				this.tf_result2.setText("FALSE. It is not a partial-permutation");
				return result;
			}
			
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
				return result;
			}else {
				this.ta_logs2.append("YES. This jumbled word is a partial-permutation.\n");
				this.tf_result2.setText("TRUE. It is a partial-permutation");
				result = true;
				return result;
			}
		}		
	}
	
	protected boolean q3CheckTypoWord(String correctWord3, String typoWord) {
		boolean result = false;
		this.ta_logs3.setText("");
		tf_result3.setText("");
				
		char[] correctWordChars = correctWord3.toCharArray();
		char[] typoWordChars = typoWord.toCharArray();
		
		this.ta_logs3.append("Starting...\n");
				
		if(insertCharTypo(correctWordChars, typoWordChars) ||
				removeCharTypo(correctWordChars, typoWordChars) ||
				replaceCharTypo(correctWordChars, typoWordChars)) {
			result = true;
		}	
		
		return result;
	}
	
	private boolean insertCharTypo(char[] correctWordChars, char[] typoWordChars) {
		boolean result = false;
		
		this.ta_logs3.append("--------------------------------------------\n");
		this.ta_logs3.append("Checking the 'Insert characters' typo.\n");
					
		if(correctWordChars.length < typoWordChars.length) {
			this.ta_logs3.append("They have different size... the typo can be 'Insert a character' typo... \n");
			
			if(( typoWordChars.length - correctWordChars.length) > 1) {
				this.ta_logs3.append("The difference of the number of characters is more than 1. It's not a 'Insert a character' typo. \n");
				tf_result3.setText("FALSE. It's ZERO typo");
				return result;
			} else {
				
				this.ta_logs3.append("Validating if the Correct word has some character different. \n");
				int match_count = 0;
				for (int i = 0; i < correctWordChars.length; i++) {
					match_count = 0;
					for (int j = 0; j < typoWordChars.length; j++) {
						if(correctWordChars[i] == typoWordChars[j]) {
							match_count++;
							break;
						}
					}
					if(match_count == 0) {
						this.ta_logs3.append("The Correct Word has a different character.It's not a 'Insert a character' typo. \n");
						tf_result3.setText("FALSE. It's ZERO typo");
						return result;
					}
				}
				
				this.ta_logs3.append("It's a 'Insert a character' typo. \n");
				tf_result3.setText("TRUE. It's a 'Insert a character' typo");
				result = true;
			}
		}
		return result;
	}

	private boolean removeCharTypo(char[] correctWordChars, char[] typoWordChars) {
		boolean result = false;
		
		this.ta_logs3.append("--------------------------------------------\n");
		this.ta_logs3.append("Checking the 'Remove characters' typo.\n");
				
		if(typoWordChars.length < correctWordChars.length) {
			this.ta_logs3.append("They have different size... the typo can be 'Remove a character'... \n");
			
			if(( correctWordChars.length - typoWordChars.length) > 1) {
				this.ta_logs3.append("The difference of the number of characters is more than 1. It's not a 'Remove a character' typo. \n");
				tf_result3.setText("FALSE. It's ZERO typo");
				return result;
			} else {
				
				this.ta_logs3.append("Validating if the Typo Word has some character different. \n");
				int match_count = 0;
				for (int i = 0; i < typoWordChars.length; i++) {
					match_count = 0;
					for (int j = 0; j < correctWordChars.length; j++) {
						if(typoWordChars[i] == correctWordChars[j]) {
							match_count++;
							break;
						}
					}
					if(match_count == 0) {
						this.ta_logs3.append("The Typo Word has a different character.It's not a 'Remove a character' typo. \n");
						tf_result3.setText("FALSE. It's ZERO typo");
						return result;
					}
				}
				
				this.ta_logs3.append("It's a 'Remove a character' typo. \n");
				tf_result3.setText("TRUE. It's a 'Remove a character' typo");
				result = true;
			}
		}
		return result;
	}
	
	private boolean replaceCharTypo(char[] correctWordChars, char[] typoWordChars) {
		boolean result = false;
		
		this.ta_logs3.append("--------------------------------------------\n");
		this.ta_logs3.append("Checking the 'Replace a characters' typo.\n");
					
		if(correctWordChars.length == typoWordChars.length) {
			int match_count = 0;
			for (int i = 0; i < correctWordChars.length; i++) {
				for (int j = 0; j < typoWordChars.length; j++) {
					if(correctWordChars[i] == typoWordChars[j]) {
						match_count++;
						break;
					}
				}
			}
			if(match_count == (typoWordChars.length)) {
				this.ta_logs3.append("The words are equals, nothing to do here.\n");
				tf_result3.setText("FALSE. It's ZERO typo");
				return result;
			}else if((typoWordChars.length - match_count) > 1){
				this.ta_logs3.append("There are more than 1 character replaced. It's not a 'Replace a character' typo\n");
				tf_result3.setText("FALSE. It's ZERO typo");
				return result;
			}
			
			this.ta_logs3.append("It's a 'Replace a character' typo. \n");
			tf_result3.setText("TRUE. It's a 'Replace a character' typo");
			result = true;
		}
		return result;
	}

	/**
	 * Remove duplicates form LinkedList - Question 5
	 * @return 
	 */
	protected LinkedList<String> q5RemoveDuplicates(LinkedList<String> linkedList1) {
		
		ta_finalList.setText("");
		
		this.ta_logs5.append("Starting...\n");
		this.ta_logs5.append("--------------------------------------------\n");
		this.ta_logs5.append("Collecting emails duplicated:\n");

		List<String> duplicated = new ArrayList<String>();
		
		for (int i = 0; i < linkedList1.size()-1; i++) {
			for (int j = i+1; j < linkedList1.size();j++) {
				String element1 = linkedList1.get(i);
				String element2 = linkedList1.get(j);
				if(element1.equals(element2)) {
					if(!duplicated.contains(element1)) {
						duplicated.add(element1);
						this.ta_logs5.append(" - " + element1 + "\n");
						break;
					}
				}
			}
		}
		
		this.ta_logs5.append("Removing emails duplicated...\n");
		for (String string : duplicated) {
			int matched = 0;
			for (int i = 0; i < linkedList1.size();) {
				String element = linkedList1.get(i);
				if(string.equals(element)) {
					if(matched == 0) {
						matched++;
					} else {
						linkedList1.remove(i);
						i--;						
					}
				}				
				i++;
			}
		}
		
		ta_finalList.append("Index    |   Email \n");
		
		for (int i = 0; i < linkedList1.size(); i++) {
			String element = linkedList1.get(i);
			ta_finalList.append(i + "            |   " + element +  "\n");
		}
		
		return linkedList1;
	}
	
	/**
	 * Button Restart - Remove Duplicated - Question 5
	 */
	protected void restartRemoveDuplicated() {
		ta_finalList.setText("");
		ta_logs5.setText("");
		initLinkedListQuestion5();
	}
	
	/**
	 * Check intersection - Question 7
	 */
	protected Question7Result q7CheckIntersection(LinkedList<String> linkedList2, LinkedList<String> linkedList3) {
		Question7Result result = new Question7Result();
		
		ta_finalList.setText("");
		tf_list1Intersection.setText("");
		tf_list2Intersection.setText("");
		
		this.ta_logs7.append("Starting...\n");
		this.ta_logs7.append("--------------------------------------------\n");
		this.ta_logs7.append("Lopping booth list in order do find de node intersection...\n");
				
		int list1Size = linkedList2.size();
		int list2Size = linkedList3.size();
		
		LinkedList<String> list1 = linkedList2;
		LinkedList<String> list2 = linkedList3;
		
		if(list2Size > list1Size) {
			list1 = linkedList3;
			list2 = linkedList2;
		}
		
		for (int i = 0; i < list1.size(); i++) {
			for (int j = 0; j < list2.size(); j++) {
				String element1 = list1.get(i);
				String element2 = list2.get(j);
				if(element1.equals(element2)) {
					if(list2Size > list1Size) {
						tf_list2Intersection.setText("The index intersection is: " + i);
						tf_list1Intersection.setText("The index intersection is: " + j);
						result.setList1IndexIntersection(j);
						result.setList2IndexIntersection(i);
					} else {
						tf_list1Intersection.setText("The index intersection is: " + i);
						tf_list2Intersection.setText("The index intersection is: " + j);
						result.setList1IndexIntersection(i);
						result.setList2IndexIntersection(j);
					}
					return result;
				}
			}
		}
		this.ta_logs7.append("Oops... a didn't find the node intersection.\n");
		return result;
	}
	
	/**
	 * Button Restart - Check Intersection- Question 7
	 */
	protected void restartCheckIntersection() {
		tf_list1Intersection.setText("");
		tf_list2Intersection.setText("");
		ta_logs7.setText("");
		initLinkedList1Question7();
		initLinkedList2Question7();
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
		frmCesarsTest.setResizable(false);
		frmCesarsTest.setTitle("Cesar's Test");
		frmCesarsTest.setBounds(100, 100, 1185, 762);
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
				q1ReplaceSpaces(tf_insert.getText());
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
				q1ReplaceSpaces(tf_insert.getText());
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
				q2CheckJumbledWord(tf_correctWord.getText(), tf_jumbledWord.getText());
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
				q2CheckJumbledWord(tf_correctWord.getText(), tf_jumbledWord.getText());
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
		GridBagLayout gbl_tb_question3 = new GridBagLayout();
		gbl_tb_question3.columnWidths = new int[]{0, 0, 0, 0};
		gbl_tb_question3.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_tb_question3.columnWeights = new double[]{1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_tb_question3.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		tb_question3.setLayout(gbl_tb_question3);
		
		JLabel lbl_question1_answer_1_1 = new JLabel("3. Check words with typos:");
		GridBagConstraints gbc_lbl_question1_answer_1_1 = new GridBagConstraints();
		gbc_lbl_question1_answer_1_1.ipadx = 2;
		gbc_lbl_question1_answer_1_1.anchor = GridBagConstraints.WEST;
		gbc_lbl_question1_answer_1_1.gridwidth = 2;
		gbc_lbl_question1_answer_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_question1_answer_1_1.gridx = 0;
		gbc_lbl_question1_answer_1_1.gridy = 0;
		tb_question3.add(lbl_question1_answer_1_1, gbc_lbl_question1_answer_1_1);
		
		JLabel lbl_question1_desc_1_1 = new JLabel("<html>\nThere are three types of typos that can be performed on strings: insert a character,<br>\nremove a character, or replace a character. Given two strings, write a function to<br>\ncheck if they are one typo (or zero typos) away.<br>\n<br>\nExamples:<br>\n<br>\npale, ple => true<br>\npales, pale =­> true<br>\npale, bale ­=> true<br>\npale, bake ­=> false\n</html>");
		GridBagConstraints gbc_lbl_question1_desc_1_1 = new GridBagConstraints();
		gbc_lbl_question1_desc_1_1.ipadx = 2;
		gbc_lbl_question1_desc_1_1.anchor = GridBagConstraints.WEST;
		gbc_lbl_question1_desc_1_1.gridwidth = 2;
		gbc_lbl_question1_desc_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_question1_desc_1_1.gridx = 0;
		gbc_lbl_question1_desc_1_1.gridy = 1;
		tb_question3.add(lbl_question1_desc_1_1, gbc_lbl_question1_desc_1_1);
		
		JSeparator separator_1_1 = new JSeparator();
		GridBagConstraints gbc_separator_1_1 = new GridBagConstraints();
		gbc_separator_1_1.ipadx = 2;
		gbc_separator_1_1.gridwidth = 2;
		gbc_separator_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_separator_1_1.gridx = 0;
		gbc_separator_1_1.gridy = 2;
		tb_question3.add(separator_1_1, gbc_separator_1_1);
		
		JLabel lblAnswer_1_1 = new JLabel("SOLUTION:");
		GridBagConstraints gbc_lblAnswer_1_1 = new GridBagConstraints();
		gbc_lblAnswer_1_1.anchor = GridBagConstraints.WEST;
		gbc_lblAnswer_1_1.gridwidth = 2;
		gbc_lblAnswer_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblAnswer_1_1.gridx = 0;
		gbc_lblAnswer_1_1.gridy = 3;
		tb_question3.add(lblAnswer_1_1, gbc_lblAnswer_1_1);
		
		JLabel lblCorrectword_1 = new JLabel("Correct word:");
		GridBagConstraints gbc_lblCorrectword_1 = new GridBagConstraints();
		gbc_lblCorrectword_1.anchor = GridBagConstraints.EAST;
		gbc_lblCorrectword_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblCorrectword_1.gridx = 0;
		gbc_lblCorrectword_1.gridy = 5;
		tb_question3.add(lblCorrectword_1, gbc_lblCorrectword_1);
		
		tf_correctWord3 = new JTextField();
		tf_correctWord3.setToolTipText("Do not forget to insert the correct number of spaces at the end in order to define the correct size of the array");
		tf_correctWord3.setHorizontalAlignment(SwingConstants.LEFT);
		tf_correctWord3.setColumns(50);
		GridBagConstraints gbc_tf_correctWord3 = new GridBagConstraints();
		gbc_tf_correctWord3.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_correctWord3.anchor = GridBagConstraints.WEST;
		gbc_tf_correctWord3.insets = new Insets(0, 0, 5, 5);
		gbc_tf_correctWord3.gridx = 1;
		gbc_tf_correctWord3.gridy = 5;
		tb_question3.add(tf_correctWord3, gbc_tf_correctWord3);
		
		JLabel lblTypoWord = new JLabel("Typo word:");
		GridBagConstraints gbc_lblTypoWord = new GridBagConstraints();
		gbc_lblTypoWord.anchor = GridBagConstraints.EAST;
		gbc_lblTypoWord.insets = new Insets(0, 0, 5, 5);
		gbc_lblTypoWord.gridx = 0;
		gbc_lblTypoWord.gridy = 6;
		tb_question3.add(lblTypoWord, gbc_lblTypoWord);
		
		tf_typoWord = new JTextField();
		tf_typoWord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				q3CheckTypoWord(tf_correctWord3.getText(), tf_typoWord.getText());
			}
		});
		tf_typoWord.setColumns(10);
		GridBagConstraints gbc_tf_typoWord = new GridBagConstraints();
		gbc_tf_typoWord.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_typoWord.insets = new Insets(0, 0, 5, 5);
		gbc_tf_typoWord.gridx = 1;
		gbc_tf_typoWord.gridy = 6;
		tb_question3.add(tf_typoWord, gbc_tf_typoWord);
		
		JButton bt_check3 = new JButton("Check");
		bt_check3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				q3CheckTypoWord(tf_correctWord3.getText(), tf_typoWord.getText());
			}
		});
		GridBagConstraints gbc_bt_check3 = new GridBagConstraints();
		gbc_bt_check3.weightx = 8.0;
		gbc_bt_check3.anchor = GridBagConstraints.WEST;
		gbc_bt_check3.insets = new Insets(0, 5, 5, 0);
		gbc_bt_check3.gridx = 2;
		gbc_bt_check3.gridy = 6;
		tb_question3.add(bt_check3, gbc_bt_check3);
		
		JLabel lblResult_1_1 = new JLabel("RESULT =");
		GridBagConstraints gbc_lblResult_1_1 = new GridBagConstraints();
		gbc_lblResult_1_1.anchor = GridBagConstraints.EAST;
		gbc_lblResult_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblResult_1_1.gridx = 0;
		gbc_lblResult_1_1.gridy = 7;
		tb_question3.add(lblResult_1_1, gbc_lblResult_1_1);
		
		tf_result3 = new JTextField();
		tf_result3.setHorizontalAlignment(SwingConstants.LEFT);
		tf_result3.setEditable(false);
		tf_result3.setColumns(50);
		GridBagConstraints gbc_tf_result3 = new GridBagConstraints();
		gbc_tf_result3.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_result3.anchor = GridBagConstraints.WEST;
		gbc_tf_result3.insets = new Insets(0, 0, 5, 5);
		gbc_tf_result3.gridx = 1;
		gbc_tf_result3.gridy = 7;
		tb_question3.add(tf_result3, gbc_tf_result3);
		
		JScrollPane sp_1_1 = new JScrollPane(ta_logs3);
		GridBagConstraints gbc_sp_1_1 = new GridBagConstraints();
		gbc_sp_1_1.fill = GridBagConstraints.BOTH;
		gbc_sp_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_sp_1_1.gridx = 1;
		gbc_sp_1_1.gridy = 8;
		tb_question3.add(sp_1_1, gbc_sp_1_1);
		
		JPanel tb_question4 = new JPanel();
		tabbedPane.addTab("Question 4", null, tb_question4, null);
		GridBagLayout gbl_tb_question4 = new GridBagLayout();
		gbl_tb_question4.columnWidths = new int[]{0, 0, 0, 0};
		gbl_tb_question4.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_tb_question4.columnWeights = new double[]{1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_tb_question4.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		tb_question4.setLayout(gbl_tb_question4);
		
		JLabel lbl_question1_answer_1_1_1 = new JLabel("4. [Android] Search on a list:");
		GridBagConstraints gbc_lbl_question1_answer_1_1_1 = new GridBagConstraints();
		gbc_lbl_question1_answer_1_1_1.ipadx = 2;
		gbc_lbl_question1_answer_1_1_1.anchor = GridBagConstraints.WEST;
		gbc_lbl_question1_answer_1_1_1.gridwidth = 2;
		gbc_lbl_question1_answer_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_question1_answer_1_1_1.gridx = 0;
		gbc_lbl_question1_answer_1_1_1.gridy = 0;
		tb_question4.add(lbl_question1_answer_1_1_1, gbc_lbl_question1_answer_1_1_1);
		
		JLabel lbl_question1_desc_1_1_1 = new JLabel("<html>\nWrite an application with one activity that shows a list of items and a search box. The<br>\nuser expects that the search returns a result even if word typed is partially permuted<br>\nor it has one typo (like explained on previous problems), but not both.\n</html>");
		GridBagConstraints gbc_lbl_question1_desc_1_1_1 = new GridBagConstraints();
		gbc_lbl_question1_desc_1_1_1.ipadx = 2;
		gbc_lbl_question1_desc_1_1_1.anchor = GridBagConstraints.WEST;
		gbc_lbl_question1_desc_1_1_1.gridwidth = 2;
		gbc_lbl_question1_desc_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_question1_desc_1_1_1.gridx = 0;
		gbc_lbl_question1_desc_1_1_1.gridy = 1;
		tb_question4.add(lbl_question1_desc_1_1_1, gbc_lbl_question1_desc_1_1_1);
		
		JSeparator separator_1_1_1 = new JSeparator();
		GridBagConstraints gbc_separator_1_1_1 = new GridBagConstraints();
		gbc_separator_1_1_1.ipadx = 2;
		gbc_separator_1_1_1.gridwidth = 2;
		gbc_separator_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_separator_1_1_1.gridx = 0;
		gbc_separator_1_1_1.gridy = 2;
		tb_question4.add(separator_1_1_1, gbc_separator_1_1_1);
		
		JLabel lblAnswer_1_1_1 = new JLabel("SOLUTION:");
		GridBagConstraints gbc_lblAnswer_1_1_1 = new GridBagConstraints();
		gbc_lblAnswer_1_1_1.anchor = GridBagConstraints.WEST;
		gbc_lblAnswer_1_1_1.gridwidth = 2;
		gbc_lblAnswer_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblAnswer_1_1_1.gridx = 0;
		gbc_lblAnswer_1_1_1.gridy = 3;
		tb_question4.add(lblAnswer_1_1_1, gbc_lblAnswer_1_1_1);
		
		JPanel tb_question5 = new JPanel();
		tabbedPane.addTab("Question 5", null, tb_question5, null);
		tb_question5.setLayout(null);
		
		JLabel lbl_question1_answer_1_1_1_1 = new JLabel("5. Remove duplicates on email thread:");
		lbl_question1_answer_1_1_1_1.setBounds(0, 0, 230, 17);
		tb_question5.add(lbl_question1_answer_1_1_1_1);
		
		JLabel lbl_question1_desc_1_1_1_1 = new JLabel("<html>\nWhen different email clients are used on a same thread, the discussion get messy<br>\nbecause old messages are included again and get duplicated. Given a email thread<br>\n(represented by a singly unsorted linked list of messages), write a function that<br>\nremove duplicated messages from it.\n</html>");
		lbl_question1_desc_1_1_1_1.setBounds(0, 22, 498, 68);
		tb_question5.add(lbl_question1_desc_1_1_1_1);
		
		JSeparator separator_1_1_1_1 = new JSeparator();
		separator_1_1_1_1.setBounds(567, 95, 2, 2);
		tb_question5.add(separator_1_1_1_1);
		
		JLabel lblAnswer_1_1_1_1 = new JLabel("SOLUTION:");
		lblAnswer_1_1_1_1.setBounds(0, 102, 68, 17);
		tb_question5.add(lblAnswer_1_1_1_1);
		
		JLabel lbl_listFrom = new JLabel("Initial Emails List");
		lbl_listFrom.setBounds(23, 141, 120, 17);
		tb_question5.add(lbl_listFrom);
		
		ta_initialList.setEditable(false);
		ta_initialList.setBounds(18, 162, 125, 291);
		tb_question5.add(ta_initialList);
		
		JLabel lblFinalEmailsList = new JLabel("Final Emails List");
		lblFinalEmailsList.setBounds(161, 141, 120, 17);
		tb_question5.add(lblFinalEmailsList);
		
		ta_finalList.setEditable(false);
		ta_finalList.setBounds(161, 162, 125, 291);
		tb_question5.add(ta_finalList);
		
		JButton bt_RemoveDuplicates = new JButton("Remove Duplicates");
		bt_RemoveDuplicates.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				q5RemoveDuplicates(initLinkedListQuestion5());
			}
		});
		bt_RemoveDuplicates.setBounds(74, 480, 149, 27);
		tb_question5.add(bt_RemoveDuplicates);
		
		JButton bt_Restart = new JButton("Restart");
		bt_Restart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				restartRemoveDuplicated();
			}
		});
		bt_Restart.setBounds(97, 519, 105, 27);
		tb_question5.add(bt_Restart);
		
		ta_logs5.setEditable(false);
		ta_logs5.setBounds(378, 162, 405, 212);
		tb_question5.add(ta_logs5);
		
		JLabel lbl_logs5 = new JLabel("Logs");
		lbl_logs5.setBounds(375, 141, 60, 17);
		tb_question5.add(lbl_logs5);
		
		JPanel tb_question6 = new JPanel();
		tabbedPane.addTab("Question 6", null, tb_question6, null);
		GridBagLayout gbl_tb_question6 = new GridBagLayout();
		gbl_tb_question6.columnWidths = new int[]{0, 0, 0, 0};
		gbl_tb_question6.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_tb_question6.columnWeights = new double[]{1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_tb_question6.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		tb_question6.setLayout(gbl_tb_question6);
		
		JLabel lbl_question1_answer_1_1_1_2 = new JLabel("6. [Android] Email processor service:");
		GridBagConstraints gbc_lbl_question1_answer_1_1_1_2 = new GridBagConstraints();
		gbc_lbl_question1_answer_1_1_1_2.ipadx = 2;
		gbc_lbl_question1_answer_1_1_1_2.anchor = GridBagConstraints.WEST;
		gbc_lbl_question1_answer_1_1_1_2.gridwidth = 2;
		gbc_lbl_question1_answer_1_1_1_2.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_question1_answer_1_1_1_2.gridx = 0;
		gbc_lbl_question1_answer_1_1_1_2.gridy = 0;
		tb_question6.add(lbl_question1_answer_1_1_1_2, gbc_lbl_question1_answer_1_1_1_2);
		
		JLabel lbl_question1_desc_1_1_1_2 = new JLabel("<html>\nWrite an application with one service (no activities) that receive requests from other<br>\napps with an email thread (as a linked­list), applies the previous algorithm and<br>\nreturns a cleaner version of same email thread. Concurrent requests should be<br>\nqueued.\n</html>");
		GridBagConstraints gbc_lbl_question1_desc_1_1_1_2 = new GridBagConstraints();
		gbc_lbl_question1_desc_1_1_1_2.ipadx = 2;
		gbc_lbl_question1_desc_1_1_1_2.anchor = GridBagConstraints.WEST;
		gbc_lbl_question1_desc_1_1_1_2.gridwidth = 2;
		gbc_lbl_question1_desc_1_1_1_2.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_question1_desc_1_1_1_2.gridx = 0;
		gbc_lbl_question1_desc_1_1_1_2.gridy = 1;
		tb_question6.add(lbl_question1_desc_1_1_1_2, gbc_lbl_question1_desc_1_1_1_2);
		
		JSeparator separator_1_1_1_2 = new JSeparator();
		GridBagConstraints gbc_separator_1_1_1_2 = new GridBagConstraints();
		gbc_separator_1_1_1_2.ipadx = 2;
		gbc_separator_1_1_1_2.gridwidth = 2;
		gbc_separator_1_1_1_2.insets = new Insets(0, 0, 5, 5);
		gbc_separator_1_1_1_2.gridx = 0;
		gbc_separator_1_1_1_2.gridy = 2;
		tb_question6.add(separator_1_1_1_2, gbc_separator_1_1_1_2);
		
		JLabel lblAnswer_1_1_1_2 = new JLabel("SOLUTION:");
		GridBagConstraints gbc_lblAnswer_1_1_1_2 = new GridBagConstraints();
		gbc_lblAnswer_1_1_1_2.anchor = GridBagConstraints.WEST;
		gbc_lblAnswer_1_1_1_2.gridwidth = 2;
		gbc_lblAnswer_1_1_1_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblAnswer_1_1_1_2.gridx = 0;
		gbc_lblAnswer_1_1_1_2.gridy = 3;
		tb_question6.add(lblAnswer_1_1_1_2, gbc_lblAnswer_1_1_1_2);
		
		JPanel tb_question7 = new JPanel();
		tb_question7.setLayout(null);
		tabbedPane.addTab("Question 7", null, tb_question7, null);
		
		JLabel lbl_question1_answer_1_1_1_1_1 = new JLabel("7. Linked List Intersection:");
		lbl_question1_answer_1_1_1_1_1.setBounds(0, 0, 230, 17);
		tb_question7.add(lbl_question1_answer_1_1_1_1_1);
		
		JLabel lbl_question1_desc_1_1_1_1_1 = new JLabel("<html>\nIf two requests on the queue have linked lists that intersect (like the example below),<br>\nprevious service could be improved to process only the difference between them.<br>\nWrite a method that receives two singly linked lists and return the intersecting node<br>\nof the two lists (if exists). Note that the intersection is defined by reference, not value.<br>\n(No need to change previous answer).\n</html>");
		lbl_question1_desc_1_1_1_1_1.setBounds(0, 22, 498, 68);
		tb_question7.add(lbl_question1_desc_1_1_1_1_1);
		
		JSeparator separator_1_1_1_1_1 = new JSeparator();
		separator_1_1_1_1_1.setBounds(567, 95, 2, 2);
		tb_question7.add(separator_1_1_1_1_1);
		
		JLabel lblAnswer_1_1_1_1_1 = new JLabel("SOLUTION:");
		lblAnswer_1_1_1_1_1.setBounds(0, 102, 68, 17);
		tb_question7.add(lblAnswer_1_1_1_1_1);
		
		JLabel lbl_list_1 = new JLabel("List 1");
		lbl_list_1.setBounds(23, 141, 120, 17);
		tb_question7.add(lbl_list_1);
		
		ta_list1.setText("");
		ta_list1.setEditable(false);
		ta_list1.setBounds(18, 162, 125, 291);
		tb_question7.add(ta_list1);
		
		JLabel lb_list_2 = new JLabel("List 2");
		lb_list_2.setBounds(161, 141, 120, 17);
		tb_question7.add(lb_list_2);
		
		ta_list2.setEditable(false);
		ta_list2.setBounds(161, 162, 125, 291);
		tb_question7.add(ta_list2);
		
		JButton bt_checkIntersection = new JButton("Check Intersection");
		bt_checkIntersection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				q7CheckIntersection(initLinkedList1Question7(), initLinkedList2Question7());
			}
		});
		bt_checkIntersection.setBounds(154, 480, 149, 27);
		tb_question7.add(bt_checkIntersection);
		
		JButton bt_Restart_7 = new JButton("Restart");
		bt_Restart_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				restartCheckIntersection();
			}
		});
		bt_Restart_7.setBounds(176, 519, 105, 27);
		tb_question7.add(bt_Restart_7);
		
		ta_logs7.setEditable(false);
		ta_logs7.setBounds(524, 162, 405, 212);
		tb_question7.add(ta_logs7);
		
		JLabel lbl_logs7 = new JLabel("Logs");
		lbl_logs7.setBounds(525, 141, 60, 17);
		tb_question7.add(lbl_logs7);
		
		JLabel lb_list1_intersection = new JLabel("List 1 Index Intersection");
		lb_list1_intersection.setBounds(311, 141, 158, 17);
		tb_question7.add(lb_list1_intersection);
		
		tf_list1Intersection.setBounds(311, 160, 187, 21);
		tb_question7.add(tf_list1Intersection);
		tf_list1Intersection.setColumns(10);
		
		JLabel lb_list2_intersection = new JLabel("List 2 Index Intersection");
		lb_list2_intersection.setBounds(311, 221, 158, 17);
		tb_question7.add(lb_list2_intersection);
		
		tf_list2Intersection.setBounds(311, 238, 187, 21);
		tb_question7.add(tf_list2Intersection);
		tf_list2Intersection.setColumns(10);
	}

	/**
	 * Class container for Question7 answer
	 * @author sergio
	 *
	 */
	public class Question7Result {
		private int list1IndexIntersection;
		private int list2IndexIntersection;
		
		public void setList1IndexIntersection(int value) {
			this.list1IndexIntersection = value;
		}
		
		public void setList2IndexIntersection(int value) {
			this.list2IndexIntersection = value;
		}
		
		public int getList1IndexIntersection() {
			return this.list1IndexIntersection;
		}
		
		public int getList2IndexIntersection() {
			return this.list2IndexIntersection;
		}
	}
}

