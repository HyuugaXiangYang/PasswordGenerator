import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;


public class PasswordGeneratorGUI extends JFrame {
    private PasswordGenerator passwordGenerator;
    public PasswordGeneratorGUI(){
        super("Password Generator");

        setSize(540, 570);

        setResizable(false);

        setLayout(null);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        passwordGenerator = new PasswordGenerator();

        addGUIcomponent();


    }

    private void addGUIcomponent(){
        //Label
        JLabel titleLabel = new JLabel("Password Generator");

        titleLabel.setFont(new Font("Dialog", Font.BOLD, 32));

        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        titleLabel.setBounds(0, 10, 540, 39);
        
        add(titleLabel);


        //text area

        JTextArea passwordOutput = new JTextArea();

        passwordOutput.setEditable(false);
        passwordOutput.setFont(new Font("Dialog", Font.BOLD, 32));


        //scorllability

        JScrollPane passwordOutputPane = new JScrollPane(passwordOutput);
        passwordOutputPane.setBounds(25, 97, 479, 70);

        passwordOutputPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(passwordOutputPane);


        //create password length label

        JLabel passwordLengthLabel = new JLabel("Password Length: ");
        passwordLengthLabel.setFont(new Font("Dialog", Font.PLAIN, 32));
        passwordLengthLabel.setBounds(25, 215, 272, 39);
        add(passwordLengthLabel);

        //password length input
        JTextArea passwordLengthInputArea = new JTextArea();
        passwordLengthInputArea.setFont(new Font("Dialog", Font.PLAIN, 32));
        passwordLengthInputArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        passwordLengthInputArea.setBounds(310, 215, 192, 39);
        add(passwordLengthInputArea);






        //toggle buttons
        //uppercase
        JToggleButton uppercaseToggle = new JToggleButton("Uppercase");
        uppercaseToggle.setBounds(25, 302, 225, 56);
        uppercaseToggle.setFont(new Font("Dialog", Font.PLAIN, 24));
        add(uppercaseToggle);

        //lowercase
        JToggleButton lowercaseToggle = new JToggleButton("Lowercase");
        lowercaseToggle.setBounds(282, 302, 225, 56);
        lowercaseToggle.setFont(new Font("Dialog", Font.PLAIN, 24));
        add(lowercaseToggle);

        //number
        JToggleButton numberToggle = new JToggleButton("Number");
        numberToggle.setBounds(25, 373, 225, 56);
        numberToggle.setFont(new Font("Dialog", Font.PLAIN, 24));
        add(numberToggle);

        //symbols toggle
        JToggleButton symbolsToggle = new JToggleButton("Symbols");
        symbolsToggle.setBounds(282, 373, 225, 56);
        symbolsToggle.setFont(new Font("Dialog", Font.PLAIN, 24));
        add(symbolsToggle);



        // create password button
        JButton generateButton = new JButton("Generate");
        generateButton.setFont(new Font("Dialog", Font.PLAIN, 32));
        generateButton.setBounds(155, 477, 222, 41);
        
       
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // validation: generate a password only when length > 0 and one of the toggled buttons is pressed
                if(passwordLengthInputArea.getText().length() <= 0) return;
                boolean anyToggleSelected = lowercaseToggle.isSelected() ||
                        uppercaseToggle.isSelected() ||
                        numberToggle.isSelected() ||
                        symbolsToggle.isSelected();

                // generate password
                // converts the text to an integer value
                int passwordLength = Integer.parseInt(passwordLengthInputArea.getText());
                if(anyToggleSelected){
                    String generatedPassword = passwordGenerator.generatePassword(passwordLength,
                            uppercaseToggle.isSelected(),
                            lowercaseToggle.isSelected(),
                            numberToggle.isSelected(),
                            symbolsToggle.isSelected());

                    // display password back to the user
                    passwordOutput.setText(generatedPassword);
                }
            }
        });
       
        add(generateButton);
        














    }













}
