import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Iterator;

public class VetSys extends JFrame implements ActionListener{


        JMenu StaffMenu;
        JMenu ClientsMenu;
        JMenu PetsMenu;
        JButton staffButton;


        ArrayList<Staff> staffList = new ArrayList();
        private Staff staff;

        ArrayList<Client> clientList = new ArrayList();
        private Client client;

        ArrayList<Pet> petList = new ArrayList();
        private Pet pet;

        public VetSys() {


            super("Veterinarian System");

            setLayout(new GridBagLayout());



            this.createStaffMenu();
            this.createClientsMenu();
            this.createPetsMenu();





            JMenuBar menuBar = new JMenuBar();
            this.setJMenuBar(menuBar);
            menuBar.setBackground(Color.gray);
            menuBar.add(this.StaffMenu);
            menuBar.add(this.ClientsMenu);
            menuBar.add(this.PetsMenu);
            //ImageIcon icon = new ImageIcon("");
            //setIconImage(icon.getImage());
            //this.response = new JLabel("Veterinarian System" );
            //add(response);

            setSize(400,200);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setLocation(400,400);
            setVisible(true);

            this.staffButton = new JButton("Add Staff");
            this.staffButton.addActionListener(this);



        }

    public static void main(String[] args) {
            VetSys frame = new VetSys();
        }
        public void actionPerformed(ActionEvent e) {
            int quit;
            String  menuName;
            menuName = e.getActionCommand();

            if(e.getActionCommand().equals("Register Staff")){
                this.registerStaff();
            }else if(e.getActionCommand().equals("View Staff")){
                this.viewStaff();
            }else if(e.getActionCommand().equals("Delete Staff")){
               this.deleteStaff();
            }else if(e.getActionCommand().equals("Quit")) {
                quit = JOptionPane.showConfirmDialog(null,"Are you sure you want to exit?","Exit",JOptionPane.YES_NO_OPTION);
                if(quit==JOptionPane.YES_OPTION){
                    JOptionPane.showMessageDialog(null,"Goodbye","Quit",JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                }
            }else if(e.getActionCommand().equals("Add Client")){
                this.addClient();
            }else if(e.getActionCommand().equals("View Clients")) {
                this.viewClient();
            }else if (e.getActionCommand().equals("Delete Clients")){
                this.deleteClient();
            }else if(e.getActionCommand().equals("Add Pet")){
                this.addPet();
            }else if(e.getActionCommand().equals("View Pets")){
                //this.viewPet();
            }else if(e.getActionCommand().equals("Delete Pets")) {
                //this.deletePet();
            }
    }


        private void createStaffMenu( ) {
            JMenuItem item;

            this.StaffMenu = new JMenu("Staff");

            item = new JMenuItem("Register Staff");
            item.addActionListener( this );
            this.StaffMenu.add( item );

            item = new JMenuItem("View Staff");
            item.addActionListener( this );
            this.StaffMenu.add( item );

            item = new JMenuItem("Delete Staff");
            item.addActionListener( this );
            this.StaffMenu.add( item );

            this.StaffMenu.addSeparator(); //adds a horizontal separator line

            item = new JMenuItem("Quit");
            item.addActionListener( this );
            this.StaffMenu.add( item );
        }

    private void createClientsMenu( ) {
        JMenuItem item;

        ClientsMenu = new JMenu("Clients");

        item = new JMenuItem("Add Client");
        item.addActionListener( this );
        ClientsMenu.add( item );

        item = new JMenuItem("View Clients");
        item.addActionListener( this );
        ClientsMenu.add( item );

        item = new JMenuItem("Delete Clients");
        item.addActionListener( this );
        ClientsMenu.add( item );
    }


    private void createPetsMenu() {
        JMenuItem item;

        PetsMenu = new JMenu("Pets");

        item = new JMenuItem("Add Pet");
        item.addActionListener( this );
        PetsMenu.add( item );

        item = new JMenuItem("View Pets");
        item.addActionListener( this );
        PetsMenu.add( item );

        item = new JMenuItem("Delete Pets");
        item.addActionListener( this );
        PetsMenu.add( item );

    }

    public void registerStaff(){
        String[] title = new String[]{"Manager", "Cleaner", "Veterinarian", "Receptionist"};
        int i;
        boolean valid = true;
        String name =  JOptionPane.showInputDialog("Enter the Staff's name");

        while(valid){

            for(i=0; i< name.length() && Character.isLetter(name.charAt(i)); i++){
            }
            if(i == name.length() && name.length() != 0){
                String address = JOptionPane.showInputDialog("Enter the Staff's address");
                if(address.length() != 0){
                    String position = (String)JOptionPane.showInputDialog((Component)null, "Choose Staff's Position", "Position", 3, (Icon)null, title, title[0]);

                    int j=0;
                    String phone = JOptionPane.showInputDialog("Enter the Staff's phone number");

                    while(j!=1){
                       try {
                        Integer.parseInt(phone);
                        j=1;
                        valid = false;
                        this.staff = new Staff(name, address,position, phone);
                        JOptionPane.showMessageDialog(null,"Staff created successfully", "Added", JOptionPane.INFORMATION_MESSAGE);
                       }catch(NumberFormatException e){
                        JOptionPane.showMessageDialog(null,"Phone number is invalid", "ERROR",JOptionPane.ERROR_MESSAGE);
                        phone = JOptionPane.showInputDialog("Enter the Staff's phone number");

                       }
                   }
                }else{
                    JOptionPane.showMessageDialog(null,"Address is invalid", "ERROR",JOptionPane.ERROR_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(null,"Name is invalid", "ERROR",JOptionPane.ERROR_MESSAGE);
                name =  JOptionPane.showInputDialog("Enter the Staff's name");
            }
        }

        this.staffList.add(this.staff);




    }
//help from restaurant system for all the code below
    public void viewStaff(){
        JComboBox staffCombo = new JComboBox();
        JTextArea output = new JTextArea();
        output.setText("Staff Info:\n");


        if (this.staffList.size() < 1) {
            JOptionPane.showMessageDialog((Component)null, "There are no staff in the system", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            Iterator iterator = this.staffList.iterator();

            while(iterator.hasNext()) {
                staffCombo.addItem(((Staff)iterator.next()).getName() + "\n");
            }

            JOptionPane.showMessageDialog(null, staffCombo, "Select a member of the staff",JOptionPane.INFORMATION_MESSAGE);
            int selected = staffCombo.getSelectedIndex();
            output.append(((Staff)this.staffList.get(selected)).toString());
            JOptionPane.showMessageDialog(null, output, "Staff Details",JOptionPane.INFORMATION_MESSAGE);
        }
    }
    public void deleteStaff(){
        JComboBox staffList = new JComboBox();
        Iterator var2 = this.staffList.iterator();

        if (this.staffList.size() < 1) {
            JOptionPane.showMessageDialog(null, "There are no staff in the system to Delete", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            while (var2.hasNext()) {
                Staff s = (Staff) var2.next();
                staffList.addItem(s.getName());
            }

            JOptionPane.showMessageDialog( null, staffList, "Delete Staff",JOptionPane.INFORMATION_MESSAGE);
            int selected = staffList.getSelectedIndex();
            this.staffList.remove(selected);
            JOptionPane.showMessageDialog( null, "Deleted Staff Member", "Deleted",JOptionPane.INFORMATION_MESSAGE);

        }
    }

    public void addClient(){
        int i;
        boolean valid = true;
        String name =  JOptionPane.showInputDialog("Enter the Clients name");

        while(valid){

            for(i=0; i< name.length() && Character.isLetter(name.charAt(i)); i++){
            }
            if(i == name.length() && name.length() != 0){
                String address = JOptionPane.showInputDialog("Enter the Clients address");
                if(address.length() != 0){


                    int j=0;
                    String phone = JOptionPane.showInputDialog("Enter the Clients phone number");

                    while(j!=1){
                        try {
                            Integer.parseInt(phone);
                            j=1;
                            valid = false;
                            this.client = new Client(name, address, phone);
                            JOptionPane.showMessageDialog(null,"Client created successfully", "Added", JOptionPane.INFORMATION_MESSAGE);
                        }catch(NumberFormatException e){
                            JOptionPane.showMessageDialog(null,"Phone number is invalid", "ERROR",JOptionPane.ERROR_MESSAGE);
                            phone = JOptionPane.showInputDialog("Enter the Clients phone number");

                        }
                    }
                }else{
                    JOptionPane.showMessageDialog(null,"Address is invalid", "ERROR",JOptionPane.ERROR_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(null,"Name is invalid", "ERROR",JOptionPane.ERROR_MESSAGE);
                name =  JOptionPane.showInputDialog("Enter the Clients name");
            }
        }

        this.clientList.add(this.client);






    }
    public void viewClient(){
        JComboBox clientCombo = new JComboBox();
        JTextArea output = new JTextArea();
        output.setText("Client Info:\n");


        if (this.clientList.size() < 1) {
            JOptionPane.showMessageDialog(null, "There are no clients in the system", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            Iterator iterator = this.clientList.iterator();

            while(iterator.hasNext()) {
                clientCombo.addItem(((Client)iterator.next()).getName() + "\n");
            }

            JOptionPane.showMessageDialog(null, clientCombo, "Select a Client",JOptionPane.INFORMATION_MESSAGE);
            int selected = clientCombo.getSelectedIndex();
            output.append(((Client)this.clientList.get(selected)).toString());
            JOptionPane.showMessageDialog(null, output, "Client Details",JOptionPane.INFORMATION_MESSAGE);
        }
    }
    public void deleteClient(){
        JComboBox clientList = new JComboBox();
        Iterator var2 = this.clientList.iterator();

        if (this.clientList.size() < 1) {
            JOptionPane.showMessageDialog(null, "There are no clients in the system to Delete", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            while (var2.hasNext()) {
                Client s = (Client) var2.next();
                clientList.addItem(s.getName());
            }

            JOptionPane.showMessageDialog( null, clientList, "Delete Client",JOptionPane.INFORMATION_MESSAGE);
            int selected = clientList.getSelectedIndex();
            this.clientList.remove(selected);
            JOptionPane.showMessageDialog( null, "Deleted Client", "Deleted",JOptionPane.INFORMATION_MESSAGE);

        }
    }


    public void addPet(){
        if (this.clientList.size() < 1) {
            JOptionPane.showMessageDialog(null, "There are no clients in the system", "Error", JOptionPane.ERROR_MESSAGE);
        }else {
            int i;
            boolean valid = true;
            String name = JOptionPane.showInputDialog("Enter the Pets name");

            while (valid) {

                for (i = 0; i < name.length() && Character.isLetter(name.charAt(i)); i++) {
                }
                if (i == name.length() && name.length() != 0) {
                    String type = JOptionPane.showInputDialog("Enter the type of pet");
                    if (type.length() != 0) {
                        JComboBox clientList = new JComboBox();
                        Iterator var2 = this.clientList.iterator();


                        while (var2.hasNext()) {
                            Client s = (Client) var2.next();
                            clientList.addItem(s.getName());
                        }

                        JOptionPane.showMessageDialog(null, clientList, "Pets owner", JOptionPane.INFORMATION_MESSAGE);
                        int selected = clientList.getSelectedIndex();
                        String owner = String.valueOf(this.clientList);


                        valid = false;
                    } else {
                        JOptionPane.showMessageDialog(null, "Type is invalid", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Name is invalid", "ERROR", JOptionPane.ERROR_MESSAGE);
                    name = JOptionPane.showInputDialog("Enter the Pets name");
                }
            }
        }
        this.petList.add(this.pet);
        }
//this does not work
/*
    public void viewPet(){
        JComboBox petCombo = new JComboBox();
        JTextArea output = new JTextArea();
        output.setText("Pet Info:\n");


        if (this.petList.size() < 1) {
            JOptionPane.showMessageDialog(null, "There are no pets in the system", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            Iterator iterator = this.petList.iterator();

            while(iterator.hasNext()) {
                petCombo.addItem(((Pet)iterator.next()).getName() + "\n");
            }

            JOptionPane.showMessageDialog(null, petCombo, "Select a Pet",JOptionPane.INFORMATION_MESSAGE);
            int selected = petCombo.getSelectedIndex();
            output.append(((Pet)this.petList.get(selected)).toString());
            JOptionPane.showMessageDialog(null, output, "Pet Details",JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void deletePet(){
        JComboBox petList = new JComboBox();
        Iterator var2 = this.petList.iterator();

        if (this.petList.size() < 1) {
            JOptionPane.showMessageDialog(null, "There are no pets in the system to Delete", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            while (var2.hasNext()) {
                Pet s = (Pet) var2.next();
                petList.addItem(s.getName());
            }

            JOptionPane.showMessageDialog( null, petList, "Delete pet",JOptionPane.INFORMATION_MESSAGE);
            int selected = petList.getSelectedIndex();
            this.petList.remove(selected);
            JOptionPane.showMessageDialog( null, "Deleted pet", "Deleted",JOptionPane.INFORMATION_MESSAGE);

        }
    }
*/


}

