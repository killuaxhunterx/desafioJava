package pet.java.exceptions;

public class PetEntitieNotFoundException extends Exception{
    public PetEntitieNotFoundException(String message) {
        System.out.println(message);
    }
}
