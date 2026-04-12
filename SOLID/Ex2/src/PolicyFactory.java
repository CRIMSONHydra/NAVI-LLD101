public class PolicyFactory {
    public static ITaxPolicy taxFor(String customerType) {
        if ("student".equalsIgnoreCase(customerType)) return new StudentTaxPolicy();
        if ("staff".equalsIgnoreCase(customerType)) return new StaffTaxPolicy();
        return new DefaultTaxPolicy();
    }

    public static IDiscountPolicy discountFor(String customerType) {
        if ("student".equalsIgnoreCase(customerType)) return new StudentDiscountPolicy();
        if ("staff".equalsIgnoreCase(customerType)) return new StaffDiscountPolicy();
        return new NoDiscountPolicy();
    }
}
