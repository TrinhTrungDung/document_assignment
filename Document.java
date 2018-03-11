package document;

import java.util.List;

public interface Document {
    void setId(Integer id);
    Integer getId();
    void setName(String name);
    String getName();
    static Integer size(Document document) {
        Integer totalSize = 0;

        if (document instanceof CoreDocument) {
            totalSize += ((CoreDocument) document).size();
        } else {
            for (Document subDocument : ((ComplexDocument) document).getSubDocuments()) {
                if (subDocument instanceof CoreDocument) {
                    totalSize += ((CoreDocument) subDocument).size();
                } else {
                    totalSize += size(subDocument);
                }
            }
        }

        return totalSize;
    }
}
