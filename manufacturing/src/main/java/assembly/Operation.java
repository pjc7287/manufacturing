package assembly;

/**
 * Represents an operation that takes time cycles to be completed.
 */
public interface Operation {

    /**
     * Used to tell the Operation object to perform part of it's operation. Returns status of completion
     * @return (true/false) - depending if operation is complete
     */
    boolean cycle();
}
