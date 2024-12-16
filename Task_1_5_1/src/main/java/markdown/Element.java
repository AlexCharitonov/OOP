package markdown;

/**
 * Parent class.
 */
public abstract class Element {
    protected String str;

    /**
     * Make string.
     *
     * @return string
     */
    @Override
    public String toString() {
        return this.str;
    }
}