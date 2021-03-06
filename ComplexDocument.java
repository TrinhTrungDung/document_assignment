package document;

import java.util.ArrayList;
import java.util.List;

public class ComplexDocument implements Document {

    private List<Document> documents = new ArrayList<>();
    private Integer id;
    private String name;

    public ComplexDocument(String name) {
        this.name = name;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public List<Document> getSubDocuments() {
        return this.documents;
    }

    public boolean addDocument(Document document) {
        return documents.add(document);
    }

    public boolean removeDocument(Document document) {
        return documents.remove(document);
    }

    public void removeAllDocuments() {
        this.documents.clear();
    }
}
