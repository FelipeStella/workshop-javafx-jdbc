package gui;

import java.net.URL;
import java.util.ResourceBundle;

import db.DbException;
import gui.util.Alerts;
import gui.util.Constraints;
import gui.util.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import model.entities.Department;
import model.services.DepartmentService;

public class DepartmentFormController implements Initializable{

	private Department entity;
	private DepartmentService service;

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
	public void onBtnSaveAction(ActionEvent event){
		if(entity == null){
			throw new IllegalStateException("Entity was null!");
		}
		if(service == null){
			throw new IllegalStateException("Service was null!");
		}
		try{
			setDepartment(getFormdata());
			service.saveOrUpdate(getDepartment());
			Utils.currentStage(event).close();
		}
		catch(DbException e){
			Alerts.showAlerts("Error saving object!", null, e.getMessage(), AlertType.ERROR);
		}

	}

	private Department getFormdata() {
		Department obj = new Department();

		obj.setId(Utils.tryParseToInt(txtId.getId()));
		obj.setName(txtName.getText());

		return obj;
	}

	@FXML
	public void onBtnCancelAction(ActionEvent event){
		Utils.currentStage(event).close();
	}

	public void setDepartment(Department entity){
		this.entity = entity;
	}

	public Department getDepartment(){
		return entity;
	}

	public void setDepartmentService(DepartmentService service){
		this.service = service;
	}

	public DepartmentService getDepartmentService(){
		return service;
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
