package com.boaglio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class GenerateTBX {

	public static void main(String[] args) throws IOException, TemplateException {

		StringWriter output = geraTemplate();

        StringBuffer messageBody = output.getBuffer();

//        System.out.println("msg="+messageBody.toString());

        writeToFile(messageBody);

	}

	private static void writeToFile(StringBuffer messageBody)
			throws IOException {
		Writer outputFile = new BufferedWriter(new FileWriter("kde-pt_BR-terms.tbx"));
        try {
        	outputFile.write( messageBody.toString() );
        }
        finally {
        	outputFile.close();
        }
	}

	@SuppressWarnings("unchecked")
	private static StringWriter geraTemplate() throws IOException,
			TemplateException {
		Configuration cfg = new Configuration();

        cfg.setDirectoryForTemplateLoading(new File("/home/fb/workspace/kde-TBX/doc/"));
        cfg.setObjectWrapper(new DefaultObjectWrapper());

		Template t = cfg.getTemplate("terms.ftl");

        Map root = new HashMap();
        root.put("glossary", "KDE i18n pt_BR Glossary - Aug 09");

        root.put("terms", getTerms());


        StringWriter output = new StringWriter();

        t.process(root, output);
		return output;
	}

	private static List<Termo> getTerms() {


		List<Termo> list = new ArrayList<Termo>();

		list.add(new Termo("1", "definição", "folder", "pasta"));
		list.add(new Termo("2", "definição2", "folder2", "pasta2"));

//		return list;

		return PostgreSQLHelper.getTermsFromPostgreSQL();

	}

}
