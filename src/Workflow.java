public class Workflow 
{
    private String state;
    private Form entry;
    public Workflow() {}
    public String getState() { return state; }
    public Form getEntry() { return entry; }
    public void addEntry(Form entry) { this.entry = entry; }
    public void save(String update) { this.state = update; }
    public void rmEntry() { this.entry = null; }
}
