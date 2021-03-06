package autoBus;

/**
 * @author IT-1X-A16 Group 1: Mogens Bjerregaard, Adam Kounis, Eugene Maloman, Nicolai Onov
 *
 */
import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;

public class Autobus extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JMenuItem mntmAboutAutobus;
	private JMenuItem mntmExit;
	private ImageIcon icon;
	
	private ChauffeursArchive chauffeursArchive;
	private BusesArchive busesArchive;
	private ToursArchive toursArchive;
	private JMenuItem mntmTourReservations;
	private JMenuItem mntmBusReservations;
	private JPanel panelTourReservations;
	private JPanel panelBusReservations;
	private JPanel panelChauffeurs;
	private JMenuItem mntmEditChauffeur;
	private JTable tableChauffeurs;
	private JLabel lblAddChauffeurButton;
	private JTextField textFieldChauffeurName;
	private JTextField textFieldChauffeurAddress;
	private JTextField textFieldEmployeeNo;
	private JTextField textFieldChauffeurEmail;
	private JTextField textFieldChauffeurPhone;
	private JTextField textFieldChauffeurBirthMonth;
	private JTextField textFieldChauffeurBirthDay;
	private JTextField textFieldChauffeurBirthYear;
	private JCheckBox chckbxExternalEmployee;
	private JCheckBox chckbxOnlyOneDayTrips;
	private DefaultTableModel chauffeursTable;
	private JLabel lblDeleteChauffeurBtn;
	private JPanel panelBuses;
	private JMenuItem mntmEditBus;
	private JPanel panelTours;
	private JMenuItem mntmEditTours;
	private JMenuItem mntmEditCustomers;
	private JPanel panelCustomers;
	private JMenuItem mntmPassengers;
	private JPanel panelPassengers;
	private JMenuItem mntmNewTourReservation;
	private JPanel panelNewTourReservation;
	private JMenuItem mntmNewBusReservation;
	private JPanel panelNewBusReservation;
	private JTable tableBuses;
	private DefaultTableModel busesTable;
	private JLabel labelAddBusBtn;
	private JTextField textFieldVehicleID;
	private JTextField textFieldPriceHour;
	private JTextField textFieldNumberSeats;
	private JRadioButton rdbtnStandardBus;
	private JRadioButton rdbtnPartyBus;
	private JRadioButton rdbtnLuxuryBus;
	private JLabel labelDeleteBusBtn;
	private JPanel panelAddTour;
	private JTextField textFieldDestination;
	private JTextField textFieldAddPickup;
	private JList list;
	private JLabel lblStartDate;
	private JTextField textFieldStartMonth;
	private JTextField textFieldStartDay;
	private JTextField textFieldStartYear;
	private JLabel lblEndDate;
	private JTextField textFieldEndMonth;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblClearPickUpBtn;
	private JList listSelectBus;
	private JList listSelectChauffeur;
	private JLabel lblAddTourBtn;
	private JLabel lblDeleteTourBtn;
	private JCheckBox chckbxBreakfast;
	private JCheckBox chckbxAllInclusive;
	private JCheckBox chckbxLunch;
	private JTable tablePassengersForNewReservation;
	private DefaultTableModel passengersTableModelForNewReservation;
	private JTextField searchPassengersTextField;
	private JTable tableCustomersForNewReservation;
	private DefaultTableModel customersTableModelForNewReservation;
	private JTextField searchCustomerTextField;
	private JTable tableToursForNewReservation;
	private DefaultTableModel toursTableModelForNewReservation;
	private JTextField searchTourTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() ->{
			Autobus frame = null;
			try {
				frame = new Autobus();
			} catch (Exception e) {
				e.printStackTrace();
			}
			frame.setVisible(true);
		});
		
	}


	public Autobus() throws Exception {
		
			
		initComponents();
		createEvents();
		loadArchives();

	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////
	// This method contains all code for loading the archives
	///////////////////////////////////////////////////////////////////////////////////////////////////////
	private void loadArchives() throws Exception {
		
		chauffeursArchive = new ChauffeursArchive();
		if (chauffeursArchive.isFileFound()) {
			chauffeursArchive.loadChauffeursArchive();
			listChauffeurs();
		} else {
			chauffeursArchive.createFile();
			listChauffeurs();
		}
			
		busesArchive = new BusesArchive();		
		if (busesArchive.isFileFound()){
			busesArchive.loadBusesArchive();
			listBuses();
		} else {
			busesArchive.createFile();
			listBuses();
		}
		
		
	}


	////////////////////////////////////////////////////////////////////////////////////////////////////////
	// This method contains all code for creating events
	///////////////////////////////////////////////////////////////////////////////////////////////////////
	private void createEvents() {
		
		mntmAboutAutobus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "autobus\u00AE\nBus Transportation Management System version 1.0\n\nDeveloped by:\n"+
			"Mogens Bjerregaard, Nick Onov, Eugene Maloman, and Adam Kounis\n\n\u00A9 2016. All rights reserved.", "About autobut\u00AE", JOptionPane.INFORMATION_MESSAGE, icon);
			}
		});
		
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		mntmTourReservations.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hideAllPanels();
				panelTourReservations.setVisible(true);
			}
		});
		
		mntmBusReservations.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hideAllPanels();
				panelBusReservations.setVisible(true);
			}
		});
		
		mntmEditChauffeur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hideAllPanels();
				panelChauffeurs.setVisible(true);
			}
		});
		
		lblAddChauffeurButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				String str = new String("");
				int month = 0;
				int day = 0;
				int year = 0;
				Calendar timeNow = Calendar.getInstance();
				int currentYear = timeNow.get(Calendar.YEAR);
				int phone=0;
				
				if (textFieldEmployeeNo.getText().equals("")) str = str + "\nEmployee number seems to be empty!";
				if (textFieldChauffeurName.getText().equals("")) str = str + "\nName seems to be empty!";
				if (textFieldChauffeurAddress.getText().equals("")) str = str + "\nAddress seems to be empty!";
				if (!(textFieldChauffeurEmail.getText().contains("@")&&textFieldChauffeurEmail.getText().contains("."))){
					str = str+"\nEmail does not seem to be in correct format!";
				}
				try {
					month = Integer.parseInt(textFieldChauffeurBirthMonth.getText());
					if (month>12||month<1) str = str + "\nMonth does not seem to be a number between 1-12!";
				} catch (NumberFormatException e1) {
					str = str + "\nMonth does not seem to be a number between 1-12!";
				}
				try {
					day = Integer.parseInt(textFieldChauffeurBirthDay.getText());
					if (month==1||month==3||month==5||month==7||month==8||month==10||month==12) {
						if (!(1<=day&&day<=31)) {
							str = str + "\nDay does not seem to be a number between 1-31!";
						}
					} else if (month==2){
						if (!(1<=day&&day<=28)) {
							str = str + "\nDay does not seem to be a number between 1-28!";
						}
					} else if (month==4||month==6||month==9||month==11){
						if (!(1<=day&&day<=30)) {
							str = str + "\nDay does not seem to be a number between 1-30!";
						}
					}
				} catch (NumberFormatException e1) {
					str = str + "\nDay does not seem to be a number between 1-31!";
				}
				try {
					year = Integer.parseInt(textFieldChauffeurBirthYear.getText());
					if (year>currentYear-17||year<currentYear-90) str = str + "\nYear does not appear to be a valid number!";
				} catch (NumberFormatException e1) {
					str = str + "\nYear does not appear to be a valid number!";
				}
				try {
					phone = Integer.parseInt(textFieldChauffeurPhone.getText());
					if (phone>99999999) {
						str = str + "\nPhone number appears to have too many digits!";
					}
					if (phone<10000000) {
						str = str + "\nPhone number appears to have too few digits!";
					}
				} catch (Exception e) {
					str = str + "\nPhone number does not appear to be a number!";
				}
				
				if (str.equals("")) {
					
					chauffeursArchive.addChauffeur(new Chauffeur(textFieldChauffeurName.getText(), textFieldChauffeurEmail.getText(), 
							textFieldChauffeurAddress.getText(), month, day, year, 
							Integer.toString(phone), textFieldEmployeeNo.getText(), chckbxExternalEmployee.isSelected(), 
							chckbxOnlyOneDayTrips.isSelected()));
					updateListChauffeurs(textFieldEmployeeNo.getText(), chckbxExternalEmployee.isSelected(), textFieldChauffeurName.getText(), 
							textFieldChauffeurAddress.getText(), textFieldChauffeurEmail.getText(), textFieldChauffeurPhone.getText(), 
							month+"/"+day+"/"+year , chckbxOnlyOneDayTrips.isSelected());
					textFieldChauffeurName.setText("");
					textFieldChauffeurEmail.setText("");
					textFieldChauffeurAddress.setText("");
					textFieldChauffeurBirthMonth.setText("");
					textFieldChauffeurBirthDay.setText("");
					textFieldChauffeurBirthYear.setText("");
					textFieldChauffeurPhone.setText("");
					textFieldEmployeeNo.setText("");
					chckbxExternalEmployee.setSelected(false);
					chckbxOnlyOneDayTrips.setSelected(false);
					try {
						chauffeursArchive.saveChauffeursArchive();
					} catch (Exception e) {
						
						e.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(null, "You have to fill out the fields correct:\n"+str);
				}
			
			}
		});
		
		lblDeleteChauffeurBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				int index = tableChauffeurs.getSelectedRow();
				if (index!=-1){
					chauffeursTable.removeRow(index);
					chauffeursArchive.removeChauffeur(index);
					try {
						chauffeursArchive.saveChauffeursArchive();
					} catch (Exception e) {
					
						e.printStackTrace();
					}				
				} else {
					JOptionPane.showMessageDialog(null, "You need first to select the row you wish to delete!");
				}
			}
		});
		
		mntmEditBus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				hideAllPanels();
				panelBuses.setVisible(true);
			}
		});
		
		mntmEditTours.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				hideAllPanels();
				panelTours.setVisible(true);
			}
		});
		
		mntmEditCustomers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hideAllPanels();
				panelCustomers.setVisible(true);
			}
		});
		
		mntmPassengers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				hideAllPanels();
				panelPassengers.setVisible(true);
			}
		});
		
		mntmNewTourReservation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hideAllPanels();
				panelNewTourReservation.setVisible(true);
			}
		});
		
		mntmNewBusReservation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hideAllPanels();
				panelNewBusReservation.setVisible(true);
			}
		});
		
		labelAddBusBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				String str = new String("");
				double priceHour = 0;
				int maxSeats = 0;
				String modelType= new String("");
				if (textFieldVehicleID.getText().equals("")){
					str = str + "\nVehicle ID appears to be empty!";
				}
				if (textFieldPriceHour.getText().equals("")){
					str = str + "\nPrice per hour appears to be empty!";
				}
				try { 
					priceHour = Double.parseDouble(textFieldPriceHour.getText());
					if (priceHour<0){
						str = str + "\nThe price per hour must be possitive!";
					}
					
				} catch (Exception e2) {
					str = str + "\nThe price per hour does not appear to be a number!";
				}
				if (textFieldNumberSeats.getText().equals("")){
					str = str + "\nNumber of seats cannot be empty!";
				}
				try {
					maxSeats = Integer.parseInt(textFieldNumberSeats.getText());
					if (maxSeats<5){
						str = str + "\nNumber of seats entered may be too small!";
					}
					if (maxSeats>80){
						str = str + "\nNumber of seats enteret may be too high!";
					}
				} catch (Exception e2) {
					str = str + "\nNumber of seats must be a number!";
				}
				if (!(rdbtnStandardBus.isSelected()||rdbtnLuxuryBus.isSelected()||rdbtnPartyBus.isSelected())){
					str = str + "\nBus modeltype must be selected!";
				}
				if (rdbtnStandardBus.isSelected()){
					modelType="STANDARD";
				}
				if (rdbtnLuxuryBus.isSelected()){
					modelType="LUXURY";
				}
				if (rdbtnPartyBus.isSelected()){
					modelType="PARTY";
				}
				
				if (str.equals("")){
					busesArchive.addBus(new Bus(maxSeats, textFieldVehicleID.getText(), priceHour, modelType));
					updateListBuses(textFieldVehicleID.getText(), priceHour, maxSeats, maxSeats, modelType, true);
					textFieldVehicleID.setText("");
					textFieldPriceHour.setText("");
					textFieldNumberSeats.setText("");
					rdbtnStandardBus.setSelected(false);
					rdbtnLuxuryBus.setSelected(false);
					rdbtnPartyBus.setSelected(false);
					
					try {
						busesArchive.saveBusesArchive();
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(null, "You have to fill out the fields correct:\n"+str);
				}
			}
		});
		
		rdbtnStandardBus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rdbtnLuxuryBus.setSelected(false);
				rdbtnPartyBus.setSelected(false);
			}
		});
		
		rdbtnPartyBus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnLuxuryBus.setSelected(false);
				rdbtnStandardBus.setSelected(false);
			}
		});
		
		rdbtnLuxuryBus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnPartyBus.setSelected(false);
				rdbtnStandardBus.setSelected(false);
			}
		});
		
		labelDeleteBusBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				int index = tableBuses.getSelectedRow();
				if (index!=-1){
					if (okOrCancel("Are you sure you want to delete this bus?")==0) {
						busesTable.removeRow(index);
						busesArchive.removeBus(index);
						try {
							busesArchive.saveBusesArchive();
						} catch (Exception e2) {
						
							e2.printStackTrace();
						}				
					}
				} else {
					JOptionPane.showMessageDialog(null, "You need first to select the row you wish to delete!");
				}
			}
		});
		
		chckbxBreakfast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				chckbxAllInclusive.setSelected(false);		
			}
		});
		
		chckbxLunch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chckbxAllInclusive.setSelected(false);
			}
		});
		
		chckbxAllInclusive.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chckbxBreakfast.setSelected(false);
				chckbxLunch.setSelected(false);
			}
		});
		
	}
	
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////
	// This method contains all code for prompting the user for a ok / cancel message
	///////////////////////////////////////////////////////////////////////////////////////////////////////
	public static int okOrCancel(String alertMessage) {
	    int result = JOptionPane.showConfirmDialog((Component) null, alertMessage,
	        "Caution", JOptionPane.OK_CANCEL_OPTION);
	    return result;
	  }
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////
	// This method contains all code for adding all chauffeurs from file archive to table of chauffeurs
	///////////////////////////////////////////////////////////////////////////////////////////////////////
	public void listChauffeurs(){
		chauffeursTable = (DefaultTableModel) tableChauffeurs.getModel();
		Object[] rowData = new Object[8];
		for (int i=0; i<chauffeursArchive.size(); i++){
			rowData[0] = chauffeursArchive.get(i).getEmployeeNumber();
			rowData[1] = chauffeursArchive.get(i).isExternalEmployee();
			rowData[2] = chauffeursArchive.get(i).getName();
			rowData[3] = chauffeursArchive.get(i).getAddress();
			rowData[4] = chauffeursArchive.get(i).getEmail();
			rowData[5] = chauffeursArchive.get(i).getPhonenumber();
			rowData[6] = chauffeursArchive.get(i).getBirthDay();
			rowData[7] = chauffeursArchive.get(i).isOnlyOneDayTrips();
			chauffeursTable.addRow(rowData);			
		}
		
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////
	// This method contains all code for updating the chauffeurs list
	///////////////////////////////////////////////////////////////////////////////////////////////////////
	public void updateListChauffeurs(String employeeNumber, boolean externalEmployee, String name, String address, String email, String phonenumber, String birthDay, boolean onlyOneDayTrips){
		Object[] rowData = new Object[8];		
			rowData[0] = employeeNumber;
			rowData[1] = externalEmployee;
			rowData[2] = name;
			rowData[3] = address;
			rowData[4] = email;
			rowData[5] = phonenumber;
			rowData[6] = birthDay;
			rowData[7] = onlyOneDayTrips;
			chauffeursTable.addRow(rowData);			
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////
	// This method contains all code for adding all buses from file archive to table of buses
	///////////////////////////////////////////////////////////////////////////////////////////////////////
	public void listBuses(){
		busesTable = (DefaultTableModel) tableBuses.getModel();
		Object[] rowData = new Object[6];
		for (int i=0; i<busesArchive.size(); i++){
		rowData[0] = busesArchive.get(i).getVehicleID();
		rowData[1] = busesArchive.get(i).getPricePerHour();
		rowData[2] = busesArchive.get(i).getMaxNumberOfSeats();
		rowData[3] = busesArchive.get(i).getSeatsAvailable();
		rowData[4] = busesArchive.get(i).getModelString();
		rowData[5] = busesArchive.get(i).isAvailableForTours();
		busesTable.addRow(rowData);			
	}
	
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////
	// This method contains all code for updating the buses list
	///////////////////////////////////////////////////////////////////////////////////////////////////////
	public void updateListBuses(String vehicleId, double pricePerHour, int maxSeats, int availableSeats, String model, boolean availableForTours){
		Object[] rowData = new Object[6];
		rowData[0] = vehicleId;
		rowData[1] = pricePerHour;
		rowData[2] = maxSeats;
		rowData[3] = availableSeats;
		rowData[4] = model;
		rowData[5] = availableForTours;
		busesTable.addRow(rowData);				
	}
	
	public void listTours(){
		toursTableModelForNewReservation = (DefaultTableModel) tableToursForNewReservation.getModel();
		Object[] rowData = new Object[6];
		for (int i=0; i<reservationsArchive.size(); i++){
		rowData[0] = busesArchive.get(i).getVehicleID();
		rowData[1] = busesArchive.get(i).getPricePerHour();
		rowData[2] = busesArchive.get(i).getMaxNumberOfSeats();
		rowData[3] = busesArchive.get(i).getSeatsAvailable();
		rowData[4] = busesArchive.get(i).getModelString();
		rowData[5] = busesArchive.get(i).isAvailableForTours();
		toursTableModelForNewReservation.addRow(rowData);			
		}
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////
	// This method contains all code for creating and initializing components
	///////////////////////////////////////////////////////////////////////////////////////////////////////
	private void initComponents() {
		icon = new ImageIcon(Autobus.class.getResource("/ressources/icon_bus.png"));
		
		getContentPane().setBackground(new Color(0, 128, 128));
		
		setBackground(new Color(32, 178, 170));
		setTitle("autobus\u00AE - Bus Transportation Management System");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Autobus.class.getResource("/ressources/icon_bus.png")));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setMargin(new Insets(3, 3, 3, 3));
		menuBar.setForeground(new Color(255, 255, 255));
		menuBar.setBackground(new Color(32, 178, 170));
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		mnFile.setForeground(new Color(255, 255, 255));
		menuBar.add(mnFile);
		
		mntmNewTourReservation = new JMenuItem("New Tour reservation");
		mnFile.add(mntmNewTourReservation);
		
		mntmNewBusReservation = new JMenuItem("New Bus reservation");
		mnFile.add(mntmNewBusReservation);
		
		mntmExit = new JMenuItem("Exit");
		
		mnFile.add(mntmExit);
		
		JMenu mnEdit = new JMenu("Edit");
		mnEdit.setForeground(new Color(255, 255, 255));
		menuBar.add(mnEdit);
		
		mntmEditBus = new JMenuItem("Buses");
		
		mnEdit.add(mntmEditBus);
		
		mntmEditChauffeur = new JMenuItem("Chauffeurs");
	
		mnEdit.add(mntmEditChauffeur);
		
		mntmEditCustomers = new JMenuItem("Customers");
		mnEdit.add(mntmEditCustomers);
		
		mntmPassengers = new JMenuItem("Passengers");
		mnEdit.add(mntmPassengers);
		
		mntmEditTours = new JMenuItem("Tours");
		mnEdit.add(mntmEditTours);
		
		JMenu mnReservations = new JMenu("Reservations");
		mnReservations.setForeground(new Color(255, 255, 255));
		menuBar.add(mnReservations);
		
		mntmTourReservations = new JMenuItem("Tour reservations");
	
		mnReservations.add(mntmTourReservations);
		
		mntmBusReservations = new JMenuItem("Bus reservations");

		mnReservations.add(mntmBusReservations);
		
		JMenu mnHelp = new JMenu("Help");
		mnHelp.setForeground(new Color(255, 255, 255));
		menuBar.add(mnHelp);
		
		mntmAboutAutobus = new JMenuItem("About autobus\u00AE");
		
		mnHelp.add(mntmAboutAutobus);
		
		JLabel lblTopBanner = new JLabel("");
		lblTopBanner.setIcon(new ImageIcon(Autobus.class.getResource("/ressources/bus_banner.jpg")));
		
		JDesktopPane desktopPane = new JDesktopPane();
	
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(desktopPane, GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
							.addGap(0))
						.addComponent(lblTopBanner, GroupLayout.PREFERRED_SIZE, 1000, Short.MAX_VALUE))
					.addGap(0))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(lblTopBanner)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(desktopPane, GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE))
		);
		desktopPane.setLayout(new CardLayout(0, 0));
		
		panelTourReservations = new JPanel();
		panelTourReservations.setBackground(new Color(95, 158, 160));
		desktopPane.add(panelTourReservations, "name_32464075200119");
		
		JPanel panelTopTourReservations = new JPanel();
		panelTopTourReservations.setBackground(new Color(0, 128, 128));
		GroupLayout gl_panelTourReservations = new GroupLayout(panelTourReservations);
		gl_panelTourReservations.setHorizontalGroup(
			gl_panelTourReservations.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelTourReservations.createSequentialGroup()
					.addComponent(panelTopTourReservations, GroupLayout.DEFAULT_SIZE, 1027, Short.MAX_VALUE)
					.addGap(0))
		);
		gl_panelTourReservations.setVerticalGroup(
			gl_panelTourReservations.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelTourReservations.createSequentialGroup()
					.addComponent(panelTopTourReservations, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(436, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel = new JLabel("Tour reservations");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		GroupLayout gl_panelTopTourReservations = new GroupLayout(panelTopTourReservations);
		gl_panelTopTourReservations.setHorizontalGroup(
			gl_panelTopTourReservations.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelTopTourReservations.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(749, Short.MAX_VALUE))
		);
		gl_panelTopTourReservations.setVerticalGroup(
			gl_panelTopTourReservations.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelTopTourReservations.createSequentialGroup()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panelTopTourReservations.setLayout(gl_panelTopTourReservations);
		panelTourReservations.setLayout(gl_panelTourReservations);
		
		panelBusReservations = new JPanel();
		panelBusReservations.setBackground(new Color(95, 158, 160));
		desktopPane.add(panelBusReservations, "name_33299908692167");
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 128, 128));
		
		JLabel labelBusReservations = new JLabel("Bus and Chauffeur reservations");
		labelBusReservations.setForeground(Color.WHITE);
		labelBusReservations.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(labelBusReservations, GroupLayout.PREFERRED_SIZE, 378, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(610, Short.MAX_VALUE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addComponent(labelBusReservations, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_2.setLayout(gl_panel_2);
		GroupLayout gl_panelBusReservations = new GroupLayout(panelBusReservations);
		gl_panelBusReservations.setHorizontalGroup(
			gl_panelBusReservations.createParallelGroup(Alignment.LEADING)
				.addGap(0, 1000, Short.MAX_VALUE)
				.addGroup(gl_panelBusReservations.createSequentialGroup()
					.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 1027, Short.MAX_VALUE)
					.addGap(0))
		);
		gl_panelBusReservations.setVerticalGroup(
			gl_panelBusReservations.createParallelGroup(Alignment.LEADING)
				.addGap(0, 494, Short.MAX_VALUE)
				.addGroup(gl_panelBusReservations.createSequentialGroup()
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(436, Short.MAX_VALUE))
		);
		panelBusReservations.setLayout(gl_panelBusReservations);
		
		panelChauffeurs = new JPanel();
		panelChauffeurs.setBackground(new Color(95, 158, 160));
		desktopPane.add(panelChauffeurs, "name_33922176440952");
		
		JPanel panelTopChauffeurs = new JPanel();
		panelTopChauffeurs.setBackground(new Color(0, 128, 128));
		
		JLabel labelChauffeurs = new JLabel("Chauffeurs archive");
		labelChauffeurs.setForeground(Color.WHITE);
		labelChauffeurs.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		GroupLayout gl_panelTopChauffeurs = new GroupLayout(panelTopChauffeurs);
		gl_panelTopChauffeurs.setHorizontalGroup(
			gl_panelTopChauffeurs.createParallelGroup(Alignment.LEADING)
				.addGap(0, 1000, Short.MAX_VALUE)
				.addGroup(gl_panelTopChauffeurs.createSequentialGroup()
					.addContainerGap()
					.addComponent(labelChauffeurs, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(748, Short.MAX_VALUE))
		);
		gl_panelTopChauffeurs.setVerticalGroup(
			gl_panelTopChauffeurs.createParallelGroup(Alignment.LEADING)
				.addGap(0, 58, Short.MAX_VALUE)
				.addGroup(gl_panelTopChauffeurs.createSequentialGroup()
					.addComponent(labelChauffeurs, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panelTopChauffeurs.setLayout(gl_panelTopChauffeurs);
		
		JPanel panelAddChauffeur = new JPanel();
		panelAddChauffeur.setBackground(new Color(95, 158, 160));
		panelAddChauffeur.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255), 1, true), "Add chauffeur", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		
		JScrollPane scrollPaneChauffeursArchive = new JScrollPane();
		scrollPaneChauffeursArchive.setOpaque(false);
		scrollPaneChauffeursArchive.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		scrollPaneChauffeursArchive.setBorder(new CompoundBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255), 1, true), "Chauffeurs archive", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)), new EmptyBorder(5, 5, 5, 5)));
		scrollPaneChauffeursArchive.setBackground(new Color(95, 158, 160));
		
		lblDeleteChauffeurBtn = new JLabel("Delete Chauffeur");
		
		lblDeleteChauffeurBtn.setBorder(new CompoundBorder(new LineBorder(new Color(255, 255, 255), 1, true), new EmptyBorder(2, 2, 2, 2)));
		lblDeleteChauffeurBtn.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblDeleteChauffeurBtn.setForeground(new Color(255, 255, 255));
		GroupLayout gl_panelChauffeurs = new GroupLayout(panelChauffeurs);
		gl_panelChauffeurs.setHorizontalGroup(
			gl_panelChauffeurs.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelChauffeurs.createSequentialGroup()
					.addComponent(panelTopChauffeurs, GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
					.addGap(0))
				.addGroup(gl_panelChauffeurs.createSequentialGroup()
					.addGap(12)
					.addComponent(panelAddChauffeur, GroupLayout.PREFERRED_SIZE, 318, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_panelChauffeurs.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelChauffeurs.createSequentialGroup()
							.addComponent(lblDeleteChauffeurBtn)
							.addContainerGap())
						.addGroup(gl_panelChauffeurs.createSequentialGroup()
							.addComponent(scrollPaneChauffeursArchive, GroupLayout.DEFAULT_SIZE, 612, Short.MAX_VALUE)
							.addGap(40))))
		);
		gl_panelChauffeurs.setVerticalGroup(
			gl_panelChauffeurs.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelChauffeurs.createSequentialGroup()
					.addComponent(panelTopChauffeurs, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_panelChauffeurs.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(scrollPaneChauffeursArchive, 0, 0, Short.MAX_VALUE)
						.addComponent(panelAddChauffeur, GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblDeleteChauffeurBtn)
					.addContainerGap(13, Short.MAX_VALUE))
		);
		
		tableChauffeurs = new JTable();
		tableChauffeurs.setRowHeight(20);
		tableChauffeurs.setShowVerticalLines(false);
		scrollPaneChauffeursArchive.setViewportView(tableChauffeurs);
		tableChauffeurs.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		tableChauffeurs.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"#", "External", "Name", "Address", "Email", "Phone", "Birthday", "1 d only"
			}
		));
		tableChauffeurs.getColumnModel().getColumn(0).setPreferredWidth(31);
		tableChauffeurs.getColumnModel().getColumn(1).setPreferredWidth(53);
		tableChauffeurs.getColumnModel().getColumn(2).setPreferredWidth(107);
		tableChauffeurs.getColumnModel().getColumn(3).setPreferredWidth(115);
		tableChauffeurs.getColumnModel().getColumn(4).setPreferredWidth(91);
		tableChauffeurs.setSelectionForeground(new Color(255, 255, 255));
		tableChauffeurs.setSelectionBackground(new Color(102, 205, 170));
		tableChauffeurs.setForeground(new Color(255, 255, 255));
		tableChauffeurs.setBackground(new Color(95, 158, 160));
		
		textFieldChauffeurName = new JTextField();
		textFieldChauffeurName.setForeground(new Color(255, 255, 255));
		textFieldChauffeurName.setBackground(new Color(95, 158, 160));
		textFieldChauffeurName.setBorder(new LineBorder(Color.WHITE));
		textFieldChauffeurName.setColumns(10);
		
		JLabel lblChauffeurName = new JLabel("Name:");
		lblChauffeurName.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		lblChauffeurName.setForeground(new Color(255, 255, 255));
		
		JLabel lblChauffeurAddress = new JLabel("Address:");
		lblChauffeurAddress.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		lblChauffeurAddress.setForeground(new Color(255, 255, 255));
		
		textFieldChauffeurAddress = new JTextField();
		textFieldChauffeurAddress.setBorder(new LineBorder(new Color(255, 255, 255)));
		textFieldChauffeurAddress.setBackground(new Color(95, 158, 160));
		textFieldChauffeurAddress.setForeground(new Color(255, 255, 255));
		textFieldChauffeurAddress.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(new Color(255, 255, 255));
		lblEmail.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setForeground(new Color(255, 255, 255));
		lblPhone.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		
		JLabel lblBirthday = new JLabel("Birthday");
		lblBirthday.setForeground(new Color(255, 255, 255));
		lblBirthday.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		
		JLabel lblEmployee = new JLabel("Employee#");
		lblEmployee.setForeground(new Color(255, 255, 255));
		lblEmployee.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		
		textFieldChauffeurEmail = new JTextField();
		textFieldChauffeurEmail.setBorder(new LineBorder(new Color(255, 255, 255)));
		textFieldChauffeurEmail.setBackground(new Color(95, 158, 160));
		textFieldChauffeurEmail.setForeground(new Color(255, 255, 255));
		textFieldChauffeurEmail.setSelectedTextColor(new Color(255, 255, 255));
		textFieldChauffeurEmail.setSelectionColor(new Color(95, 158, 160));
		textFieldChauffeurEmail.setColumns(10);
		
		textFieldChauffeurPhone = new JTextField();
		textFieldChauffeurPhone.setBorder(new LineBorder(new Color(255, 255, 255)));
		textFieldChauffeurPhone.setBackground(new Color(95, 158, 160));
		textFieldChauffeurPhone.setForeground(new Color(255, 255, 255));
		textFieldChauffeurPhone.setSelectedTextColor(new Color(255, 255, 255));
		textFieldChauffeurPhone.setSelectionColor(new Color(95, 158, 160));
		textFieldChauffeurPhone.setColumns(10);
		
		textFieldChauffeurBirthMonth = new JTextField();
		textFieldChauffeurBirthMonth.setBorder(new TitledBorder(new LineBorder(null), "MM", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)));
		textFieldChauffeurBirthMonth.setBackground(new Color(95, 158, 160));
		textFieldChauffeurBirthMonth.setForeground(new Color(255, 255, 255));
		textFieldChauffeurBirthMonth.setSelectedTextColor(new Color(255, 255, 255));
		textFieldChauffeurBirthMonth.setSelectionColor(new Color(95, 158, 160));
		textFieldChauffeurBirthMonth.setColumns(10);
		
		textFieldEmployeeNo = new JTextField();
		textFieldEmployeeNo.setBorder(new LineBorder(new Color(255, 255, 255)));
		textFieldEmployeeNo.setBackground(new Color(95, 158, 160));
		textFieldEmployeeNo.setForeground(new Color(255, 255, 255));
		textFieldEmployeeNo.setSelectedTextColor(new Color(255, 255, 255));
		textFieldEmployeeNo.setSelectionColor(new Color(95, 158, 160));
		textFieldEmployeeNo.setColumns(10);
		
		chckbxExternalEmployee = new JCheckBox("External employee");
		chckbxExternalEmployee.setForeground(new Color(255, 255, 255));
		chckbxExternalEmployee.setBackground(new Color(95, 158, 160));
		chckbxExternalEmployee.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		
		chckbxOnlyOneDayTrips = new JCheckBox("Only 1 day trips");
		chckbxOnlyOneDayTrips.setForeground(new Color(255, 255, 255));
		chckbxOnlyOneDayTrips.setBackground(new Color(95, 158, 160));
		chckbxOnlyOneDayTrips.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		
		lblAddChauffeurButton = new JLabel("Add Chauffeur");
		
		lblAddChauffeurButton.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblAddChauffeurButton.setBorder(new CompoundBorder(new LineBorder(new Color(255, 255, 255), 1, true), new EmptyBorder(2, 2, 2, 2)));
		lblAddChauffeurButton.setForeground(new Color(255, 255, 255));
		
		textFieldChauffeurBirthDay = new JTextField();
		textFieldChauffeurBirthDay.setBorder(new TitledBorder(new LineBorder(null), "DD", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)));
		textFieldChauffeurBirthDay.setBackground(new Color(95, 158, 160));
		textFieldChauffeurBirthDay.setForeground(new Color(255, 255, 255));
		textFieldChauffeurBirthDay.setColumns(10);
		
		textFieldChauffeurBirthYear = new JTextField();
		textFieldChauffeurBirthYear.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255)), "YYYY", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)));
		textFieldChauffeurBirthYear.setBackground(new Color(95, 158, 160));
		textFieldChauffeurBirthYear.setForeground(new Color(255, 255, 255));
		textFieldChauffeurBirthYear.setColumns(10);
		GroupLayout gl_panelAddChauffeur = new GroupLayout(panelAddChauffeur);
		gl_panelAddChauffeur.setHorizontalGroup(
			gl_panelAddChauffeur.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelAddChauffeur.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblEmployee)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textFieldEmployeeNo, GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
					.addGap(7))
				.addGroup(gl_panelAddChauffeur.createSequentialGroup()
					.addGap(13)
					.addGroup(gl_panelAddChauffeur.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelAddChauffeur.createSequentialGroup()
							.addGroup(gl_panelAddChauffeur.createParallelGroup(Alignment.LEADING)
								.addComponent(chckbxOnlyOneDayTrips)
								.addComponent(chckbxExternalEmployee))
							.addContainerGap())
						.addGroup(gl_panelAddChauffeur.createSequentialGroup()
							.addGroup(gl_panelAddChauffeur.createParallelGroup(Alignment.LEADING)
								.addComponent(lblBirthday)
								.addComponent(lblChauffeurName)
								.addComponent(lblChauffeurAddress)
								.addComponent(lblEmail)
								.addComponent(lblPhone))
							.addGap(29)
							.addGroup(gl_panelAddChauffeur.createParallelGroup(Alignment.LEADING)
								.addComponent(textFieldChauffeurAddress, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
								.addComponent(textFieldChauffeurName, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
								.addComponent(textFieldChauffeurEmail, GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
								.addComponent(textFieldChauffeurPhone, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
								.addGroup(gl_panelAddChauffeur.createSequentialGroup()
									.addComponent(textFieldChauffeurBirthMonth, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textFieldChauffeurBirthDay, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textFieldChauffeurBirthYear, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)))
							.addGap(7))))
				.addGroup(Alignment.TRAILING, gl_panelAddChauffeur.createSequentialGroup()
					.addContainerGap(188, Short.MAX_VALUE)
					.addComponent(lblAddChauffeurButton)
					.addContainerGap())
		);
		gl_panelAddChauffeur.setVerticalGroup(
			gl_panelAddChauffeur.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelAddChauffeur.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelAddChauffeur.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEmployee)
						.addComponent(textFieldEmployeeNo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
					.addGroup(gl_panelAddChauffeur.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldChauffeurName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblChauffeurName))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelAddChauffeur.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblChauffeurAddress)
						.addComponent(textFieldChauffeurAddress, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelAddChauffeur.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEmail)
						.addComponent(textFieldChauffeurEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(12)
					.addGroup(gl_panelAddChauffeur.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPhone)
						.addComponent(textFieldChauffeurPhone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelAddChauffeur.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBirthday)
						.addComponent(textFieldChauffeurBirthMonth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldChauffeurBirthYear, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldChauffeurBirthDay, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(chckbxExternalEmployee)
					.addGap(4)
					.addComponent(chckbxOnlyOneDayTrips)
					.addGap(45)
					.addComponent(lblAddChauffeurButton)
					.addContainerGap())
		);
		panelAddChauffeur.setLayout(gl_panelAddChauffeur);
		panelChauffeurs.setLayout(gl_panelChauffeurs);
		
		panelBuses = new JPanel();
		panelBuses.setBackground(new Color(95, 158, 160));
		desktopPane.add(panelBuses, "name_5618907185400");
		
		JPanel panelTopBuses = new JPanel();
		panelTopBuses.setBackground(new Color(0, 128, 128));
		
		JLabel lblBusesArchive = new JLabel("Buses archive");
		lblBusesArchive.setForeground(Color.WHITE);
		lblBusesArchive.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		GroupLayout gl_panelTopBuses = new GroupLayout(panelTopBuses);
		gl_panelTopBuses.setHorizontalGroup(
			gl_panelTopBuses.createParallelGroup(Alignment.LEADING)
				.addGap(0, 1000, Short.MAX_VALUE)
				.addGroup(gl_panelTopBuses.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblBusesArchive, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(748, Short.MAX_VALUE))
		);
		gl_panelTopBuses.setVerticalGroup(
			gl_panelTopBuses.createParallelGroup(Alignment.LEADING)
				.addGap(0, 58, Short.MAX_VALUE)
				.addGroup(gl_panelTopBuses.createSequentialGroup()
					.addComponent(lblBusesArchive, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panelTopBuses.setLayout(gl_panelTopBuses);
		
		JPanel panelAddBus = new JPanel();
		panelAddBus.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255), 1, true), "Add bus", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		panelAddBus.setBackground(new Color(95, 158, 160));
		
		JLabel lblVehicleId = new JLabel("Vehicle ID# :");
		lblVehicleId.setForeground(Color.WHITE);
		lblVehicleId.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		
		textFieldVehicleID = new JTextField();
		textFieldVehicleID.setSelectionColor(new Color(95, 158, 160));
		textFieldVehicleID.setSelectedTextColor(Color.WHITE);
		textFieldVehicleID.setForeground(Color.WHITE);
		textFieldVehicleID.setColumns(10);
		textFieldVehicleID.setBorder(new LineBorder(new Color(255, 255, 255)));
		textFieldVehicleID.setBackground(new Color(95, 158, 160));
		
		JLabel lblPricePerHour = new JLabel("Price per hour:");
		lblPricePerHour.setForeground(Color.WHITE);
		lblPricePerHour.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		
		JLabel lblNumberOfSeats = new JLabel("Number of seats:");
		lblNumberOfSeats.setForeground(Color.WHITE);
		lblNumberOfSeats.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		
		JLabel lblBusModeltype = new JLabel("Bus modeltype:");
		lblBusModeltype.setForeground(Color.WHITE);
		lblBusModeltype.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		
		textFieldNumberSeats = new JTextField();
		textFieldNumberSeats.setForeground(Color.WHITE);
		textFieldNumberSeats.setColumns(10);
		textFieldNumberSeats.setBorder(new LineBorder(new Color(255, 255, 255)));
		textFieldNumberSeats.setBackground(new Color(95, 158, 160));
		
		textFieldPriceHour = new JTextField();
		textFieldPriceHour.setForeground(Color.WHITE);
		textFieldPriceHour.setColumns(10);
		textFieldPriceHour.setBorder(new LineBorder(Color.WHITE));
		textFieldPriceHour.setBackground(new Color(95, 158, 160));
		
		labelAddBusBtn = new JLabel("Add Bus");
		labelAddBusBtn.setForeground(Color.WHITE);
		labelAddBusBtn.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		labelAddBusBtn.setBorder(new CompoundBorder(new LineBorder(new Color(255, 255, 255), 1, true), new EmptyBorder(2, 2, 2, 2)));
		
		rdbtnStandardBus = new JRadioButton("Standard bus");
		rdbtnStandardBus.setForeground(new Color(255, 255, 255));
		rdbtnStandardBus.setBackground(new Color(95, 158, 160));
		rdbtnStandardBus.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		
		rdbtnPartyBus = new JRadioButton("Party bus");
		rdbtnPartyBus.setForeground(new Color(255, 255, 255));
		rdbtnPartyBus.setBackground(new Color(95, 158, 160));
		rdbtnPartyBus.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		
		rdbtnLuxuryBus = new JRadioButton("Luxury bus");
		rdbtnLuxuryBus.setForeground(new Color(255, 255, 255));
		rdbtnLuxuryBus.setBackground(new Color(95, 158, 160));
		rdbtnLuxuryBus.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		GroupLayout gl_panelAddBus = new GroupLayout(panelAddBus);
		gl_panelAddBus.setHorizontalGroup(
			gl_panelAddBus.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelAddBus.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelAddBus.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelAddBus.createSequentialGroup()
							.addGroup(gl_panelAddBus.createParallelGroup(Alignment.TRAILING)
								.addGroup(Alignment.LEADING, gl_panelAddBus.createSequentialGroup()
									.addGroup(gl_panelAddBus.createParallelGroup(Alignment.LEADING)
										.addComponent(lblPricePerHour)
										.addComponent(lblNumberOfSeats)
										.addComponent(lblBusModeltype))
									.addGap(29)
									.addGroup(gl_panelAddBus.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panelAddBus.createSequentialGroup()
											.addComponent(rdbtnLuxuryBus)
											.addPreferredGap(ComponentPlacement.RELATED, 73, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panelAddBus.createParallelGroup(Alignment.LEADING)
											.addGroup(gl_panelAddBus.createSequentialGroup()
												.addComponent(rdbtnPartyBus)
												.addPreferredGap(ComponentPlacement.RELATED, 82, GroupLayout.PREFERRED_SIZE))
											.addGroup(gl_panelAddBus.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_panelAddBus.createSequentialGroup()
													.addComponent(rdbtnStandardBus)
													.addPreferredGap(ComponentPlacement.RELATED, 60, GroupLayout.PREFERRED_SIZE))
												.addComponent(textFieldPriceHour, GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
												.addComponent(textFieldNumberSeats, GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)))))
								.addGroup(Alignment.LEADING, gl_panelAddBus.createSequentialGroup()
									.addComponent(lblVehicleId)
									.addGap(53)
									.addComponent(textFieldVehicleID, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGap(7))
						.addGroup(Alignment.TRAILING, gl_panelAddBus.createSequentialGroup()
							.addComponent(labelAddBusBtn)
							.addContainerGap())))
		);
		gl_panelAddBus.setVerticalGroup(
			gl_panelAddBus.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panelAddBus.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelAddBus.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblVehicleId)
						.addComponent(textFieldVehicleID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelAddBus.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldPriceHour, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPricePerHour))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelAddBus.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNumberOfSeats)
						.addComponent(textFieldNumberSeats, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelAddBus.createParallelGroup(Alignment.LEADING)
						.addComponent(lblBusModeltype)
						.addComponent(rdbtnStandardBus))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(rdbtnPartyBus)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(rdbtnLuxuryBus)
					.addPreferredGap(ComponentPlacement.RELATED, 126, Short.MAX_VALUE)
					.addComponent(labelAddBusBtn)
					.addContainerGap())
		);
		panelAddBus.setLayout(gl_panelAddBus);
		
		labelDeleteBusBtn = new JLabel("Delete Bus");
		labelDeleteBusBtn.setForeground(Color.WHITE);
		labelDeleteBusBtn.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		labelDeleteBusBtn.setBorder(new CompoundBorder(new LineBorder(new Color(255, 255, 255), 1, true), new EmptyBorder(2, 2, 2, 2)));
		
		JScrollPane scrollPaneBusesArchive = new JScrollPane();
		scrollPaneBusesArchive.setOpaque(false);
		scrollPaneBusesArchive.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		scrollPaneBusesArchive.setBorder(new CompoundBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255), 1, true), "Buses archive", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)), new EmptyBorder(5, 5, 5, 5)));
		scrollPaneBusesArchive.setBackground(new Color(95, 158, 160));
		GroupLayout gl_panelBuses = new GroupLayout(panelBuses);
		gl_panelBuses.setHorizontalGroup(
			gl_panelBuses.createParallelGroup(Alignment.LEADING)
				.addGap(0, 1000, Short.MAX_VALUE)
				.addGroup(gl_panelBuses.createSequentialGroup()
					.addComponent(panelTopBuses, GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
					.addGap(0))
				.addGroup(gl_panelBuses.createSequentialGroup()
					.addGap(12)
					.addComponent(panelAddBus, GroupLayout.PREFERRED_SIZE, 318, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_panelBuses.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelBuses.createSequentialGroup()
							.addComponent(labelDeleteBusBtn)
							.addContainerGap())
						.addGroup(gl_panelBuses.createSequentialGroup()
							.addComponent(scrollPaneBusesArchive, GroupLayout.DEFAULT_SIZE, 612, Short.MAX_VALUE)
							.addGap(40))))
		);
		gl_panelBuses.setVerticalGroup(
			gl_panelBuses.createParallelGroup(Alignment.LEADING)
				.addGap(0, 494, Short.MAX_VALUE)
				.addGroup(gl_panelBuses.createSequentialGroup()
					.addComponent(panelTopBuses, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_panelBuses.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(scrollPaneBusesArchive, 0, 0, Short.MAX_VALUE)
						.addComponent(panelAddBus, GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(labelDeleteBusBtn)
					.addContainerGap(13, Short.MAX_VALUE))
		);
		
		tableBuses = new JTable();
		tableBuses.setShowVerticalLines(false);
		tableBuses.setRowHeight(20);
		tableBuses.setSelectionForeground(new Color(255, 255, 255));
		tableBuses.setSelectionBackground(new Color(102, 205, 170));
		tableBuses.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Vehicle ID", "Price/hour", "Max # seats", "Available seats", "Model type", "Available for Tours"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] {
				String.class, Double.class, Integer.class, Integer.class, String.class, Boolean.class
			};
			@SuppressWarnings({ "rawtypes", "unchecked" })
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tableBuses.setForeground(new Color(255, 255, 255));
		tableBuses.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		tableBuses.setBackground(new Color(95, 158, 160));
		scrollPaneBusesArchive.setViewportView(tableBuses);
		panelBuses.setLayout(gl_panelBuses);
		
		panelTours = new JPanel();
		panelTours.setBackground(new Color(95, 158, 160));
		desktopPane.add(panelTours, "name_6540542874877");
		
		JPanel panelTopTours = new JPanel();
		panelTopTours.setBackground(new Color(0, 128, 128));
		
		JLabel labelTours = new JLabel("Tours archive");
		labelTours.setForeground(Color.WHITE);
		labelTours.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		GroupLayout gl_panelTopTours = new GroupLayout(panelTopTours);
		gl_panelTopTours.setHorizontalGroup(
			gl_panelTopTours.createParallelGroup(Alignment.LEADING)
				.addGap(0, 1000, Short.MAX_VALUE)
				.addGroup(gl_panelTopTours.createSequentialGroup()
					.addContainerGap()
					.addComponent(labelTours, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(748, Short.MAX_VALUE))
		);
		gl_panelTopTours.setVerticalGroup(
			gl_panelTopTours.createParallelGroup(Alignment.LEADING)
				.addGap(0, 58, Short.MAX_VALUE)
				.addGroup(gl_panelTopTours.createSequentialGroup()
					.addComponent(labelTours, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panelTopTours.setLayout(gl_panelTopTours);
		
		panelAddTour = new JPanel();
		panelAddTour.setForeground(new Color(255, 255, 255));
		panelAddTour.setBackground(new Color(95, 158, 160));
		panelAddTour.setBorder(new CompoundBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255), 1, true), "Add Tour", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)), new EmptyBorder(3, 3, 3, 3)));
		
		JScrollPane scrollPaneToursArchive = new JScrollPane();
		
		lblDeleteTourBtn = new JLabel("Delete Tour");
		lblDeleteTourBtn.setBorder(new CompoundBorder(new LineBorder(new Color(255, 255, 255), 1, true), new EmptyBorder(3, 3, 3, 3)));
		lblDeleteTourBtn.setForeground(new Color(255, 255, 255));
		lblDeleteTourBtn.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		GroupLayout gl_panelTours = new GroupLayout(panelTours);
		gl_panelTours.setHorizontalGroup(
			gl_panelTours.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelTours.createSequentialGroup()
					.addComponent(panelTopTours, GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
					.addGap(0))
				.addGroup(gl_panelTours.createSequentialGroup()
					.addGap(12)
					.addComponent(panelAddTour, GroupLayout.PREFERRED_SIZE, 469, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_panelTours.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelTours.createSequentialGroup()
							.addComponent(scrollPaneToursArchive, GroupLayout.DEFAULT_SIZE, 481, Short.MAX_VALUE)
							.addGap(20))
						.addGroup(gl_panelTours.createSequentialGroup()
							.addComponent(lblDeleteTourBtn)
							.addContainerGap())))
		);
		gl_panelTours.setVerticalGroup(
			gl_panelTours.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelTours.createSequentialGroup()
					.addComponent(panelTopTours, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_panelTours.createParallelGroup(Alignment.LEADING, false)
						.addComponent(panelAddTour, GroupLayout.PREFERRED_SIZE, 406, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panelTours.createSequentialGroup()
							.addComponent(scrollPaneToursArchive, GroupLayout.PREFERRED_SIZE, 351, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblDeleteTourBtn)))
					.addContainerGap())
		);
		
		JList listToursArchive = new JList();
		listToursArchive.setBackground(new Color(95, 158, 160));
		listToursArchive.setBorder(new CompoundBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255), 1, true), "Tours archive", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)), new EmptyBorder(3, 3, 3, 3)));
		scrollPaneToursArchive.setViewportView(listToursArchive);
		
		JLabel lblDestination = new JLabel("Destination:");
		lblDestination.setForeground(new Color(255, 255, 255));
		lblDestination.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		
		textFieldDestination = new JTextField();
		textFieldDestination.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		textFieldDestination.setSelectionColor(new Color(102, 205, 170));
		textFieldDestination.setSelectedTextColor(new Color(255, 255, 255));
		textFieldDestination.setBorder(new LineBorder(new Color(255, 255, 255)));
		textFieldDestination.setBackground(new Color(95, 158, 160));
		textFieldDestination.setForeground(new Color(255, 255, 255));
		textFieldDestination.setColumns(10);
		
		JLabel lblAddPickUpBtn = new JLabel("Add");
		lblAddPickUpBtn.setBorder(new CompoundBorder(new LineBorder(new Color(255, 255, 255), 1, true), new EmptyBorder(3, 3, 3, 3)));
		lblAddPickUpBtn.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		lblAddPickUpBtn.setForeground(new Color(255, 255, 255));
		lblAddPickUpBtn.setBackground(new Color(95, 158, 160));
		
		textFieldAddPickup = new JTextField();
		textFieldAddPickup.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		textFieldAddPickup.setSelectionColor(new Color(102, 205, 170));
		textFieldAddPickup.setSelectedTextColor(new Color(255, 255, 255));
		textFieldAddPickup.setBorder(new LineBorder(new Color(255, 255, 255)));
		textFieldAddPickup.setForeground(new Color(255, 255, 255));
		textFieldAddPickup.setBackground(new Color(95, 158, 160));
		textFieldAddPickup.setColumns(10);
		
		list = new JList();
		list.setForeground(new Color(255, 255, 255));
		list.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		list.setBackground(new Color(95, 158, 160));
		list.setBorder(new CompoundBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255)), "Pick up stops", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)), new EmptyBorder(3, 3, 3, 3)));
		
		lblStartDate = new JLabel("Start date:");
		lblStartDate.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		lblStartDate.setForeground(new Color(255, 255, 255));
		
		textFieldStartMonth = new JTextField();
		textFieldStartMonth.setSelectionColor(new Color(102, 205, 170));
		textFieldStartMonth.setSelectedTextColor(new Color(255, 255, 255));
		textFieldStartMonth.setBackground(new Color(95, 158, 160));
		textFieldStartMonth.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255)), "MM", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		textFieldStartMonth.setForeground(new Color(255, 255, 255));
		textFieldStartMonth.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		textFieldStartMonth.setColumns(10);
		
		textFieldStartDay = new JTextField();
		textFieldStartDay.setBackground(new Color(95, 158, 160));
		textFieldStartDay.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255)), "DD", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		textFieldStartDay.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		textFieldStartDay.setForeground(new Color(255, 255, 255));
		textFieldStartDay.setColumns(10);
		
		textFieldStartYear = new JTextField();
		textFieldStartYear.setForeground(new Color(255, 255, 255));
		textFieldStartYear.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		textFieldStartYear.setBackground(new Color(95, 158, 160));
		textFieldStartYear.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255)), "YYYY", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		textFieldStartYear.setColumns(10);
		
		lblEndDate = new JLabel("End date:");
		lblEndDate.setForeground(new Color(255, 255, 255));
		lblEndDate.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		
		textFieldEndMonth = new JTextField();
		textFieldEndMonth.setForeground(new Color(255, 255, 255));
		textFieldEndMonth.setBackground(new Color(95, 158, 160));
		textFieldEndMonth.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255)), "MM", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		textFieldEndMonth.setColumns(10);
		
		textField = new JTextField();
		textField.setBackground(new Color(95, 158, 160));
		textField.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255)), "DD", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255)), "YYYY", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		textField_1.setBackground(new Color(95, 158, 160));
		textField_1.setForeground(new Color(255, 255, 255));
		textField_1.setColumns(10);
		
		lblClearPickUpBtn = new JLabel("Clear");
		lblClearPickUpBtn.setBorder(new CompoundBorder(new LineBorder(new Color(255, 255, 255), 1, true), new EmptyBorder(3, 3, 3, 3)));
		lblClearPickUpBtn.setForeground(new Color(255, 255, 255));
		lblClearPickUpBtn.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		
		listSelectBus = new JList();
		listSelectBus.setBorder(new CompoundBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255)), "Select bus", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)), new EmptyBorder(3, 3, 3, 3)));
		listSelectBus.setSelectionForeground(new Color(51, 51, 51));
		listSelectBus.setSelectionBackground(new Color(102, 205, 170));
		listSelectBus.setForeground(new Color(255, 255, 255));
		listSelectBus.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		listSelectBus.setBackground(new Color(95, 158, 160));
		
		listSelectChauffeur = new JList();
		listSelectChauffeur.setSelectionBackground(new Color(102, 205, 170));
		listSelectChauffeur.setForeground(new Color(255, 255, 255));
		listSelectChauffeur.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		listSelectChauffeur.setBorder(new CompoundBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255)), "Select chauffeur", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)), null));
		listSelectChauffeur.setBackground(new Color(95, 158, 160));
		
		chckbxBreakfast = new JCheckBox("Breakfast");
		chckbxBreakfast.setForeground(new Color(255, 255, 255));
		chckbxBreakfast.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		chckbxBreakfast.setBackground(new Color(95, 158, 160));
		
		chckbxLunch = new JCheckBox("Lunch");
		chckbxLunch.setBackground(new Color(95, 158, 160));
		chckbxLunch.setForeground(new Color(255, 255, 255));
		chckbxLunch.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		
		chckbxAllInclusive = new JCheckBox("All inclusive");
		chckbxAllInclusive.setForeground(new Color(255, 255, 255));
		chckbxAllInclusive.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		chckbxAllInclusive.setBackground(new Color(95, 158, 160));
		
		JCheckBox chckbxEntranceTickets = new JCheckBox("Entrance tickets");
		chckbxEntranceTickets.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		chckbxEntranceTickets.setBackground(new Color(95, 158, 160));
		chckbxEntranceTickets.setForeground(new Color(255, 255, 255));
		
		lblAddTourBtn = new JLabel("Add Tour");
		lblAddTourBtn.setBorder(new CompoundBorder(new LineBorder(new Color(255, 255, 255), 1, true), new EmptyBorder(3, 3, 3, 3)));
		lblAddTourBtn.setForeground(new Color(255, 255, 255));
		lblAddTourBtn.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		GroupLayout gl_panelAddTour = new GroupLayout(panelAddTour);
		gl_panelAddTour.setHorizontalGroup(
			gl_panelAddTour.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelAddTour.createSequentialGroup()
					.addGroup(gl_panelAddTour.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelAddTour.createSequentialGroup()
							.addGroup(gl_panelAddTour.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelAddTour.createSequentialGroup()
									.addContainerGap()
									.addGroup(gl_panelAddTour.createParallelGroup(Alignment.LEADING, false)
										.addGroup(gl_panelAddTour.createSequentialGroup()
											.addComponent(lblDestination)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(textFieldDestination))
										.addGroup(gl_panelAddTour.createSequentialGroup()
											.addGroup(gl_panelAddTour.createParallelGroup(Alignment.LEADING)
												.addComponent(lblStartDate)
												.addComponent(lblEndDate))
											.addPreferredGap(ComponentPlacement.RELATED)
											.addGroup(gl_panelAddTour.createParallelGroup(Alignment.LEADING, false)
												.addComponent(textFieldEndMonth, 0, 0, Short.MAX_VALUE)
												.addComponent(textFieldStartMonth, GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE))
											.addPreferredGap(ComponentPlacement.RELATED)
											.addGroup(gl_panelAddTour.createParallelGroup(Alignment.LEADING, false)
												.addComponent(textField, 0, 0, Short.MAX_VALUE)
												.addComponent(textFieldStartDay, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
											.addPreferredGap(ComponentPlacement.RELATED)
											.addGroup(gl_panelAddTour.createParallelGroup(Alignment.LEADING, false)
												.addComponent(textFieldStartYear, 0, 0, Short.MAX_VALUE)
												.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)))))
								.addGroup(gl_panelAddTour.createSequentialGroup()
									.addGap(13)
									.addComponent(listSelectBus, GroupLayout.PREFERRED_SIZE, 272, GroupLayout.PREFERRED_SIZE)))
							.addGroup(gl_panelAddTour.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelAddTour.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_panelAddTour.createParallelGroup(Alignment.LEADING, false)
										.addComponent(list, GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
										.addGroup(gl_panelAddTour.createSequentialGroup()
											.addComponent(lblAddPickUpBtn)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(lblClearPickUpBtn))
										.addComponent(textFieldAddPickup)))
								.addGroup(gl_panelAddTour.createSequentialGroup()
									.addGap(40)
									.addGroup(gl_panelAddTour.createParallelGroup(Alignment.LEADING)
										.addComponent(chckbxLunch)
										.addComponent(chckbxBreakfast)
										.addComponent(chckbxAllInclusive)
										.addComponent(chckbxEntranceTickets)))))
						.addGroup(gl_panelAddTour.createSequentialGroup()
							.addContainerGap()
							.addComponent(listSelectChauffeur, GroupLayout.PREFERRED_SIZE, 271, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(2, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_panelAddTour.createSequentialGroup()
					.addContainerGap(380, Short.MAX_VALUE)
					.addComponent(lblAddTourBtn)
					.addContainerGap())
		);
		gl_panelAddTour.setVerticalGroup(
			gl_panelAddTour.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelAddTour.createSequentialGroup()
					.addGroup(gl_panelAddTour.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelAddTour.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panelAddTour.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblDestination)
								.addComponent(textFieldDestination, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panelAddTour.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblStartDate)
								.addComponent(textFieldStartMonth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textFieldStartDay, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textFieldStartYear, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panelAddTour.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblEndDate)
								.addGroup(gl_panelAddTour.createParallelGroup(Alignment.BASELINE)
									.addComponent(textFieldEndMonth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
									.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(22)
							.addComponent(listSelectBus, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(listSelectChauffeur, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelAddTour.createSequentialGroup()
							.addComponent(list, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textFieldAddPickup, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addGroup(gl_panelAddTour.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblAddPickUpBtn)
								.addComponent(lblClearPickUpBtn))
							.addGap(31)
							.addComponent(chckbxBreakfast)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(chckbxLunch)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(chckbxAllInclusive)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(chckbxEntranceTickets)))
					.addPreferredGap(ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
					.addComponent(lblAddTourBtn)
					.addContainerGap())
		);
		panelAddTour.setLayout(gl_panelAddTour);
		panelTours.setLayout(gl_panelTours);
		
		panelCustomers = new JPanel();
		panelCustomers.setBackground(new Color(95, 158, 160));
		desktopPane.add(panelCustomers, "name_6580052400446");
		
		JPanel panelTopCustomers = new JPanel();
		panelTopCustomers.setBackground(new Color(0, 128, 128));
		
		JLabel labelCustomers = new JLabel("Customers archive");
		labelCustomers.setForeground(Color.WHITE);
		labelCustomers.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		GroupLayout gl_panelTopCustomers = new GroupLayout(panelTopCustomers);
		gl_panelTopCustomers.setHorizontalGroup(
			gl_panelTopCustomers.createParallelGroup(Alignment.LEADING)
				.addGap(0, 1000, Short.MAX_VALUE)
				.addGroup(gl_panelTopCustomers.createSequentialGroup()
					.addContainerGap()
					.addComponent(labelCustomers, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(748, Short.MAX_VALUE))
		);
		gl_panelTopCustomers.setVerticalGroup(
			gl_panelTopCustomers.createParallelGroup(Alignment.LEADING)
				.addGap(0, 58, Short.MAX_VALUE)
				.addGroup(gl_panelTopCustomers.createSequentialGroup()
					.addComponent(labelCustomers, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panelTopCustomers.setLayout(gl_panelTopCustomers);
		GroupLayout gl_panelCustomers = new GroupLayout(panelCustomers);
		gl_panelCustomers.setHorizontalGroup(
			gl_panelCustomers.createParallelGroup(Alignment.LEADING)
				.addGap(0, 1000, Short.MAX_VALUE)
				.addGroup(gl_panelCustomers.createSequentialGroup()
					.addComponent(panelTopCustomers, GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
					.addGap(0))
		);
		gl_panelCustomers.setVerticalGroup(
			gl_panelCustomers.createParallelGroup(Alignment.LEADING)
				.addGap(0, 494, Short.MAX_VALUE)
				.addGroup(gl_panelCustomers.createSequentialGroup()
					.addComponent(panelTopCustomers, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(436, Short.MAX_VALUE))
		);
		panelCustomers.setLayout(gl_panelCustomers);
		
		panelPassengers = new JPanel();
		panelPassengers.setBackground(new Color(95, 158, 160));
		desktopPane.add(panelPassengers, "name_7387082934835");
		
		JPanel panelTopPassengers = new JPanel();
		panelTopPassengers.setBackground(new Color(0, 128, 128));
		
		JLabel labelPassengers = new JLabel("Passengers archive");
		labelPassengers.setForeground(Color.WHITE);
		labelPassengers.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		GroupLayout gl_panelTopPassengers = new GroupLayout(panelTopPassengers);
		gl_panelTopPassengers.setHorizontalGroup(
			gl_panelTopPassengers.createParallelGroup(Alignment.LEADING)
				.addGap(0, 1000, Short.MAX_VALUE)
				.addGroup(gl_panelTopPassengers.createSequentialGroup()
					.addContainerGap()
					.addComponent(labelPassengers, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(748, Short.MAX_VALUE))
		);
		gl_panelTopPassengers.setVerticalGroup(
			gl_panelTopPassengers.createParallelGroup(Alignment.LEADING)
				.addGap(0, 58, Short.MAX_VALUE)
				.addGroup(gl_panelTopPassengers.createSequentialGroup()
					.addComponent(labelPassengers, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panelTopPassengers.setLayout(gl_panelTopPassengers);
		GroupLayout gl_panelPassengers = new GroupLayout(panelPassengers);
		gl_panelPassengers.setHorizontalGroup(
			gl_panelPassengers.createParallelGroup(Alignment.LEADING)
				.addGap(0, 1000, Short.MAX_VALUE)
				.addGroup(gl_panelPassengers.createSequentialGroup()
					.addComponent(panelTopPassengers, GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
					.addGap(0))
		);
		gl_panelPassengers.setVerticalGroup(
			gl_panelPassengers.createParallelGroup(Alignment.LEADING)
				.addGap(0, 494, Short.MAX_VALUE)
				.addGroup(gl_panelPassengers.createSequentialGroup()
					.addComponent(panelTopPassengers, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(436, Short.MAX_VALUE))
		);
		panelPassengers.setLayout(gl_panelPassengers);
		
		panelNewTourReservation = new JPanel();
		panelNewTourReservation.setBackground(new Color(95, 158, 160));
		desktopPane.add(panelNewTourReservation, "name_7800006522332");
		
		JPanel panelTopNewTourReservation = new JPanel();
		panelTopNewTourReservation.setBackground(new Color(0, 128, 128));
		
		JLabel labelNewTourReservation = new JLabel("New Tour reservation");
		labelNewTourReservation.setForeground(Color.WHITE);
		labelNewTourReservation.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		GroupLayout gl_panelTopNewTourReservation = new GroupLayout(panelTopNewTourReservation);
		gl_panelTopNewTourReservation.setHorizontalGroup(
			gl_panelTopNewTourReservation.createParallelGroup(Alignment.LEADING)
				.addGap(0, 1000, Short.MAX_VALUE)
				.addGroup(gl_panelTopNewTourReservation.createSequentialGroup()
					.addContainerGap()
					.addComponent(labelNewTourReservation, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(748, Short.MAX_VALUE))
		);
		gl_panelTopNewTourReservation.setVerticalGroup(
			gl_panelTopNewTourReservation.createParallelGroup(Alignment.LEADING)
				.addGap(0, 58, Short.MAX_VALUE)
				.addGroup(gl_panelTopNewTourReservation.createSequentialGroup()
					.addComponent(labelNewTourReservation, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panelTopNewTourReservation.setLayout(gl_panelTopNewTourReservation);
		
		JTabbedPane newTourReservationTabbedPanel = new JTabbedPane(JTabbedPane.TOP);
		GroupLayout gl_panelNewTourReservation = new GroupLayout(panelNewTourReservation);
		gl_panelNewTourReservation.setHorizontalGroup(
			gl_panelNewTourReservation.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelNewTourReservation.createSequentialGroup()
					.addGroup(gl_panelNewTourReservation.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_panelNewTourReservation.createSequentialGroup()
							.addGap(12)
							.addComponent(newTourReservationTabbedPanel, GroupLayout.PREFERRED_SIZE, 954, GroupLayout.PREFERRED_SIZE)
							.addGap(34))
						.addComponent(panelTopNewTourReservation, GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE))
					.addGap(0))
		);
		gl_panelNewTourReservation.setVerticalGroup(
			gl_panelNewTourReservation.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelNewTourReservation.createSequentialGroup()
					.addComponent(panelTopNewTourReservation, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
					.addComponent(newTourReservationTabbedPanel, GroupLayout.PREFERRED_SIZE, 366, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		JPanel selectTourPanel = new JPanel();
		selectTourPanel.setBackground(new Color(0, 153, 102));
		newTourReservationTabbedPanel.addTab("Select Tour", null, selectTourPanel, null);
		newTourReservationTabbedPanel.setForegroundAt(0, new Color(0, 153, 102));
		newTourReservationTabbedPanel.setBackgroundAt(0, new Color(0, 153, 102));
		
		JScrollPane selectTourScrollPanel = new JScrollPane();
		
		JLabel lblSearchByDestination = new JLabel("Search by destination");
		
		searchTourTextField = new JTextField();
		searchTourTextField.setToolTipText("enter Tour's destination here");
		searchTourTextField.setColumns(10);
		
		JLabel lblNoTourWas = new JLabel("No Tour was yet selected");
		GroupLayout gl_selectTourPanel = new GroupLayout(selectTourPanel);
		gl_selectTourPanel.setHorizontalGroup(
			gl_selectTourPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_selectTourPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_selectTourPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(selectTourScrollPanel, GroupLayout.PREFERRED_SIZE, 630, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_selectTourPanel.createSequentialGroup()
							.addComponent(lblSearchByDestination)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(searchTourTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNoTourWas))
					.addContainerGap(307, Short.MAX_VALUE))
		);
		gl_selectTourPanel.setVerticalGroup(
			gl_selectTourPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_selectTourPanel.createSequentialGroup()
					.addGap(37)
					.addGroup(gl_selectTourPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSearchByDestination)
						.addComponent(searchTourTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(selectTourScrollPanel, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNoTourWas)
					.addContainerGap(35, Short.MAX_VALUE))
		);
		
		tableToursForNewReservation = new JTable();
		selectTourScrollPanel.setViewportView(tableToursForNewReservation);
		tableToursForNewReservation.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"Destination", "Departure date", "Number of available seats", "Bus", "Chauffeur"
			}
		));
		tableToursForNewReservation.getColumnModel().getColumn(2).setPreferredWidth(158);
		selectTourPanel.setLayout(gl_selectTourPanel);
		
		JPanel selectCustomerPanel = new JPanel();
		selectCustomerPanel.setBackground(new Color(0, 153, 102));
		newTourReservationTabbedPanel.addTab("Select Customer", null, selectCustomerPanel, null);
		newTourReservationTabbedPanel.setForegroundAt(1, new Color(0, 153, 102));
		
		JScrollPane selectCustomerScrollPanel = new JScrollPane();
		
		JLabel lblSearchCustomer = new JLabel("Search by name");
		
		searchCustomerTextField = new JTextField();
		searchCustomerTextField.setToolTipText("enter customer's name here");
		searchCustomerTextField.setColumns(10);
		
		JLabel lblNoCustomerWas = new JLabel("No customer was yet selected");
		lblNoCustomerWas.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GroupLayout gl_selectCustomerPanel = new GroupLayout(selectCustomerPanel);
		gl_selectCustomerPanel.setHorizontalGroup(
			gl_selectCustomerPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_selectCustomerPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_selectCustomerPanel.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(lblNoCustomerWas, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(selectCustomerScrollPanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, gl_selectCustomerPanel.createSequentialGroup()
							.addComponent(lblSearchCustomer)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(searchCustomerTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(356, Short.MAX_VALUE))
		);
		gl_selectCustomerPanel.setVerticalGroup(
			gl_selectCustomerPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_selectCustomerPanel.createSequentialGroup()
					.addGap(29)
					.addGroup(gl_selectCustomerPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSearchCustomer)
						.addComponent(searchCustomerTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(selectCustomerScrollPanel, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
					.addGap(30)
					.addComponent(lblNoCustomerWas, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		tableCustomersForNewReservation = new JTable();
		tableCustomersForNewReservation.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"Full name", "Phone number", "Address", "Date of birth", "Email"
			}
		));
		selectCustomerScrollPanel.setViewportView(tableCustomersForNewReservation);
		selectCustomerPanel.setLayout(gl_selectCustomerPanel);
		
		JPanel selectPassengersPanel = new JPanel();
		selectPassengersPanel.setBackground(new Color(0, 153, 102));
		newTourReservationTabbedPanel.addTab("Select Passengers", null, selectPassengersPanel, null);
		newTourReservationTabbedPanel.setForegroundAt(2, new Color(0, 153, 102));
		
		JScrollPane selectPassengersScrollPanel = new JScrollPane();
		
		JLabel lblSearchPassengers = new JLabel("Search by name");
		
		searchPassengersTextField = new JTextField();
		searchPassengersTextField.setToolTipText("enter customer's name here");
		searchPassengersTextField.setColumns(10);
		
		JLabel lblPassengersSelected = new JLabel("No passenger was yet selected");
		lblPassengersSelected.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GroupLayout gl_selectPassengersPanel = new GroupLayout(selectPassengersPanel);
		gl_selectPassengersPanel.setHorizontalGroup(
			gl_selectPassengersPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_selectPassengersPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_selectPassengersPanel.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(lblPassengersSelected, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(selectPassengersScrollPanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, gl_selectPassengersPanel.createSequentialGroup()
							.addComponent(lblSearchPassengers)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(searchPassengersTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(356, Short.MAX_VALUE))
		);
		gl_selectPassengersPanel.setVerticalGroup(
			gl_selectPassengersPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_selectPassengersPanel.createSequentialGroup()
					.addGap(20)
					.addGroup(gl_selectPassengersPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSearchPassengers)
						.addComponent(searchPassengersTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(selectPassengersScrollPanel, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
					.addGap(29)
					.addComponent(lblPassengersSelected, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		tablePassengersForNewReservation = new JTable();
		tablePassengersForNewReservation.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"Full name", "Phone number", "Address", "Date of birth", "Email"
			}
		));
		selectPassengersScrollPanel.setViewportView(tablePassengersForNewReservation);
		selectPassengersPanel.setLayout(gl_selectPassengersPanel);
		panelNewTourReservation.setLayout(gl_panelNewTourReservation);
		
		panelNewBusReservation = new JPanel();
		panelNewBusReservation.setBackground(new Color(95, 158, 160));
		desktopPane.add(panelNewBusReservation, "name_7867663339455");
		
		JPanel panelTopNewBusReservation = new JPanel();
		panelTopNewBusReservation.setBackground(new Color(0, 128, 128));
		
		JLabel labelNewBusReservation = new JLabel("New Bus & Chauffeur reservation");
		labelNewBusReservation.setForeground(Color.WHITE);
		labelNewBusReservation.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		GroupLayout gl_panelTopNewBusReservation = new GroupLayout(panelTopNewBusReservation);
		gl_panelTopNewBusReservation.setHorizontalGroup(
			gl_panelTopNewBusReservation.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelTopNewBusReservation.createSequentialGroup()
					.addContainerGap()
					.addComponent(labelNewBusReservation, GroupLayout.PREFERRED_SIZE, 458, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(530, Short.MAX_VALUE))
		);
		gl_panelTopNewBusReservation.setVerticalGroup(
			gl_panelTopNewBusReservation.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelTopNewBusReservation.createSequentialGroup()
					.addComponent(labelNewBusReservation, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panelTopNewBusReservation.setLayout(gl_panelTopNewBusReservation);
		GroupLayout gl_panelNewBusReservation = new GroupLayout(panelNewBusReservation);
		gl_panelNewBusReservation.setHorizontalGroup(
			gl_panelNewBusReservation.createParallelGroup(Alignment.LEADING)
				.addGap(0, 1000, Short.MAX_VALUE)
				.addGroup(gl_panelNewBusReservation.createSequentialGroup()
					.addComponent(panelTopNewBusReservation, GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
					.addGap(0))
		);
		gl_panelNewBusReservation.setVerticalGroup(
			gl_panelNewBusReservation.createParallelGroup(Alignment.LEADING)
				.addGap(0, 494, Short.MAX_VALUE)
				.addGroup(gl_panelNewBusReservation.createSequentialGroup()
					.addComponent(panelTopNewBusReservation, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(436, Short.MAX_VALUE))
		);
		panelNewBusReservation.setLayout(gl_panelNewBusReservation);
		getContentPane().setLayout(groupLayout);
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////
	// This method contains all code for setting all panels invisible
	///////////////////////////////////////////////////////////////////////////////////////////////////////
	public void hideAllPanels(){
		panelTourReservations.setVisible(false);
		panelBusReservations.setVisible(false);
		panelChauffeurs.setVisible(false);
		panelBuses.setVisible(false);
		panelTours.setVisible(false);
		panelCustomers.setVisible(false);
		panelPassengers.setVisible(false);
		panelNewTourReservation.setVisible(false);
		panelNewBusReservation.setVisible(false);
	}
}


