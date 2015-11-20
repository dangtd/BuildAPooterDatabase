package ca.sheridancollege.beans;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

@DynamicUpdate
@SelectBeforeUpdate
@Entity
public class Build implements Serializable {

	@Id
	@GeneratedValue
	private int buildId;
	private String title, computerCase, motherBoard, ram, graphicCard, hardDrive, powerSupply, discDrive;
	
	public int getBuildId() {
		return buildId;
	}

	public void setBuildId(int buildId) {
		this.buildId = buildId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getComputerCase() {
		return computerCase;
	}

	public void setComputerCase(String computerCase) {
		this.computerCase = computerCase;
	}

	public String getMotherBoard() {
		return motherBoard;
	}

	public void setMotherBoard(String motherBoard) {
		this.motherBoard = motherBoard;
	}

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	public String getGraphicCard() {
		return graphicCard;
	}

	public void setGraphicCard(String graphicCard) {
		this.graphicCard = graphicCard;
	}

	public String getHardDrive() {
		return hardDrive;
	}

	public void setHardDrive(String hardDrive) {
		this.hardDrive = hardDrive;
	}

	public String getPowerSupply() {
		return powerSupply;
	}

	public void setPowerSupply(String powerSupply) {
		this.powerSupply = powerSupply;
	}

	public String getDiscDrive() {
		return discDrive;
	}

	public void setDiscDrive(String discDrive) {
		this.discDrive = discDrive;
	}


	public Build(int buildId, String title, String computerCase, String motherBoard, String ram, String graphicCard,
			String hardDrive, String powerSupply, String discDrive) {
		super();
		this.buildId = buildId;
		this.title = title;
		this.computerCase = computerCase;
		this.motherBoard = motherBoard;
		this.ram = ram;
		this.graphicCard = graphicCard;
		this.hardDrive = hardDrive;
		this.powerSupply = powerSupply;
		this.discDrive = discDrive;
	}

	public Build() {
		super();
	}
	
}
