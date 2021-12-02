import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VetSys extends JFrame implements ActionListener{


        JMenu StaffMenu;
        JMenu ClientsMenu;
        JMenu PetsMenu;
        JLabel response;

        public VetSys() {


            super("Veterinarian System");

            setLayout(new GridBagLayout());

            // invoke some user-defined methods to create two menus (and their menu items)
            // this is done just to make the constructor shorter but is good programming practice

            createStaffMenu();
            createClientsMenu();
            createPetsMenu();



            //and add them to the menubar
            JMenuBar menuBar = new JMenuBar();
            setJMenuBar(menuBar);
            menuBar.setBackground(Color.gray);
            menuBar.add(StaffMenu);
            menuBar.add(ClientsMenu);
            menuBar.add(PetsMenu);


            response = new JLabel("Veterinarian System" );
            add(response);

            setSize(400,200);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setLocation(250,200);
            setVisible(true);

        }

    public static void main(String[] args) {
            VetSys frame = new VetSys();
        }

        // when a menu-item is clicked, response starts here
        public void actionPerformed(ActionEvent event) {
            String  menuName;
            menuName = event.getActionCommand();

            if (menuName.equals("Quit"))
                System.exit(0);
            else
                response.setText("Menu Item '" + menuName + "' is selected.");

        }

        //Creates File menu and its menu items
        private void createStaffMenu( ) {
            JMenuItem    item;

            StaffMenu = new JMenu("Staff");

            item = new JMenuItem("Register Staff");
            item.addActionListener( this );

            StaffMenu.add( item );

            item = new JMenuItem("View Staff");
            item.addActionListener( this );
            StaffMenu.add( item );

            item = new JMenuItem("Delete Staff");
            item.addActionListener( this );
            StaffMenu.add( item );

            StaffMenu.addSeparator(); //adds a horizontal separator line

            item = new JMenuItem("Quit");
            item.addActionListener( this );
            StaffMenu.add( item );
        }

    private void createClientsMenu( ) {
        JMenuItem    item;

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
        JMenuItem    item;

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

}

