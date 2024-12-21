package hust.soict.dsai.aims.screen.controller;

import java.awt.Button;
import java.awt.TextField;
import java.awt.event.ActionEvent;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class CartScreenController {

	private Cart cart;
	
	@FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;
    
    @FXML
    private TextField tfFilter;
    
    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;
	
	@FXML
	private TableView<Media> tblMedia;
	
	@FXML
	private TableColumn<Media, String> colMediaTitle;
	
	@FXML
	private TableColumn<Media, String> colMediacategory;
	
	@FXML
	private TableColumn<Media, Float> colMediaCost;
	
	public CartScreenController(Cart cart) {
		super();	
		this.cart = cart;
	}
	
	@FXML
	private void initialize() {
		colMediaTitle.setCellValueFactory (new PropertyValueFactory<Media, String>("title"));
		colMediacategory.setCellValueFactory (new PropertyValueFactory<Media, String>("category"));
		colMediaCost.setCellValueFactory (new PropertyValueFactory<Media, Float>("cost"));
		tblMedia.setItems(this.cart.getItemsOrdered());
		
		btnPlay.setVisible(false);
		btnRemove.setVisible(false);
		
		tblMedia.getSelectionModel().selectedItemProperty().addListener(
				new ChangeListener<Media>() {	
			@Override
			public void changed (ObservableValue<? extends Media> observable, Media oldValue,
					Media newValue) {
				if(newValue!=null) {
					updateButtonBar(newValue);
				}
			}
		});
		
		tfFilter.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue,
					String newValue) {
				showFilteredMedia(newValue);
			}
		});
	}
	
	void updateButtonBar(Media media) {
		btnRemove.setVisible(true);
		if(media instanceof Playable) {
			btnPlay.setVisible(true);
		}
		else {
			btnPlay.setVisible(false);
		}
	}
	
	void showFilteredMedia(String input) {
        if (input == "") {
            tblMedia.setItems(cart.getItemsOrdered());
            return;
        }

        FilteredList<Media> filteredList = new FilteredList<>(cart.getItemsOrdered());
        if (radioBtnFilterId.isSelected())
            filteredList.setPredicate((it) -> it.getId() == Integer.parseInt(input));
        else
            filteredList.setPredicate((it) -> it.isMatch(input));

        tblMedia.setItems(filteredList);
    }
	
	@FXML
	void btnRemovePressed(ActionEvent event) {
		Media media = tblMedia.getSelectionModel().getSelectedItem();
		cart.removeMedia(media);
	}
}