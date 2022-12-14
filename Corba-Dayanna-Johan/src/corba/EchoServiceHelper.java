package corba;


abstract public class EchoServiceHelper
{
  private static String  _id = "IDL:corba/EchoService:1.0";

  public static void insert (org.omg.CORBA.Any a, corba.EchoService that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static corba.EchoService extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (corba.EchoServiceHelper.id (), "EchoService");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static corba.EchoService read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_EchoServiceStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, corba.EchoService value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static corba.EchoService narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof corba.EchoService)
      return (corba.EchoService)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      corba._EchoServiceStub stub = new corba._EchoServiceStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static corba.EchoService unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof corba.EchoService)
      return (corba.EchoService)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      corba._EchoServiceStub stub = new corba._EchoServiceStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
