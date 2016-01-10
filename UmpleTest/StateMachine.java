/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.22.0.5146 modeling language!*/



/**
 * The do activity of the first state machine is a thread that
 * communicates with the second state machine.
 * It calls the event method e with different arguments.
 * The second state machine only changes state when the
 * guard detects that the argument is valid
 * The argument is also used in the transition action code.
 */
// line 7 "StateMachine.ump"
public class StateMachine
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //StateMachine State Machines
  enum StateMachine1 { s1a, s1b }
  private StateMachine1 stateMachine1;
  enum StateMachine2 { s2a, s2b }
  private StateMachine2 stateMachine2;

  //StateMachine Do Activity Threads
  Thread doActivityStateMachine1S1aThread = null;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public StateMachine()
  {
    setStateMachine1(StateMachine1.s1a);
    setStateMachine2(StateMachine2.s2a);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public String getStateMachine1FullName()
  {
    String answer = stateMachine1.toString();
    return answer;
  }

  public String getStateMachine2FullName()
  {
    String answer = stateMachine2.toString();
    return answer;
  }

  public StateMachine1 getStateMachine1()
  {
    return stateMachine1;
  }

  public StateMachine2 getStateMachine2()
  {
    return stateMachine2;
  }

  private boolean __autotransition2__()
  {
    boolean wasEventProcessed = false;
    
    StateMachine1 aStateMachine1 = stateMachine1;
    switch (aStateMachine1)
    {
      case s1a:
        exitStateMachine1();
        setStateMachine1(StateMachine1.s1b);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean e(int a)
  {
    boolean wasEventProcessed = false;
    
    StateMachine2 aStateMachine2 = stateMachine2;
    switch (aStateMachine2)
    {
      case s2a:
        if (a>6)
        {
        // line 27 "StateMachine.ump"
          System.out.println("e"+a);
          setStateMachine2(StateMachine2.s2b);
          wasEventProcessed = true;
          break;
        }
        break;
      case s2b:
        // line 31 "StateMachine.ump"
        System.out.println("e"+a);
        setStateMachine2(StateMachine2.s2a);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  private void exitStateMachine1()
  {
    switch(stateMachine1)
    {
      case s1a:
        if (doActivityStateMachine1S1aThread != null) { doActivityStateMachine1S1aThread.interrupt(); }
        break;
    }
  }

  private void setStateMachine1(StateMachine1 aStateMachine1)
  {
    stateMachine1 = aStateMachine1;

    // entry actions and do activities
    switch(stateMachine1)
    {
      case s1a:
        doActivityStateMachine1S1aThread = new DoActivityThread(this,"doActivityStateMachine1S1a");
        break;
    }
  }

  private void setStateMachine2(StateMachine2 aStateMachine2)
  {
    stateMachine2 = aStateMachine2;

    // entry actions and do activities
    switch(stateMachine2)
    {
      case s2a:
        // line 26 "StateMachine.ump"
        System.out.println("s2a");
        break;
      case s2b:
        // line 30 "StateMachine.ump"
        System.out.println("s2b");
        break;
    }
  }

  private void doActivityStateMachine1S1a()
  {
    try
    {
      // This do activity sends events to stateMachine1
        e(5);
        Thread.sleep(1000);
        e(6);
        Thread.sleep(1000);
        e(7);
        Thread.sleep(1000);
        e(8);
      Thread.sleep(1);
      __autotransition2__();
    }
    catch (InterruptedException e)
    {

    }
  }

  private static class DoActivityThread extends Thread
  {
    StateMachine controller;
    String doActivityMethodName;
    
    public DoActivityThread(StateMachine aController,String aDoActivityMethodName)
    {
      controller = aController;
      doActivityMethodName = aDoActivityMethodName;
      start();
    }
    
    public void run()
    {
      if ("doActivityStateMachine1S1a".equals(doActivityMethodName))
      {
        controller.doActivityStateMachine1S1a();
      }
    }
  }

  public void delete()
  {}

  // line 35 "StateMachine.ump"
   public static  void main(String [] args){
    Thread.currentThread().setUncaughtExceptionHandler(new UmpleExceptionHandler());
    Thread.setDefaultUncaughtExceptionHandler(new UmpleExceptionHandler());
    StateMachine x = new StateMachine();
  }

  public static class UmpleExceptionHandler implements Thread.UncaughtExceptionHandler
  {
    public void uncaughtException(Thread t, Throwable e)
    {
      translate(e);
      if(e.getCause()!=null)
      {
        translate(e.getCause());
      }
      e.printStackTrace();
    }
    public void translate(Throwable e)
    {
      java.util.List<StackTraceElement> result = new java.util.ArrayList<StackTraceElement>();
      StackTraceElement[] elements = e.getStackTrace();
      try
      {
        for(StackTraceElement element:elements)
        {
          String className = element.getClassName();
          String methodName = element.getMethodName();
          boolean methodFound = false;
          int index = className.lastIndexOf('.')+1;
          try {
            java.lang.reflect.Method query = this.getClass().getMethod(className.substring(index)+"_"+methodName,new Class[]{});
            UmpleSourceData sourceInformation = (UmpleSourceData)query.invoke(this,new Object[]{});
            for(int i=0;i<sourceInformation.size();++i)
            {
              int distanceFromStart = element.getLineNumber()-sourceInformation.getJavaLine(i)-(("main".equals(methodName))?2:0);
              if(distanceFromStart>=0&&distanceFromStart<=sourceInformation.getLength(i))
              {
                result.add(new StackTraceElement(element.getClassName(),element.getMethodName(),sourceInformation.getFileName(i),sourceInformation.getUmpleLine(i)+distanceFromStart));
                methodFound = true;
                break;
              }
            }
          }
          catch (Exception e2){}
          if(!methodFound)
          {
            result.add(element);
          }
        }
      }
      catch (Exception e1)
      {
        e1.printStackTrace();
      }
      e.setStackTrace(result.toArray(new StackTraceElement[0]));
    }
  //The following methods Map Java lines back to their original Umple file / line    
    public UmpleSourceData StateMachine_e(){ return new UmpleSourceData().setFileNames("StateMachine.ump"," StateMachine.ump"," StateMachine.ump").setUmpleLines(26, 26, 30).setJavaLines(95, 97, 105).setLengths(1, 1, 1);}
    public UmpleSourceData StateMachine_main(){ return new UmpleSourceData().setFileNames("StateMachine.ump").setUmpleLines(34).setJavaLines(202).setLengths(3);}
    public UmpleSourceData StateMachine_setStateMachine2(){ return new UmpleSourceData().setFileNames("StateMachine.ump"," StateMachine.ump").setUmpleLines(25, 29).setJavaLines(148, 152).setLengths(1, 1);}
    public UmpleSourceData StateMachine_doActivityStateMachine1S1a(){ return new UmpleSourceData().setFileNames("StateMachine.ump").setUmpleLines(9).setJavaLines(163).setLengths(8);}

  }
  public static class UmpleSourceData
  {
    String[] umpleFileNames;
    Integer[] umpleLines;
    Integer[] umpleJavaLines;
    Integer[] umpleLengths;
    
    public UmpleSourceData(){
    }
    public String getFileName(int i){
      return umpleFileNames[i];
    }
    public Integer getUmpleLine(int i){
      return umpleLines[i];
    }
    public Integer getJavaLine(int i){
      return umpleJavaLines[i];
    }
    public Integer getLength(int i){
      return umpleLengths[i];
    }
    public UmpleSourceData setFileNames(String... filenames){
      umpleFileNames = filenames;
      return this;
    }
    public UmpleSourceData setUmpleLines(Integer... umplelines){
      umpleLines = umplelines;
      return this;
    }
    public UmpleSourceData setJavaLines(Integer... javalines){
      umpleJavaLines = javalines;
      return this;
    }
    public UmpleSourceData setLengths(Integer... lengths){
      umpleLengths = lengths;
      return this;
    }
    public int size(){
      return umpleFileNames.length;
    }
  } 
}