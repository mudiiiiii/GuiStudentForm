import java.awt.List;
import java.awt.*;
import java.util.*;
import javax.swing.*;
public class StudentForm extends JFrame {
	private JPanel pForm, form1, form2, form3, form4, form5, form6, form7, form8, form9, form10;
	private JLabel lblFullName, lblAddress, lblCity, lblProvince, lblPostalCode, lblPhoneNumber, lblEmail;
	private JTextField txtFullName, txtAddress, txtCity, txtProvince, txtPostalCode, txtPhoneNumber, txtEmail;
	private JButton button;
	private JCheckBox checkBox1, checkBox2;
	private JRadioButton radioButton1, radioButton2;
	private JComboBox courses;
	private JTextArea textArea;
	private ArrayList<String> addedCourses = new ArrayList<>();
	private JList<String> selectedCourses = new JList<>();
	
	public StudentForm() {
		setSize(400, 400);
		setLayout(null);
		pForm = new JPanel();
		pForm.setLayout(null);;
		pForm.setBounds(6,6,740,450);
		add(pForm);
		
		form1 = new JPanel();
		form1.setLayout(null);
		form1.setBounds(10,30, 400, 240);
		pForm.add(form1);

		form2 = new JPanel();
		form2.setLayout(null);
		form2.setBounds(420,18, 150, 100);
		pForm.add(form2);

		form3 = new JPanel();
		form3.setLayout(null);
		form3.setBounds(280, 268, 180, 35);
		pForm.add(form3);

		form4 = new JPanel();
		form4.setLayout(null);
		form4.setBounds(580, 18, 150, 100);
		pForm.add(form4);
        
        form5 = new JPanel();
        form5.setLayout(null);
        form5.setBounds(420, 128, 310, 130);
        form5.setBorder(BorderFactory.createTitledBorder("List of Courses"));
        pForm.add(form5);

        form6 = new JPanel();
        form6.setLayout(null);
        form6.setBounds(10, 300, 720, 140);
        form6.setBorder(BorderFactory.createTitledBorder("List of Courses"));
        pForm.add(form6);

        form7 = new JPanel(new GridLayout(7, 2, -180, 5));
        form7.setBounds(10, 20, 380, 200);
		
		lblFullName = new JLabel("Name: ");
		txtFullName = new JTextField();
        lblAddress = new JLabel("Address: ");
        txtAddress = new JTextField();
        lblCity = new JLabel("City: ");
        txtCity = new JTextField();
        lblProvince = new JLabel("Province: ");
        txtProvince = new JTextField();
        lblPostalCode = new JLabel("Postal Code: ");
        txtPostalCode = new JTextField();
        lblPhoneNumber = new JLabel("Phone Number: ");
        txtPhoneNumber = new JTextField();
        lblEmail = new JLabel("Email: ");
        txtEmail = new JTextField();
        
        form7.add(lblFullName);
        form7.add(txtFullName);
        form7.add(lblAddress);
        form7.add(txtAddress);
        form7.add(lblCity);
        form7.add(txtCity);
        form7.add(lblProvince);
        form7.add(txtProvince);
        form7.add(lblPostalCode);
        form7.add(txtPostalCode);
        form7.add(lblPhoneNumber);
        form7.add(txtPhoneNumber );
        form7.add(lblEmail);
        form7.add(txtEmail);
        form1.add(form7);
        
        form8 = new JPanel(new GridLayout(2, 2, 10, -5));
        form8.setBounds(5, 22, 150, 75);
        
        checkBox1 = new JCheckBox("Student Council");
        checkBox2 = new JCheckBox("Volunteer Work");
        
        form8.add(checkBox1);
        form8.add(checkBox2);
        form2.add(form8);
        
        form9 = new JPanel(new GridLayout(2, 2, 10, -5));
        form9.setBounds(5, 22, 150, 75);
        
        radioButton1 = new JRadioButton("Computer Science");
        radioButton1.setSelected(true);
        radioButton2 = new JRadioButton("Business");
        
        radioButton1.addActionListener(event -> radioClicked());
        radioButton2.addActionListener(event -> radioClicked());
        
        ButtonGroup bGroup = new ButtonGroup();
        bGroup.add(radioButton1);
        bGroup.add(radioButton2);
        
        form9.add(radioButton1);
        form9.add(radioButton2);
        form4.add(form9);
        
        form10 = new JPanel(new GridLayout(1, 1));
        form10.setBounds(9, 22, 280, 25);
        
        courses = new JComboBox();
        
        form10.add(courses);
        
        button = new JButton("Display");
        button.setBounds(60, 5, 80, 25);
        
        form3.add(button);
        courses.addActionListener(event -> courseAdded());
        button.addActionListener(event -> displayClicked());
        
        textArea = new JTextArea();
        textArea.setLineWrap(true);
        form5.add(form10);
        
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(10, 20, 700, 110);
        textArea.setEditable(false);
        
        form6.add(scrollPane);
        
        selectedCourses.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        JScrollPane paneCourses = new JScrollPane(selectedCourses);
        paneCourses.setBounds(10, 60, 280, 60);
        form5.add(paneCourses);
        
        
        
        
	}

	private void displayClicked() {
		 String fName = txtFullName.getText();
	        String address = txtAddress.getText();
	        String city = txtCity.getText();
	        String province = txtProvince.getText();
	        String postalCode = txtPostalCode.getText();
	        String phoneNumber = txtPhoneNumber.getText();
	        String email = txtEmail.getText();
	        
	        try {
	            if(
	                    fName == null || fName.isEmpty() ||
	                            address == null || address.isEmpty() ||
	                            city == null || city.isEmpty() ||
	                            province == null || province.isEmpty() ||
	                            postalCode == null || postalCode.isEmpty() ||
	                            phoneNumber == null || phoneNumber.isEmpty() ||
	                            email == null || email.isEmpty()
	                    )
	            {
	                JOptionPane.showMessageDialog(null, "You have to fill out the form! ");
	            }
	            else
	            {
	                textArea.append(
	                         fName + " " +
	                                address  + " "+
	                                 city  + " " +
	                                 province + " " +
	                                 postalCode + " " +
	                                 phoneNumber + " " +
	                                email + "\n");
	                for (String course : addedCourses){
	                    textArea.append(String.format("    - %s\n", course));
	                }

	            }


	        } catch (Exception e){}

	    }


	private void courseAdded() {
		try {
            if(courses.getSelectedItem()!=null){
                addedCourses.add(courses.getSelectedItem().toString());
                }

            String[] arrayCourses = new String[addedCourses.size()];

            for (int i = 0; i < addedCourses.size(); i++) {
                arrayCourses[i] = addedCourses.get(i);
            }

            selectedCourses.setListData(arrayCourses);
        }catch (Exception e){}

    }
	

	private void radioClicked() {
		 try {
	            if(radioButton1.isSelected()){
	                courses.removeAllItems();
	                courses.addItem("Course: ");
	                courses.addItem("Java");
	                courses.addItem("Python");
	                courses.addItem("C#");
	            }
	            if(radioButton2.isSelected()){
	                courses.removeAllItems();
	                courses.addItem("Course: ");
	                courses.addItem("Marketing");
	                courses.addItem("Accounting");
	                courses.addItem("Finance");
	            }

	        }catch (Exception e){}
	}

}
