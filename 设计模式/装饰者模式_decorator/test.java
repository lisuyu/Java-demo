class invoice{
	public void printInvoice(){
		System.out.println("This is the content of the invoice");
	}
}

class Decorator extends invoice{
	protected invoice ticket;
	public Decorator(invoice t){
		ticket = t;
	}
	public void printInvoice(){
		if (ticket!=null) {
			ticket.printInvoice();
		}
	}
}

class HeadDecorator extends Decorator{
	public HeadDecorator(invoice t){
		super(t);
	}

	public void printInvoice(){
		System.out.println("This is the header of the invoice!");
		ticket.printInvoice();
	}
}

class FootDecorator extends Decorator{
	public FootDecorator(invoice t){
		super(t);
	}

	public void printInvoice(){
		ticket.printInvoice();
		System.out.println("This is the footnote of the invoice!");
	}
}

class test{
	public static void main(String[] args) {
		invoice t = new invoice();
		invoice ticket;
		ticket = new FootDecorator(new HeadDecorator(t));
		ticket.printInvoice();
		System.out.println("-------------");
		ticket = new FootDecorator(new HeadDecorator(new Decorator(null)));
		ticket.printInvoice();
	}
}