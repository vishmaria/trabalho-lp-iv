/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.itextpdf.text.*;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.ResultSet;

/**
 *
 * @author Ave Maria
 */
public class PDF {
    public void criaPdf(String tabela, String col1, String col2){
        ConectaBanco cb = new ConectaBanco();
        Document documentoPDF = new Document();
            
        
        try {
          //cria instância do documento 
            PdfWriter.getInstance(documentoPDF, new FileOutputStream 
            ("C:\\Users\\Ave Maria\\Desktop\\documento.pdf"));
            //abrir o documento
            documentoPDF.open();
            Image img = Image.getInstance
            ("C:\\Users\\Ave Maria\\Documents\\TCC\\Logo TCC.png");
            //configurando tamanho
            img.scaleToFit(525,200);
            documentoPDF.add(new Paragraph("  "));
            Paragraph p = new Paragraph ("TCC Automação Residencial");
            p.setAlignment(Element.ALIGN_CENTER);
            documentoPDF.add(p);
            documentoPDF.add(new Paragraph("  "));
            Paragraph p1 = new Paragraph ("Maria Fernanda Bittelbrunn - 123 A");
            p1.setAlignment(Element.ALIGN_CENTER);
            documentoPDF.add(p1);
            img.setAlignment(Element.ALIGN_CENTER);
            //adicionando imagem ao pdf
            documentoPDF.add(img);

            //cria um parágrafo no pdf
            Paragraph p3 = new Paragraph
            ("\nPDF gerado a partir das informações de Automação residencial\n");
            //justificando o paragráfo
            p3.setAlignment(Element.ALIGN_CENTER);
            //adicionando o parágrafo ao pdf
            documentoPDF.add(p3);
            //pulando uma linha
            documentoPDF.add(new Paragraph("  "));
            
         
            //adicionar tabela
            PdfPTable table = new PdfPTable(2); //qtd de colunas como parametro
            //criando celulas alimentadas do banco de dados
            ResultSet rs = cb.buscaDados("select * from aparelho");
            
                try {
                
                    while (rs.next()){
                        
                        PdfPCell cel = new PdfPCell(new Paragraph("Aparelho"));
                        PdfPCell cel1 = new PdfPCell(new Paragraph(rs.getString("nome")));
                        
                        //centraliza o conteudo das celulas
                        cel.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cel1.setHorizontalAlignment(Element.ALIGN_CENTER);
   
                        //adiciona celulas criadas a tabela
                        table.addCell(cel);
                        table.addCell(cel1);
                       
                        
                    }
                    
                } catch (Exception e) {
                }
            
            /*PdfPCell cel = new PdfPCell(new Paragraph("Nome", new Font(FontFamily.COURIER, 23)));
            PdfPCell cel1 = new PdfPCell(new Paragraph("Idade", new Font(FontFamily.COURIER, 23)));
            PdfPCell cel2 = new PdfPCell(new Paragraph("ID", new Font(FontFamily.COURIER, 23)));*/
            //adicionando tabela ao arquivo 
            table.setHorizontalAlignment(Element.ALIGN_CENTER);
            documentoPDF.add(table); 
            
            
            
            //fechando edição do pdf para abrir o arquivo
            documentoPDF.close();
            
        } catch (Exception e) {
            
            e.printStackTrace();
            
        }
        
        
        //Exibir pdf
        try {
            
            Desktop.getDesktop().open(new File ("C:\\Users\\Ave Maria\\Desktop\\documento.pdf"));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
