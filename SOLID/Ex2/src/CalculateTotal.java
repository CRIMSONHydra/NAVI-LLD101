import java.util.List;
import java.util.Map;

public class CalculateTotal {
    private CalculateTotal() {}

    public static  double calc(Map<String, MenuItem> menu, List<OrderLine> lines) {
        double subtotal = 0.0;
        for (OrderLine l : lines) {
            MenuItem item = menu.get(l.itemId);
            double lineTotal = item.price * l.qty;
            subtotal += lineTotal;
        }
        return subtotal;
    }
}
