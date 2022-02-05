package OOD_design_5;

public class Main {
  public static void main(String[] args) throws CMDLineProcessorException, PortNotValidException {
    CMDLineProcessor cmdLineProcessor = new CMDLineProcessor();
    cmdLineProcessor.process(args);
  }
}
