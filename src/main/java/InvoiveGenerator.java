

import com.itextpdf.text.pdf.FontSelector;
import com.itextpdf.text.pdf.PdfDocument;
import com.itextpdf.text.pdf.PdfImage;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Scanner;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.codec.Base64.OutputStream;
public class InvoiveGenerator {
	
	public static PdfPCell getIRHCell(String text, int alignment) {
		FontSelector fs = new FontSelector();
		Font font = FontFactory.getFont(FontFactory.HELVETICA, 16);
		/*	font.setColor(BaseColor.GRAY);*/
		fs.addFont(font);
		Phrase phrase = fs.process(text);
		PdfPCell cell = new PdfPCell(phrase);
		cell.setPadding(5);
		cell.setHorizontalAlignment(alignment);
		cell.setBorder(PdfPCell.NO_BORDER);
		return cell;
	}

	public static PdfPCell getIRDCell(String text) {
		PdfPCell cell = new PdfPCell (new Paragraph (text));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		cell.setPadding (5.0f);
		cell.setBorderColor(BaseColor.LIGHT_GRAY);
		return cell;
	}

	public static PdfPCell getBillHeaderCell(String text) {
		FontSelector fs = new FontSelector();
		Font font = FontFactory.getFont(FontFactory.HELVETICA, 11);
		font.setColor(BaseColor.GRAY);
		fs.addFont(font);
		Phrase phrase = fs.process(text);
		PdfPCell cell = new PdfPCell (phrase);
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		cell.setPadding (5.0f);
		return cell;
	}

	public static PdfPCell getBillRowCell(String text) {
		PdfPCell cell = new PdfPCell (new Paragraph (text));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		cell.setPadding (5.0f);
		cell.setBorderWidthBottom(0);
		cell.setBorderWidthTop(0);
		return cell;
	}

	public static PdfPCell getBillFooterCell(String text) {
		PdfPCell cell = new PdfPCell (new Paragraph (text));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		cell.setPadding (5.0f);
		cell.setBorderWidthBottom(0);
		cell.setBorderWidthTop(0);
		return cell;
	}

	public static PdfPCell getValidityCell(String text) {
		FontSelector fs = new FontSelector();
		Font font = FontFactory.getFont(FontFactory.HELVETICA, 10);
		font.setColor(BaseColor.GRAY);
		fs.addFont(font);
		Phrase phrase = fs.process(text);
		PdfPCell cell = new PdfPCell (phrase);		
		cell.setBorder(0);
		return cell;
	}

	public static PdfPCell getAccountsCell(String text) {
		FontSelector fs = new FontSelector();
		Font font = FontFactory.getFont(FontFactory.HELVETICA, 10);
		fs.addFont(font);
		Phrase phrase = fs.process(text);
		PdfPCell cell = new PdfPCell (phrase);		
		cell.setBorderWidthRight(0);
		cell.setBorderWidthTop(0);
		cell.setPadding (5.0f);
		return cell;
	}
	public static PdfPCell getAccountsCellR(String text) {
		FontSelector fs = new FontSelector();
		Font font = FontFactory.getFont(FontFactory.HELVETICA, 10);
		fs.addFont(font);
		Phrase phrase = fs.process(text);
		PdfPCell cell = new PdfPCell (phrase);		
		cell.setBorderWidthLeft(0);
		cell.setBorderWidthTop(0);
		cell.setHorizontalAlignment (Element.ALIGN_RIGHT);
		cell.setPadding (5.0f);
		cell.setPaddingRight(20.0f);
		return cell;
	}

	public static PdfPCell getdescCell(String text) {
		FontSelector fs = new FontSelector();
		Font font = FontFactory.getFont(FontFactory.HELVETICA, 10);
		font.setColor(BaseColor.GRAY);
		fs.addFont(font);
		Phrase phrase = fs.process(text);
		PdfPCell cell = new PdfPCell (phrase);	
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		cell.setBorder(0);
		return cell;
	}

	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		
		Document document = new Document();
	      try
	      {
	    	  System.out.println("Enter Invoice pdf no:");
	    	 int pdfno=Integer.parseInt(sc.nextLine());

	    	  PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("Invoice"+pdfno+".pdf"));
	          document.open();
	         
	  		
	  		System.out.print("Enter Customer name:");
	  		String Customername=sc.nextLine();
	  		System.out.print("Enter Contact Number:");
	  		String contactno=sc.nextLine();
	  		System.out.print("Enter city name:");
	  		String city=sc.nextLine();
	  		
	  		System.out.print("Enter Invoice Number:");
		    String invoiceno=sc.nextLine();
		    System.out.print("Enter Invoice Date:");
		    String invoicedate=sc.nextLine();
	  		
	  		System.out.print("Enter Index No:");
	        String index=sc.nextLine();
	        System.out.print("Enter Item Name:");
	        String item=sc.nextLine();
	  		System.out.print("Enter Description:");
	  		String description=sc.nextLine();
	  		System.out.print("Enter Unit Price:");
	  		String unitprice=sc.nextLine();
	  		System.out.print("Enter Quantity:");
	  		String quantity=sc.nextLine();
	  		System.out.print("Enter Product amount:");
	  		String amount=sc.nextLine();
	  		
