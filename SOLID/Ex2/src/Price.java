import java.util.List;
import java.util.Map;

public class Price {
    private final Map<String, MenuItem> menu;
    private final List<OrderLine> lines;
    private final StringBuilder out;
    private final String customerType;
    double subtotal, tax, discount;

    public Price(Map<String, MenuItem> menu, List<OrderLine> lines, StringBuilder out, String customerType) {
        this.menu = menu;
        this.lines = lines;
        this.out = out;
        this.customerType = customerType;
        subtotal = 0.0;
        tax = 0.0;
        discount = 0.0;
    }

    public void calculateSubtotal() {
        subtotal = 0.0;
        for (OrderLine l : lines) {
            MenuItem item = menu.get(l.itemId);
            double lineTotal = item.price * l.qty;
            subtotal += lineTotal;
            out.append(String.format("- %s x%d = %.2f\n", item.name, l.qty, lineTotal));
        }
        out.append(String.format("Subtotal: %.2f\n", subtotal));
    }

    public void calculateTax() {
        double taxPct = TaxRules.taxPercent(customerType);
        tax = subtotal * (taxPct / 100.0);

        out.append(String.format("Tax(%.0f%%): %.2f\n", taxPct, tax));
    }

    public void calculateDiscount() {
        discount = DiscountRules.discountAmount(customerType, subtotal, lines.size());
        
        out.append(String.format("Discount: -%.2f\n", discount));
    }

    public void calculateTotal() {
        double total = subtotal + tax - discount;
       
        out.append(String.format("TOTAL: %.2f\n", total));
    }
}
