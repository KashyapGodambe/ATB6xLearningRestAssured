package ex_250624.RA_MISC.Listeners;


import org.testng.IExecutionListener;
import org.testng.ISuiteListener;

public class CustomeListener implements IExecutionListener,ISuiteListener {

	@Override
	public void onExecutionStart() {
		// TODO Auto-generated method stub
		System.out.println("onExecutionStart");
	}

	@Override
	public void onExecutionFinish() {
		// TODO Auto-generated method stub
		System.out.println("onExecutionFinish");
	}
	
	
	
	

}
