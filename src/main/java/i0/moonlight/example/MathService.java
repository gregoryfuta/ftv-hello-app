package i0.moonlight.example;

public class MathService {
    public int sqr(final int i) {
        return i * i;
    }

    public int abs(final int i) {
        return i < 0 ? -1 * i : i;
    }
}
