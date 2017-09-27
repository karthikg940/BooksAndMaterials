
public class Example extends Thread {

	public void run()
	{
		System.out.println("inside run method of Example");
	}

	 public static void main(String[] args) {
		Example e=new Example();
		e.start();
	}
	
}
