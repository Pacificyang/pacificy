package cn.pacificy.xml.xml_04;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.io.IOException;
import java.util.List;

/*
 * Dom4J�ĳ��÷�����
 * 		Document
 * 			 Element getRootElement() :��ȡ��Ԫ�ض��󣨸���ǩ��
 * 		Element
 * 			 List elements() ����ȡ���е���Ԫ��
 * 			 List elements(String name)������ָ����Ԫ����������ȡ��Ӧ�����е���Ԫ��
 * 			 Element element(String name)������ָ����Ԫ����������ȡ��Ԫ�ض���,���Ԫ�������ظ������ȡ��һ��Ԫ�� 
 * 			 String	elementText(String name) ������ָ������Ԫ�����ƣ�����ȡ��Ԫ���е��ı�
 * 			 String	getText() ����ȡ��ǰԪ�ض�����ı�
 * 			 void setText(String text)�����õ�ǰԪ�ض�����ı�
 * 			 String	attributeValue(String name)������ָ�����������ƻ�ȡ���Ӧ��ֵ
 * 			 public Element addAttribute(String name,String value)������ָ�����������ƺ�ֵ������ӻ����޸�
 * 			 addElement
 * 		DocumentHelper
 * 			static Element	createElement(String name) 
           
 * 			  
 */
public class Dom4JDemo {
	public static void main(String[] args) throws Exception  {
		//7������XML�ļ�����:��ӡState��Name
		//8��������ԣ�State�� GDP="99999��"
		Document document = cn.pacificy.xml.xml_04.Dom4JUtils.getDocument();
		//��ȡ��Ԫ��
		Element rootElement = document.getRootElement();
		//����µ����ԺͶ�Ӧ��ֵ
		rootElement.addAttribute("GDP", "99999��");
		
		//д���ļ�
		cn.pacificy.xml.xml_04.Dom4JUtils.write2XML(document);
	}

	private static void method7() throws Exception {
		//7������XML�ļ�����:��ӡState��Name
		Document document = cn.pacificy.xml.xml_04.Dom4JUtils.getDocument();
		//��ȡ��Ԫ��
		Element rootElement = document.getRootElement();
		//�����������ƻ�ȡֵ
		String value = rootElement.attributeValue("Name");
		System.out.println(value);
	}


	private static void method6() throws Exception, IOException {
		//5����ָ��Ԫ�ؽڵ�������ͬ��Ԫ�ؽڵ�:������ǰ�棬���һ��<City>����Ͽ</City>
		//����һ���µ�Ԫ�ض���
		Element cityElement = DocumentHelper.createElement("City");
		//�����ı�
		cityElement.setText("����Ͽ");
		
		Document document = cn.pacificy.xml.xml_04.Dom4JUtils.getDocument();
		//��ȡ��Ԫ��
		Element rootElement = document.getRootElement();
		//��ȡ��Ԫ�������е���Ԫ��
		List<Element> es = rootElement.elements();
		//���µ�Ԫ����ӵ���Ԫ���б���
		es.add(1, cityElement);
		
		//д���ļ�
		cn.pacificy.xml.xml_04.Dom4JUtils.write2XML(document);
	}


	private static void method5() throws Exception, IOException {
		//4����ָ��Ԫ�ؽڵ���������Ԫ�ؽ�:���һ���³���<City>����</City>
		Document document = cn.pacificy.xml.xml_04.Dom4JUtils.getDocument();
		//��ȡ��Ԫ��
		Element rootElement = document.getRootElement();
		//���Ԫ��
		Element cityElement = rootElement.addElement("City");
		//�����ı�
		cityElement.setText("����");
		//д���ļ�
		cn.pacificy.xml.xml_04.Dom4JUtils.write2XML(document);
	}


	private static void method4() throws Exception, IOException {
		//6��ɾ��ָ��Ԫ�ؽڵ�:ɾ��Ԫ�ؿ���	
		Document document = cn.pacificy.xml.xml_04.Dom4JUtils.getDocument();
		//��ȡ��Ԫ��
		Element rootElement = document.getRootElement();
		//��ȡ��Ԫ���µ�������Ԫ��
		List<Element> es = rootElement.elements();
		Element cityElement = es.get(1);
		//�޷���ɱ��������
		Element parentElement = cityElement.getParent();
		parentElement.remove(cityElement);
		//д���ļ�
		cn.pacificy.xml.xml_04.Dom4JUtils.write2XML(document);
	}


	private static void method3() throws Exception, IOException {
		//3���޸�ĳ��Ԫ�ؽڵ����������:����-->����
		Document document = cn.pacificy.xml.xml_04.Dom4JUtils.getDocument();
		//��ȡ��Ԫ��
		Element rootElement = document.getRootElement();
		//��ȡ��Ԫ���µ�������Ԫ��
		List<Element> es = rootElement.elements();
		//�����������Ի�ȡָ����Ԫ��
		Element cityElement = es.get(3);
		//�޸��ı�
		cityElement.setText("����");
		//д���ļ�
		cn.pacificy.xml.xml_04.Dom4JUtils.write2XML(document);
	}


	private static void method2() throws Exception {
		//2����������Ԫ�ؽڵ�:��ӡ���ǵ�Ԫ�����ơ�
		//��ȡ��Ԫ��
		Document document = cn.pacificy.xml.xml_04.Dom4JUtils.getDocument();
		Element rootElement = document.getRootElement();
		treeWalk(rootElement);
	}
	
	
	public static void treeWalk(Element element) {
		//���Ԫ�ص�����
		System.out.println(element.getName());
		
		//��ȡָ��Ԫ�ص�������Ԫ��
		List<Element> es = element.elements();
		for (Element e : es) {
			treeWalk(e);
		}
	}

	private static void method() throws Exception {
		//1���õ�ĳ������Ľڵ�����:��ӡ"֣��"
		Document document = cn.pacificy.xml.xml_04.Dom4JUtils.getDocument();
		//��ȡ��Ԫ��
		Element rootElement = document.getRootElement();
		//��ȡ��Ԫ���µ�������Ԫ��
		List<Element> elements = rootElement.elements();
		//����������ȡ��һ��CityԪ��
		Element cityElement = elements.get(0);
		//������Ԫ�ص���������ȡ��Ԫ�ص��ı�
		String text = cityElement.elementText("Name");
		System.out.println(text);
	}
 
	 
}
