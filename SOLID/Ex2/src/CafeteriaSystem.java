
import java.util.*;

public class CafeteriaSystem {

    private final Map<String, MenuItem> menu = new LinkedHashMap<>();
    private int invoiceSeq = 1000;
    IInvoiceStore store;

    public CafeteriaSystem(IInvoiceStore store) {
        this.store = store;
    }

    public void addToMenu(MenuItem i) {
        menu.put(i.id, i);
    }

    // Intentionally SRP-violating: menu mgmt + tax + discount + format + persistence.
    public void checkout(String customerType, List<OrderLine> lines) {
        //setup
        String invId = "INV-" + (++invoiceSeq);
        ITaxPolicy tax = PolicyFactory.taxFor(customerType);
        IDiscountPolicy discount = PolicyFactory.discountFor(customerType);

        //calculate subtotals
        double subtotal = CalculateTotal.calc(menu, lines);
        double taxPct = tax.taxPercent();
        double currTax = subtotal * (taxPct / 100.0);
        double currDiscount = discount.discountAmount(subtotal, lines.size());

        //calc total
        double total = subtotal + currTax - currDiscount;

        //print invoice
        String printable = InvoiceFormatter.format(invId, menu, lines, subtotal, taxPct, currTax, currDiscount, total);
        System.out.print(printable);

        store.save(invId, printable);
        System.out.println("Saved invoice: " + invId + " (lines=" + store.countLines(invId) + ")");
    }
}
