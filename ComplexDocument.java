package document;

import java.util.ArrayList;
import java.util.List;

public class ComplexDocument implements Document {

    private static List<Document> documents = new ArrayList<>();
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

    public Integer size() {
        Integer totalSize = 0;

        for (Document document : documents) {
            if (document instanceof CoreDocument) {
                totalSize += ((CoreDocument) document).size();
            }
        }

        return totalSize;
    }

    public boolean addDocument(Document document) {
        return documents.add(document);
    }

    public boolean removeDocument(Document document) {
        return documents.remove(document);
    }
}
