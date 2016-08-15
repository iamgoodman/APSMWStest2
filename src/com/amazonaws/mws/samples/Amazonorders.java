package com.amazonaws.mws.samples;

public class Amazonorders {
	
//avaialble fileds to DB
	String Amazonorderid;
	String Sellerorderid;
	String Purchasedate;
	String Lastupdatedate;
	String Orderstatus;
	String Fulfillmentchannel;
	String Saleschannel;
	String Shipservicelevel;
	String Customername;
	String Streetname;
	String City;
	String State;
	String Zip;
	String Country;
	String Phone;
	String Secondaddress;
	String Qtyshipped;
	String Qtyunshipped;
	String Marketplaceid;
	String Shippingservicelevel;
	String OrderType;
	String Earliestshipdate;
	String Latestshipdate;
	String businessorder;
	String Prime;
	String Premium;
	String Currency;
	String Amount;
	String Paymentmethod;
	String email;
	String fullname;
	Boolean Shippedbyamz;
	String asin;
	String sku;
	String productname;
	
	//Constructor
	public Amazonorders(String amazonorderid, String sellerorderid, String purchasedate, String lastupdatedate,
			String orderstatus, String fulfillmentchannel, String saleschannel, String shipservicelevel,
			String customername, String streetname, String city, String state, String zip, String country, String phone,
			String secondaddress, String qtyshipped, String qtyunshipped, String marketplaceid,
			String shippingservicelevel, String orderType, String earliestshipdate, String latestshipdate,
			String businessorder, String prime, String premium, String currency, String amount, String paymentmethod,
			String email, String fullname, Boolean shippedbyamz, String ASIN, String SKU,
			String pr) {
		super();
		Amazonorderid = amazonorderid;
		Sellerorderid = sellerorderid;
		Purchasedate = purchasedate;
		Lastupdatedate = lastupdatedate;
		Orderstatus = orderstatus;
		Fulfillmentchannel = fulfillmentchannel;
		Saleschannel = saleschannel;
		Shipservicelevel = shipservicelevel;
		Customername = customername;
		Streetname = streetname;
		City = city;
		State = state;
		Zip = zip;
		Country = country;
		Phone = phone;
		Secondaddress = secondaddress;
		Qtyshipped = qtyshipped;
		Qtyunshipped = qtyunshipped;
		Marketplaceid = marketplaceid;
		Shippingservicelevel = shippingservicelevel;
		OrderType = orderType;
		Earliestshipdate = earliestshipdate;
		Latestshipdate = latestshipdate;
		this.businessorder = businessorder;
		Prime = prime;
		Premium = premium;
		Currency = currency;
		Amount = amount;
		Paymentmethod = paymentmethod;
		this.email = email;
		this.fullname = fullname;
		Shippedbyamz = shippedbyamz;
		asin = ASIN;
		sku = SKU;
		productname = pr;
	}
	
	//get size of fileds for db
	
	public int getColumnCount() {
	    return getClass().getDeclaredFields().length;
	}
	//getter and setters

	public String getAmazonorderid() {
		return Amazonorderid;
	}

	public void setAmazonorderid(String amazonorderid) {
		Amazonorderid = amazonorderid;
	}

	public String getSellerorderid() {
		return Sellerorderid;
	}

	public void setSellerorderid(String sellerorderid) {
		Sellerorderid = sellerorderid;
	}

	public String getPurchasedate() {
		return Purchasedate;
	}

	public void setPurchasedate(String purchasedate) {
		Purchasedate = purchasedate;
	}

	public String getLastupdatedate() {
		return Lastupdatedate;
	}

	public void setLastupdatedate(String lastupdatedate) {
		Lastupdatedate = lastupdatedate;
	}

	public String getOrderstatus() {
		return Orderstatus;
	}

	public void setOrderstatus(String orderstatus) {
		Orderstatus = orderstatus;
	}

	public String getFulfillmentchannel() {
		return Fulfillmentchannel;
	}

	public void setFulfillmentchannel(String fulfillmentchannel) {
		Fulfillmentchannel = fulfillmentchannel;
	}

	public String getSaleschannel() {
		return Saleschannel;
	}

	public void setSaleschannel(String saleschannel) {
		Saleschannel = saleschannel;
	}

	public String getShipservicelevel() {
		return Shipservicelevel;
	}

	public void setShipservicelevel(String shipservicelevel) {
		Shipservicelevel = shipservicelevel;
	}

	public String getCustomername() {
		return Customername;
	}

	public void setCustomername(String customername) {
		Customername = customername;
	}

	public String getStreetname() {
		return Streetname;
	}

	public void setStreetname(String streetname) {
		Streetname = streetname;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public String getZip() {
		return Zip;
	}

	public void setZip(String zip) {
		Zip = zip;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public String getSecondaddress() {
		return Secondaddress;
	}

	public void setSecondaddress(String secondaddress) {
		Secondaddress = secondaddress;
	}

	public String getQtyshipped() {
		return Qtyshipped;
	}

	public void setQtyshipped(String qtyshipped) {
		Qtyshipped = qtyshipped;
	}

	public String getQtyunshipped() {
		return Qtyunshipped;
	}

	public void setQtyunshipped(String qtyunshipped) {
		Qtyunshipped = qtyunshipped;
	}

	public String getMarketplaceid() {
		return Marketplaceid;
	}

	public void setMarketplaceid(String marketplaceid) {
		Marketplaceid = marketplaceid;
	}

	public String getShippingservicelevel() {
		return Shippingservicelevel;
	}

	public void setShippingservicelevel(String shippingservicelevel) {
		Shippingservicelevel = shippingservicelevel;
	}

	public String getOrderType() {
		return OrderType;
	}

	public void setOrderType(String orderType) {
		OrderType = orderType;
	}

	public String getEarliestshipdate() {
		return Earliestshipdate;
	}

	public void setEarliestshipdate(String earliestshipdate) {
		Earliestshipdate = earliestshipdate;
	}

	public String getLatestshipdate() {
		return Latestshipdate;
	}

	public void setLatestshipdate(String latestshipdate) {
		Latestshipdate = latestshipdate;
	}

	public String getBusinessorder() {
		return businessorder;
	}

	public void setBusinessorder(String businessorder) {
		this.businessorder = businessorder;
	}

	public String getPrime() {
		return Prime;
	}

	public void setPrime(String prime) {
		Prime = prime;
	}

	public String getPremium() {
		return Premium;
	}

	public void setPremium(String premium) {
		Premium = premium;
	}

	public String getCurrency() {
		return Currency;
	}

	public void setCurrency(String currency) {
		Currency = currency;
	}

	public String getAmount() {
		return Amount;
	}

	public void setAmount(String amount) {
		Amount = amount;
	}

	public String getPaymentmethod() {
		return Paymentmethod;
	}

	public void setPaymentmethod(String paymentmethod) {
		Paymentmethod = paymentmethod;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public Boolean getShippedbyamz() {
		return Shippedbyamz;
	}

	public void setShippedbyamz(Boolean shippedbyamz) {
		Shippedbyamz = shippedbyamz;
	}

	public String getAsin() {
		return asin;
	}

	public void setAsin(String ASIN) {
		asin = ASIN;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String SKU) {
		sku = SKU;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String ProductName) {
		productname = ProductName;
	}
	
	
	
	
	

}
