public class Synset {
    String id;
    String syn;
    String def;

    public Synset(String id, String syn, String def) {
       this.id = id;
        this.syn = syn;
        this.def = def;
    }

    @Override
    public String toString() {
        return "Synset [def=" + def + ", id=" + id + ", syn=" + syn + "]";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSyn() {
        return syn;
    }

    public void setSyn(String syn) {
        this.syn = syn;
    }

    public String getDef() {
        return def;
    }

    public void setDef(String def) {
        this.def = def;
    }
}