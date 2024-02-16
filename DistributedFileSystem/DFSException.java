public class DFSException extends Exception{
    public static class ServerdoesnotexistException extends DFSException{
       public ServerdoesnotexistException(){
           System.out.println("Server Does not exist");
       }
    }
    public static class Filedoesnotexist extends DFSException{
        public Filedoesnotexist(){
            System.out.println("No such File Exists!!");
        }
    }
    public static class NotenoughspaceException extends DFSException{
        public NotenoughspaceException(){
            System.out.println("Not enough space available on the server!!");
        }
    }
}
