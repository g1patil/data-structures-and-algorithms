package annotation;

/**
 * @author g1patil
 *
 * Reference : https://github.com/mmnaseri/cs-review
 * original author @author Mohammad Milad Naseri
 */
public enum Stage {
    /**
     * Marked element is not completely implemented, so there are not any reliable tests
     * for it
     */
    INCOMPLETE,
    /**
     * Marked elements does not behave as it should
     */
    BUGGY,
    /**
     * Marked element is believed to behave as it should, though there are no tests directly targeting it
     */
    UNTESTED,
    /**
     * Marked element has an associated test but the tests are failing
     */
    FAILING,
    /**
     *  Marked element is believed to have been sufficiently tested and is therefore assumed to be reliable for
     *  use and study
     */
    TESTED,
    /**
     * The code is not only tested, but also documented so that it is completely understandable
     */
    DOCUMENTED
}
