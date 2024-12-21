package hust.soict.dsai.aims.screen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.swing.SwingAccumulator;

public class StoreScreen extends JFrame {
	private Store store;
	
	public StoreScreen(Store store) {
		this.store = store;
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		
		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(createCenter(), BorderLayout.CENTER);
	
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
	
	JPanel createCenter() {
		
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(3, 3, 2, 2));

		ArrayList<Media> mediaInStore = store.getItemsInStore();
		for (int i = 0; i < mediaInStore.size(); i++) {
			MediaStore cell = new MediaStore(mediaInStore.get(i));
			center.add(cell);
		}
		
		return center;
	}
	
	public class MediaStore extends JPanel {
		private Media media;
		public MediaStore(Media media) {
			
			this.media = media;
			this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
			
			JLabel title = new JLabel(media.getTitle());
			title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
			title.setAlignmentX(CENTER_ALIGNMENT);
			
			JLabel cost = new JLabel(""+media.getCost()+" $");
			cost.setAlignmentX(CENTER_ALIGNMENT);
			
			JPanel container = new JPanel();
			container.setLayout(new FlowLayout(FlowLayout.CENTER));
			
			container.add(new JButton("Add to cart"));
			if(media instanceof Playable) {
				container.add(new JButton("Play"));
			}
			
			this.add(Box.createVerticalGlue());
			this.add(title);
			this.add(cost);
			this.add(Box.createVerticalGlue());
			this.add(container);
			
			this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
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
