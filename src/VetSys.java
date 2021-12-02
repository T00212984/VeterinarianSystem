import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class VetSys extends JFrame implements ActionListener{


        JMenu StaffMenu;
        JMenu ClientsMenu;
        JMenu PetsMenu;
        JLabel response;
        JButton staffButton;


        ArrayList<Staff> staff2 = new ArrayList();
        private Staff staff;


        public VetSys() {


            super("Veterinarian System");

            setLayout(new GridBagLayout());

            // invoke some user-defined methods to create two menus (and their menu items)
            // this is done just to make the constructor shorter but is good programming practice

            this.createStaffMenu();
            this.createClientsMenu();
            this.createPetsMenu();




            //and add them to the menubar
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

        // when a menu-item is clicked, response starts here
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
                    JOptionPane.showMessageDialog(null,"Goodbye","Quit",JOptionPane.YES_OPTION);
                    System.exit(0);
                }

            }else if(e.getActionCommand().equals("Add Client")){
                System.out.print("4");
            }else if(e.getActionCommand().equals("View Clients")) {
                System.out.print("5");
            }else if (e.getActionCommand().equals("Delete Clients")){
                System.out.print("6");
            }else if(e.getActionCommand().equals("Add Pet")){
                System.out.print("7");
            }else if(e.getActionCommand().equals("View Pets")){
                System.out.print("8");
            }else if(e.getActionCommand().equals("Delete Pets")) {
                System.out.print("9");
            }
    }



        //Creates File menu and its menu items
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
                    while(j!=1){
                       String phone = JOptionPane.showInputDialog("Enter the Staff's phone number");
                       try {
                        Integer.parseInt(phone);
                        j=1;
                        valid = false;
                        this.staff = new Staff(name, address,position, phone);
                        JOptionPane.showMessageDialog(null,"Staff created successfully", "Added", JOptionPane.INFORMATION_MESSAGE);
                    }catch(NumberFormatException e){
                        JOptionPane.showMessageDialog(null,"Phone number is invalid", "ERROR",JOptionPane.ERROR_MESSAGE);
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
        this.staff2.add(this.staff);


    }
    public void viewStaff(){
        if(this.staff2.size()<1){
            JOptionPane.showMessageDialog(null,"There are no staff to display","Empty",JOptionPane.INFORMATION_MESSAGE);
        }else{
            String output = String.valueOf(staff2.get(0));
            output += "----------------------";
            JOptionPane.showMessageDialog(null,output,"Staff List", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    public void deleteStaff(){}


}

