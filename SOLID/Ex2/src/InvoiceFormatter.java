public class InvoiceFormatter {
    // pointless wrapper (smell)
    public String print(StringBuilder out) {
        String printable = out.toString();
        System.out.print(printable);
        return printable;
    }
}
