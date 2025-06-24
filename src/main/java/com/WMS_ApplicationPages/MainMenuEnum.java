package com.WMS_ApplicationPages;


public enum MainMenuEnum {
	
	ARTS_CRAFTS_NEEDLEWORK("Arts-Crafts-Needlework"),
	WORK("My Work"),
	WORK_My_Checked_Out_Items("My Checked-Out Items"),
	WORK_UpComing_WOrk_Items("Upcoming Workitems"),
	FAVORITES("Favorites"),
	SESSION("My Seasons"),
	LIBRARIES("Libraries"),
	REPORTS("Reports"),
	SESSION_PALETTE(" Palette "),
	ADMINISTRATIVE("Administrative"),
	SESSION_LINE_SHEET("Line Sheet"),
	SESSION_LINE_BOARD("LineBoard"),
	LIBRARIES_BOM("BOM"),
	LIBRARIES_BUSSINESS("Business Object"),
	LIBRARIES_CALENDAR("Calendar"),
	LIBRARIES_COLOR("Color"),
	LIBRARIES_COLORWAY("Colorway"),
	LIBRARIES_CONSTRUCTION("Construction"),
	LIBRARIES_CONUNTRY("Country Or Market"),
    LIBRARIES_SUPPLIER("Vendor (Supplier)"),
	LIBRARIES_MEASUREMENTS("Measurements"),
	LIBRARIES_Season("Season"),
	LIBRARIES_DocumentCollection("Document Collection"),
	LIBRARIES_PRODUCT("Product"),
	LIBRARIES_MATERIAL("Material"),
	LIBRARIES_INTELLECTUALPROPERTY("Intellectual Property"),
	LIBRARIES_RETAILDOCUMENT("Retail Document"),
	SESSION_LINESHEET("Line Sheet"),
	LIBRARIES_SIZEDEFINITION("Size Definition"),
	LIBRARIES_SAMPLE("Sample"),
	LIBRARIES_PROGRAM("Program"),
	LIBRARIES_LOG_ENTRY("Log Entry"),
	SAMPLES_CONSOLE("Samples Console"),
	LIBRARIES_COLOR_LOOK("Color/Look"),
	LIBRARIES_Financecode("Finance Code"),
	LIBRARIES_DASHBOARD("Dashboards"),
	LIBRARIES_PALETTE("Palette"),
	LIBRARIES_FAMA("FAMA"),
	LIBRARIES_Plan("Plan"),
	LIBRARIES_Confidentiality("Confidentiality"),
	LIBRARIES_MYWORKLIST("MyWorkListItems"),
	LIBRARIES_RETAILCOMPONENT("Component"),
	REPORTS_LoadFile("Load File"),
	LIBRARIES_SEASONGROUPASSOCIATION("Season Group Associations"),
	LIBRARIES_SIZEDIMENSION("Size Dimension"),
	LIBRARIES_SIZESCALE("Size Scale"),
	LIBRARIES_SIZEGRID("Size Grid"),
	LIBRARIES_SEASON_COLLECTION("Season Collection");

	
	
	private String menu;
	
	MainMenuEnum(String menu) {
		this.menu = menu;
	}
	
	public String menu() {
		return menu;
	}
	
	
}
