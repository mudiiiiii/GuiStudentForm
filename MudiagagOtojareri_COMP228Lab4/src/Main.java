import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) {
		StudentForm studentform = new StudentForm();
		studentform.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		studentform.setSize(770, 500);
		studentform.setVisible(true);
		studentform.setLocationRelativeTo(null);
	}

}
