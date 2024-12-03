package hust.soict.dsai.aims;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Disc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.store.Store;

public class Aims {
	public static void showMenu() {
		System.out.println("AIMS: ");
		System.out.println("--------------------------------");
		System.out.println("1. View store");
		System.out.println("2. Update store");
		System.out.println("3. See current cart");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
	}
	
	public static void storeMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. See a media’s details");
		System.out.println("2. Add a media to cart");
		System.out.println("3. Play a media");
		System.out.println("4. See current cart");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
	}
	
	public static void updateStoreMenu() {
        System.out.println("Options:");
        System.out.println("--------------------------------");
        System.out.println("1. Add a media to the store");
        System.out.println("2. Remove a media from the store");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2");
	}

    public static void addMediaToStore(Store store, Scanner scanner) {
    	System.out.println("Enter the type of Media:");
    	System.out.println("1. Book.");
    	System.out.println("2. Digital Video Disc.");
    	System.out.println("3. Compact Disc.");
    	System.out.println("0. Back.");
    	int type = scanner.nextInt();
    	if(type == 0) return;
    	scanner.nextLine();
        System.out.println("Enter the title of the media: ");
        String title = scanner.nextLine();
        System.out.println("Enter the category: ");
        String category = scanner.nextLine();
        System.out.println("Enter the cost: ");
        float cost = scanner.nextFloat();
        Media m = null;
        switch(type) {
            case 1:
            	m = new Book();
            	break;
            case 2: 
            	m = new DigitalVideoDisc();
            	break;
            case 3:
            	m = new CompactDisc();
            	store.addMedia(m);
            	break;
            default:
            	System.out.println("Invalid choice, please try again.");
        }
        store.addMedia(m);
    }
    
    public static void removeMediaFromStore(Store store, Scanner scanner) {
        System.out.println("Enter the title of the media to remove: ");
        String title = scanner.nextLine();
        Media media = store.search(title);
        if (media != null) {
            store.removeMedia(media);
        } else {
            System.out.println("Not found");
        }
    }
    
    public static void updateStore(Store store, Scanner scanner) {
        while (true) {
        	updateStoreMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    addMediaToStore(store, scanner);
                    break;
                case 2:
                    removeMediaFromStore(store, scanner);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

	public static void mediaDetailsMenu(Media m) {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Add to cart");
		boolean isDisc = false;
		if (m instanceof Disc && m instanceof Playable) {
			System.out.println("2. Play");
			isDisc = true;
		}
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.print("Please choose a number: 0-1");
		if(isDisc) System.out.print("-2");
		System.out.println();
	}
	
	public static void cartMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Filter medias in cart");
		System.out.println("2. Sort medias in cart");
		System.out.println("3. Remove media from cart");
		System.out.println("4. Play a media");
		System.out.println("5. Place order");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4-5");
	}
	
	public static void filterMediasInCart(Cart cart, Scanner scanner) {
        System.out.println("Filter by: ");
        System.out.println("1. ID");
        System.out.println("2. Title");
        System.out.println("0. Back");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
            	System.out.println("Please enter ID");
            	int id = scanner.nextInt();
            	cart.search(id);
                break;
            case 2:
            	scanner.nextLine();
            	String title = scanner.nextLine();
            	cart.search(title);
                break;
            case 0: return;
            default:
                System.out.println("Invalid choice.");
        }
    }

    public static void sortMediasInCart(Cart cart, Scanner scanner) {
        System.out.println("Sort by: ");
        System.out.println("1. Title");
        System.out.println("2. Cost");
        System.out.println("0. Back");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1:
            	Collections.sort(cart.getMediaList(), Media.COMPARE_BY_TITLE_COST);
                break;
            case 2:
            	Collections.sort(cart.getMediaList(), Media.COMPARE_BY_COST_TITLE);
                break;
            case 0: return;
            default:
                System.out.println("Invalid choice.");
        }
    }

    public static void removeMediaFromCart(Cart cart, Scanner scanner) {
        System.out.println("Enter the title of the media to remove: ");
        String title = scanner.nextLine();
        Media media = cart.search(title);
        if (media != null) {
            cart.removeMedia(media);
        } else {
            System.out.println("Media not found in cart.");
        }
    }
    
    public static void placeOrder(Cart cart) {
        System.out.println("That an order is created and empty the current cart");
        cart.clear();
    }

	public static void main(String[] args) {
		Store store = new Store();
		Cart cart = new Cart();
		showMenu();
		Scanner scan = new Scanner(System.in);
		int menuChoice = scan.nextInt();
		
		while (true) {
			if (menuChoice == 0) break;
			if (menuChoice == 1) {
				store.print();
				storeMenu();
				int storeMenuChoice = scan.nextInt();
				while (true) {
					if (storeMenuChoice == 0) break;
					if (storeMenuChoice == 1) {
						System.out.print("Enter title of media: ");
						String title = scan.nextLine();
						Media m = store.search(title);
						if (m != null) {
							System.out.println(m.toString());
							mediaDetailsMenu(m);
							int mediaDetailsMenuChoice = scan.nextInt();
							while (true) {
								if (mediaDetailsMenuChoice == 0) break;
								boolean isDisc = m instanceof Disc && m instanceof Playable;
								if (mediaDetailsMenuChoice == 1) {
									cart.addMedia(m);
								} else if (mediaDetailsMenuChoice == 2) {
									if (isDisc) {
										Playable playable = (Playable) m;
										playable.play();
									}
								} else {
									System.out.print("Please choose a number: 0-1");
									if (isDisc) System.out.print("-2");
									System.out.println();
								}
							}
						} else {
							System.out.println("Not found " + title + " in the store");
						}
					} else if (storeMenuChoice == 2) {
						System.out.println("Enter the titles of the media you want to add to the cart (separated by commas): ");
						String input = scan.nextLine();
						String titles[] = input.split(",\\s*");
						
						for (String title : titles) {
							Media mediaToAdd = store.search(title.trim());
							if (mediaToAdd != null) {
								cart.addMedia(mediaToAdd);
								if (mediaToAdd instanceof DigitalVideoDisc)
									System.out.println("Number of DVDs in the cart: " + cart.countDVD());
							} else {
								System.out.println("Media with title '" + title.trim() + "' not found in the store");
							}
						}
					} else if (storeMenuChoice == 3) {
						System.out.println("Enter the title of the media you want to play: ");
						String title = scan.nextLine();
						Media m = store.search(title);
						if (m != null) {
							if (m instanceof Disc && m instanceof Playable) {
								Playable playable = (Playable) m;
								playable.play();
							} else {
								System.out.println("Media '" + title + "' cannot be played");
							}
						} else {
							System.out.println("Media with title '" + title + "' not found in the store");
						}
					} else if (storeMenuChoice == 4) {
						
					} else {
						System.out.println("Please choose a number: 0-1-2-3-4");
					}
				}
			} else if (menuChoice == 2) {
				updateStoreMenu();
				updateStore(store, scan);
			} else if (menuChoice == 3) {
				cartMenu();
			} else {
				System.out.println("Please choose a number: 0-1-2-3");
			}
		}
	}

}
