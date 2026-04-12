public class NoDiscountPolicy implements IDiscountPolicy {
    @Override
    public double discountAmount(double subtotal, int distinctLines) {
        return 0.0;
    }
}