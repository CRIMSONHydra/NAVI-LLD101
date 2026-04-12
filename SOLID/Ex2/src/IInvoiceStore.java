public interface IInvoiceStore {
    void save(String name, String content);
    int countLines(String name);
}
