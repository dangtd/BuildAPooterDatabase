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
	private String name;
	private ComputerPart computercase, processor, motherboard, ram, powersupply, graphicscard, harddrive, monitor, keyboard, webcam, headset, computermouse;

	public int getBuildId() {
		return buildId;
	}
	public void setBuildId(int buildId) {
		this.buildId = buildId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ComputerPart getComputercase() {
		return computercase;
	}
	public void setComputercase(ComputerPart computercase) {
		this.computercase = computercase;
	}
	public ComputerPart getProcessor() {
		return processor;
	}
	public void setProcessor(ComputerPart processor) {
		this.processor = processor;
	}
	public ComputerPart getMotherboard() {
		return motherboard;
	}
	public void setMotherboard(ComputerPart motherboard) {
		this.motherboard = motherboard;
	}
	public ComputerPart getRam() {
		return ram;
	}
	public void setRam(ComputerPart ram) {
		this.ram = ram;
	}
	public ComputerPart getPowersupply() {
		return powersupply;
	}
	public void setPowersupply(ComputerPart powersupply) {
		this.powersupply = powersupply;
	}
	public ComputerPart getGraphicscard() {
		return graphicscard;
	}
	public void setGraphicscard(ComputerPart graphicscard) {
		this.graphicscard = graphicscard;
	}
	public ComputerPart getHarddrive() {
		return harddrive;
	}
	public void setHarddrive(ComputerPart harddrive) {
		this.harddrive = harddrive;
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
	public ComputerPart getComputermouse() {
		return computermouse;
	}
	public void setComputermouse(ComputerPart computermouse) {
		this.computermouse = computermouse;
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
