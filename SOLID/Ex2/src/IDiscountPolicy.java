public interface IDiscountPolicy {
    double discountAmount(double subtotal, int distinctLines);
}
