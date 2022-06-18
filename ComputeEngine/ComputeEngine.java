/**
 * @author Anubhab
 * @reference https://docs.oracle.com/javase/tutorial/rmi/implementing.html
 */

// Importing necessary classes
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ComputeEngine extends UnicastRemoteObject implements Compute {

	private static final long serialVersionUID = 1L;

	protected ComputeEngine() throws RemoteException {
		super();
	}

	@Override
	public <T> T executeTask(Task<T> t) throws RemoteException {
		return t.execute();
	}

	public static void main(String args[]) {
		// Set the server policy
		System.setProperty("java.security.policy","D:\\Eclipse\\eclipse-workspace\\21MCMT34_QE7\\server.policy");
		if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        try {
            String name = "Compute";
            Compute stub = new ComputeEngine();
            Registry registry = LocateRegistry.getRegistry();
            registry.rebind(name, stub);
            System.out.println("ComputeEngine bound");
        } catch (Exception e) {
            System.err.println("ComputeEngine exception:");
            e.printStackTrace();
        }
	}
}

