/**
 * @author Anubhab
 * @reference https://docs.oracle.com/javase/tutorial/rmi/client.html
 */

// Importing necessary classes
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ComputeClient {
    public static void main(String args[]) {
    	if (args.length != 1) {
			System.out.println("Provide number of random points as argument!");
			return;
		}
    	// Set the server policy
    	System.setProperty("java.security.policy",
    			"D:\\Eclipse\\eclipse-workspace\\21MCMT34_QE7\\client.policy");
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        try {
            String name = "Compute";
            Registry registry = LocateRegistry.getRegistry();
            Compute comp = (Compute) registry.lookup(name);
            Pi task = new Pi(Integer.parseInt(args[0]));
            Double pi = comp.executeTask(task);		// execute remote method
            System.out.println("Server says value of PI is : " + pi);
        } catch (Exception e) {
            System.err.println("ComputePi exception:");
            e.printStackTrace();
        }
    }    
}