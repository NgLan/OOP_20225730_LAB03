package hust.soict.dsai.aims.screen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import hust.soict.dsai.aims.Aims;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.store.Store;
import javafx.collections.FXCollections;
import javafx.collections.transformation.FilteredList;

public class StoreScreen extends JFrame {
	private Store store;
	private JPanel center;
	private Cart cart = new Cart(); 
	
	public StoreScreen(Store store) {
		this.store = store;
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		
		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(center = createCenter(store.getItemsInStore()), BorderLayout.CENTER);
	
		setVisible(true);
		setTitle("Store");
		setSize(1024, 768);
	}
	
	JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
		return north;
	}
	
	JMenuBar createMenuBar() {
		
		JMenu menu = new JMenu("Options");

		JMenu smUpdateStore = new JMenu ("Update Store");
		smUpdateStore.add(new JMenuItem("Add Book"));
		smUpdateStore.add(new JMenuItem("Add CD"));
		smUpdateStore.add(new JMenuItem("Add DVD"));
		
		menu.add(smUpdateStore);
		menu.add(new JMenuItem("View store"));
		menu.add(new JMenuItem("View cart"));
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menuBar.add(menu);
		
		return menuBar;
	}
	
	JPanel createHeader() {
		
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
		
		JLabel title = new JLabel("AIMS");
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
		title.setForeground (Color.CYAN);
		
		JButton cart = new JButton("View cart");
		cart.setPreferredSize (new Dimension(100, 50));
		cart.setMaximumSize (new Dimension(100, 50));
		
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		header.add(title);
		header.add(Box.createHorizontalGlue());
		header.add(cart);
		header.add(Box.createRigidArea(new Dimension (10, 10)));
		
		return header;
	}
	
	private void playMedia(Media media) {
        JDialog dialog = new JDialog(this, "Playing Media", true);
        dialog.setLayout(new BorderLayout());
        dialog.add(new JLabel("Now playing: " + media.getTitle(), JLabel.CENTER), BorderLayout.CENTER);
        dialog.setSize(300, 200);
        dialog.setVisible(true);
        
        Playable playable = (Playable) media;
        playable.play();
    }
	
	JPanel createSearchBar() {
		JPanel searchBar = new JPanel();
        searchBar.setLayout(new BoxLayout(searchBar, BoxLayout.X_AXIS));

        JLabel lblSearch = new JLabel("Search: ");
        lblSearch.setFont(new Font(lblSearch.getFont().getName(), Font.BOLD, 14));
        searchBar.add(lblSearch);

        JPanel panelRadioGroup = new JPanel();
        panelRadioGroup.setLayout(new BoxLayout(panelRadioGroup, BoxLayout.Y_AXIS));

        JRadioButton btnByTitle = new JRadioButton("By Title", true);
        JRadioButton btnByCategory = new JRadioButton("By Category");
        JRadioButton btnByCost = new JRadioButton("By Cost");

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(btnByTitle);
        buttonGroup.add(btnByCategory);
        buttonGroup.add(btnByCost);

        panelRadioGroup.add(btnByTitle);
        panelRadioGroup.add(btnByCategory);
        panelRadioGroup.add(btnByCost);
        searchBar.add(Box.createRigidArea(new Dimension(10, 10)));
        searchBar.add(panelRadioGroup);

        JTextField textField = new JTextField(10);
        textField.setMaximumSize(new Dimension(1000, 25));
        searchBar.add(Box.createRigidArea(new Dimension(10, 10)));
        searchBar.add(textField);

        JPanel panelCostFromTo = new JPanel();
        panelCostFromTo.setLayout(new BoxLayout(panelCostFromTo, BoxLayout.X_AXIS));
        JLabel lblFrom = new JLabel("From  ");
        JLabel lblTo = new JLabel("  to  ");
        JTextField tfFrom = new JTextField();
        tfFrom.setPreferredSize(new Dimension(10, 25));
        tfFrom.setMaximumSize(new Dimension(5000, 25));
        JTextField tfTo = new JTextField();
        tfTo.setPreferredSize(new Dimension(10, 25));
        tfTo.setMaximumSize(new Dimension(5000, 25));
        panelCostFromTo.add(lblFrom);
        panelCostFromTo.add(tfFrom);
        panelCostFromTo.add(lblTo);
        panelCostFromTo.add(tfTo);
        searchBar.add(panelCostFromTo);
        panelCostFromTo.setVisible(false);

        ActionListener actionListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (btnByTitle.isSelected() || btnByCategory.isSelected()) {
                    resetTextFields();
                    textField.setVisible(true);
                    panelCostFromTo.setVisible(false);
                } else {
                    resetTextFields();
                    textField.setVisible(false);
                    panelCostFromTo.setVisible(true);
                }
            }

            void resetTextFields() {
                textField.setText("");
                tfFrom.setText("");
                tfTo.setText("");
            }
        };

        btnByTitle.addActionListener(actionListener);
        btnByCategory.addActionListener(actionListener);
        btnByCost.addActionListener(actionListener);

        DocumentListener documentListener = new DocumentListener() {

            @Override
            public void removeUpdate(DocumentEvent e) {
                changedUpdate(e);
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                changedUpdate(e);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                if (btnByTitle.isSelected() || btnByCategory.isSelected()) {
                    if (textField.getText().equals("")) {
                        loadItemsToStore();
                        return;
                    }

                    FilteredList<Media> filteredList = new FilteredList<>(
                            FXCollections.observableArrayList(store.getItemsInStore()));
                    if (btnByTitle.isSelected()) {
                        filteredList.setPredicate((it) -> it.isMatch(textField.getText()));
                    } else {
                    	filteredList.setPredicate((it) -> it.isMatch(textField.getText()));
                    }

                    loadItemsToStore(filteredList);
                } else {
                    if (tfFrom.getText().equals("") && tfTo.getText().equals("")) {
                        loadItemsToStore();
                        return;
                    }

                    FilteredList<Media> filteredList = new FilteredList<>(
                            FXCollections.observableArrayList(store.getItemsInStore()));
                    if (tfFrom.getText().equals("")) {
                        filteredList.setPredicate((it) -> it.getCost() < Float.parseFloat(tfTo.getText()));
                    } else if (tfTo.getText().equals("")) {
                        filteredList.setPredicate((it) -> it.getCost() > Float.parseFloat(tfFrom.getText()));
                    } else {
                        filteredList.setPredicate((it) -> it.getCost() > Float.parseFloat(tfFrom.getText())
                                && it.getCost() < Float.parseFloat(tfTo.getText()));
                    }

                    loadItemsToStore(filteredList);
                }
            }
        };

        textField.getDocument().addDocumentListener(documentListener);
        tfFrom.getDocument().addDocumentListener(documentListener);
        tfTo.getDocument().addDocumentListener(documentListener);

        return searchBar;
    }
	
	JPanel createCenter(List<Media> itemList) {
        JPanel center = new JPanel();

        int itemsToShow = itemList.size() < 9 ? itemList.size() : 9;

        if (itemsToShow == 0) {
            center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));

            JLabel lblStoreEmpty = new JLabel("No item found.");
            lblStoreEmpty.setAlignmentX(CENTER_ALIGNMENT);
            lblStoreEmpty.setFont(new Font(lblStoreEmpty.getName(), Font.PLAIN, 20));

            center.add(Box.createRigidArea(new Dimension(10, 200)));
            center.add(lblStoreEmpty);
            return center;
        }

        center.setLayout(new GridLayout(0, 3, 2, 2));

        for (int i = 0; i < itemsToShow; i++) {
            MediaStore cell = new MediaStore(itemList.get(i), this);
            center.add(cell);
        }

        return center;
    }
	
	public void loadItemsToStore() {
        loadItemsToStore(store.getItemsInStore());
    }
	
	public void loadItemsToStore(List<Media> itemList) {
        remove(center);
        add(center = createCenter(itemList), BorderLayout.CENTER);
        repaint();
        revalidate();
    }
	
	private class MenuListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            switch (e.getActionCommand()) {
                case "Add Book":
                    new AddBookToStoreScreen();
                    break;
                case "Add CD":
                    new AddCompactDiscToStoreScreen();
                    break;
                case "Add DVD":
                    new AddDigitalVideoDiscToStoreScreen();
                    break;
                case "View cart":
                    Aims.closeStoreScreen();
                    Aims.openCartScreen();
                    break;
            }

        }

    }
	
	public static void main(String[] args) {
		Store store = new Store();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("DVD1's Title", 
                "Animation", "Roger Allers", 87, 76f);
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("DVD5's Title", 
                "Science Fiction", "George Lucas", 87, 43f);
		
		List<String> authors = new ArrayList<String>();
		authors.add("ABC");
		Book book2 = new Book("Book'2 Title", "Tâm lý học", 61f, authors);
		Book book7 = new Book("Book'7 Title", "Tâm lý học", 24f, authors);
		Book book8 = new Book("Book'8 Title", "Tâm lý học", 78f, authors);
		
		ArrayList<Track> trks = new ArrayList<Track>();
		trks.add(new Track("Track 1", 60));
		trks.add(new Track("Track 2", 60));
        CompactDisc cd3 = new CompactDisc("CD3's Title", "Animation", "Watashi", 120, 59f, "Artist", trks);
        CompactDisc cd4 = new CompactDisc("CD4's Title", "Animation", "Watashi", 120, 38f, "Artist", trks);
        CompactDisc cd6 = new CompactDisc("CD6's Title", "Animation", "Watashi", 120, 95f, "Artist", trks);
        CompactDisc cd9 = new CompactDisc("CD9's Title", "Animation", "Watashi", 120, 95f, "Artist", trks);
//        CompactDisc cd10 = new CompactDisc("CD9's Title", "Animation", "Watashi", 120, 95f, "Artist", trks);
        store.addMedia(dvd1, book2, cd3, cd4, dvd5, cd6, book7, book8, cd9);
        
        new StoreScreen(store);
	}
}
