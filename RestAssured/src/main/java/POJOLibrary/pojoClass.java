package POJOLibrary;

public class pojoClass
{
    public String name;
    public String job;

    public pojoClass(String name, String job){
        super();
        this.name=name;
        this.job=job;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }


}