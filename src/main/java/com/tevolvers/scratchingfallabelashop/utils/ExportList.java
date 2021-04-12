package com.tevolvers.scratchingfallabelashop.utils;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.tevolvers.scratchingfallabelashop.models.Product;


import java.io.*;
import java.nio.charset.Charset;
import java.util.List;

public class ExportList {

    public static void toFile(List<Product> products){
        CsvMapper mapper = new CsvMapper();
        CsvSchema schema = mapper.schemaFor(Product.class).withHeader();
        ObjectWriter myObjectWriter = mapper.writer(schema);
        File tempFile = new File("products.csv");
        try {
            FileOutputStream tempFileOutputStream = new FileOutputStream(tempFile);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(tempFileOutputStream, 1024);
            OutputStreamWriter writerOutputStream = new OutputStreamWriter(bufferedOutputStream, "UTF-8");
            myObjectWriter.writeValue(writerOutputStream, products);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
