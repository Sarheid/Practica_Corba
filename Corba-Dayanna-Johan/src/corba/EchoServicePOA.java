package corba;


public abstract class EchoServicePOA extends org.omg.PortableServer.Servant
 implements corba.EchoServiceOperations, org.omg.CORBA.portable.InvokeHandler
{



  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("echo", new java.lang.Integer (0));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  
       {
         String x = in.read_string ();
         String $result = null;
         $result = this.echo (x);
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } 
  private static String[] __ids = {
    "IDL:corba/EchoService:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public EchoService _this() 
  {
    return EchoServiceHelper.narrow(
    super._this_object());
  }

  public EchoService _this(org.omg.CORBA.ORB orb) 
  {
    return EchoServiceHelper.narrow(
    super._this_object(orb));
  }


} 
