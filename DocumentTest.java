package document;

import org.junit.*;
import org.junit.Assert;

public class DocumentTest {

    @Test
    public void testEmptyRoot() {
        Document root = new ComplexDocument("root");
        Assert.assertNull("Test root ID: ", root.getId());
        Assert.assertEquals("Test root name: ", "root", root.getName());
    }

    @Test
    public void testOneCoreDocument() {
        CoreDocument textDocument = new TextDocument("Untitled.txt", TextDocument.Encoding.UTF32);
        textDocument.setId(1);
        Assert.assertEquals("Test text document ID: ", 1, (long) textDocument.getId());
        Assert.assertEquals("Test text document name: ", "Untitled.txt", textDocument.getName());
        Assert.assertEquals("Test text document size: ", 1600, (long) textDocument.size());
    }

    @Test
    public void testOneComplexDocument() {
        ComplexDocument root = new ComplexDocument("root");
        root.setId(5);
        Assert.assertEquals("Test root ID: ",  5, (long) root.getId());
        Assert.assertEquals("Test root name: ", "root", root.getName());
    }

    @Test
    public void testMultipleDocuments() {
        ComplexDocument root = new ComplexDocument("root");
        ComplexDocument folder = new ComplexDocument("folder");
        TextDocument textDocument = new TextDocument("text.txt", TextDocument.Encoding.UTF8);
        GraficDocument graficDocument = new GraficDocument("image.jpg");
        root.setId(1);
        folder.setId(2);
        textDocument.setId(3);
        graficDocument.setId(4);
        root.addDocument(folder);
        root.addDocument(graficDocument);
        folder.addDocument(textDocument);
        Assert.assertEquals("Test root ID: ",1, (long) root.getId());
        Assert.assertEquals("Test root name: ", "root", root.getName());
        Assert.assertTrue("Test root contains folder: ", root.getSubDocuments().contains(folder));
        Assert.assertEquals("Test folder ID: ", 2, (long) folder.getId());
        Assert.assertEquals("Test folder name: ", "folder", folder.getName());
        Assert.assertTrue("Test folder contains file: ", folder.getSubDocuments().contains(textDocument));
        Assert.assertEquals("Test file size: ", 400, (long) textDocument.size());
        Assert.assertEquals("Test image document size: ", 1200, (long) graficDocument.size());
        Assert.assertEquals("Test folder size: ", 1600, (long) root.size());
    }

}
