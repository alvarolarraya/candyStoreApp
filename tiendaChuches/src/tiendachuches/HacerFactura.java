/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiendachuches;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author lukep
 */
public class HacerFactura {
    
    private float precio1;
    private float precio2;
    private float precio3;
    private float precioTotalSinIva;
    private float precioTotalConIva;
    private int cantidadP1;
    private int cantidadP2;
    private int cantidadP3;
    private int numeroFact;
    public HacerFactura(float precio1, float precio2, float precio3, float precioTotalSinIva, float precioTotalConIva, int numeroFact){
        this.precio1 = precio1;
        this.precio2 = precio2;
        this.precio3 = precio3;
        this.cantidadP1 = (int)this.precio1/5;
        this.cantidadP2 = (int)this.precio2/4;
        this.cantidadP3 = (int)this.precio3/6;
        this.precioTotalSinIva = precioTotalSinIva;
        this.precioTotalConIva = precioTotalConIva;
        this.numeroFact = numeroFact;
    }
    
    public void generatePDF(){
        try {
            Document document = new Document();
            String destino = "factura"+this.numeroFact+".pdf";
            PdfWriter.getInstance(document, new FileOutputStream(destino));
            document.open();
            /*Phrase p1 = new Phrase("Numero factura: "+this.numeroFact);
            document.add(p1);
            Phrase p2 = new Phrase("Chuche 1 X "+this.cantidadP1+" : "+this.precio1+" € ");
            document.add(p2);
            Phrase p3 = new Phrase("Chuche 2 X "+this.cantidadP2+" : "+this.precio2+" € ");
            document.add(p3);
            Phrase p4 = new Phrase("Chuche 3 X "+this.cantidadP3+" : "+this.precio3+" € ");
            document.add(p4);
            Phrase p5 = new Phrase("Precio total sin IVA : "+this.precioTotalSinIva+" € ");
            document.add(p5);
            Phrase p6 = new Phrase("Precio total con IVA del 21%: "+this.precioTotalConIva+" € ");
            document.add(p6);*/
            String text = "Numero factura: "+this.numeroFact;
            List list = new List(List.UNORDERED);
            ListItem item = new ListItem(text);
            item.setAlignment(Element.ALIGN_JUSTIFIED);
            list.add(item);
            //--------------------------
            text = "Chuche 1 X "+this.cantidadP1+" : "+this.precio1+" € ";
            item = new ListItem(text);
            item.setAlignment(Element.ALIGN_JUSTIFIED);
            list.add(item);
            //-------------------------
            text = "Chuche 2 X "+this.cantidadP2+" : "+this.precio2+" € ";
            item = new ListItem(text);
            item.setAlignment(Element.ALIGN_JUSTIFIED);
            list.add(item);
            //------------------------
            text = "Chuche 3 X "+this.cantidadP3+" : "+this.precio3+" € ";
            item = new ListItem(text);
            item.setAlignment(Element.ALIGN_JUSTIFIED);
            list.add(item);
            //------------------------
            text = "Precio total sin IVA : "+this.precioTotalSinIva+" € ";
            item = new ListItem(text);
            item.setAlignment(Element.ALIGN_JUSTIFIED);
            list.add(item);
            //------------------------
            text = "Precio total con IVA del 21%: "+this.precioTotalConIva+" € ";
            item = new ListItem(text);
            item.setAlignment(Element.ALIGN_JUSTIFIED);
            list.add(item);
            //------------------------
            document.add(list);
            document.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(HacerFactura.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(HacerFactura.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
