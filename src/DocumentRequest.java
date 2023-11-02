public class DocumentRequest
{
    private String field;
    public DocumentRequest() {}
    public String getField() { return field; }
    public DataEntry getDataEntry() { return new DataEntry(); }
    public void update(String update) { this.field = update; }
}