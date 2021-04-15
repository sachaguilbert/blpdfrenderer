import java.io.File;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDTextField;
import org.apache.log4j.BasicConfigurator;
import java.io.FileReader;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.util.*;
import java.io.IOException;
import org.json.simple.parser.ParseException;
import java.io.FileNotFoundException;

public final class BLPDFRenderer {
    public static void main(String[] args) throws IOException, ParseException, FileNotFoundException{
        BasicConfigurator.configure();
        String formTemplate = "BillOfLadingWithForms.pdf";
        PDDocument pdfDocument = PDDocument.load(new File(formTemplate));
        PDAcroForm acroForm = pdfDocument.getDocumentCatalog().getAcroForm();

        JSONParser parser = new JSONParser();
        Object object = parser.parse(new FileReader("bol.json"));
        JSONObject jsonObject = (JSONObject)object;
        Set<String> keys = jsonObject.keySet();
        Iterator<?> i = keys.iterator();

        do{
            String k = i.next().toString();
            if (acroForm != null){
                acroForm.getField(k).setValue(jsonObject.get(k).toString());
            }

        }while(i.hasNext());
                pdfDocument.save("billoflading.pdf");
        pdfDocument.close();
    }
}
