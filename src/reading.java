import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.util.FileManager;
import org.apache.jena.vocabulary.VCARD;

import java.io.InputStream;

public class reading {
    public static void main(String[] args) {
        Model model = ModelFactory.createDefaultModel();
        InputStream in = FileManager.get().open("./data.xml");
        if (in == null )
            System.out.println("enter a valid file path");
        model.read(in, "");

        Resource Stefan = model.getResource("https://twitter.com/Stefk0xd");

        System.out.println(Stefan.getProperty(VCARD.FN).getString());
        System.out.println(Stefan.getProperty(VCARD.ADR).getString());
        System.out.println(Stefan.getProperty(VCARD.N).getResource());

    }
}
