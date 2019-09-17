class Pizza{
	private String parts;
	public void setParts(String parts){
		this.parts = parts;
	}
	public String toString(){
		return this.parts;
	}
}

abstract class PizzaBuilder{
	protected Pizza pizza;
	public Pizza getPizza(){
		return pizza;
	}
	public void createNewPizza(){
		pizza = new Pizza();
	}
	public abstract void buildParts();
}

class HawaiianPizzaBuilder extends PizzaBuilder{
	public void buildParts(){
		pizza.setParts("cross + mild + ham&pineapple");
	}
}

class SpicyPizzaBuilder extends PizzaBuilder{
	public void buildParts(){
		pizza.setParts("pan baked + hot +pepperoni&salami");
	}
}

class Waiter{
	private PizzaBuilder pizzaBuilder;
	public void setPizzaBuilder(PizzaBuilder pizzaBuilder){
		this.pizzaBuilder = pizzaBuilder;
	}
	public Pizza getPizza(){
		return pizzaBuilder.getPizza();
	}
	public void construct(){
		pizzaBuilder.createNewPizza();
		pizzaBuilder.buildParts();
	}
}

class FastFoodOrdering{
	public static void main(String[] args) {
		Waiter waiter = new Waiter();
		PizzaBuilder hawaiianPizzaBuilder = new HawaiianPizzaBuilder();
		waiter.setPizzaBuilder(hawaiianPizzaBuilder);
		waiter.construct();
		System.out.println("pizza:"+waiter.getPizza());
	}
}