public class DocumentRequest
{
    private String field;
    public DocumentRequest() {}
    public String getField() { return field; }
    public Form getForm() { return new Form(); }
    public void update(String update) { this.field = update; }
}