	          document.add(new Paragraph("INVOICE GENERATED!!!!"));
	          
	    	  PdfPTable irdTable = new PdfPTable(2);
				irdTable.addCell(getIRDCell("Invoice No"));
				irdTable.addCell(getIRDCell("Invoice Date"));
				
				irdTable.addCell(getIRDCell(invoiceno)); 
				irdTable.addCell(getIRDCell(invoicedate)); 
				
				

				PdfPTable irhTable = new PdfPTable(3);
				irhTable.setWidthPercentage(100);

				irhTable.addCell(getIRHCell("", PdfPCell.ALIGN_RIGHT));
				irhTable.addCell(getIRHCell("", PdfPCell.ALIGN_RIGHT));
				irhTable.addCell(getIRHCell("Invoice", PdfPCell.ALIGN_RIGHT));
				irhTable.addCell(getIRHCell("", PdfPCell.ALIGN_RIGHT));
				irhTable.addCell(getIRHCell("", PdfPCell.ALIGN_RIGHT));
				PdfPCell invoiceTable = new PdfPCell (irdTable);
				invoiceTable.setBorder(0);
				irhTable.addCell(invoiceTable);

				FontSelector fs = new FontSelector();
				Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN, 13, Font.BOLD);
				fs.addFont(font);
				Phrase bill = fs.process("Bill To"); // customer information
				Paragraph name = new Paragraph(Customername);
				name.setIndentationLeft(20);
				Paragraph contact = new Paragraph(contactno);
				contact.setIndentationLeft(20);
				Paragraph address = new Paragraph(city);
				address.setIndentationLeft(20);

				PdfPTable billTable = new PdfPTable(6); 
				billTable.setWidthPercentage(100);
				billTable.setWidths(new float[] { 1, 2,5,2,1,2 });
				billTable.setSpacingBefore(30.0f);
				billTable.addCell(getBillHeaderCell("Index"));
				billTable.addCell(getBillHeaderCell("Item"));
				billTable.addCell(getBillHeaderCell("Description"));
				billTable.addCell(getBillHeaderCell("Unit Price"));
				billTable.addCell(getBillHeaderCell("Qty"));
				billTable.addCell(getBillHeaderCell("Amount"));
				
				
				billTable.addCell(getBillRowCell(index));
				billTable.addCell(getBillRowCell(item));
				billTable.addCell(getBillRowCell(description));
				billTable.addCell(getBillRowCell(unitprice));
				billTable.addCell(getBillRowCell(quantity));
				billTable.addCell(getBillRowCell(amount));
				
				billTable.addCell(getBillRowCell(index));
				billTable.addCell(getBillRowCell(item));
				billTable.addCell(getBillRowCell(description));
				billTable.addCell(getBillRowCell(unitprice));
				billTable.addCell(getBillRowCell(quantity));
				billTable.addCell(getBillRowCell(amount));

				PdfPTable validity = new PdfPTable(1);
				validity.setWidthPercentage(100);
				validity.addCell(getValidityCell(" "));
				validity.addCell(getValidityCell("Warranty"));
				validity.addCell(getValidityCell(" * Products purchased comes with 1 year national warranty \n   (if applicable)"));
				validity.addCell(getValidityCell(" * Warranty should be claimed only from the respective manufactures"));		    
				PdfPCell summaryL = new PdfPCell (validity);
				summaryL.setColspan (3);
				summaryL.setPadding (1.0f);	                   
				billTable.addCell(summaryL);
                
			   
				PdfPTable accounts = new PdfPTable(2);
				accounts.setWidthPercentage(100);
				accounts.addCell(getAccountsCell("Subtotal"));
				accounts.addCell(getAccountsCellR(amount));
				accounts.addCell(getAccountsCell("Discount (10%)"));
				accounts.addCell(getAccountsCellR("2500"));
				accounts.addCell(getAccountsCell("Tax(2.5%)"));
				accounts.addCell(getAccountsCellR("625"));
				accounts.addCell(getAccountsCell("Total"));
				accounts.addCell(getAccountsCellR("23125"));			
				PdfPCell summaryR = new PdfPCell (accounts);
				summaryR.setColspan (3);         
				billTable.addCell(summaryR);  

				PdfPTable describer = new PdfPTable(1);
				describer.setWidthPercentage(100);
				describer.addCell(getdescCell(" "));
				describer.addCell(getdescCell("Goods once sold will not be taken back or exchanged || Subject to product justification || Product damage no one responsible || "
						+ " Service only at concarned authorized service centers"));	

				document.open();//PDF document opened........	
				document.add(irhTable);
				document.add(bill);
				document.add(name);
				document.add(contact);
				document.add(address);			
				document.add(billTable);
				document.close();
		          writer.close();
		         System.out.println("Pdf created successfully..");
	      } 
	      catch (DocumentException e)
	      {
	         e.printStackTrace();
	      } 
	      catch (FileNotFoundException e)
	      {
	         e.printStackTrace();
	      }
	}
}
