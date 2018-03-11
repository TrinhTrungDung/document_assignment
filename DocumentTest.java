package document;

import org.junit.*;
import org.junit.Assert;

import javax.print.Doc;

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
        Assert.assertEquals("Test folder size: ", 1600, (long) Document.size(root));
    }

    @Test
    public void testRemoveOneDocument() {
        ComplexDocument doc0 = new ComplexDocument("doc0");
        TextDocument doc2 = new TextDocument("The final exam takes place soon!!", TextDocument.Encoding.UTF8);
        doc0.setId(1);
        doc2.setId(2);
        doc0.addDocument(doc2);
        Assert.assertEquals("Test doc0 size: ", 400, (long) Document.size(doc0));
        doc0.removeDocument(doc2);
        Assert.assertEquals("Test doc0 size: ", 0, (long) Document.size(doc0));
    }

    @Test
    public void testRemoveAllDocuments() {
        ComplexDocument doc0 = new ComplexDocument("doc0");
        TextDocument doc2 = new TextDocument("The final exam takes place soon!!", TextDocument.Encoding.UTF8);
        ComplexDocument doc3 = new ComplexDocument("doc3");
        GraficDocument doc4 = new GraficDocument("localhost:8080");
        TextDocument doc5 = new TextDocument("Software Engineering. Design is a lecture at the VGU!",
                TextDocument.Encoding.UTF32);
        doc0.setId(1);
        doc2.setId(2);
        doc3.setId(3);
        doc4.setId(4);
        doc5.setId(5);
        doc0.addDocument(doc2);
        doc0.addDocument(doc3);
        doc3.addDocument(doc4);
        doc3.addDocument(doc5);
        Assert.assertEquals("Test doc0 size: ", 3200, (long) Document.size(doc0));
        Assert.assertEquals("Test doc3 size: ", 2800, (long) Document.size(doc3));
        doc3.removeAllDocuments();
        Assert.assertEquals("Test doc3 size: ", 0, (long) Document.size(doc3));
        doc0.removeAllDocuments();
        Assert.assertEquals("Test doc0 size: ", 0, (long) Document.size(doc0));
    }

    @Test
    public void sampleTest() {
        ComplexDocument doc0 = new ComplexDocument("doc0");
        TextDocument doc2 = new TextDocument("The final exam takes place soon!!", TextDocument.Encoding.UTF8);
        ComplexDocument doc3 = new ComplexDocument("doc3");
        GraficDocument doc4 = new GraficDocument("localhost:8080");
        TextDocument doc5 = new TextDocument("Software Engineering. Design is a lecture at the VGU!",
                TextDocument.Encoding.UTF32);
        doc0.setId(1);
        doc2.setId(2);
        doc3.setId(3);
        doc4.setId(4);
        doc5.setId(5);
        doc0.addDocument(doc2);
        doc0.addDocument(doc3);
        doc3.addDocument(doc4);
        doc3.addDocument(doc5);
        Assert.assertEquals("Test doc0 size: ", 3200, (long) Document.size(doc0));
        Assert.assertEquals("Test doc3 size: ", 2800, (long) Document.size(doc3));
    }

}
