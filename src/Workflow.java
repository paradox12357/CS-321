public class Workflow 
{
    private String state;
    public String firstname, lastname, ssn, email, id;
    private DataEntry entry;
    private Review review;
    public boolean continueWorkflow = false;
    public Workflow() {}
    public String getState() { return state; }
    public DataEntry getEntry() { return entry; }
    public Review getReview() { return review; }
    public void addEntry(DataEntry entry) { this.entry = entry; }
    public void addReview(Review review) { this.review = review; }
    public void save(String update) { this.state = update; }
    public void rmEntry() { this.entry = null; }

    public static void main(String[] args) 
    {
        Workflow workflow = new Workflow();
        workflow.state = "Data Entry";
        FormFrame frame = new FormFrame(workflow);
        while(!workflow.continueWorkflow) {System.out.print("");}
        System.out.println("got entry");
        workflow.firstname = workflow.entry.getFirstName();
        workflow.lastname = workflow.entry.getLastName();
        workflow.ssn = workflow.entry.getSSN();
        workflow.email = workflow.entry.getEmail();
        workflow.id = workflow.entry.getID();
        workflow.state = "Review";
        ReviewFrame frame2 = new ReviewFrame(workflow);
        workflow.continueWorkflow = false;
        while(!workflow.continueWorkflow) {System.out.print("");}
        System.out.println("got review");
        workflow.firstname = workflow.review.getFirstName();
        workflow.lastname = workflow.review.getLastName();
        workflow.ssn = workflow.review.getSSN();
        workflow.state = "Approval";
        DocumentRequest DRForm = new DocumentRequest();
        Approval frame3 = new Approval(workflow, DRForm);
        workflow.continueWorkflow = false;
        while(!workflow.continueWorkflow) {System.out.print("");}
        System.out.println("got approval");
        // submit to database
        return;
    }
}
