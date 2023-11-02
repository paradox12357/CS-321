public class Workflow 
{
    private String state;
    private DataEntry entry;
    public Workflow() {}
    public String getState() { return state; }
    public DataEntry getEntry() { return entry; }
    public void addEntry(Form entry) { this.entry = entry; }
    public void save(String update) { this.state = update; }
    public void rmEntry() { this.entry = null; }
}
