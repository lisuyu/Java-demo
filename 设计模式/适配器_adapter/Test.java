class Address{
	public void street(){
		System.out.println("Address street");
	}
	public void zip(){
		System.out.println("Address zip");
	}
	public void city(){
		System.out.println("Address city");
	}
}

class DutchAddress{
	public void straat(){
		System.out.println("DutchAddress straat");
	}

	public void postcode(){
		System.out.println("DutchAddress postcode");
	}

	public void plaats(){
		System.out.println("DutchAddress plaats");
	}
}

class DutchAddressAdapter extends DutchAddress{
	private Address address;
	public DutchAddressAdapter(Address addr){
		address = addr;
	}

	public void straat(){
		address.street();
	}

	public void postcode(){
		address.zip();
	}

	public void plaats(){
		address.city();
	}
}

class Test{
	public static void main(String[] args) {
		Address addr = new Address();
		DutchAddress addrAdapter = new DutchAddressAdapter(addr);
		System.out.println("\n The DutchAddress \n");
		testDutch(addrAdapter);
	}

	static void testDutch(DutchAddress addr){
		addr.straat();
		addr.postcode();
		addr.plaats();
	}
}