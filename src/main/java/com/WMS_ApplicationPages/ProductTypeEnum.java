package com.WMS_ApplicationPages;


public enum ProductTypeEnum {
	
	PRODUCT("Product"),
	DISNEY_VERTICAL("Disney Vertical"),
	CLOTHING("Clothing"),
	ARTS_CRAFTS_NEEDLEWORK("Arts-Crafts-Needlework"),
	EDIBLE_PRODUCTS("Edible Products"),
	FORMULATED_PRODUCTS("Formulated Products - Inedible"),
	AUDIO_VISUAL_PHOTOGRAPHY("Audio Visual-Photography"),
	FABRIC("Fabric"),
	KNIT("Knit"),
	PACKAGING("Packaging"),
	HARD_MATERIAL("Hard Material"),
	NONWOVEN("Non Woven - Other"),
	LEATHERHAIR("Leather-Hair-Fur-Suede"),
	PLUSH("Plush"),
	FAUX("Faux"),
	WOVEN("Woven"),
	OUTSOLE("Outsole"),
	ACCESSORIES("Accessories"),
	BEAUTY_CARE("Beauty-Personal Care-Hygiene"),
	CAMPING("Camping"),
	CLEANING("Cleaning-Hygiene Products"),
	CROSS_SEGEMENT("Cross Segment"),
	FOOD_BEVERAGE("Food-Beverage"),
	FOOTWEAR("Footwear"),
	HEALTHCARE("Healthcare"),
	HOME_APPLICANCES("Home Appliances"),
	HOSUEHOLD("Household-Office Furniture-Furnishings"),
	KITCHENWARE("Kitchenware and Tableware"),
	LAWN_GARDEN("Lawn-Garden Supplies"),
	MUSIC("Music"),
	PERSONAL("Personal Accessories"),
	PET_CARE_FOOD("Pet Care-Food"),
	SPORT_EQUIPMENT("Sports Equipment"),
	STATIONERY_OFFICE("Stationery-Office Machinery-Occasion Supplies"),
	TOYS_GAMES("Toys-Games"),
	VEHICLE("Vehicle"),
	AD_MARKETING("Ad Marketing"),
	ABC("ABC"),
	LICENSED_ENTERTAINMENT("Licensed Entertainment"),
	SPECIAL("Special Business"),
	CPGP_STANDARD("Standard"),
	STANDARD("Standard"),
	PRODUCT_ASSORTMENT("Product Assortment"),
	DESIGN_SAFETY("Design Safety"),
	PRODUCT_COMPONENTS("Product Components"),
	FOOD("Food"),
	PETFOOD("Pet Food"),
	SUPPLEMENT("Supplement"),
	LICENSING("Licensing"),
	LICENSEDNONCPGP("Licensed Merchandise Non CPGP"),
	PRODUCTCOMPONENT("Component"),
	LICENSED("Licensed Products");



	
	private String productType;
	
	ProductTypeEnum(String productType) {
		this.productType = productType;
	}
	
	public String productType() {
		return productType;
	}
	
}
