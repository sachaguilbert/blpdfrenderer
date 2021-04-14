import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDTextField;

import org.apache.log4j.BasicConfigurator;

public final class BLPDFRenderer
{
    private BLPDFRenderer(){}
    public static void main(String[] args) throws IOException{
        BasicConfigurator.configure();
        String formTemplate = "BillOfLadingWithForms.pdf";
        
        PDDocument pdfDocument = PDDocument.load(new File(formTemplate));

        PDAcroForm acroForm = pdfDocument.getDocumentCatalog().getAcroForm();
        
        if (acroForm != null){
            acroForm.getField( "SHIPPER" ).setValue("OCEAN NETWORK EXPRESS (SINGAPORE) PE. LTD.");
            acroForm.getField( "EXPORTER" ).setValue("2 HARBOURFRONT PLACE, #06-01/03, MERILL LYNCH HARBOURFRONT, SINGAPORE 98499");
            acroForm.getField( "EXPORT REFERENCES" ).setValue("");
            acroForm.getField( "FORWARDING AGEN-REFERENCES FMC NO" ).setValue("");
            acroForm.getField( "CONSIGNEE" ).setValue("");
            acroForm.getField( "NOTIFY PARTY" ).setValue("");
            acroForm.getField( "PRE-CARRIAGE BY" ).setValue("");
            acroForm.getField( "PLACE OF RECEIPT" ).setValue("SINGAPORE");
            acroForm.getField( "OCEAN VESSEL VOYAGE NO FLAG" ).setValue("ONE OLYMPUS 059W");
            acroForm.getField( "PORT OF LANDING" ).setValue("SINGAPORE");
            acroForm.getField( "PORT OF DISCHARGE" ).setValue("ROTTERDAM");
            acroForm.getField( "PLACE OF DELIVERY" ).setValue("ROTTERDAM");
            acroForm.getField( "BOOKING NO" ).setValue("SINA11708600");
            acroForm.getField( "BILL OF LADING NO" ).setValue("ONEYSINA11708600");
            acroForm.getField( "FINAL DESTINATION" ).setValue("");
            acroForm.getField( "TYPE OF MOVEMENT" ).setValue("");
            acroForm.getField( "CNTR NOS" ).setValue("OCEAN FREIGHT PREPAID");
            acroForm.getField( "QUANTITY" ).setValue("");
            acroForm.getField( "H/M" ).setValue("");
            acroForm.getField( "DESCRIPTION OF GOODS" ).setValue("");
            acroForm.getField( "GROSS WEIGHT" ).setValue("");
            acroForm.getField( "GROSS MEASUREMENT" ).setValue("");
            acroForm.getField( "SERVICE CONTRACT NO" ).setValue("");
            acroForm.getField( "DOC FORM NO" ).setValue("");
            acroForm.getField( "COMMODITY CODE" ).setValue("");
            acroForm.getField( "EXCHANGE RATE" ).setValue("");
            acroForm.getField( "EXCHANGE RATE2" ).setValue("");
            acroForm.getField( "CODE" ).setValue("");
            acroForm.getField( "TARRIF ITEM" ).setValue("");
            acroForm.getField( "FREIGHTED AS" ).setValue("");
            acroForm.getField( "RATE" ).setValue("");
            acroForm.getField( "PREPAID" ).setValue("");
            acroForm.getField( "PREPAID2" ).setValue("");
            acroForm.getField( "COLLECT" ).setValue("");
            acroForm.getField( "COLLECT2" ).setValue("");
            acroForm.getField( "DATE CARGO RECEIVED" ).setValue("");
            acroForm.getField( "DATE LADEN ON BOARD" ).setValue("");
            acroForm.getField( "PLACE OF BILLS(S) ISSUE" ).setValue("");
            acroForm.getField( "DATED" ).setValue("");
//             acroForm.getField( "" ).setValue("");
//             acroForm.getField( "" ).setValue("");
//             acroForm.getField( "" ).setValue("");
//             acroForm.getField( "" ).setValue("");
        }
        pdfDocument.save("target/billoflading.pdf");
        pdfDocument.close();
    }

}
