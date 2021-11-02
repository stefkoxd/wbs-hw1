import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.util.FileManager;
import org.apache.jena.vocabulary.VCARD;

import java.io.InputStream;

public class lastExercise {
    public static void main(String[] args) {
        Model model = ModelFactory.createDefaultModel();

        InputStream in = FileManager.get().open("./hifm-dataset.ttl");
        if (in == null)
            System.out.println("enter a valid file path");
        model.read(in, "", "TURTLE");

        Resource drugBank = model.getResource("http://wifo5-04.informatik.uni-mannheim.de/drugbank/resource/drugbank/");
    }
}
