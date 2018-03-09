package document;

public abstract class CoreDocument implements Document {

    private Integer id;
    private String name;
    private String text = null;
    private TextDocument.Encoding encoding = null;
    private String url = null;
    private Integer size;

    CoreDocument(String text, TextDocument.Encoding encoding) {
        if (encoding == TextDocument.Encoding.UTF8) {
            size = 400;
        } else if (encoding == TextDocument.Encoding.UTF16) {
            size = 800;
        } else if (encoding == TextDocument.Encoding.UTF32) {
            size = 1600;
        } else {
            throw new IllegalArgumentException("Encoding version is not supported");
        }
        this.text = text;
        this.encoding = encoding;
    }

    CoreDocument(String url) {
        this.url = url;
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

    public Integer size() {
        return size;
    }
}
