package i0.sealights.ftv.model.math;

public final class ComplexInteger {
    private final int real;
    private final int imagine;

    public ComplexInteger(int real, int imagine) {
        this.real = real;
        this.imagine = imagine;
    }

    public ComplexInteger add(ComplexInteger number) {
        return new ComplexInteger(this.real + number.real, this.imagine + number.imagine);
    }

    public ComplexInteger sub(ComplexInteger number) {
        return new ComplexInteger(this.real - number.real, this.imagine - number.imagine);
    }

    public int getReal() {
        return real;
    }

    public int getImagine() {
        return imagine;
    }
}
