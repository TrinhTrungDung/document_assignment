package document;

import java.util.List;

public class TextDocument extends CoreDocument {

    private Integer id;
    private String name;
    public enum Encoding {UTF8 , UTF16, UTF32}

    TextDocument(String name, Encoding encoding) {
        super(name, encoding);
        this.name = name;
    }

    @Override
    public void setId(Integer id) {
        super.setId(id);
        this.id = id;
    }

    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public void setName(String name) {
        super.setName(name);
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Integer size() {
        return super.size();
    }
}
