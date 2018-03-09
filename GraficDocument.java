package document;

import java.util.List;

public class GraficDocument extends CoreDocument {

    private Integer id;
    private String name;
    private static final Integer size = 1200;

    GraficDocument(String url) {
        super(url);
    }

    @Override
    public void setId(Integer id) {
        super.setId(id);
    }

    @Override
    public Integer getId() {
        return super.getId();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public Integer size() {
        return this.size;
    }
}
