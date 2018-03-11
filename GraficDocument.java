package document;

import java.net.URL;

public class GraficDocument extends CoreDocument {

    private Integer id;
    private String url;
    private static final Integer size = 1200;

    GraficDocument(String url) {
        super(url);
        this.url = url;
    }

    @Override
    public void setId(Integer id) {
        super.setId(id);
    }

    @Override
    public Integer getId() {
        return super.getId();
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }

    @Override
    public Integer size() {
        return this.size;
    }
}
