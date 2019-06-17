package com.test.demo.utils.serializers;

import org.xml.sax.InputSource;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

public class XMLSerializer {
    public static byte[] objectToBytes(Object obj) {
        byte[] result = null;
        ByteArrayOutputStream byteOutputStream = null;
        ObjectOutputStream objectOutputStream = null;

        try {
            byteOutputStream = new ByteArrayOutputStream();
            objectOutputStream = new ObjectOutputStream(byteOutputStream);

            objectOutputStream.writeObject(obj);
            objectOutputStream.flush();

            result = byteOutputStream.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != objectOutputStream) {
                try {
                    objectOutputStream.close();
                    byteOutputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return result;
    }

    public static Object bytesToObject(byte[] bytes) {
        Object obj = null;

        if (bytes == null) {
            return null;
        }

        ByteArrayInputStream byteInputStream = null;
        ObjectInputStream objectInputStream = null;

        try {
            byteInputStream = new ByteArrayInputStream(bytes);
            objectInputStream = new ObjectInputStream(byteInputStream);
            obj = objectInputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != objectInputStream) {
                try {
                    objectInputStream.close();
                    byteInputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return obj;
    }

    public static <T> T xmlToObject(String xml, Class<T> clazz) throws IllegalAccessException, InstantiationException, JAXBException {
        if (xml == null || xml.equals("")) {
            return clazz.newInstance();
        }

        StringReader xmlString = new StringReader(xml);
        InputSource source = new InputSource(xmlString);

        JAXBContext jc = JAXBContext.newInstance(clazz);
        Unmarshaller u = jc.createUnmarshaller();
        return (T) u.unmarshal(source);
    }

    public static <T> String objectToXml(T t, Class<T> clazz) throws JAXBException {
        Writer writer = new StringWriter();
        JAXBContext context = JAXBContext.newInstance(clazz);
        Marshaller marshaller = context.createMarshaller();

        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(t, writer);

        return writer.toString();
    }
}
