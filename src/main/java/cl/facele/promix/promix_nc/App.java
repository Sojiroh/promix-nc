package cl.facele.promix.promix_nc;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Hello world!
 *
 */
public class App {
	private static Path dirDTE;
    public static void main( String[] args ) throws Exception {
        dirDTE = Paths.get("D:\\Descargas\\dtes");
        if (Files.notExists(dirDTE))
        	Files.createDirectories(dirDTE);
        
        doit();
    }
    
	private static void doit() throws Exception {
		System.out.println("hola mundo");

		DirectoryStream<Path> directory = null;
		DTEBean bean;
		Transforma tr;
		long folio=0;
                //int folito=55101;
                int folito=131601;
		try {
			directory = Files.newDirectoryStream(dirDTE);
			//Obtiene folio menor
			for (Path filePath : directory) {
				tr = new Transforma();
                                System.out.println(filePath.getFileName());
                                if(!filePath.getFileName().toString().contains("txt")){
				bean = new DTEBean();
				String pico=new String(Files.readAllBytes(filePath), Charset.forName("ISO-8859-1"));
				if (pico.contains("http://www.sii.cl/SiiDte"))
					pico=pico.replace("http://www.sii.cl/SiiDte", "");
				bean.setContendioFile(pico);
                                bean.setDescuento("no");
				bean.setTipoDTE("61");		
				bean.setRutEmisor("96579920-6");
                                bean.setFolioDTE(Integer.toString(folito));
				Transforma.toTXT57(bean);
				System.out.println(bean.getTXT());
				
				
				folio++;
				
				Thread.sleep(10);
				
				System.out.println("folio: " + folio);

                            File file = new File(Paths.get("D:\\Descargas\\dtes\\txt")+"\\"+bean.getRutEmisor()+"_T"+bean.getTipoDTE()+"_F"+bean.getFolioDTE()+".txt");
//                            File file = new File(Paths.get("D:\\Descargas\\dtes\\txt")+"\\"+bean.getFolioDTE()+"."+bean.getCodigoEmotions());

                            //                            File file = new File(Paths.get("D:\\Descargas\\dtes\\txt")+"/"+bean.getFolioDTE()+"."+folito+".txt");
                                
                 // if file doesnt exists, then create it
                 if (!file.exists()) {
                         file.createNewFile();
                 }
                
                 FileWriter fw = new FileWriter(file.getAbsoluteFile());
                 BufferedWriter bw = new BufferedWriter(fw);
                 bw.write(bean.getTXT());
                 bw.close();
                 folito++;
                                
                                
                                }
				
			}
		} catch (Exception e) {
			throw new Exception("Error iterando archivos: " + e.getMessage(), e);
		} finally {
			try {directory.close();
			} catch (Exception e) {
				Logger.getLogger(App.class.getCanonicalName()).log(Level.INFO, e.getMessage());
			}
		}
		
	}
}
