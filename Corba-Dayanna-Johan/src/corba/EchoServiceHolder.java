package corba;

public final class EchoServiceHolder implements org.omg.CORBA.portable.Streamable
{
  public corba.EchoService value = null;

  public EchoServiceHolder ()
  {
  }

  public EchoServiceHolder (corba.EchoService initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = corba.EchoServiceHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    corba.EchoServiceHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return corba.EchoServiceHelper.type ();
  }

}
