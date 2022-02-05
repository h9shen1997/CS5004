package OOD_design_5;

public class CMDLineProcessor {
  private static final int ARGS_MIN = 2;
  private static final int ARGS_MAX = 5;
  private static final String PORT_FLAG = "--port";
  private static final String HOSTNAME_FLAG = "hostname";
  private static final String DEFAULT_HOSTNAME = "localhost";
  private static final EncryptionType DEFAULT_ENCRYPTION = EncryptionType.ENCRYPT;
  public CMDLineProcessor() {
  }

  public CLData process(String[] args) throws CMDLineProcessorException, PortNotValidException {

    CLData returnCLData;
    Integer port;
    String hostname;
    EncryptionType encrypted;

    if(this.checkNumParameters(args)) {
      throw new CMDLineProcessorException("The number of parameter is incorrect");
    } else {
      port = findPortNumber(args);
      hostname = findHostName(args);
      encrypted = findEncrypted(args);
    }
    return new CLData(port, hostname, encrypted);
  }

  private EncryptionType findEncrypted(String[] args) {
    EncryptionType encryptionType = DEFAULT_ENCRYPTION;
    for(String arg : args) {
      if(arg.equals(EncryptionType.ENCRYPT)) {
        encryptionType = EncryptionType.ENCRYPT;
        break;
      }
    }
    return encryptionType;
  }

  private String findHostName(String[] args) {
    String hostname = DEFAULT_HOSTNAME;
    for(int i = 0; i < args.length; i++) {
      if(args[i].equals(HOSTNAME_FLAG)) {
        hostname = args[i + 1];
      }
    }
    return hostname;
  }

  private Integer findPortNumber(String[] args) {
    Integer port = 0;
    for(int i = 0; i < args.length; i++) {
      if(args[i].equals(PORT_FLAG)) {
        port = Integer.parseInt(args[i + 1]);
        break;
      }
    }
    return port;
  }

  private boolean checkNumParameters(String[] args) {
    if(args.length >= ARGS_MIN && args.length <= ARGS_MAX) {
      return true;
    }
    return false;
  }
}
