import org.apache.jena.rdf.model.*;
import org.apache.jena.vocabulary.VCARD;

import java.util.Date;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Model model = ModelFactory.createDefaultModel();

        Resource Stefan = model.createResource("https://twitter.com/Stefk0xd");
        Resource Finki = model.createResource("https://www.finki.ukim.mk/");
        Resource Skopje = model.createResource("https://skopje.gov.mk/");
        Resource Macedonia = model.createResource("https://en.wikipedia.org/wiki/North_Macedonia");

        Stefan.addProperty(VCARD.FN, "Stefan Mitrevski");
        Stefan.addProperty(VCARD.NICKNAME, "Stef");
        Stefan.addProperty(VCARD.BDAY, "25-01-2000");
        Stefan.addProperty(VCARD.ADR, "Blagoja Stefkovski 25-1/15");
        Stefan.addProperty(VCARD.TITLE, "Software Engineer");
        Stefan.addProperty(VCARD.N, Finki);

        Finki.addProperty(VCARD.ADR, Skopje);
        Finki.addProperty(VCARD.ORG, "UKIM");

        Skopje.addProperty(VCARD.GEO, Macedonia);
        Macedonia.addProperty(VCARD.GEO, "Europe");

        StmtIterator stmtIterator = model.listStatements();
        System.out.println("Printing with model.listStatements():");
        while (stmtIterator.hasNext()){
            Statement statement = stmtIterator.nextStatement();
            Resource subject = statement.getSubject();
            Property predicate = statement.getPredicate();
            RDFNode object = statement.getObject();

            System.out.print(subject.toString() + " - ");
            System.out.print(predicate.toString() + " - ");
            if (object instanceof Resource)
                System.out.println(object.toString() + ".");
            else
                System.out.println("\"" + object.toString() + "\".");
        }

        System.out.println("Printing with model.print(), in RDF/XML:");
        model.write(System.out);

        System.out.println("Printing with model.print(), in Pretty RDF/XML:");
        model.write(System.out, "RDF/XML-ABBREV");

        System.out.println("Printing with model.print(), in N-Triples:");
        model.write(System.out, "N-TRIPLES");

        System.out.println("Printing with model.print(), in Turtle:");
        model.write(System.out, "TURTLE");
    }
}
