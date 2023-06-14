/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PDC;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author yuhwankim
 */
public class BookingSystem extends JFrame {

    private int height = 400; //Frame height
    private int width = 400; //Frame width

    private JMenuBar menuBar;
    private JMenuItem exitMenu;

    private int confirm; //confirm the hotel which is being booked

    private final Hotel selectedHotel;
    private Guest guest;

    private JPanel mainPanel;
    private JPanel lastNamePanel;
    private JPanel firstNamePanel;
    private JPanel emailPanel;
    private JPanel mobilePanel;
    private JPanel nullWarning;
    private JPanel checkInPanel;
    private JPanel checkOutPanel;

    private JTextField lastNameTextField;
    private JTextField firstNameTextField;
    private JTextField emailTextField;
    private JTextField mobileTextField;
    private JTextField checkInTextField;
    private JTextField checkOutTextField;

    private JLabel nullWarningLabel;

    private JButton submitButton;
    private BookingResultFrame bookingResultFrame;

    public BookingSystem(Hotel selectedHotel) {
        this.selectedHotel = selectedHotel;
        this.setTitle("Check booking");
        this.dispose();
        this.setSize(width, height);
        this.setResizable(false);
        setLocationRelativeTo(null);
        this.setVisible(true);
        this.setLayout(new BorderLayout());

        menuBar = new JMenuBar();
        exitMenu = new JMenuItem("Exit"); //program exit menu item
        menuBar.add(exitMenu);
        this.setJMenuBar(menuBar);

        exitMenu.addActionListener(new CheckFrame.exit());

        confirm = JOptionPane.showConfirmDialog(null, "Please confirm the hotel again. Hotel: " + selectedHotel.getName(), "Confirmation", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.NO_OPTION) {
            this.dispose(); //exit the window to select again       
        }

        JLabel notice = new JLabel("Please fill the information");

        notice.setBounds(125, -30, 200, 100);
        notice.setVisible(true);
        this.add(notice);

        

        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        lastNameTextField = new JTextField(20);
        lastNamePanel = createQuestions("Last Name:", lastNameTextField);
        lastNamePanel.setAlignmentX(0.5f); // Align center horizontally
        mainPanel.add(lastNamePanel);
        

        firstNameTextField = new JTextField(20);
        firstNamePanel = createQuestions("First Name:", firstNameTextField);
        firstNamePanel.setAlignmentX(0.5f); // Align center horizontally
        mainPanel.add(firstNamePanel);
        

        emailTextField = new JTextField(20);
        emailPanel = createQuestions("E-mail Address:", emailTextField);
        emailPanel.setAlignmentX(0.5f); // Align center horizontally
        mainPanel.add(emailPanel);
       

        mobileTextField = new JTextField(20);
        mobilePanel = createQuestions("Mobile:", mobileTextField);
        mobilePanel.setAlignmentX(0.5f); // Align center horizontally
        mainPanel.add(mobilePanel);
        mainPanel.add(Box.createVerticalGlue());

        checkInTextField = new JTextField(20);
        checkInPanel = createQuestions("Check-in Date(dd/mm/yyyy) : ", checkInTextField);
        checkInPanel.setAlignmentX(0.5f);
        mainPanel.add(checkInPanel);
        mainPanel.add(Box.createVerticalGlue());
        

        checkOutTextField = new JTextField(20);
        checkOutPanel = createQuestions("Check-out Date(dd/mm/yyyy) : ", checkOutTextField);
        checkOutPanel.setAlignmentX(0.5f);
        mainPanel.add(checkOutPanel);
        mainPanel.add(Box.createVerticalGlue());

        submitButton = new JButton("Submit");
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(submitButton);
        this.add(buttonPanel, BorderLayout.SOUTH);
        this.add(mainPanel, BorderLayout.CENTER);

        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                guest = new Guest();
                if (lastNameTextField.getText() != null && !lastNameTextField.getText().isEmpty()
                        && firstNameTextField.getText() != null && !firstNameTextField.getText().isEmpty()
                        && emailTextField.getText() != null && !emailTextField.getText().isEmpty()
                        && mobileTextField.getText() != null && !mobileTextField.getText().isEmpty()
                        && isDateFormatValid(checkInTextField.getText()) && isDateFormatValid(checkOutTextField.getText())) {

                    guest.setLastName(lastNameTextField.getText());
                    guest.setFirstName(firstNameTextField.getText());
                    guest.setEmail(emailTextField.getText());
                    guest.setMobile(mobileTextField.getText());

                    String checkInDateStr = checkInTextField.getText();
                    String checkOutDateStr = checkOutTextField.getText();

            LocalDate checkInDate = LocalDate.parse(checkInDateStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            LocalDate checkOutDate = LocalDate.parse(checkOutDateStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

            guest.setCheckInDate(checkInDateStr);
            guest.setCheckOutDate(checkOutDateStr);
            guest.setTotalPrice(selectedHotel.getCosts(),guest.getNights()); 
            guest.setSelectedHotelName(selectedHotel.getName());

                    bookingResultFrame = new BookingResultFrame(guest);
                    bookingResultFrame.setVisible(true);

                } else {
                    JOptionPane.showMessageDialog(null, "Please fill in all fields and enter valid date format (dd/mm/yyyy).");
                }
            }
        });

        this.setVisible(true);
    }

    private JPanel createQuestions(String labelText, JTextField textField) {
        JPanel panel = new JPanel();
        FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT, 0, 0);
        panel.setLayout(flowLayout);
        panel.add(new JLabel(labelText));
        panel.add(textField);
        return panel;
    }

    private boolean isDateFormatValid(String date) {
        try {
            LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }
}
