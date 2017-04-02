package com.mkyong.helloworld.domain.builder.generator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mkyong.helloworld.domain.KokyakuKojinTantoBushoDomain;

import freemarker.template.Configuration;
import freemarker.template.TemplateException;

public class BuilderGenerater {

	private static String TEMPLATE_FILE = "BuilderTemplate.ftl";
	private static String DESTINATION = "generated/";

	@SuppressWarnings("rawtypes")
	static Class TARGET_CLASS = KokyakuKojinTantoBushoDomain.class;

	public static void main(String[] args) {

		// get domain private fields
		List<Field> privateFields = new ArrayList<>();
		Field[] allFields = TARGET_CLASS.getDeclaredFields();
		for (Field field : allFields) {
			if (Modifier.isPrivate(field.getModifiers())) {
				privateFields.add(field);
			}
		}

		// config
		DomainConfig domainConfig = new DomainConfig();
		domainConfig.setBuilderBaseClass("AbstractDomainBuilder");
		domainConfig.setDomain(TARGET_CLASS.getSimpleName().replaceAll("Domain$", ""));
		ArrayList<HashMap<String, String>> members = new ArrayList<HashMap<String, String>>();
		for (Field m : privateFields) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("type", m.getType().getName());
			map.put("name", m.getName());
			map.put("explain", m.getName());
			members.add(map);
		}
		domainConfig.setMembers(members);

		// configuration
		Configuration fileMarkerConfig = new Configuration(Configuration.VERSION_2_3_23);
		fileMarkerConfig.setClassForTemplateLoading(BuilderGenerater.class, "/");

		try {

			// template
			freemarker.template.Template template = fileMarkerConfig.getTemplate(TEMPLATE_FILE);

			// map
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("builderBaseClass", domainConfig.getBuilderBaseClass());
			map.put("domain", domainConfig.getDomain());
			map.put("members", domainConfig.getMembers());

			StringBuilder memberListWithComma = new StringBuilder();
			for (HashMap<String, String> m : domainConfig.getMembers()) {
				memberListWithComma.append("," + m.get("name"));
			}
			map.put("memberListWithComma", memberListWithComma.toString().replaceAll("^,", ""));

			// write
			File file = new File(DESTINATION + domainConfig.getDomain() + "DomainBuilder.java");
			PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(file)));
			template.process(map, writer);

		} catch (IOException | TemplateException e) {
			e.printStackTrace();
		}
		System.out.println("Success!!");
	}

}
