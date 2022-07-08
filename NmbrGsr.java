import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;
import javax.swing.text.WrappedPlainView;
import  java.util.concurrent.TimeUnit;


public class Main implements ActionListener {
    // frame
    public static JFrame frame;

    // Panels
    public static JPanel buttonsPanel;
    public static JPanel questionPanel;
    public static JPanel mainPanel;
    public static JPanel answerPanel;


    // buttons
    public static JButton btnBigger;
    public static JButton btnLower;
    public static JButton btnFound;
    public static JButton btnClear;

    // labels
    public static JLabel questionLabel;
    public static JLabel guessLabel;

    // vatiables for the data being collected
    public static int CLow = 0;
    public static int CHigh = 999;
    public static int guess = 0;
    public static int attempts = 0;

    // start the random object
    public static Random rand= new Random();

    public static void main(String[] args){
        // make a random guess
        guess = rand.nextInt((CHigh - CLow) + 1) + CLow;

        // frame init
        frame = new JFrame();

        // panel init
        buttonsPanel = new JPanel();
        questionPanel = new JPanel();
        answerPanel = new JPanel();
        mainPanel = new JPanel();

        // buttons init
        btnBigger = new JButton("Greater");
        btnLower = new JButton("Lower");
        btnFound = new JButton("Found!");
        btnClear = new JButton("Reset");

        // label init
        questionLabel = new JLabel("is this your number?");
        guessLabel = new JLabel(String.valueOf(guess));

        // frame setup
        frame.setSize(300,150);
        frame.setTitle("Number Guesser");

        // creating layout for main panel
//        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // creating action listener
        ActionListener al = new Main();

        // assigning action listerner
        btnBigger.addActionListener(al);
        btnLower.addActionListener(al);
        btnFound.addActionListener(al);
        btnClear.addActionListener(al);

        // adding components to panels
        // textPanel
        questionPanel.add(questionLabel);
        answerPanel.add(guessLabel);

        // Buttons Panel
        buttonsPanel.add(btnBigger);
        buttonsPanel.add(btnLower);
        buttonsPanel.add(btnFound);
//        buttonsPanel.add(btnClear);


        //adding sub panels to main panel
        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(questionPanel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        mainPanel.add(answerPanel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        mainPanel.add(buttonsPanel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        mainPanel.add(btnClear,gbc );

        // adding main panel to main
        frame.add(mainPanel);

        // frame stuff
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnBigger){
            // if the number is greater than
            // print
            questionLabel.setText("okay got it! What about this?");
            // reduce the searching field
            CLow = guess;
            // make new guess based on smaller range
            guess = rand.nextInt((CHigh - CLow) + 1) + CLow;
            // print the guess
            guessLabel.setText(String.valueOf(guess));
            // incr attempts
            attempts++;
        }

        if (e.getSource() == btnLower){
            // same as previous example
            questionLabel.setText("okay got it! What about this?");
            CHigh = guess;
            guess = rand.nextInt((CHigh - CLow) + 1) + CLow;
            guessLabel.setText(String.valueOf(guess));
            attempts++;
        }

        if (e.getSource() == btnFound){
            // print the number of attempts it took before finding number
            questionLabel.setText("Number Was found in " + attempts + " attempts");
        }

        if (e.getSource() == btnClear){
            // make a sound
            Toolkit.getDefaultToolkit().beep();

            // inform user
            questionLabel.setText("Search was reset, is this your number?");

            // reset everything and make a new guess
            guess = rand.nextInt((CHigh - CLow) + 1) + CLow;
            guessLabel.setText(String.valueOf(guess));
            CHigh = 999;
            CLow = 0;
            attempts = 0;
        }

    }
}