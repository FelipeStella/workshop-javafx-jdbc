package gui;

import java.net.URL;
import java.util.ResourceBundle;

import gui.util.Constraints;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.entities.Department;

public class DepartmentFormController implements Initializable{

	private Department entity;

	@FXML
	private TextField txtId;

	@FXML
	private TextField txtName;

	@FXML
	private Label labelErrorName;

	@FXML
	private Button btnSave;

	@FXML
	private Button btnCancel;

	@FXML
	public void onBtnSaveAction(){

	}

	@FXML
	public void onBtnCancelAction(){

	}

	public void setDepartment(Department entity){
		this.entity = entity;
	}

	public Department getDepartment(){
		return entity;
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initializeNodes();
	}

	private void initializeNodes(){
		Constraints.setTextFieldInteger(txtId);
		Constraints.setTextFieldMaxLength(txtName, 30);
	}

	public void updateFormData(){
		if(getDepartment() == null){
			throw new IllegalStateException("Entity was null!");
		}
		txtId.setText(String.valueOf(getDepartment().getId()));
		txtName.setText(getDepartment().getName());
	}

}
