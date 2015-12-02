package ca.sheridancollege.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

@DynamicUpdate
@SelectBeforeUpdate
@Entity
public class Build implements Serializable {

	@Id
	@GeneratedValue
	private int buildId;
	private ComputerPart name, computerCase, motherBoard, ram, graphicCard, hardDrive, powerSupply, processor, monitor, keyboard, webcam, headset, mouse;
	
	public int getBuildId() {
		return buildId;
	}

	public void setBuildId(int buildId) {
		this.buildId = buildId;
	}

	public ComputerPart getName() {
		return name;
	}

	public void setName(ComputerPart name) {
		this.name = name;
	}

	public ComputerPart getComputerCase() {
		return computerCase;
	}

	public void setComputerCase(ComputerPart computerCase) {
		this.computerCase = computerCase;
	}

	public ComputerPart getMotherBoard() {
		return motherBoard;
	}

	public void setMotherBoard(ComputerPart motherBoard) {
		this.motherBoard = motherBoard;
	}

	public ComputerPart getRam() {
		return ram;
	}

	public void setRam(ComputerPart ram) {
		this.ram = ram;
	}

	public ComputerPart getGraphicCard() {
		return graphicCard;
	}

	public void setGraphicCard(ComputerPart graphicCard) {
		this.graphicCard = graphicCard;
	}

	public ComputerPart getHardDrive() {
		return hardDrive;
	}

	public void setHardDrive(ComputerPart hardDrive) {
		this.hardDrive = hardDrive;
	}

	public ComputerPart getPowerSupply() {
		return powerSupply;
	}

	public void setPowerSupply(ComputerPart powerSupply) {
		this.powerSupply = powerSupply;
	}

	public ComputerPart getProcessor() {
		return processor;
	}

	public void setProcessor(ComputerPart processor) {
		this.processor = processor;
	}

	public ComputerPart getMonitor() {
		return monitor;
	}

	public void setMonitor(ComputerPart monitor) {
		this.monitor = monitor;
	}

	public ComputerPart getKeyboard() {
		return keyboard;
	}

	public void setKeyboard(ComputerPart keyboard) {
		this.keyboard = keyboard;
	}

	public ComputerPart getWebcam() {
		return webcam;
	}

	public void setWebcam(ComputerPart webcam) {
		this.webcam = webcam;
	}

	public ComputerPart getHeadset() {
		return headset;
	}

	public void setHeadset(ComputerPart headset) {
		this.headset = headset;
	}

	public ComputerPart getMouse() {
		return mouse;
	}

	public void setMouse(ComputerPart mouse) {
		this.mouse = mouse;
	}

	public Build() {
		super();
	}
	
	@OneToMany(fetch=FetchType.EAGER )
	private List<Comment> commentList = new ArrayList<Comment>();
	public List<Comment> getCommentList() {
		return commentList;
	}
	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}
}
