import java.util.Scanner;
import org.omg.CORBA.*;
import org.omg.CosNaming.*;
import corba.*;

public class CorbaClient {
    static EchoService echoImpl;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        try {
            ORB orb = ORB.init(args, null);
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("nombre del servicio");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
            String name = "Echo";
            echoImpl = EchoServiceHelper.narrow(ncRef.resolve_str(name));
            System.out.println("Texto:");
            String a = sc.nextLine();
            System.out.println(echoImpl.echo(a));
        } catch (Exception e) {
            System.out.println("Error: " + e);
            e.printStackTrace(System.out);
        }
    }
    
}
