package uz.ilmnajot.library_system_2.exception;

public class NotFoundException  extends RuntimeException {

    private static final long serialVersionUID =1L;

    public NotFoundException(String message){
        super(message);
    }
}
