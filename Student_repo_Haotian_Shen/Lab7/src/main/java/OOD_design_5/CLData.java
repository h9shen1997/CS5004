package OOD_design_5;

import javax.print.DocFlavor.STRING;

public class CLData {
  private Integer port;
  private String hostname;
  private EncryptionType encrypted;
  private static final int PORT_MIN = 1000;
  private static final int PORT_MAX = 65000;




  public CLData(Integer port, String hostname, EncryptionType encrypted) throws PortNotValidException {
    if(!this.isPortValid(port)) {
      throw new PortNotValidException("The provided port value is not valid");
    }
    this.port = port;
    this.hostname = hostname;
    this.encrypted = encrypted;
  }

  private boolean isPortValid(Integer port) {
    if (port >= PORT_MIN && port <= PORT_MAX) {
      return true;
    }
    return false;
  }
}
