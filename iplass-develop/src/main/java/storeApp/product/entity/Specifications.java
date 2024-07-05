package storeApp.product.entity;

import org.iplass.mtp.entity.GenericEntity;

/**
 * Specifications Entity。
 */
public class Specifications extends GenericEntity {

	private static final long serialVersionUID = 1L;

	/** Entity Definition Name */
	public static final String DEFINITION_NAME = "storeApp.product.Specifications";

	/** Main Camera */
	public static final String MAIN_CAMERA = "mainCamera";
	/** Front Camera */
	public static final String FRONT_CAMERA = "frontCamera";
	/** Screen size */
	public static final String SCREEN_SIZE = "screenSize";
	/** RAM */
	public static final String RAM = "ram";
	/** ROM */
	public static final String ROM = "rom";
	/** Chipset */
	public static final String CHIPSET = "chipset";
	/** Pin */
	public static final String PIN = "pin";

	public Specifications() {
		setDefinitionName(DEFINITION_NAME);
	}

	/**
	 * Main Cameraを返します。
	 * 
	 * @return Main Camera
	 */
	public String getMainCamera() {
		return getValue(MAIN_CAMERA);
	}

	/**
	 * Main Cameraを設定します。
	 * 
	 * @param mainCamera Main Camera
	 */
	public void setMainCamera(String mainCamera) {
		setValue(MAIN_CAMERA, mainCamera);
	}

	/**
	 * Front Cameraを返します。
	 * 
	 * @return Front Camera
	 */
	public String getFrontCamera() {
		return getValue(FRONT_CAMERA);
	}

	/**
	 * Front Cameraを設定します。
	 * 
	 * @param frontCamera Front Camera
	 */
	public void setFrontCamera(String frontCamera) {
		setValue(FRONT_CAMERA, frontCamera);
	}

	/**
	 * Screen sizeを返します。
	 * 
	 * @return Screen size
	 */
	public String getScreenSize() {
		return getValue(SCREEN_SIZE);
	}

	/**
	 * Screen sizeを設定します。
	 * 
	 * @param screenSize Screen size
	 */
	public void setScreenSize(String screenSize) {
		setValue(SCREEN_SIZE, screenSize);
	}

	/**
	 * RAMを返します。
	 * 
	 * @return RAM
	 */
	public String getRam() {
		return getValue(RAM);
	}

	/**
	 * RAMを設定します。
	 * 
	 * @param ram RAM
	 */
	public void setRam(String ram) {
		setValue(RAM, ram);
	}

	/**
	 * ROMを返します。
	 * 
	 * @return ROM
	 */
	public String getRom() {
		return getValue(ROM);
	}

	/**
	 * ROMを設定します。
	 * 
	 * @param rom ROM
	 */
	public void setRom(String rom) {
		setValue(ROM, rom);
	}

	/**
	 * Chipsetを返します。
	 * 
	 * @return Chipset
	 */
	public String getChipset() {
		return getValue(CHIPSET);
	}

	/**
	 * Chipsetを設定します。
	 * 
	 * @param chipset Chipset
	 */
	public void setChipset(String chipset) {
		setValue(CHIPSET, chipset);
	}

	/**
	 * Pinを返します。
	 * 
	 * @return Pin
	 */
	public String getPin() {
		return getValue(PIN);
	}

	/**
	 * Pinを設定します。
	 * 
	 * @param pin Pin
	 */
	public void setPin(String pin) {
		setValue(PIN, pin);
	}

}
