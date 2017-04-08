package observer;



public abstract class Observer<T> {
    protected final Subject<T> subject;

    /**
     * Default constructor
     *
     * @param subject the subject object
     */
    public Observer(final Subject<T> subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    public abstract void update();
}