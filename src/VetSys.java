import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VetSys extends JFrame implements ActionListener{


        JMenu StaffMenu;
        JMenu ClientsMenu;
        JMenu PetsMenu;
        JLabel response;
        JButton staffButton;
        JButton buttonC;

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


            this.response = new JLabel("Veterinarian System" );
            //add(response);

            setSize(400,200);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setLocation(400,400);
            setVisible(true);

            this.staffButton = new JButton("Add Staff");
            this.staffButton.addActionListener(this);
            this.buttonC.add(this.staffButton);

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
                System.out.print("1");
            }else if(e.getActionCommand().equals("View Staff")){
                System.out.print("2");
            }else if(e.getActionCommand().equals("Delete Staff")){
                System.out.print("3");
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
            JOptionPane.showMessageDialog(null,"hi","hi",JOptionPane.INFORMATION_MESSAGE);

    }

}

